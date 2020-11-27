package com.example.prova1

import retrofit2.Call
import retrofit2.http.GET

interface API {

   @GET("droidcafe")
   fun getValor(): Call<List<DTO>>
}