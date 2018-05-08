package vinay.assignmenttest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vinay on 12/8/2017.
 */

public class ApiClient {
    //https://itunes.apple.com/search?term=ar+rahman
    //public static final String BASE_URL = "http://amareshkaradi.com/api/";
    public static final String BASE_URL = "https://itunes.apple.com/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
