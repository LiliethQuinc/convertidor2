package com.example.actividaduno;

import android.content.Context;
import android.content.SharedPreferences;

public class decimales {
    public static String NUMERODECIMAL="numerodecimal";

    public static void  setStringPref(Context context, String prefKey,String key,String value){
        SharedPreferences sp=context.getSharedPreferences(prefKey,0);
        SharedPreferences.Editor edit=sp.edit();
        edit.putString(key,value);
        edit.apply();
    }

    public static String getStringPref(Context context,String prefName,String key){
        SharedPreferences sp=context.getSharedPreferences(prefName,0);
        return sp.getString(key,"");
    }

    public static final class prefKey{
        public static final String DECIMAL="decimal";
    }
}
