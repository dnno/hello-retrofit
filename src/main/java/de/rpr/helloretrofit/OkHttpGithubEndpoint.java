package de.rpr.helloretrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OkHttpGithubEndpoint {

    @GET("users/{user}/repos")
    Call<ResponseBody> listRepos(@Path("user") String username);
}
