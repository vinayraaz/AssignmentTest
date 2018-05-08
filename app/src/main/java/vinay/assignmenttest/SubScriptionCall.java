package vinay.assignmenttest;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import vinay.assignmenttest.model.AppModel;

/**
 * Created by vinay on 12/21/2017.
 */

public interface SubScriptionCall {

    //====================Product list=============
    @FormUrlEncoded
    @POST("App_c_controller/get_sliders")
    Call<AppModel> VersionApi(@Field("app_name") String token_key);

}
