package retrofit.com.newskh.api;

import retrofit.com.newskh.model.AllArticlesResponse;
import retrofit.com.newskh.model.AnArticleResponse;
import retrofit.com.newskh.model.CategoryResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {


    //Get All Article
    @GET("/v1/api/articles")
    Call<AllArticlesResponse> findAllArticles(@Query("title") String title, @Query("page") Integer page, @Query("limit") Integer limit);

    //Get An Article
    @GET("/v1/api/articles/{id}")
    Call<AnArticleResponse> findOneArticle(@Path("id") Integer Id);

    //Get Article Category
    @GET("/v1/api/categories")
    Call<CategoryResponse> findArticleCategory();


    //Get All Article By Id
    @GET("/v1/api/categories/{id}/articles")
    Call<AllArticlesResponse> findAllArticleById(@Path("id") Integer Id);

}
