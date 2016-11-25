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

  /**
   * True if reachable, False otherwise.
   */
  public boolean areYouThere(Context context) {
    return whosThere(context, Actor.ANY);
  }

  /**
   * True if reachable via the specific actor, False otherwise.
   */
  public boolean whosThere(Context context, Actor actor) {
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
}
