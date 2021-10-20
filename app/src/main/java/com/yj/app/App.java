package com.yj.app;

import android.app.Application;

import com.jkb.fragment.rigger.rigger.Rigger;

public class App extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    //Rigger.getRigger(this);
  }
}
