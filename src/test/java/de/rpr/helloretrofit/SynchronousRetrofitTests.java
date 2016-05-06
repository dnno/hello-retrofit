package de.rpr.helloretrofit;

import okhttp3.ResponseBody;
import org.junit.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class SynchronousRetrofitTests extends AbstractOkHttpRetrofitTest {

    @Test
    public void should_get_successful_response_status() throws IOException {
        Response<ResponseBody> response = call.execute();
        assertThat(response.isSuccessful()).isTrue();
    }

    @Test
    public void should_have_response_body() throws IOException {
        Response<ResponseBody> response = call.execute();
        assertThat(response.body()).isNotNull();
    }

    @Test
    public void should_have_mediatype_application_json() throws IOException {
        Response<ResponseBody> response = call.execute();
        assertThat(response.body().contentType().toString()).startsWith("application/json");
    }

    @Test
    public void should_get_response_body() throws IOException {
        Response<ResponseBody> response = call.execute();
        assertThat(response.isSuccessful()).isNotNull();
    }
}

