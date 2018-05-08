package vinay.assignmenttest;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vinay.assignmenttest.model.AppModel;

public class MainActivity extends AppCompatActivity {
    public static List<ResponseData> responseDataModeModeList = new ArrayList<>();
    private RecyclerView rView;
    LinearLayoutManager layoutManager;
    ApiInterface apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity);
        rView = (RecyclerView) findViewById(R.id.recycler_view);

        layoutManager = new LinearLayoutManager(MainActivity.this);
         apiService = ApiClient.getClient().create(ApiInterface.class);
        APICall();
       // PostAPICall();
    }

   /* private void PostAPICall() {
        Call<AppModel>appModelCall = apiService.versionApi("2");
        appModelCall.enqueue(new Callback<AppModel>() {
            @Override
            public void onResponse(Call<AppModel> call, Response<AppModel> response) {
                Log.i("Response1",response.body().getMsg().toString());
            }

            @Override
            public void onFailure(Call<AppModel> call, Throwable t) {

            }
        });
       *//* apiService.versionApi("2").enqueue(new Callback<AppModel>() {
            @Override
            public void onResponse(Call<AppModel> call, Response<AppModel> response) {
               // Log.i("Response1",+response.body());
                //String m = response.body();
                //System.out.println("Res*************"+response.body().getRestaurantSliders().);
                for (int i=0;i<response.body().getRestaurantSliders().size();i++){
                    Log.i("Response2*****",response.body().getRestaurantSliders().get(i).getBannerId());
                }

            }

            @Override
            public void onFailure(Call<AppModel> call, Throwable t) {

            }
        });*//*
    }*/

    private void APICall() {
        responseDataModeModeList.clear();
        apiService.getAnswers().enqueue(new Callback<ResponseDataMode>() {
            @Override
            public void onResponse(Call<ResponseDataMode> call, Response<ResponseDataMode> response) {
                if(response.isSuccessful()) {
                   for (int i=0;i<response.body().getResults().size();i++){
                       responseDataModeModeList.add(new ResponseData(
                               response.body().getResults().get(i).getWrapperType(),
                               response.body().getResults().get(i).getKind(),
                               response.body().getResults().get(i).getArtistId(),
                               response.body().getResults().get(i).getCollectionId(),
                               response.body().getResults().get(i).getTrackId(),
                               response.body().getResults().get(i).getArtistName(),
                               response.body().getResults().get(i).getCollectionName(),
                               response.body().getResults().get(i).getTrackName(),
                               response.body().getResults().get(i).getCollectionCensoredName(),
                               response.body().getResults().get(i).getTrackCensoredName(),
                               response.body().getResults().get(i).getCollectionArtistId(),
                               response.body().getResults().get(i).getCollectionArtistName(),
                               response.body().getResults().get(i).getArtistViewUrl(),
                               response.body().getResults().get(i).getCollectionViewUrl(),
                               response.body().getResults().get(i).getArtworkUrl60()
                               ));

                   }
                   listdetails();
                    Log.d("MainActivity", response.body().toString());
                }else {
                }
            }

            @Override
            public void onFailure(Call<ResponseDataMode> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");
            }
        });
    }

    private void listdetails() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rView.setLayoutManager(layoutManager);
       // mRecyclerView.setAdapter(mAdapter);
        rView.setHasFixedSize(true);
        RecyclerView_ListAdapter recyclerView_listAdapter = new RecyclerView_ListAdapter(this, responseDataModeModeList);
        rView.setAdapter(recyclerView_listAdapter);
    }
}
