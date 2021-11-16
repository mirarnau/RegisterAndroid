package edu.upc.dsa;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("/register")
    Call<LoginUserTO> addUser();

}
