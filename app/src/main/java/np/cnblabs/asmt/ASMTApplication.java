package np.cnblabs.asmt;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by sanjogstha on 12/24/17.
 * CNB LABS
 * sanjogshrestha.nepal@gmail.com
 */

public class ASMTApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        Realm.setDefaultConfiguration(createNewConfiguration());
    }

    private RealmConfiguration createNewConfiguration() {
       return new RealmConfiguration.Builder()
                .name("ASMT.realm")
                .schemaVersion(1)
                .build();
    }

    /**
     * Get Realm Instance
     *
     * @return Realm Configuration
     */
    public static Realm getRealmInstance() {
        return Realm.getDefaultInstance();
    }

}
