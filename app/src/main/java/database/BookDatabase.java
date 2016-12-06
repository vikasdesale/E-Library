package database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.vikas.elibrary.Logging.L;
import com.vikas.elibrary.info.Book;

import java.util.ArrayList;

/**
 * Created by Dell on 12/20/2015.
 */
public class BookDatabase {


   private   BookHelper bookHelper;
    private SQLiteDatabase sqLiteDatabase;

    public BookDatabase(Context context){
        bookHelper=new BookHelper(context);
        sqLiteDatabase=bookHelper.getWritableDatabase();
    }

    public void insertBookList(ArrayList<Book> bookArrayList,boolean clearPrevious){
        if(clearPrevious){
            deleteAll();
        }


        String sql="INSERT INTO "+bookHelper.TABLE_BOOK_LIST+" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);";

        SQLiteStatement sqLiteStatement=sqLiteDatabase.compileStatement(sql);
        sqLiteDatabase.beginTransaction();
        for(int i=0;i<bookArrayList.size();i++){
            Book currentBook=bookArrayList.get(i);
            int bool;
            sqLiteStatement.clearBindings();
            sqLiteStatement.bindString(2, currentBook.getTitle());
            sqLiteStatement.bindString(3, currentBook.getMediam());
            sqLiteStatement.bindLong(4, currentBook.getAudienceScore());
            sqLiteStatement.bindString(5, currentBook.getUrlSelf());
            sqLiteStatement.bindString(6, currentBook.getAuthor());
            sqLiteStatement.bindString(7, currentBook.getDescription());
            sqLiteStatement.bindString(8, currentBook.getUrlDown());
            sqLiteStatement.bindString(9, currentBook.getUrlShare());
            sqLiteStatement.bindString(10, currentBook.getUrlView());
            sqLiteStatement.bindString(11, currentBook.getUrlMore());
            sqLiteStatement.bindString(12, currentBook.getNote());
            sqLiteStatement.bindString(13, currentBook.getType());
            L.m("inser enty " + i);
            sqLiteStatement.execute();
        }
        sqLiteDatabase.setTransactionSuccessful();
        sqLiteDatabase.endTransaction();
    }

    public ArrayList<Book> getAllBookList(){

        ArrayList<Book> bookArrayList=new ArrayList<>();

        String[] columns={
          BookHelper.COLUMN_ID,BookHelper.COLUMN_TITLE,BookHelper.COLUMN_MEDIAM,BookHelper.COLUMN_SCORE,BookHelper.COLUMN_URLSELF,BookHelper.COLUMN_AUTHOR,BookHelper.COLUMN_DESCRIPTION,
        BookHelper.COLUMN_DOWNLOAD,BookHelper.COLUMN_SHARE,BookHelper.COLUMN_VIEW,BookHelper.COLUMN_MORE,BookHelper.COLUMN_NOTE,BookHelper.COLUMN_TYPE};
        Cursor cursor=sqLiteDatabase.query(BookHelper.TABLE_BOOK_LIST,columns,null,null,null,null,null);
        if(cursor!=null&&cursor.moveToFirst()){
            do{
                Book book=new Book();
                book.setTitle(cursor.getString(cursor.getColumnIndex(BookHelper.COLUMN_TITLE)));
                book.setMediam(cursor.getString(cursor.getColumnIndex(BookHelper.COLUMN_MEDIAM)));
                String auidScore=cursor.getString(cursor.getColumnIndex(BookHelper.COLUMN_SCORE));
                book.setAudienceScore(Long.parseLong(auidScore));
                book.setUrlSelf(cursor.getString(cursor.getColumnIndex(BookHelper.COLUMN_URLSELF)));
                book.setAuthor(cursor.getString(cursor.getColumnIndex(BookHelper.COLUMN_AUTHOR)));
                book.setDescription(cursor.getString(cursor.getColumnIndex(BookHelper.COLUMN_DESCRIPTION)));
                book.setUrlDown(cursor.getString(cursor.getColumnIndex(BookHelper.COLUMN_DOWNLOAD)));
                book.setUrlShare(cursor.getString(cursor.getColumnIndex(BookHelper.COLUMN_SHARE)));
                book.setUrlView(cursor.getString(cursor.getColumnIndex(BookHelper.COLUMN_VIEW)));
                book.setUrlMore(cursor.getString(cursor.getColumnIndex(BookHelper.COLUMN_MORE)));
                book.setNote(cursor.getString(cursor.getColumnIndex(BookHelper.COLUMN_NOTE)));
                book.setType(cursor.getString(cursor.getColumnIndex(BookHelper.COLUMN_TYPE)));

                L.m("gettting book object" + book);
                bookArrayList.add(book);
                            }while(cursor.moveToNext());
        }
        return  bookArrayList;

    }
    public  void deleteAll(){
        sqLiteDatabase.delete(BookHelper.TABLE_BOOK_LIST,null,null);
    }
    private static class BookHelper extends SQLiteOpenHelper{

        private Context mContext;
        private static final String DB_NAME="book_db";
        private static final int DB_VERSION=1;
        private static final String TABLE_BOOK_LIST="book_list";
        public static final String COLUMN_ID="id";
        public static final String COLUMN_TITLE= "title";
        public static final String COLUMN_MEDIAM= "mediam";
        public static final String COLUMN_SCORE="audienceScore";
        public static final String COLUMN_URLSELF="urlSelf";
        public static final String COLUMN_AUTHOR="author";
        public static final String COLUMN_DESCRIPTION="description";
        public static final String COLUMN_DOWNLOAD="download";
        public static final String COLUMN_SHARE="share";
        public static final String COLUMN_VIEW="view";
        public static final String COLUMN_MORE="more";
        public static final String COLUMN_NOTE="bool";
        public static final String COLUMN_TYPE="type";
        private static final String CREATE_TABLE_BOOK_LIST="CREATE TABLE "+TABLE_BOOK_LIST+"("+
                COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_TITLE+" TEXT, "+
                COLUMN_MEDIAM+" TEXT, "+
                COLUMN_SCORE+" INTEGER, "+
                COLUMN_URLSELF+" TEXT, "+
                COLUMN_AUTHOR+" TEXT, "+
                COLUMN_DESCRIPTION+" TEXT, "+
                COLUMN_DOWNLOAD+" TEXT, "+
                COLUMN_SHARE+" TEXT, "+
                COLUMN_VIEW+" TEXT, "+
                COLUMN_MORE+" TEXT, "+
                COLUMN_NOTE+" TEXT, "+
                COLUMN_TYPE+" TEXT " + " );";
        public BookHelper(Context context){
            super(context,DB_NAME,null,DB_VERSION);
              mContext=context;
        }



        @Override
        public void onCreate(SQLiteDatabase db) {
             try{
                 db.execSQL(CREATE_TABLE_BOOK_LIST);
                 L.m("CREATE TABLE BOOK LIST EXceuted");
             }catch (SQLiteException exception){
                 L.t(mContext,exception+"");
             }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
              try{
                  L.m("upgarde table book list executed");
                  db.execSQL("DROP TABLE " + TABLE_BOOK_LIST + " IF EXISTS;");
                  onCreate(db);
              }catch (SQLiteException e){
                  L.t(mContext,e+"");
              }
        }
    }
}
