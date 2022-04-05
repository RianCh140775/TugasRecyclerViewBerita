package com.example.recyclerviewberita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.recyclerviewberita.adapter.NewsAdapter;
import com.example.recyclerviewberita.model.News;
import com.example.recyclerviewberita.service.NewsApiClient;
import com.example.recyclerviewberita.service.NewsApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvBerita;
    Button btnSearch;
    EditText editSearch;
//    List<BeritaModel> listBerita= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvBerita=findViewById(R.id.rvBerita);
        btnSearch=findViewById(R.id.btnSearch);
        editSearch=findViewById(R.id.editSearch);
//        listBerita.add(new BeritaModel("Orang ini mati 3 kali, ini kata resti","Health","https://assets.pikiran-rakyat.com/crop/0x0:0x0/x/photo/2022/03/30/2810251709.jpg","ini deksripsi yang sangaaaaaaaaaaaaaaaaaaaaaaaaaat panjang"));
//        listBerita.add(new BeritaModel("Juara Coding itu mantap, ini kata nining","Lifestyle","https://juaracoding.com/public/dummy/img_pak_paulus.png","ini deksripsi yang sangaaaaaaaaaaaaaaaaaaaaaaaaaat panjang 2"));
//        listBerita.add(new BeritaModel("Banci ini ditangkap warga karna tidak banci","Travel","https://cdn0-production-images-kly.akamaized.net/C78TuqRI6EvujNd5nHZApBQ9apw=/1200x900/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/3951801/original/052272700_1646356554-Tessy_1.jpg","ini deksripsi yang sangaaaaaaaaaaaaaaaaaaaaaaaaaat panjang 3"));


        NewsApiInterface newsApiInterface = NewsApiClient.getRetrofit().create(NewsApiInterface.class);
        Call<News> call = newsApiInterface.getTopHeadLinesNewsByCountry("ca","2cf809c11dab494babd7fb9dabbfb663");

        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                NewsAdapter adapter = new NewsAdapter(MainActivity.this, response.body().getArticles());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
                rvBerita.setLayoutManager(layoutManager);
                rvBerita.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                System.out.println(t);
            }
        });


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cari = editSearch.getText().toString();
                String input = "chile";
                if(cari.isEmpty() ) {
                    cari = input;
                }
                Call<News> call2 = newsApiInterface.getTopHeadLinesNewsBySearch(cari,"59430faa9546448da7de3786ace4bdab");
                call2.enqueue(new Callback<News>()

                {

                    @Override
                    public void onResponse(Call<News> call, Response<News> response) {
                        NewsAdapter adapter = new NewsAdapter(MainActivity.this, response.body().getArticles());
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
                        rvBerita.setLayoutManager(layoutManager);
                        rvBerita.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<News> call, Throwable t) {

                    }
                });
            }
        });

    }
}