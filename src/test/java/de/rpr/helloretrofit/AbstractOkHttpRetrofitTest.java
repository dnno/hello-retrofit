package de.rpr.helloretrofit;

import okhttp3.ResponseBody;
import org.junit.Before;
import retrofit2.Call;
import retrofit2.Retrofit;

public abstract class AbstractOkHttpRetrofitTest {

    protected Call<ResponseBody> call;

    @Before
    public void setup() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .build();
        OkHttpGithubEndpoint endpoint = retrofit.create(OkHttpGithubEndpoint.class);
        call = endpoint.listRepos("dnno");
    }
}
