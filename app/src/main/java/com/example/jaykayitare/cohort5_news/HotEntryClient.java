package com.example.jaykayitare.cohort5_news;

import android.util.Log;

import com.example.jaykayitare.cohort5_news.models.Entry;

import org.apache.http.Header;

import java.util.List;

import rejasupotaro.asyncrssclient.AsyncRssClient;
import rejasupotaro.asyncrssclient.AsyncRssResponseHandler;
import rejasupotaro.asyncrssclient.RssFeed;
import rejasupotaro.asyncrssclient.RssItem;


public class HotEntryClient {

    public HotEntryClient(String url){
        this.HOTENTRY_RSS_URL = url;
    }

    private static final String TAG = HotEntryClient.class.getSimpleName();

    private static final AsyncRssClient sClient = new AsyncRssClient();

    private static String HOTENTRY_RSS_URL;
    public static interface HotEntryResponseHandler {

        public void onResponse(List<Entry> rssItemList);

        public void onErrorResponse();
    }

    public void request(final HotEntryResponseHandler handler) {
        sClient.read(HOTENTRY_RSS_URL, new AsyncRssResponseHandler() {
            @Override
            public void onSuccess(RssFeed rssFeed) {
                List<RssItem> rssItemList = rssFeed.getRssItems();
                handler.onResponse(Entry.fromRssItem(rssItemList));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody,
                    Throwable error) {
                Log.e(TAG, "Request hot entry failed", error);
                handler.onErrorResponse();
            }
        });

    }
}
