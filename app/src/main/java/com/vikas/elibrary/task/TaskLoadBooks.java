package com.vikas.elibrary.task;

import android.os.AsyncTask;

import com.android.volley.RequestQueue;
import com.vikas.elibrary.callback.BookListLoaderListener;
import com.vikas.elibrary.extras.BookUtils;
import com.vikas.elibrary.info.Book;
import com.vikas.elibrary.network.VolleySingalton;

import java.util.ArrayList;

/**
 * Created by Dell on 12/20/2015.
 */

public class TaskLoadBooks extends AsyncTask<Void,Void,ArrayList<Book>> {
    private BookListLoaderListener myComponents;
    private VolleySingalton volleySingalton;
    private RequestQueue requestQueue;
    String load;
    public TaskLoadBooks(BookListLoaderListener myComponents, String name1) {
        this.myComponents = myComponents;
        volleySingalton= VolleySingalton.getInstance();
        requestQueue = volleySingalton.getRequestQueue();
        this.load=name1;
    }


    @Override
    protected ArrayList<Book> doInBackground(Void... params) {
        ArrayList<Book> bookArrayList= null;
        try {
            bookArrayList = BookUtils.loadBookList(requestQueue, load);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookArrayList;
    }

        @Override
    protected void onPostExecute(ArrayList<Book> bookArrayList) {
            if(myComponents!=null){
                myComponents.onBookListLoaded(bookArrayList);
            }
    }



}
