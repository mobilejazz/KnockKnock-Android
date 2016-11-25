package com.mobilejazz.knockknock.library;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Knock {

  public enum Actor {
    WIFI,
    CELLULAR,
    ANY
  }

  private static Knock instance;
  private Context context;

  private Knock() {
  }

  /**
   * Default singleton instance.
   */
  public static Knock knock() {
    if (instance == null) {
      instance = new Knock();
    }

    return instance;
  }

  public void initialize(Context context) {
    this.context = context;
  }

  /**
   * True if reachable, False otherwise.
   */
  public boolean areYouThere() {
    checkContextParameter();

    return whosThere(Actor.ANY);
  }

  /**
   * True if reachable via the specific actor, False otherwise.
   */
  public boolean whosThere(Actor actor) {
    checkContextParameter();

    final ConnectivityManager connectivityManager =
        ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));

    NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();

    if (activeNetwork != null) {
      switch (actor) {
        case WIFI:
          return activeNetwork.getType() == ConnectivityManager.TYPE_WIFI
              && activeNetwork.isConnected();
        case CELLULAR:
          return activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE
              && activeNetwork.isConnected();
        case ANY:
        default:
          return activeNetwork.isConnected();
      }
    } else {
      return false;
    }
  }

  private void checkContextParameter() {
    if (context == null) {
      throw new IllegalStateException(
          "context == null | You must call to Knock.knock().initialize() method first");
    }
  }
}
