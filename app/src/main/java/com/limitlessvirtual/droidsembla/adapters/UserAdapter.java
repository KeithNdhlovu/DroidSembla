package com.limitlessvirtual.droidsembla.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.limitlessvirtual.droidsembla.R;
import com.limitlessvirtual.droidsembla.models.User;

import java.util.List;

/**
 * Created by keith on 2015/02/06.
 */
public class UserAdapter extends ArrayAdapter<User> {

    private LayoutInflater inflater;
    private Context context;

    public UserAdapter(Context context) {
        super(context, 0);
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void updateData(List<User> userList) {
        this.clear();
        for (User aUserList : userList) {
            add(aUserList);
        }
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.user_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.root = (LinearLayout) convertView.findViewById(R.id.userItem);
            viewHolder.usertvName = (TextView) convertView.findViewById(R.id.username);
            viewHolder.usertvEmail = (TextView) convertView.findViewById(R.id.user_email);
            viewHolder.usertvLoginId = (TextView) convertView.findViewById(R.id.user_id);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        editBackground(position, viewHolder);
        fillViewWithData(position, viewHolder);

        return convertView;
    }

    private void editBackground(int position, ViewHolder viewHolder) {
        if (position % 2 == 0) {
            viewHolder.root.setBackgroundColor(context.getResources().getColor(R.color.white));
        } else {
            viewHolder.root.setBackgroundColor(context.getResources().getColor(R.color.lightGray));
        }
    }

    private void fillViewWithData(int position, ViewHolder viewHolder) {
        viewHolder.usertvName.setText(getItem(position).getName());
        viewHolder.usertvEmail.setText(getItem(position).getEmail());
        viewHolder.usertvLoginId.setText(getItem(position).getLoginId());
    }

    static class ViewHolder {
        LinearLayout root;
        TextView usertvName;
        TextView usertvEmail;
        TextView usertvLoginId;
    }
}