package com.lib.finalproject;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class NotificationAdapter extends ArrayAdapter<String> {
    private Context mContext;
    private ArrayList<Integer> mIcons;
    private ArrayList<String> mTexts;

    public NotificationAdapter(Context context, ArrayList<Integer> icons, ArrayList<String> texts) {
        super(context, R.layout.notification_item, texts);
        mContext = context;
        mIcons = icons;
        mTexts = texts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.notification_item, parent, false);

        ImageView iconImageView = view.findViewById(R.id.notification_icon);
        TextView textTextView = view.findViewById(R.id.notification_text);

        iconImageView.setImageResource(mIcons.get(position));
        textTextView.setText(mTexts.get(position));

        return view;
    }
}