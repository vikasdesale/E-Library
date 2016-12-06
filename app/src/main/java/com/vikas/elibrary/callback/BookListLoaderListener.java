package com.vikas.elibrary.callback;

import com.vikas.elibrary.info.Book;

import java.util.ArrayList;

/**
 * Created by Dell on 12/20/2015.
 */
public interface BookListLoaderListener {

    public void onBookListLoaded(ArrayList<Book> bookArrayList);
}
