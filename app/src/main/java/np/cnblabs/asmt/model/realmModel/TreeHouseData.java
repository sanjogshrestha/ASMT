package np.cnblabs.asmt.model.realmModel;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by sanjogstha on 12/31/17.
 * CNB LABS
 * sanjogshrestha.nepal@gmail.com
 */

public class TreeHouseData extends RealmObject {
    private String status;
    private Integer count;
    private Integer countTotal;
    private Integer pages;
    private RealmList<PostData> posts = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCountTotal() {
        return countTotal;
    }

    public void setCountTotal(Integer countTotal) {
        this.countTotal = countTotal;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public RealmList<PostData> getPosts() {
        return posts;
    }

    public void setPosts(RealmList<PostData> posts) {
        this.posts = posts;
    }
}
