package de.rpr.helloretrofit;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JacksonRetrofitTests {


    private Call<List<Repo>> call;

    @Before
    public void setup() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .build();
        JacksonGithubEndpoint endpoint = retrofit.create(JacksonGithubEndpoint.class);
        call = endpoint.listRepos("dnno");
    }

    @Test
    public void should_get_successful_response_status() throws IOException {
        Response<List<Repo>> response = call.execute();
        assertThat(response.isSuccessful()).isTrue();
    }

    @Test
    public void should_have_mapped_response_to_repo_class() throws IOException {
        Response<List<Repo>> response = call.execute();
        assertThat(response.body()).isNotNull();
    }

    @Test
    public void should_have_at_least_one_repo_in_response() throws IOException {
        Response<List<Repo>> response = call.execute();
        assertThat(response.body().get(0).getId()).isNotEqualTo(0);
    }

    @Test
    public void should_have_repo_with_name_in_response() throws IOException {
        Response<List<Repo>> response = call.execute();
        assertThat(response.body().get(0).getId()).isNotEqualTo(0);
    }
}
