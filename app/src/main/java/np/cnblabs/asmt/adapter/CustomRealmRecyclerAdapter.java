package np.cnblabs.asmt.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import np.cnblabs.asmt.R;
import np.cnblabs.asmt.model.realmModel.RealmModelData;

/**
 * Created by sanjogstha on 12/15/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public class CustomRealmRecyclerAdapter extends RecyclerView.Adapter<CustomRealmRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<RealmModelData> realmModelDataList;
    setOnClickListener listener;

    public CustomRealmRecyclerAdapter(Context context, List<RealmModelData> studentModelList) {
        this.context = context;
        this.realmModelDataList = studentModelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_realm_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final RealmModelData studentModel = realmModelDataList.get(position);
        holder.nameTV.setText(studentModel.getName());
        holder.emailTV.setText(studentModel.getEmail());
        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(studentModel.getEmail());
            }
        });
    }

    @Override
    public int getItemCount() {
        return realmModelDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTV, emailTV;
        Button deleteBtn;

        ViewHolder(View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.nameTV);
            emailTV = itemView.findViewById(R.id.emailTV);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
        }
    }

    public void setOnClick(setOnClickListener listener){
        this.listener = listener;
    }

    public interface setOnClickListener{
        void onClick(String email);
    }
}
