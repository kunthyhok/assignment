package retrofit.com.newskh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.List;

import retrofit.com.contactretrofits.R;
import retrofit.com.newskh.model.ArticleDataItem;
import retrofit.com.newskh.model.DATAItem;



public class ArticleRecyclerAdapter extends RecyclerView.Adapter<ArticleRecyclerAdapter.ArticleViewHolder>{
    private List<ArticleDataItem> news;
    private Context context;

    public ArticleRecyclerAdapter(List<ArticleDataItem> news, Context context) {
        this.news = news;
        this.context = context;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_article_recycler,parent,false);
        return new ArticleViewHolder(view) ;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(final ArticleViewHolder holder, final int position) {
        holder.title.setText(news.get(position).getTITLE());
        holder.description.setText(news.get(position).getDESCRIPTION());

        Glide.with(context).load(news.get(position).getIMAGE()).into(holder.img);

        // Go to news  Detail

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             // Toast.makeText(context,"Show position "+news.get(position).toString(),Toast.LENGTH_LONG).show();

                String newsIntent = new Gson().toJson(news.get(position));
                Intent intent = new Intent(context,NewsDetailActivity.class);
                intent.putExtra("news",newsIntent);
                context.startActivity(intent);


            }
        });



    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    // Step 1 create class view holder

    public static class ArticleViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title;
        TextView description;
        public ArticleViewHolder(View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.img);
            title = (TextView) itemView.findViewById(R.id.foodname_text);
            description = (TextView) itemView.findViewById(R.id.fooddescription_text);

        }
    }

}
