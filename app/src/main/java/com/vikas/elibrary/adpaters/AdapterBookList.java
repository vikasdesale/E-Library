package com.vikas.elibrary.adpaters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.vikas.elibrary.activity.DownloadActivity;
import com.vikas.elibrary.R;
import com.vikas.elibrary.anim.AnimationUtils;
import com.vikas.elibrary.info.Book;
import com.vikas.elibrary.network.VolleySingalton;

import java.util.ArrayList;

/**
 * Created by Dell on 12/19/2015.
 */
public class AdapterBookList extends RecyclerView.Adapter<AdapterBookList.ViewHolderBookList> implements View.OnClickListener{

    private LayoutInflater layoutInflater;
    private VolleySingalton volleySingalton;
    private ImageLoader imageLoader;
    private ArrayList<Book> listBook=new ArrayList<>();
    private int mPreviousPosition = 0;
    Context context;
    String url;
    public AdapterBookList(Context context){
        this.context=context;
                       layoutInflater=LayoutInflater.from(context);
        volleySingalton=VolleySingalton.getInstance();
        imageLoader=volleySingalton.getImageLoader();
    }
    @Override
    public AdapterBookList.ViewHolderBookList onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.custom_row_one_book,parent,false);
        ViewHolderBookList viewHolder= null;
        try {
            viewHolder = new ViewHolderBookList(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return viewHolder;
    }
   public  void setBookList(ArrayList<Book> listBook){
       try {
           this.listBook=listBook;

             //  notifyItemRangeChanged(0,listBook.size());

           notifyDataSetChanged();

          // notify();

       }catch (Exception e){}
   }
    @Override
    public void onBindViewHolder(final AdapterBookList.ViewHolderBookList holder, final int position)throws IndexOutOfBoundsException{
              final Book currentBook=listBook.get(position);
        holder.bookTitle.setText(currentBook.getTitle());
        holder.bookMediam.setText(currentBook.getMediam());
        String urlThumb=currentBook.getUrlSelf();
        holder.ratingBar.setRating((float) (currentBook.getAudienceScore() / 20.0F));

        if(urlThumb!=null){
            imageLoader.get(urlThumb, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    holder.bookImage.setImageBitmap(response.getBitmap());
                }

                @Override
                public void onErrorResponse(VolleyError error) {
                    holder.bookImage.setImageResource(android.R.drawable.ic_menu_upload_you_tube);

                }
            });
        }else {
            holder.bookImage.setImageResource(android.R.drawable.ic_menu_upload_you_tube);
        }
        if (position > mPreviousPosition) {
            AnimationUtils.animateSunblind(holder, true);
//            AnimationUtils.animateSunblind(holder, true);
//            AnimationUtils.animate1(holder, true);
//            AnimationUtils.animate(holder,true);
        } else {
            AnimationUtils.animateSunblind(holder, false);
//            AnimationUtils.animateSunblind(holder, false);
//            AnimationUtils.animate1(holder, false);
//            AnimationUtils.animate(holder, false);
        }
        mPreviousPosition = position;

        holder.bDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url=currentBook.getUrlDown();
                if (url != null) {
                    Intent myIntent = new Intent(context, DownloadActivity.class);
                    myIntent.putExtra("key",url); //Optional parameters
                    context.startActivity(myIntent);
                }

            }
        });
        holder.bookImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url=currentBook.getUrlDown();
                if (url != null) {
                    Intent myIntent = new Intent(context, DownloadActivity.class);
                    myIntent.putExtra("key",url); //Optional parameters
                    context.startActivity(myIntent);
                }

            }
        });
        holder.bShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "E-Library");
                String  ss="\n\tShared by your friend.\nThis is amazing book "+currentBook.getTitle();
                String sAux = " \n\t\t\tYou are free to download books of various streams...";
                sAux = ss+sAux + "\n\t\t\tTo get this book and more than 1 Lac books,10,000+ Video Lectures,1000+ Audio Lectrues and many more download. \n Free..Free..Free\n    ......On the Application.....\n       ******E-Library******\n https://play.google.com/store/apps/details?id=com.vikas.elibrary \n\n"+"\n\t" +
                        "\t\t\t\t\t By\n\t\t\t\tVikas Desale";
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                context.startActivity(Intent.createChooser(i, "Choose one"));
            }
        });

    }

    @Override
    public int getItemCount()throws IndexOutOfBoundsException{
        return listBook.size();
    }

    @Override
    public void onClick(View v) {

    }


    static class ViewHolderBookList extends RecyclerView.ViewHolder  {
        private ImageView bookImage;
        private TextView bookTitle;
        private TextView  bookMediam;
        private ImageView bDownload;
        private ImageView bShare;
        private ImageView bDisp;
        private ImageView bMore;
        private RatingBar ratingBar;
        private ArrayList<Book> listBook=new ArrayList<>();

        public ViewHolderBookList(View itemView)throws Exception{
            super(itemView);
            bookImage= (ImageView) itemView.findViewById(R.id.imageBook);
            bookTitle= (TextView) itemView.findViewById(R.id.bookTitle);
            bookMediam= (TextView) itemView.findViewById(R.id.bookMediam);
            ratingBar= (RatingBar) itemView.findViewById(R.id.ratingBar);
            bDownload= (ImageView) itemView.findViewById(R.id.download);
            bShare= (ImageView) itemView.findViewById(R.id.share);
            //bDisp= (ImageView) itemView.findViewById(R.id.view);
           // bMore= (ImageView) itemView.findViewById(R.id.more);
        }


    }
}
