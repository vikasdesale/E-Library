package com.vikas.elibrary.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.vikas.elibrary.Logging.L;
import com.vikas.elibrary.R;
import com.vikas.elibrary.adpaters.AdapterBookList;
import com.vikas.elibrary.callback.BookListLoaderListener;
import com.vikas.elibrary.extras.BookSorter;
import com.vikas.elibrary.extras.SortListener;
import com.vikas.elibrary.info.Book;
import com.vikas.elibrary.materialtest.MyApplication;
import com.vikas.elibrary.network.VolleySingalton;
import com.vikas.elibrary.task.TaskLoadBooks;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSearch#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSearch extends Fragment implements SortListener, BookListLoaderListener, SwipeRefreshLayout.OnRefreshListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String STATE_BOOK = "state_book";
    private String mParam1;
    private String mParam2;
    private VolleySingalton volleySingalton;
    private ImageLoader imageLoader;
    private RequestQueue requestQueue;
    private SwipeRefreshLayout swipeRefreshLayout;
    private DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    private RecyclerView listBooks;
    ArrayList<Book> bookArrayList=new ArrayList<>();
    private AdapterBookList adapterBookList;
    private TextView errorDisp;
    private BookSorter bookSorter=new BookSorter();
    static String name1;



    public static FragmentSearch newInstance(String param1, String param2) {
        FragmentSearch fragment = new FragmentSearch();
        name1=param1;
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentSearch() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList(STATE_BOOK, bookArrayList);
    }
    private void handleVolleyError(VolleyError error) {
        errorDisp.setVisibility(View.VISIBLE);
        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
            errorDisp.setText(R.string.errorTimeout);
        } else if (error instanceof NetworkError) {
            errorDisp.setText(R.string.networkError);
        } else if (error instanceof ServerError) {
            errorDisp.setText(R.string.serverError);
        } else if (error instanceof ParseError) {
            errorDisp.setText(R.string.parseError);
        } else if (error instanceof AuthFailureError) {
            errorDisp.setText(R.string.authError);
        }
    }

    /**
     * Called when the user chooses to sort results by name through the menu displayed inside FAB
     */
    @Override
    public void onSortByName() {

            bookSorter.sortBooksByName(bookArrayList);
            adapterBookList.notifyDataSetChanged();

    }


    /**
     * Called when the user chooses to sort results by rating through the menu displayed inside FAB
     */
    @Override
    public void onSortByRating() {
        bookSorter.sortBooksByRating(bookArrayList);
        adapterBookList.notifyDataSetChanged();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


       View view= inflater.inflate(R.layout.fragment_search, container, false);
        try{

            listBooks= (RecyclerView) view.findViewById(R.id.listBooks);
        errorDisp=(TextView)view.findViewById(R.id.volleyError);
      listBooks.setLayoutManager(new LinearLayoutManager(getActivity()));
       swipeRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.swipetoref);
        swipeRefreshLayout.setOnRefreshListener(this);
        adapterBookList=new AdapterBookList(getActivity());

        listBooks.setAdapter(adapterBookList);
        if(savedInstanceState!=null){
            bookArrayList=savedInstanceState.getParcelableArrayList(STATE_BOOK);

        }    bookArrayList=  MyApplication.getWritableBookDatabase().getAllBookList();
            String type;
              if(bookArrayList.isEmpty()){
                  type=null;
              }else {
                  Book arr = bookArrayList.get(0);
                  type = arr.getType();
              }
            if(!name1.equals(type)){
                new TaskLoadBooks(this,name1).execute();
            }
        adapterBookList.setBookList(bookArrayList);
        }catch (Exception e){}
        return  view;
    }


    @Override
    public void onBookListLoaded(ArrayList<Book> bookArrayList) {
        try {
            if (swipeRefreshLayout.isRefreshing()) {
                swipeRefreshLayout.setRefreshing(false);
            }
            adapterBookList.setBookList(bookArrayList);
        }catch (Exception e){}
    }

    @Override
    public void onRefresh() {
        L.t(getActivity(), "Refresh");
      new TaskLoadBooks(this, name1).execute();
    }
}
