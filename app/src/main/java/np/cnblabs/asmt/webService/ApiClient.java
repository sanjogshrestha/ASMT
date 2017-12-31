package np.cnblabs.asmt.webService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sanjogstha on 12/31/17.
 * CNB LABS
 * sanjogshrestha.nepal@gmail.com
 */

public class ApiClient {
    public static Retrofit getApiClient(){
         return new Retrofit.Builder()
                 .baseUrl(UrlConstant.MAIN_URL)
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();
    }
}
