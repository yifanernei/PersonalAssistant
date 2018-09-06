package xyz.yifanernei.personalassistant.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import xyz.yifanernei.personalassistant.Enity.ProjectInfo;
import xyz.yifanernei.personalassistant.ProjectView;
import xyz.yifanernei.personalassistant.R;
import xyz.yifanernei.personalassistant.util.DateTime;

public class ProjectViewAdapter extends BaseAdapter {
    List<ProjectInfo> mData = new ArrayList<>();
    private LayoutInflater mInflater;

    public ProjectViewAdapter(Context context) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void clear()
    {
        mData.clear();
    }

    public void push_back(ProjectInfo info)
    {
        mData.add(info);
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int i) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;

        if (view == null)
        {
            view = mInflater.inflate(R.layout.listitem_project_view, null);
            holder = new ViewHolder();

            holder.tvName = view.findViewById(R.id.name);
            holder.tvStatus = view.findViewById(R.id.status);
            holder.tvCDate = view.findViewById(R.id.cdate);

            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }

        ProjectInfo pi = mData.get(i);
        holder.tvName.setText(pi.getName());
        holder.tvStatus.setText(pi.getStatus().toString());
        holder.tvCDate.setText(DateTime.fmt(pi.getCdate(), DateTime.Fmt_Date));

        return view;
    }

    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    class ViewHolder{
        public TextView tvName, tvStatus, tvCDate;
    }
}
