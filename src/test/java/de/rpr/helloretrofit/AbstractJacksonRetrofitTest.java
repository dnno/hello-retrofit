package de.rpr.helloretrofit;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.List;

public abstract class AbstractJacksonRetrofitTest {

    protected Call<List<Repo>> call;

    @Before
    public void setup() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getBaseUri())
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .build();
        JacksonGithubService service = retrofit.create(JacksonGithubService.class);
        call = service.listRepos("dnno");
    }

    protected String getBaseUri() {
        return "https://api.github.com";
    }

}
