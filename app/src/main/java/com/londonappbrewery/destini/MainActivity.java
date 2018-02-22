package com.londonappbrewery.destini;

import android.net.Uri;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView StoryText;
    Button TopButton;
    Button BottomButton;
    int Index=1;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient mClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        StoryText = (TextView) findViewById(R.id.storyTextView);
        TopButton = (Button) findViewById(R.id.buttonTop);
        BottomButton = (Button) findViewById(R.id.buttonBottom);


        TopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Update(true);
            }
        });


        BottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Update(false);
            }
        });




        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
    private void Update ( boolean flag)
    {
        if (flag == true) {
            if (Index == 1) {
                StoryText.setText(R.string.T3_Story);
                TopButton.setText(R.string.T3_Ans1);
                BottomButton.setText(R.string.T3_Ans2);
                Index = 3;
            } else {
                StoryText.setText(R.string.T6_End);
                TopButton.setVisibility(View.GONE);
                BottomButton.setVisibility(View.GONE);

            }
        } else {
            if (Index == 1) {
                StoryText.setText(R.string.T2_Story);
                TopButton.setText(R.string.T2_Ans1);
                BottomButton.setText(R.string.T2_Ans2);
                Index = 2;
            } else if (Index == 2) {
                StoryText.setText(R.string.T4_End);
                TopButton.setVisibility(View.GONE);
                BottomButton.setVisibility(View.GONE);

            } else {
                StoryText.setText(R.string.T6_End);
                TopButton.setVisibility(View.GONE);
                BottomButton.setVisibility(View.GONE);
            }

        }

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient.connect();
        AppIndex.AppIndexApi.start(mClient, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(mClient, getIndexApiAction());
        mClient.disconnect();
    }
}
