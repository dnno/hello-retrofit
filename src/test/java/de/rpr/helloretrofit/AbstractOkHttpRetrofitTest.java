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
                .baseUrl(getBaseUri())
                .build();
        OkHttpGithubService service = retrofit.create(OkHttpGithubService.class);
        call = service.listRepos("dnno");
    }

    protected String getBaseUri() {
        return "https://api.github.com";
    }
}
