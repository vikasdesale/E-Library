package com.vikas.elibrary.json;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by Dell on 12/20/2015.
 */
public class Requestor {

    public static JSONObject sendJsonBooksRequest(RequestQueue requestQueue, String url,String load) {
        JSONObject response = null;


        RequestFuture<JSONObject> requestFuture = RequestFuture.newFuture();
        Map<String, String> map = new HashMap<String, String>();
        map.put("type",load);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,url,new JSONObject(map),
                 requestFuture, requestFuture);

        requestQueue.add(request);

        try {
            response = requestFuture.get(120000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return response;
    }
}