package com.example.jaykayitare.cohort5_news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.jaykayitare.cohort5_news.R;

import it.gmariotti.cardslib.library.cards.material.MaterialLargeImageCard;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.view.CardViewNative;

public class Landing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        MaterialLargeImageCard business = MaterialLargeImageCard.with(getApplicationContext())
                .setTextOverImage("Business")
                .useDrawableId(R.drawable.funds)
                .build();

        MaterialLargeImageCard politics = MaterialLargeImageCard.with(getApplicationContext())
                .setTextOverImage("Politics")
                .useDrawableId(R.drawable.politics)
                .build();

        MaterialLargeImageCard sports = MaterialLargeImageCard.with(getApplicationContext())
                .setTextOverImage("Sports")
                .useDrawableId(R.drawable.sport)
                .build();

        MaterialLargeImageCard technology = MaterialLargeImageCard.with(getApplicationContext())
                .setTextOverImage("Technology")
                .useDrawableId(R.drawable.tech)
                .build();

        business.setOnClickListener(new Card.OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("url","http://www.economist.com/sections/business-finance/rss.xml");
                startActivity(intent);
            }
        });

        politics.setOnClickListener(new Card.OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("url","http://feeds.reuters.com/Reuters/PoliticsNews");
                startActivity(intent);
            }
        });

        sports.setOnClickListener(new Card.OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("url","http://newsrss.bbc.co.uk/rss/sportonline_uk_edition/front_page/rss.xml");
                startActivity(intent);
            }
        });

        technology.setOnClickListener(new Card.OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("url","http://feeds.wired.com/wired/index");
                startActivity(intent);
            }
        });

        CardViewNative businesscardview = (CardViewNative)findViewById(R.id.businesscard);
        businesscardview.setCard(business);
        CardViewNative politicscardview = (CardViewNative)findViewById(R.id.politicscard);
        politicscardview.setCard(politics);
        CardViewNative sportscardview = (CardViewNative)findViewById(R.id.sportscard);
        sportscardview.setCard(sports);
        CardViewNative technologycardview = (CardViewNative)findViewById(R.id.techcard);
        technologycardview.setCard(technology);
    }
}
