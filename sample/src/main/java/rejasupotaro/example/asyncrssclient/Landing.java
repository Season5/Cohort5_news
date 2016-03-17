package rejasupotaro.example.asyncrssclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class Landing extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        Button business, politics, sports, technology;

        business = (Button)findViewById(R.id.buttonbusiness);
        business.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.buttonbusiness:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("feed","http://feeds.bbci.co.uk/news/business/rss.xml");
                this.startActivity(intent);
                break;
            case R.id.buttonsports:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("feed","http://www.espnf1.com/rss/motorsport/story/feeds/2803.xml?type=2");
                startActivity(intent);
                break;
            case R.id.buttontechnology:
                 intent = new Intent(this, MainActivity.class);
                intent.putExtra("feed","http://feeds.bbci.co.uk/news/technology/rss.xml");
                startActivity(intent);
                break;
            case R.id.buttonpolitics:
                 intent = new Intent(this, MainActivity.class);
                intent.putExtra("feed","http://feeds.bbci.co.uk/news/world/rss.xml");
                startActivity(intent);
                break;
            default:
                break;
        }


    }
}
