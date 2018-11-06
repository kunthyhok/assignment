package retrofit.com.newskh;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;

import retrofit.com.contactretrofits.R;
import retrofit.com.newskh.model.ArticleDataItem;

public class NewsDetailActivity extends AppCompatActivity {

    private ArticleDataItem  news;

    ImageView img;
    TextView title,descrition,author,createDate;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        img = (ImageView) findViewById(R.id.image_news);
        title = (TextView) findViewById(R.id.text_news_title);
        descrition = (TextView) findViewById(R.id.text_news_details);
        author = (TextView) findViewById(R.id.text_author);
        createDate = (TextView) findViewById(R.id.text_create_date);

        //Get news from Intent
        news = new Gson().fromJson(getIntent().getStringExtra("news"),ArticleDataItem.class);


        String date = news.getCREATEDDATE();
        String result = date.substring(0, 8);


        // Set Data to view
        Glide.with(NewsDetailActivity.this).load(news.getIMAGE()).into(img);
        title.setText(news.getTITLE());
        descrition.setText(news.getDESCRIPTION());

        try{
            author.setText(news.getAUTHOR().getNAME().toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        createDate.setText(result);

    }
}
