package com.example.jaykayitare.cohort5_news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.jaykayitare.cohort5_news.R;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.cards.material.MaterialLargeImageCard;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardGridArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardGridView;
import it.gmariotti.cardslib.library.view.CardViewNative;

public class Landing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

//        Array of cardviews
        ArrayList<Card> cards = new ArrayList<Card>();

        //array of images used in cardviews
        int listImages[] = new int[]{R.drawable.funds, R.drawable.politics, R.drawable.sport, R.drawable.tech};

//        array of titles of cardviews
        String listTitles[] = new String[]{"Business", "Politics", "Sports", "Technology"};

//        array of rss feed links
        final String listFeeds[] = new String[]{"http://www.economist.com/sections/business-finance/rss.xml","http://feeds.reuters.com/Reuters/PoliticsNews","http://newsrss.bbc.co.uk/rss/sportonline_uk_edition/front_page/rss.xml","http://feeds.wired.com/wired/index"};
        for(int i = 0; i<4; i++){
            //create final counter accessible from inner class
            final int counter = i;
            //Create a car
            Card card = new Card(this);
            //Add a picture
            CardThumbnail thumb = new CardThumbnail(this);
            thumb.setDrawableResource(listImages[i]);
            card.addCardThumbnail(thumb);

            //add title to card
            card.setTitle(listTitles[i]);

            //set listener
            card.setOnClickListener(new Card.OnCardClickListener() {
                @Override
                public void onClick(Card card, View view) {
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("url",listFeeds[counter]);
                    startActivity(intent);
                }
            });

            //add card to array list of cards
            cards.add(card);
        }

//        business.setOnClickListener(new Card.OnCardClickListener() {
//            @Override
//            public void onClick(Card card, View view) {
//                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                intent.putExtra("url","http://www.economist.com/sections/business-finance/rss.xml");
//                startActivity(intent);
//            }
//        });
//
//        politics.setOnClickListener(new Card.OnCardClickListener() {
//            @Override
//            public void onClick(Card card, View view) {
//                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                intent.putExtra("url","http://feeds.reuters.com/Reuters/PoliticsNews");
//                startActivity(intent);
//            }
//        });
//
//        sports.setOnClickListener(new Card.OnCardClickListener() {
//            @Override
//            public void onClick(Card card, View view) {
//                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                intent.putExtra("url","http://newsrss.bbc.co.uk/rss/sportonline_uk_edition/front_page/rss.xml");
//                startActivity(intent);
//            }
//        });
//
//        technology.setOnClickListener(new Card.OnCardClickListener() {
//            @Override
//            public void onClick(Card card, View view) {
//                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                intent.putExtra("url","http://feeds.wired.com/wired/index");
//                startActivity(intent);
//            }
//        });

//        CardViewNative businesscardview = (CardViewNative)findViewById(R.id.businesscard);
//        businesscardview.setCard(business);
//        CardViewNative politicscardview = (CardViewNative)findViewById(R.id.politicscard);
//        politicscardview.setCard(politics);
//        CardViewNative sportscardview = (CardViewNative)findViewById(R.id.sportscard);
//        sportscardview.setCard(sports);
//        CardViewNative technologycardview = (CardViewNative)findViewById(R.id.techcard);
//        technologycardview.setCard(technology);

        CardGridArrayAdapter mCardArrayAdapter = new CardGridArrayAdapter(getApplicationContext(),cards);

        CardGridView gridView = (CardGridView)findViewById(R.id.myGrid);
        if(gridView!=null){
            gridView.setAdapter(mCardArrayAdapter);
        }

    }
}
