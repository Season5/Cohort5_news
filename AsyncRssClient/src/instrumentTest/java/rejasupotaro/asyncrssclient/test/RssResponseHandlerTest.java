package rejasupotaro.asyncrssclient.test;

import android.net.Uri;
import android.test.InstrumentationTestCase;

import rejasupotaro.asyncrssclient.RssResponseHandler;
import rejasupotaro.asyncrssclient.models.RssFeed;
import rejasupotaro.asyncrssclient.models.RssItem;

public class RssResponseHandlerTest extends InstrumentationTestCase {

    public void testParse() throws Exception {
        String testData = AssetsUtils.read(getInstrumentation(), "feeds_rebuild_fm.xml");
        assertNotNull(testData);

        RssResponseHandler rssResponseHandler = new RssResponseHandler();

        RssFeed rssFeed = rssResponseHandler.parse(testData);
        assertNotNull(rssFeed);
        assertEquals("Rebuild", rssFeed.getTitle());
        assertEquals("ウェブ開発、プログラミング、モバイル、ガジェットなどにフォーカスしたテクノロジー系ポッドキャストです。", rssFeed.getDescription());
        assertEquals(Uri.parse("http://rebuild.fm"), rssFeed.getLink());
        assertEquals(24, rssFeed.getRssItemList().size());

        RssItem rssItem = rssFeed.getRssItemList().get(0);
        assertNotNull(rssItem);
        assertEquals("24: Go, Mavericks, LinkedIn Intro (typester)", rssItem.getTitle());
        assertNotNull(rssItem.getDescription());
        assertEquals("Thu, 31 Oct 2013 00:00:00 -0700", rssItem.getPubDate());
        assertEquals(Uri.parse("http://rebuild.fm/24/"), rssItem.getLink());
        assertEquals(Uri.parse("http://tracking.feedpress.it/link/1949/5437/podcast-ep24.mp3"), rssItem.getMediaEnclosure().getUrl());
    }
}