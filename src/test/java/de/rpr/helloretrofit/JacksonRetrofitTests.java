package de.rpr.helloretrofit;

import org.junit.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JacksonRetrofitTests extends AbstractJacksonRetrofitTest{

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
