package com.example.hubweatherapi;

import com.example.hubweatherapi.model.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("getVilageFcst?authKey=dVhKCqf1RziYSgqn9ec4cw")
    Call<WeatherModel> getWeather(
            @Query("dataType") String data_type,    // 한 페이지 경과 수
            @Query("numOfRows") int num_of_rows,    // 페이지 번호
            @Query("pageNo") int page_no,           // 응답 자료 형식
            @Query("base_date") String base_date,   // 발표 일자
            @Query("base_time") String base_time,   // 발표 시각
            @Query("nx") String nx,                 // 예보지점 X 좌표
            @Query("ny") String ny                  // 예보지점 Y 좌표
    );

}
