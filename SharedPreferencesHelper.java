package com.example.mohammad.nouran;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;

public class SharedPreferencesHelper {

    public static String SHARED_PREFERENCES_FILE = "mySharedPref" ;


    public static void setSharePref(Context context, String key, int value){
        SharedPreferences sharedPref=context.getSharedPreferences(SHARED_PREFERENCES_FILE,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(key,value);
        editor.commit();
    }

    public static void setSharePref(Context context, String key, String value){
        SharedPreferences sharedPref=context.getSharedPreferences(SHARED_PREFERENCES_FILE,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key,value);
        editor.commit();
    }

    public static void setSharePref(Context context, String key , boolean value){
        SharedPreferences sharedPref=context.getSharedPreferences(SHARED_PREFERENCES_FILE,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(key,value);
        editor.commit();
    }


    public  static int getIntSharedPref(Context context , String key)
    {
        SharedPreferences sharedPref = context.getSharedPreferences(SHARED_PREFERENCES_FILE , Context.MODE_PRIVATE);
        int defaultValue = 0;
        return sharedPref.getInt(key, defaultValue);

    }

    public  static int getIntYearSharedPref(Context context , String key)
    {
        SharedPreferences sharedPref = context.getSharedPreferences(SHARED_PREFERENCES_FILE , Context.MODE_PRIVATE);
        int defaultValue = 2018;
        return sharedPref.getInt(key, defaultValue);

    }

    public  static String getEmailSharedPref(Context context , String key)
    {
        SharedPreferences sharedPref = context.getSharedPreferences(SHARED_PREFERENCES_FILE , Context.MODE_PRIVATE);
        String defaultValue = "mohammadomartaha1994@gmail.com";
        return sharedPref.getString(key, defaultValue);

    }


    public  static String getStringSharedPref(Context context , String key)
    {
        SharedPreferences sharedPref = context.getSharedPreferences(SHARED_PREFERENCES_FILE , Context.MODE_PRIVATE);
        String defaultValue = "";
        return sharedPref.getString(key, defaultValue);

    }


    public  static boolean getBooleanSharedPref(Context context , String key)
    {
        SharedPreferences sharedPref = context.getSharedPreferences(SHARED_PREFERENCES_FILE , Context.MODE_PRIVATE);
        boolean defaultValue = false ;
        return sharedPref.getBoolean(key, defaultValue);

    }




}