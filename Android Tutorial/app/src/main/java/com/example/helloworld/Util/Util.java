package com.example.helloworld.Util;

import android.content.Context;
import android.content.res.Resources;

import com.example.helloworld.R;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class Util {
    public static JSONObject filetoJson(int file, Context context){
        try {
            Resources res = context.getResources();
            InputStream in_s = res.openRawResource(file);
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            String strData = new String(b);
            return new JSONObject(strData);
        }catch (Exception e){
            return null;
        }
    }
}
