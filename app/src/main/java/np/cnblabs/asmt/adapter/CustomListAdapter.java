package np.cnblabs.asmt.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import np.cnblabs.asmt.ListViewActivity;
import np.cnblabs.asmt.R;

/**
 * Created by sanjogstha on 12/14/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public class CustomListAdapter extends ArrayAdapter {
    private Context context;
    private String[] sports;
    private int[] sportsIcon;

    public CustomListAdapter(ListViewActivity context, String[] sports, int[] sportsIcon) {
        super(context, R.layout.custom_list_item, sports);
        this.context = context;
        this.sports = sports;
        this.sportsIcon  = sportsIcon;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(layoutInflater != null) {
            convertView = layoutInflater.inflate(R.layout.custom_list_item, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.title = convertView.findViewById(R.id.title);
            viewHolder.imageView = convertView.findViewById(R.id.imageView);
            viewHolder.parentLayout = convertView.findViewById(R.id.parentLayout);

            if(position % 2 == 0){
                viewHolder.parentLayout.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
            }else
                viewHolder.parentLayout.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));

            String title = sports[position];
            int icon = sportsIcon[position];

            viewHolder.title.setText(title);
            viewHolder.imageView.setImageDrawable(ContextCompat.getDrawable(context, icon));
        }
        return convertView;
    }

    @Override
    public int getCount() {
        return sports.length;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return sports[position];
    }

    class ViewHolder{
        TextView title;
        ImageView imageView;
        LinearLayout parentLayout;
    }
}
