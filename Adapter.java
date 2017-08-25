package preeti.singh.listviewcustomize;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by PS on 15-08-2017.
 */
public class Adapter extends ArrayAdapter<InfoList> {

    private Context mContext;
    private int layoutResourceId;
    private ArrayList<InfoList> infoLists = new ArrayList<InfoList>();

    public Adapter(Context mContext, int layoutResourceId, ArrayList<InfoList> infoLists) {

        super(mContext, layoutResourceId, infoLists);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.infoLists = infoLists;
    }
    /**
     * Updates grid data and refresh grid items.
     * @param infoLists
     */
    public void setGridData(ArrayList<InfoList> infoLists) {
        this.infoLists = infoLists;
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder;

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.Name= (TextView) row.findViewById(R.id.name);
            holder.Category = (TextView) row.findViewById(R.id.email);
            holder.Id=(TextView)row.findViewById(R.id.phno);
            holder.Value = (TextView)row.findViewById(R.id.caretaker);
            holder.RestaurantId = (TextView)row.findViewById(R.id.caretaker);

            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }
        final InfoList item = infoLists.get(position);
        holder.Name.setText(Html.fromHtml(item.getName()));
        holder.Category.setText(Html.fromHtml(item.getCategory()));
        holder.Id.setText(Html.fromHtml(String.valueOf(item.getId())));
        holder.Value.setText(Html.fromHtml(String.valueOf(item.getValue())));
        holder.RestaurantId.setText(Html.fromHtml(String.valueOf(item.getRestaurantId())));

        return row;
    }

    static class ViewHolder {

        TextView Name,Category,Id,Value,RestaurantId;
    }
}



