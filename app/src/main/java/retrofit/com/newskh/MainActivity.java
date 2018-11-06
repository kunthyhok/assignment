package retrofit.com.newskh;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit.com.contactretrofits.R;
import retrofit.com.newskh.api.ApiClient;
import retrofit.com.newskh.api.ApiInterface;

import retrofit.com.newskh.model.AllArticlesResponse;
import retrofit.com.newskh.model.ArticleDataItem;
import retrofit.com.newskh.model.CategoryResponse;
import retrofit.com.newskh.model.DATAItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

   // Drawer
    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;

    private TextView textViewNavHeaderName;


    /*
    News RecyclerView
    */
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ArticleRecyclerAdapter adapter;
    private List<ArticleDataItem> contacts;
    private ApiInterface apiInterface;



    // News Category

    private RecyclerView recyclerViewCat;
    private RecyclerView.LayoutManager layoutManagerCat;
    private CategoryRecyclerAdapter adapterCat;
    private List<DATAItem> categories;


    // For Search
    ProgressBar progressBar;
    TextView search;
    String[] item;

    //End Search



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // For Search

        progressBar = findViewById(R.id.prograss);
        //End Search
        // Add Drawer
        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer_dash_bord);
        //Add Action On Nav and Menu Item
        NavigationView navigationViewDashBoard = findViewById(R.id.nav_view_dash_board);
        navigationViewDashBoard.setNavigationItemSelectedListener(MainActivity.this);

        // To Fix error when don't have action on navigation
        navigationViewDashBoard.bringToFront();


        mToggle = new ActionBarDrawerToggle(this, mDrawerlayout, R.string.app_name, R.string.app_name);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Show Name to Header When Login
        View header = navigationViewDashBoard.getHeaderView(0);
        textViewNavHeaderName = (TextView) header.findViewById(R.id.navigation_header_name);



        //  New Recycler
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewFood);
        layoutManager = new LinearLayoutManager(this);


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        fetchNews("");


        // Recycler News Category
        recyclerViewCat = (RecyclerView) findViewById(R.id.recyclerCategory);
        layoutManagerCat  = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCat.setLayoutManager(layoutManagerCat);
        recyclerViewCat.setHasFixedSize(true);

        Call<CategoryResponse> callCategory = apiInterface.findArticleCategory();

        callCategory.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                categories = response.body().getDATA();

                adapterCat = new CategoryRecyclerAdapter(categories,MainActivity.this);
                recyclerViewCat.setAdapter(adapterCat);
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {

            }
        });



    }
    // Toggle Handling
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    // MenuItem Handling Navigation
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                Intent intentSearch = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intentSearch);
                break;
            case R.id.menu_category:
                Intent intentCategory = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intentCategory);
                break;
            case R.id.menu_about:

                Intent aboutIntent = new Intent(MainActivity.this,AboutActivity.class);
                startActivity(aboutIntent);
                break;
        }
        return true;
    }

    /*    ========================
           Dialogue Exit Message
         ========================*/
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit the news app ?")
                .setMessage("Thanks and Welcome again ...! ")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        MainActivity.super.onBackPressed();
                    }
                }).create().show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                fetchNews( query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fetchNews(newText);
                return false;
            }
        });
        return true;
    }


    public void fetchNews(String key){

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<AllArticlesResponse> call = apiInterface.findAllArticles( key,1,15);

        call.enqueue(new Callback<AllArticlesResponse>() {
            @Override
            public void onResponse(Call<AllArticlesResponse> call, Response<AllArticlesResponse> response) {
                progressBar.setVisibility(View.GONE);
                contacts = response.body().getDATA();
                adapter = new ArticleRecyclerAdapter(contacts, MainActivity.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<AllArticlesResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Error\n"+t.toString(), Toast.LENGTH_LONG).show();
            }
        });


    }
}
