package com.arworld.practika3;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class EventListAdapter extends BaseAdapter {


    Context context;
    public List<Event> eventList = new ArrayList<Event>();

    LayoutInflater inflater;


    public EventListAdapter(Context c, List<Event> schedulerlist) {
        this.context = c;
        this.eventList = schedulerlist;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return eventList.size();
    }

    @Override
    public Object getItem(int position) {
        return eventList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        if (convertView == null)
            vi = inflater.inflate(R.layout.event_item, null);
        ImageView profile = (ImageView) vi.findViewById(R.id.list_image);
        ImageView type = (ImageView) vi.findViewById(R.id.type);
        TextView eventViewStartEnd = (TextView) vi.findViewById(R.id.message);
        TextView eventViewLocation = (TextView) vi.findViewById(R.id.location);
        eventViewStartEnd.setText(eventList.get(position).getText1());
        eventViewLocation.setText(eventList.get(position).getText2());
        profile.setImageResource(eventList.get(position).getProfile());
        type.setImageResource(eventList.get(position).getType());
        return vi;
    }

}

