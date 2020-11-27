package com.example.prova1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.prova1.DTO
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val serviceRetrofit = RetrofitService()
        serviceRetrofit.api?.getValor()?.enqueue(object : Callback<List<DTO>> {
            override fun onResponse(call: Call<List<DTO>?>?, response: Response<List<DTO>?>?) {
                val listaDeProdutos = response?.body()
                descricao1.text = listaDeProdutos?.get(0)?.descricao
                descricao2.text = listaDeProdutos?.get(1)?.descricao
                descricao3.text = listaDeProdutos?.get(2)?.descricao

                imageView.setImageResource(R.drawable.donut_circle)
                imageView2.setImageResource(R.drawable.icecream_circle)
                imageView3.setImageResource(R.drawable.froyo_circle)

                valor1.text = listaDeProdutos?.get(0)?.valor.toString()
                valor2.text = listaDeProdutos?.get(1)?.valor.toString()
                valor3.text = listaDeProdutos?.get(2)?.valor.toString()
            }

            override fun onFailure(call: Call<List<DTO>?>?, t: Throwable?) {
                Log.e("Erro", "************** erro **********\n"+t?.message.toString())
            }
        })


    }
}