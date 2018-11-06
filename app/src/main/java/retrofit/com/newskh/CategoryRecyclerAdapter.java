package retrofit.com.newskh;

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


public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryViewHolder>{
    private List<DATAItem> categories;
    private Context context;

    public CategoryRecyclerAdapter(List<DATAItem> categories, Context context) {
        this.categories = categories;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_category_recycler,parent,false);
        return new CategoryViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, final int position) {
         holder.catName.setText(categories.get(position).getNAME());

        // Go to news  Detail

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,"Show position "+categories.get(position).getID(),Toast.LENGTH_LONG).show();

                 Integer id = categories.get(position).getID();
                 Intent myIntent = new Intent(context, ArticleByCategoryActivity.class);
                 myIntent.putExtra("catId", id);
                 context.startActivity(myIntent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    // Step 1 create class view holder

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView catName;
        public CategoryViewHolder(View itemView) {
            super(itemView);

            catName = (TextView) itemView.findViewById(R.id.itemCategoryName);

        }
    }

}
