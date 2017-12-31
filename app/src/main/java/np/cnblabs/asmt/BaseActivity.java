package np.cnblabs.asmt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import np.cnblabs.asmt.webService.ApiClient;
import np.cnblabs.asmt.webService.GitHubService;

/**
 * Created by sanjogstha on 12/31/17.
 * CNB LABS
 * sanjogshrestha.nepal@gmail.com
 */

public abstract class BaseActivity extends AppCompatActivity {
    String no_internet_message = null, exception_message = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        no_internet_message = getString(R.string.no_internet_connection_detected);
        exception_message = getString(R.string.exception_occurred);

    }

    public GitHubService getWebService(){
       return ApiClient.getApiClient().create(GitHubService.class);
    }
}
