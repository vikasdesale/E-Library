package com.vikas.elibrary.json;

import org.json.JSONObject;

/**
 * Created by Dell on 12/20/2015.
 */
public class Utils {
    public static  boolean contains(JSONObject jsonObject, String key) {

        return jsonObject!=null && jsonObject.has(key) && !jsonObject.isNull(key) ? true:false;
    }
}
