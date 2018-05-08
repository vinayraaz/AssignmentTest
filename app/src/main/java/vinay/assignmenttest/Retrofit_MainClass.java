package vinay.assignmenttest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import vinay.assignmenttest.model.AppModel;
import vinay.assignmenttest.model.RetrofitService;

/**
 * Created by vinay on 12/21/2017.
 */

public class Retrofit_MainClass extends Activity {
    SubScriptionCall subScriptionCall = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity);

        Retrofit retrofit = RetrofitService.setRetrofit("http://amareshkaradi.com/api/");
        subScriptionCall = retrofit.create(SubScriptionCall.class);

        APICallMethod();
    }

    private void APICallMethod() {
        Call<AppModel> appModelCall = subScriptionCall.VersionApi("2");
        appModelCall.enqueue(new Callback<AppModel>() {
            @Override
            public void onResponse(Call<AppModel> call, Response<AppModel> response) {
                System.out.println("Response********"+response.body().getMsg());
                for (int i=0;i<response.body().getRestaurantSliders().size();i++){
                    System.out.println("Response********"+response.body().getRestaurantSliders().get(i).getBannerId().toString());

                }

            }

            @Override
            public void onFailure(Call<AppModel> call, Throwable t) {

            }
        });
    }
}
