package np.cnblabs.asmt.fcm;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by sanjogstha on 1/3/18.
 * CNB LABS
 * sanjogshrestha.nepal@gmail.com
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String token = FirebaseInstanceId.getInstance().getToken();
        System.out.println("token=" + token);
    }
}
