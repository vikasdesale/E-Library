package com.vikas.elibrary.network;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.vikas.elibrary.materialtest.MyApplication;

/**
 * Created by Dell on 12/19/2015.
 */
public class VolleySingalton {

    private static VolleySingalton sInstance=null;
    private RequestQueue mRequestQueue;
    private ImageLoader imageLoader;
    private VolleySingalton() {

        mRequestQueue= Volley.newRequestQueue(MyApplication.getAppContext());
       imageLoader=new ImageLoader(mRequestQueue, new ImageLoader.ImageCache() {

           private LruCache<String,Bitmap> cache=new LruCache<>((int)(Runtime.getRuntime().maxMemory()/1024)/8);
           @Override
           public Bitmap getBitmap(String url) {
               return cache.get(url);
           }

           @Override
           public void putBitmap(String url, Bitmap bitmap) {
               cache.put(url,bitmap);
           }
       });
    }

    public static VolleySingalton getInstance() {

        if(sInstance==null){
            sInstance=new VolleySingalton();
        }

        return sInstance;
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }
}

