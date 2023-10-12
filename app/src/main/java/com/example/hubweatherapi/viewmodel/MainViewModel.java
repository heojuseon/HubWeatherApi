package com.example.hubweatherapi.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hubweatherapi.model.Item;
import com.example.hubweatherapi.model.WeatherClient;
import com.example.hubweatherapi.model.WeatherModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private final String TAG = "MainViewModel";

    //이 클래스에서는 Model과 통신하여서 날씨 정보를 받아온다.
    private MutableLiveData<WeatherModel> weather = new MutableLiveData<>();
    private WeatherClient client;

    public MutableLiveData<String> result_temp = new MutableLiveData<>("");
    public MutableLiveData<String> result_Max_temp = new MutableLiveData<>("");
    public MutableLiveData<String> result_Min_temp = new MutableLiveData<>("");
    public MutableLiveData<String> result_time = new MutableLiveData<>("");


    public void init() {
        client = WeatherClient.getInstance();   //WeatherClient 를 통해 객체 받아 온다.
        client.getWeather(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                if (response.isSuccessful()) {
                    List<Item> it = response.body().getResponse().getBody().getItems().getItem();

                    String temp = "";        // 기온
                    String max_temp = "";   //최고 기온
                    String min_temp = "";   //최저 기온
                    String r_time="";

                    for (int i = 0; i < 10; i++) {
                        String category = it.get(i).getCategory();
                        String fcstValue = it.get(i).getFcstValue();
                        String fcstTime = it.get(i).getFcstTime();
                        if (category.equals("TMP")) {
                            temp = fcstValue;
                            r_time = fcstTime;
                        } else {
                            continue;
                        }
                        //최저, 최고 기온 알기위해서(전체 사이즈 중에서, 가장 높은값 / 가장 낮은 값)
                        for (int i1 = 0; i1 < it.size(); i1++) {
                            String category2 = it.get(i1).getCategory();
                            String fcstValue2 = it.get(i1).getFcstValue();
                            if (category2.equals("TMX")) {
                                if (max_temp.isEmpty() || Float.parseFloat(fcstValue2) > Float.parseFloat(max_temp)){   //이전 최고 기온 값이 비어 있거나 현재 기온 값이 이전 최고 기온 값을 초과하면 새로운 최고 기온 값인 max_temp를 현재 기온 값 fcstValue2로 업데이트
                                    max_temp = fcstValue2;
                                }
                            } else if (category2.equals("TMN")) {
                                if (min_temp.isEmpty() || Float.parseFloat(fcstValue2) < Float.parseFloat(min_temp)){
                                    min_temp = fcstValue2;
                                }
                            }
                        }
                    }
                    result_temp.setValue("현재온도: " + temp);
                    result_Max_temp.setValue("최고온도: " + max_temp);
                    result_Min_temp.setValue("최저온도: " + min_temp);
                    result_time.setValue("예보시간: " + r_time);


                    Log.d("MainActivity", "Api Connect Success");
                }
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {

            }
        });
    }


    public LiveData<WeatherModel> getWeather() {
        return weather;
    }
}
