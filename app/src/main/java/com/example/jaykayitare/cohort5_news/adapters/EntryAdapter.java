package com.example.jaykayitare.cohort5_news.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jaykayitare.cohort5_news.R;
import com.example.jaykayitare.cohort5_news.models.Entry;

import java.util.List;


public class EntryAdapter extends BindableAdapter<Entry> {

    public EntryAdapter(Context context, List<Entry> episodeList) {
        super(context, episodeList);
    }

    @Override
    public View newView(LayoutInflater inflater, int position, ViewGroup container) {
        return inflater.inflate(R.layout.list_item_entry, container, false);
    }

    @Override
    public void bindView(Entry item, int position, View view) {
        TextView entryTitleTextView = (TextView) view.findViewById(R.id.entry_title);
        entryTitleTextView.setText(item.getTitle());

        TextView entryDescriptionTextView = (TextView) view.findViewById(R.id.entry_description);
        entryDescriptionTextView.setText(item.getDescription());
    }
}
