package com.vikas.elibrary.info;

import android.os.Parcel;
import android.os.Parcelable;

import com.vikas.elibrary.Logging.L;

/**
 * Created by Dell on 12/19/2015.
 */
public class Book  implements Parcelable{
    private String id;
    private String title;
    private String  mediam;
    private long  audienceScore;
    private String urlSelf;
    private String author;
    private String description;
    private String urlDownload;
    private String urlView;
    private String urlShare;
    private String urlMore;
    private byte note1;
    private String note;
    private String type;
public Book(){

}
    public Book(String id,String title,String mediam,String audienceScore,String urlSelf,String author,String description,String urlDownload,String urlView,String urlShare,String urlMore,String note,String type)
    {
        this.id=id;
        this.title=title;
        this.mediam=mediam;
        this.audienceScore= Long.parseLong(audienceScore);
        this.urlSelf=urlSelf;
        this.author=author;
        this.description=description;
        this.urlDownload=urlDownload;
        this.urlView=urlView;
        this.urlShare=urlShare;
        this.urlMore=urlMore;
        this.note=note;
        this.type=type;
    }

    public Book(Parcel source) {
        id=source.readString();
        title=source.readString();
        mediam=source.readString();
        audienceScore=source.readLong();
       urlSelf= source.readString();
       author= source.readString();
       description= source.readString();
        urlDownload=source.readString();
        urlShare= source.readString();
        urlView= source.readString();
        urlMore= source.readString();
        type=source.readString();
        //note1=source.readByte();
       // if(note1==1) {note=true;}else{note=false;}
    }

    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id=id;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title=title;
    }
    public String getMediam()
    {
        return mediam;
    }
    public void setMediam(String mediam)
    {
        this.mediam=mediam;
    }
    public long  getAudienceScore()
    {
        return audienceScore;
    }
    public void setAudienceScore(long audienceScore)
    {
        this.audienceScore=audienceScore;
    }
    public String getUrlSelf()
    {
        return urlSelf;
    }
    public void setUrlSelf(String urlSelf)
    {
        this.urlSelf=urlSelf;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description=description;
    }
    public String getAuthor()
    {
        return author;
    }
    public String getUrlDown() {
        return urlDownload;
    }
    public void setUrlDown(String urlDownload){
        this.urlDownload=urlDownload;
    }
    public void setUrlShare(String urlShare){
        this.urlShare=urlShare;
    }
    public String getUrlShare(){
        return urlShare;
    }
    public String getUrlView(){
        return urlView;
    }
    public void setUrlView(String urlView){
        this.urlView=urlView;
    }
    public String getUrlMore(){
        return urlMore;
    }
    public void setUrlMore(String urlMore){
        this.urlMore=urlMore;
    }

    public void setAuthor(String author)
    {
        this.author=author;
    }
    public void setNote(String note) {
        this.note=note;
    }
    public String getNote(){
        return note;
    }

    public void setType(String string) {
        this.type=string;
    }
    public String getType() {
        return type;
    }
public  String toString(){
      return "ID:"+id+
              "Title:"+title+
              "Mediam:"+mediam+
              "Score :"+audienceScore+
              "URL_Image"+urlSelf;
}

    @Override
    public int describeContents() {
        L.m("descbie");
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
         L.m("write");
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(mediam);
        dest.writeLong(audienceScore);
        dest.writeString(urlSelf);
        dest.writeString(author);
        dest.writeString(description);
        dest.writeString(urlDownload);
        dest.writeString(urlShare);
        dest.writeString(urlView);
        dest.writeString(urlMore);
        dest.writeString(type);

    }
    public static final Parcelable.Creator<Book> CREATOR
            = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[0];
        }
    };


}
