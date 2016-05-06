package de.rpr.helloretrofit;

import okhttp3.ResponseBody;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AsynchronousRetrofitTests extends AbstractOkHttpRetrofitTest {

    @Test
    public void should_get_successful_response_status() throws InterruptedException {
        final AtomicBoolean success = new AtomicBoolean();
        final CountDownLatch latch = new CountDownLatch(1);
        call.enqueue(new Callback<ResponseBody>() {

            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                success.set(true);
                latch.countDown();
            }

            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                latch.countDown();
            }
        });
        latch.await();
        assertThat(success.get()).isTrue();
    }

}
