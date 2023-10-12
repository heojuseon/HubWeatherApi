package com.example.hubweatherapi.model;

import android.util.Log;

import com.example.hubweatherapi.WeatherApi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherClient {
    private final String TAG = "WeatherRepository";
    public static final String WEATHER_URL = "https://apihub.kma.go.kr/api/typ02/openApi/VilageFcstInfoService_2.0/";

    public static Retrofit retrofit;
    private static WeatherClient instance;
    private WeatherApi weatherApi;

    String nx = "58";
    String ny = "127";
    String base_date = "20231010";
    String base_time = "0500";

    public static WeatherClient getInstance() {
        if (instance == null) {
            instance = new WeatherClient();
        }
        Log.d("WeatherClient", "WeatherClient : " + instance);
        return instance;
    }

    public void getWeather(Callback<WeatherModel> callback) {

        retrofit = new Retrofit.Builder()
                .baseUrl(WEATHER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        weatherApi = retrofit.create(WeatherApi.class);

        setWeather(callback, nx, ny);
    }

    private void setWeather(Callback<WeatherModel> callback, String nx, String ny) {
        // 현재 날짜, 시간 정보 가져오기
        Calendar cal = Calendar.getInstance();
        String base_date = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(cal.getTime()); //현재 날짜
        String time = new SimpleDateFormat("HH", Locale.getDefault()).format(cal.getTime());    //현재 시간
        String base_time = getBaseTime(time);

        //시간 api 가져오기 위해 변환
        // 현재 시각이 00시가 넘었다면 하루 전 날짜로 설정하여 다음 날의 데이터를 요청해야 한다.
        if (Integer.parseInt(base_time) >= 2300) {
            cal.add(Calendar.DATE, -1);
            base_date = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(cal.getTime());
        }
        base_date = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(cal.getTime());


        Call<WeatherModel> call = weatherApi.getWeather("JSON", 1000, 1, base_date, base_time, nx, ny);
        call.enqueue(callback);
    }

    private String getBaseTime(String time) {
        String result = "";
        switch (time) {
            case "02":
            case "03":
            case "04":
                result = "0200"; // 02~04
                break;
            case "05":
            case "06":
            case "07":
                result = "0500"; // 05~07
                break;
            case "08":
            case "09":
            case "10":
                result = "0800"; // 08~10
                break;
            case "11":
            case "12":
            case "13":
                result = "1100"; // 11~13
                break;
            case "14":
            case "15":
            case "16":
                result = "1400"; // 14~16
                break;
            case "17":
            case "18":
            case "19":
                result = "1700"; // 18~20
                break;
            case "20":
            case "21":
            case "22":
                result = "2000"; // 21~23
                break;
            default:
                result = "2300";
        }
        return result;
    }



}
