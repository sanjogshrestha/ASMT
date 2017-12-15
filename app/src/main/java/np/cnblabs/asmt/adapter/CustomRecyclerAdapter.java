package np.cnblabs.asmt.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import np.cnblabs.asmt.R;
import np.cnblabs.asmt.model.StudentModel;

/**
 * Created by sanjogstha on 12/15/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<StudentModel> studentModelList;

    public CustomRecyclerAdapter(Context context, List<StudentModel> studentModelList) {
        this.context = context;
        this.studentModelList = studentModelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        StudentModel studentModel = studentModelList.get(position);
        holder.nameTV.setText(studentModel.getName());
        holder.addressTV.setText(studentModel.getAddress());
        holder.rollTV.setText(String.valueOf(studentModel.getRoll()));
        holder.phoneTV.setText(String.valueOf(studentModel.getPhone()));
    }

    @Override
    public int getItemCount() {
        return studentModelList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTV, addressTV, phoneTV, rollTV;

        ViewHolder(View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.nameTV);
            addressTV = itemView.findViewById(R.id.addressTV);
            phoneTV = itemView.findViewById(R.id.phoneNumTV);
            rollTV = itemView.findViewById(R.id.rollNumTV);
        }
    }
}
