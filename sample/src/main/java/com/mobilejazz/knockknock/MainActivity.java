package com.mobilejazz.knockknock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.mobilejazz.knockknock.library.Knock;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = "Knock";

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Knock.knock().initialize(this);

    boolean areYouThere = Knock.knock().areYouThere();
    Log.d(TAG, "Are you there: " + areYouThere);

    boolean areYouWifi = Knock.knock().whosThere(Knock.Actor.WIFI);
    boolean areYouCellular = Knock.knock().whosThere(Knock.Actor.CELLULAR);
    boolean areYouAny = Knock.knock().whosThere(Knock.Actor.ANY);

    Log.d(TAG, "Are you wifi: " + areYouWifi);
    Log.d(TAG, "Are you cellular: " + areYouCellular);
    Log.d(TAG, "Are you any: " + areYouAny);
  }
}
