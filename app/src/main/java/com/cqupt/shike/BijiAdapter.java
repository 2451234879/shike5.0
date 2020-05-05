package com.cqupt.shike;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class BijiAdapter extends ArrayAdapter<Biji> {
    private int resourceID;
    public BijiAdapter(@NonNull Context context, int resource, @NonNull List<Biji> objects) {
        super(context, resource, objects);
        resourceID=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Biji biji = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceID,parent,false);
        }else {
            view = convertView;
        }
        TextView bijiId = (TextView)view.findViewById(R.id.biji_id);
        TextView bijiTitle = (TextView)view.findViewById(R.id.biji_title);
        bijiId.setText("标题");
        bijiTitle.setText(biji.getTitle());
        return view;
    }
}

