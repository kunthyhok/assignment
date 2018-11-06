package retrofit.com.newskh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit.com.contactretrofits.R;
import retrofit.com.newskh.api.ApiClient;
import retrofit.com.newskh.api.ApiInterface;
import retrofit.com.newskh.model.AllArticlesResponse;
import retrofit.com.newskh.model.ArticleDataItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleByCategoryActivity extends AppCompatActivity {

    /*
   News RecyclerView
   */
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ArticleRecyclerAdapter adapter;
    private List<ArticleDataItem> news;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_category);


        //  New Recycler
        recyclerView = (RecyclerView) findViewById(R.id.recycler_article_by_cat);
        layoutManager = new LinearLayoutManager(this);


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        if(getIntent().getExtras()!=null)
        {
            int catId = getIntent().getIntExtra("catId",0);

            Call<AllArticlesResponse> call = apiInterface.findAllArticleById(catId);

            call.enqueue(new Callback<AllArticlesResponse>() {
                @Override
                public void onResponse(Call<AllArticlesResponse> call, Response<AllArticlesResponse> response) {

                        news = response.body().getDATA();
                         if(news.size()!=0){
                             adapter = new ArticleRecyclerAdapter(news,ArticleByCategoryActivity.this);
                             recyclerView.setAdapter(adapter);
                         }


                }

                @Override
                public void onFailure(Call<AllArticlesResponse> call, Throwable t) {

                }
            });


        }


    }
}