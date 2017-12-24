package np.cnblabs.asmt.model.realmModel;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by sanjogstha on 12/24/17.
 * CNB LABS
 * sanjogshrestha.nepal@gmail.com
 */

public class RealmModelData extends RealmObject {
    public static String EMAIL = "email";
    @PrimaryKey private String email;

    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
