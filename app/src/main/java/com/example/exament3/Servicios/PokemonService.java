package com.example.exament3.Servicios;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonService {

    @GET("n00017665")
    Call<List<Pokemon>> all();

}
