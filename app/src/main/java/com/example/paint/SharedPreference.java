package com.example.paint;

import android.content.Context;
import android.content.SharedPreferences;

class PreferenceProvider {

  private static SharedPreferences sharedPreference ;
  private static final String SHARED_PREF = "PAINT" ;
  private static SharedPreferences.Editor editor ;


  public static void setValue( Context context , String key , String value){

    sharedPreference = context.getSharedPreferences(SHARED_PREF , context.MODE_PRIVATE);
    editor = sharedPreference.edit() ;
    editor.putString(key , value);
    editor.commit();

  }

  public static String getValue(Context context ,  String key){
    sharedPreference = context.getSharedPreferences(SHARED_PREF , context.MODE_PRIVATE);
   return  sharedPreference.getString(key ,"" );

  }



}
