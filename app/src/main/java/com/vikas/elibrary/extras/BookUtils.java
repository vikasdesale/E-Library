package com.vikas.elibrary.extras;

import com.android.volley.RequestQueue;
import com.vikas.elibrary.info.Book;
import com.vikas.elibrary.json.Parser;
import com.vikas.elibrary.json.Requestor;
import com.vikas.elibrary.json.Urls;
import com.vikas.elibrary.materialtest.MyApplication;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Dell on 12/20/2015.
 */
    public class BookUtils {

    public static ArrayList<Book> loadBookList(RequestQueue requestQueue, String load)throws  Exception{
        JSONObject response= Requestor.sendJsonBooksRequest(requestQueue, Urls.BOOK_URL_1_12,load);
        ArrayList<Book> bookArrayList= Parser.parseJsonResponse(response);
        MyApplication.getWritableBookDatabase().insertBookList(bookArrayList,true);
        bookArrayList=  MyApplication.getWritableBookDatabase().getAllBookList();
        return  bookArrayList;
    }
}
