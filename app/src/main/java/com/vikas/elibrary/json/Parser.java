package com.vikas.elibrary.json;

import com.vikas.elibrary.extras.Constants;
import com.vikas.elibrary.info.Book;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static com.vikas.elibrary.extras.Keys.BooksLib.KEY_AUTHOR;
import static com.vikas.elibrary.extras.Keys.BooksLib.KEY_BOOKS;
import static com.vikas.elibrary.extras.Keys.BooksLib.KEY_DESCRIPTION;
import static com.vikas.elibrary.extras.Keys.BooksLib.KEY_DOWNLOAD;
import static com.vikas.elibrary.extras.Keys.BooksLib.KEY_ID;
import static com.vikas.elibrary.extras.Keys.BooksLib.KEY_MEDIAM;
import static com.vikas.elibrary.extras.Keys.BooksLib.KEY_MORE;
import static com.vikas.elibrary.extras.Keys.BooksLib.KEY_NOTE;
import static com.vikas.elibrary.extras.Keys.BooksLib.KEY_SCORE;
import static com.vikas.elibrary.extras.Keys.BooksLib.KEY_SHARE;
import static com.vikas.elibrary.extras.Keys.BooksLib.KEY_TITLE;
import static com.vikas.elibrary.extras.Keys.BooksLib.KEY_TYPE;
import static com.vikas.elibrary.extras.Keys.BooksLib.KEY_URLSELF;
import static com.vikas.elibrary.extras.Keys.BooksLib.KEY_VIEW;
import static com.vikas.elibrary.json.Utils.contains;

/**
 * Created by Dell on 12/20/2015.
 */
public class Parser {
    public static ArrayList<Book> parseJsonResponse(JSONObject response) {
        ArrayList<Book> bookArrayList=new ArrayList<>();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        if(response!=null&&response.length()>0) {


            try {
                StringBuilder builder = new StringBuilder();
                JSONArray arrayBooks = null;
                if (response.has(KEY_BOOKS)) {
                    arrayBooks = response.getJSONArray(KEY_BOOKS);
                }
                for (int i = 0; i < arrayBooks.length(); i++) {

                    String id = Constants.NA;
                    String title = Constants.NA;
                    String  medium = Constants.NA;
                    String audience_Score = Constants.NA;
                    String urlSelf = Constants.NA;
                    String bAuthor = Constants.NA;
                    String bDesc = Constants.NA;
                    String bDownload=Constants.NA;
                    String bShare=Constants.NA;
                    String bView=Constants.NA;
                    String bMore=Constants.NA;
                    String note=Constants.NA;
                    String bType=Constants.NA;
                    JSONObject currentBook = arrayBooks.getJSONObject(i);

                    if(contains(currentBook,KEY_ID)) {
                        id = currentBook.getString(KEY_ID);
                    }
                    if(contains(currentBook,KEY_TITLE)) {
                        title = currentBook.getString(KEY_TITLE);
                    }
                    if(contains(currentBook,KEY_MEDIAM)) {
                        medium = currentBook.getString(KEY_MEDIAM);
                    }
                    if(contains(currentBook,KEY_SCORE)) {
                        audience_Score = currentBook.getString(KEY_SCORE);
                    }
                    if(contains(currentBook,KEY_URLSELF)) {
                        urlSelf = currentBook.getString(KEY_URLSELF);
                    }
                    if(contains(currentBook,KEY_AUTHOR)) {
                        bAuthor = currentBook.getString(KEY_AUTHOR);
                    }
                    if(contains(currentBook,KEY_DESCRIPTION)) {
                        bDesc = currentBook.getString(KEY_DESCRIPTION);
                    }
                    if(contains(currentBook,KEY_AUTHOR)) {
                        bAuthor = currentBook.getString(KEY_AUTHOR);
                    }
                    if(contains(currentBook,KEY_DESCRIPTION)) {
                        bDesc = currentBook.getString(KEY_DESCRIPTION);
                    }
                    if(contains(currentBook,KEY_AUTHOR)) {
                        bAuthor = currentBook.getString(KEY_AUTHOR);
                    }
                    if(contains(currentBook,KEY_DESCRIPTION)) {
                        bDesc = currentBook.getString(KEY_DESCRIPTION);
                    }
                    if(contains(currentBook,KEY_DOWNLOAD)) {
                        bDownload = currentBook.getString(KEY_DOWNLOAD);
                    }
                    if(contains(currentBook,KEY_SHARE)) {
                        bShare= currentBook.getString(KEY_SHARE);
                    }
                    if(contains(currentBook,KEY_VIEW)) {
                        bView= currentBook.getString(KEY_VIEW);
                    }
                    if(contains(currentBook,KEY_MORE)) {
                        bView= currentBook.getString(KEY_MORE);
                    }
                    if(contains(currentBook,KEY_NOTE)){
                        note=currentBook.getString(KEY_NOTE);

                    }
                    if(contains(currentBook,KEY_TYPE)){
                        bType=currentBook.getString(KEY_TYPE);

                    }
                    Book book = new Book();
                    book.setId(id);
                    book.setTitle(title);
                    book.setMediam(medium);
                    book.setAudienceScore(Long.parseLong(audience_Score));
                    book.setUrlSelf(urlSelf);
                    book.setAuthor(bAuthor);
                    book.setDescription(bDesc);
                    book.setUrlDown(bDownload);
                    book.setUrlShare(bShare);
                    book.setUrlView(bView);
                    book.setUrlMore(bMore);
                    book.setNote(note);
                    book.setType(bType);
                    bookArrayList.add(book);
                }
                //   L.t(getActivity(), bookArrayList.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return  bookArrayList;
    }

}


