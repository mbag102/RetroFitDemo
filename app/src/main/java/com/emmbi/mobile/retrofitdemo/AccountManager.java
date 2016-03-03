package com.emmbi.mobile.retrofitdemo;

import android.content.Context;
import android.content.SharedPreferences;

import com.securepreferences.SecurePreferences;

/**
 * Created by mbagliojr on 3/2/16.
 */
public class AccountManager {

    private static String token;

    public static void setToken(String newToken, Context context) {
        token = newToken;

        SharedPreferences prefs = new SecurePreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("token", token);
        editor.commit();
    }

    public static String getToken(Context context) {
        if(token != null) {
            return token;
        } else {
            SharedPreferences prefs = new SecurePreferences(context);
            token = prefs.getString("token", null);
            return token;
        }
    }
}
