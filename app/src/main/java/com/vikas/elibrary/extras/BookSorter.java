package com.vikas.elibrary.extras;

import com.vikas.elibrary.info.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Dell on 12/21/2015.
 */
public class BookSorter {
    public void sortBooksByName(ArrayList<Book> Books){
     Collections.sort(Books, new Comparator<Book>() {
            @Override
            public int compare(Book lhs, Book rhs) {
                return lhs.getTitle().compareTo(rhs.getTitle());
            }
        });
    }


    public void sortBooksByRating(ArrayList<Book> Books){
        Collections.sort(Books, new Comparator<Book>() {
            @Override
            public int compare(Book lhs, Book rhs) {
                int ratingLhs= (int) lhs.getAudienceScore();
                int ratingRhs= (int) rhs.getAudienceScore();
                if(ratingLhs<ratingRhs)
                {
                    return 1;
                }
                else if(ratingLhs>ratingRhs)
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            }
        });
    }



}