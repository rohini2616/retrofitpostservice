package com.example.postservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MakeAdapter makeAdapter;
    List<String> makeList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rvRecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Model model=new Model();
        model.setYear("2020");


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.Base_Url).addConverterFactory(GsonConverterFactory.create()).build();


        Api api=retrofit.create(Api.class);
        Call<MakeResponse> call=api.makeList(model);
        call.enqueue(new Callback<MakeResponse>() {
            @Override
            public void onResponse(Call<MakeResponse> call, Response<MakeResponse> response) {
                makeAdapter=new MakeAdapter(MainActivity.this,response.body().getMakeList());
                recyclerView.setAdapter(makeAdapter);
            }

            @Override
            public void onFailure(Call<MakeResponse> call, Throwable t) {

            }
        });




    }
}