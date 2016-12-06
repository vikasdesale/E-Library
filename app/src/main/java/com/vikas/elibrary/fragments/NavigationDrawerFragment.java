package com.vikas.elibrary.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.vikas.elibrary.activity.MainActivity;
import com.vikas.elibrary.R;
import com.vikas.elibrary.adpaters.AdapterDrawer;
import com.vikas.elibrary.adpaters.VivzAdapter;
import com.vikas.elibrary.info.Information;

import java.util.ArrayList;
import java.util.List;


public class NavigationDrawerFragment extends Fragment implements VivzAdapter.ClickListener {


   public static final String PREF_FILE_NAME="testPref";
    public static final String KEY_USER_LEARNED_DRAWER="user_learned_drawer";
   private ActionBarDrawerToggle mDrawerToggle;
   private  DrawerLayout mDrawerLayout;
    private AdapterDrawer mAdapter;
    private boolean mUserLearnedDrawer;
    private  boolean mFromSavedInstance;
    private View containerView;
    public NavigationDrawerFragment() {
        // Required empty public constructor



    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     mUserLearnedDrawer=Boolean.valueOf(readFromPreferences(getActivity(),KEY_USER_LEARNED_DRAWER,"false"));
        if(savedInstanceState!=null)
        {
            mFromSavedInstance=true;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View layout=inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        RecyclerView recylerView=(RecyclerView)layout.findViewById(R.id.drawerList);
        mAdapter=new AdapterDrawer(getActivity(),getData());
       // mAdapter.setClickListener(this);
        recylerView.setAdapter(mAdapter);
        recylerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recylerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recylerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                mDrawerLayout.closeDrawer(GravityCompat.START);
                ((MainActivity) getActivity()).onDrawerItemClicked(position - 1);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return layout;
    }

  public static List<Information> getData(){
      List<Information> data=new ArrayList<>();
      int icon[]={R.drawable.home,R.drawable.share_t,R.drawable.about,R.drawable.help};
      String title[]={"Home","Share App","About Us","Help"};
      for(int i=0;i< title.length&&i<icon.length;i++){
          Information current=new Information();
          current.title=title[i];
          current.iconId=icon[i];
          data.add(current);
      }
      return data;
  }


    public void setUp(int fragmentid, DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView=getActivity().findViewById(fragmentid);
        mDrawerLayout=drawerLayout;
        mDrawerToggle=new ActionBarDrawerToggle(getActivity(),mDrawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if(!mUserLearnedDrawer)
                {
                    mUserLearnedDrawer=true;
                    saveToPreferences(getActivity(),KEY_USER_LEARNED_DRAWER,mUserLearnedDrawer+"");

                }
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();

            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                super.onDrawerSlide(drawerView, slideOffset);
                ((MainActivity) getActivity()).onDrawerSlide(slideOffset);
                toolbar.setAlpha(1 - slideOffset / 2);

            }
        };
        if(!mUserLearnedDrawer&&!mFromSavedInstance)
        {
            mDrawerLayout.openDrawer(containerView);
        }
            mDrawerLayout.setDrawerListener(mDrawerToggle);
           mDrawerLayout.post(new Runnable() {
               @Override
               public void run() {
                   mDrawerToggle.syncState();
                   if (!mUserLearnedDrawer && !mFromSavedInstance) {
                       mDrawerLayout.openDrawer(containerView);
                   }
               }
           });
    }

   public void saveToPreferences(Context context,String preferenceName,String preferenceValue){
       SharedPreferences sharedPreferences=context.getSharedPreferences(PREF_FILE_NAME,Context.MODE_PRIVATE);
       SharedPreferences.Editor editor=sharedPreferences.edit();
       editor.putString(preferenceName,preferenceValue);
       editor.commit();

   }
    public static String readFromPreferences(Context context,String preferenceName,String preferenceValue){
        SharedPreferences sharedPreferences=context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
      return  sharedPreferences.getString(preferenceName, preferenceValue);

    }

    @Override
    public void itemClicked(View view, int position) {
    }
    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
