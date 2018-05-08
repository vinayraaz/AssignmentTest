package vinay.assignmenttest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import vinay.assignmenttest.model.AppModel;

/**
 * Created by vinay on 12/8/2017.
 */

public interface  ApiInterface {

    @GET("/search?term=ar+rahman")
    Call<ResponseDataMode> getAnswers();
/*

    @FormUrlEncoded
    @POST("/App_c_controller/get_sliders")
    Call<AppModel> versionApi(@Field("app_name") String appname);
   // void versionApi(@Query("app_name") String appname, Callback<AppModel> appModelCallback);
*/

}


