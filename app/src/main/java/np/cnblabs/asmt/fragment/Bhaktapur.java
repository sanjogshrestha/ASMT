package np.cnblabs.asmt.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import np.cnblabs.asmt.R;

/**
 * Created by sanjogstha on 12/28/17.
 * CNB LABS
 * sanjogshrestha.nepal@gmail.com
 */

public class Bhaktapur extends Fragment {
    public static Fragment newInstance() {
        return new Bhaktapur();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bhaktapur, container, false);
    }
}
