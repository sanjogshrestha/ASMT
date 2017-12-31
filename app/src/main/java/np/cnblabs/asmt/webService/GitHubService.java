package np.cnblabs.asmt.webService;

import np.cnblabs.asmt.model.TreeHouseModel;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sanjogstha on 12/31/17.
 * CNB LABS
 * sanjogshrestha.nepal@gmail.com
 */

public interface GitHubService {
    @GET("api/get_recent_summary")
    Call<TreeHouseModel> getSummary();
}
