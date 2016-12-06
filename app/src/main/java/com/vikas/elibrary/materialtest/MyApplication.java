package com.vikas.elibrary.materialtest;

import android.app.Application;
import android.content.Context;

import database.BookDatabase;

/**
 * Created by Dell on 12/19/2015.
 */
public class MyApplication extends Application {

 public static MyApplication sInstance;
    public static BookDatabase bookDatabase;
    @Override
    public void onCreate(){
        super.onCreate();
        sInstance=this;
        bookDatabase=new BookDatabase(this);
    }
    public synchronized  static  BookDatabase getWritableBookDatabase(){
        if(bookDatabase==null){
            bookDatabase=new BookDatabase(getAppContext());
        }
        return bookDatabase;
    }

    public static MyApplication getInstance() {
        return sInstance;
    }
    public static Context getAppContext()
    {
        return sInstance.getApplicationContext();
    }
}
