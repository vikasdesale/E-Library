package com.vikas.elibrary.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.vikas.elibrary.R;
import com.vikas.elibrary.anim.AnimationUtils;
import com.vikas.elibrary.extras.SortListener;
import com.vikas.elibrary.fragments.FragmentEngineering;
import com.vikas.elibrary.fragments.FragmentMpscUpsc;
import com.vikas.elibrary.fragments.FragmentOneT;
import com.vikas.elibrary.fragments.FragmentOther;
import com.vikas.elibrary.fragments.NavigationDrawerFragment;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

public class MainActivity extends ActionBarActivity implements MaterialTabListener, View.OnClickListener{

    public static final int BOOK_ONE_T=0;
    public static final int BOOK_GATE_E=1;
    public static final int BOOK_MPSC_U=2;
    public static final int BOOK_OTHER=3;
    public static final int TAB_COUNT = 4;
    //tag associated with the FAB menu button that sorts by name
    private static final String TAG_SORT_NAME = "sortName";
    //tag associated with the FAB menu button that sorts by date
    private static final String TAG_SORT_DATE = "sortDate";
    //tag associated with the FAB menu button that sorts by ratings
    private static final String TAG_SORT_RATINGS = "sortRatings";
    private Toolbar mToolbar;
    //a layout grouping the toolbar and the tabs together
    private ViewGroup mContainerToolbar;
    private MaterialTabHost mTabHost;
    private ViewPager mPager;
    private ViewPagerAdapter mAdapter;
    private FloatingActionButton mFAB;
    private FloatingActionMenu mFABMenu;
    private NavigationDrawerFragment mDrawerFragment;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupTabs();
        setupDrawer();
        AnimationUtils.animateToolbarDroppingDown(mContainerToolbar);
        }

    private void setupDrawer() {
        mToolbar = (Toolbar) findViewById(R.id.app_bar);
        mContainerToolbar = (ViewGroup) findViewById(R.id.container_app_bar);
        //set the Toolbar as ActionBar
        setSupportActionBar(mToolbar);
       ActionBar actionBar= getSupportActionBar();
               actionBar.setDisplayShowHomeEnabled(true);
        // set the icon
        actionBar.setIcon(R.drawable.a_icon);
        //setup the NavigationDrawer
        mDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        mDrawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
    }


    public void onDrawerItemClicked(int index) {


        if(index==1){

            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "E-Library");
            String sAux = " \n********E-Library********\n\tE-Library is app which provide more than 1 Lac books,10,000+ Video Lectures,1000+ Audio Lectrues and many more download.";
            String books="\n\tThe app contain following Study material for students:---";
            String ncrt="\n1) The NCERT books from 1 to 12 class in Hindi,English & Urdu Language.";
            String st="\n2) Maharashtra state board books from class 1 to 8 in Hindi,Marathi & English Language.";
            String mpup="\n3) MPSC,UPSC all exams question papers.";
            String currenb="\n4) Mpsc,Upsc exams special books and current affairs.";
            String lect="\n5) MPSC,UPSC Video lectures,Audio lectures.";
            String engg="\n6) The app contain all major engineering branches study material some of these Computer Science,Mechanical,Civil,Electrical,Electronics,It.";
            String other="\n7) Books in various languages Marathi,Hindi,English,Urdu.";
            String other1="\n8) Books in various fields like Motivational,Romance,Shayari,Story.";
            sAux =sAux+books+ncrt+st+mpup+currenb+lect+engg+other+other1+ "\n\t\t\tSo Finally With All the above features our aim to provide more than 1 Lac books,10,000+ Video Lectures,1000+ Audio Lectures and many more for the student by the student. Download Free \n Free..Free..Free\n    ......On the Application.....\n      ******E-Library******\n https://play.google.com/store/apps/details?id=com.vikas.elibrary \n"+"\n\t" +
                    "\t\t\t\t\t By\n\t\t\t\tVikas Desale";
            i.putExtra(Intent.EXTRA_TEXT, sAux);
            Intent inte=Intent.createChooser(i, "Choose one");

            inte.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            getBaseContext().startActivity(inte);
          }else if(index==2) {

            startActivity(new Intent(this, AboutUs.class));
        }
        else if(index==3) {

            startActivity(new Intent(this,Help.class));
        }
    }

    private void setupTabs() {
        mTabHost = (MaterialTabHost) findViewById(R.id.materialTabHost);
        mPager = (ViewPager) findViewById(R.id.viewPager);
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);
        //when the page changes in the ViewPager, update the Tabs accordingly
        mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                mTabHost.setSelectedNavigationItem(position);

            }
        });
        //Add all the Tabs to the TabHost
        for (int i = 0; i < mAdapter.getCount(); i++) {
            mTabHost.addTab(
                    mTabHost.newTab()
                            .setText(mAdapter.getPageTitle(i))
                            .setTabListener(this));
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onTabSelected(MaterialTab materialTab) {
        //when a Tab is selected, update the ViewPager to reflect the changes
        mPager.setCurrentItem(materialTab.getPosition());

    }

    @Override
    public void onTabReselected(MaterialTab materialTab) {
    }

    @Override
    public void onTabUnselected(MaterialTab materialTab) {
    }

    @Override
    public void onClick(View v) {
        //call instantiate item since getItem may return null depending on whether the PagerAdapter is of type FragmentPagerAdapter or FragmentStatePagerAdapter
       Fragment fragment = (Fragment) mAdapter.instantiateItem(mPager, mPager.getCurrentItem());
        if (fragment instanceof SortListener) {

            if (v.getTag().equals(TAG_SORT_NAME)) {
                //call the sort by name method on any Fragment that implements sortlistener
                ((SortListener) fragment).onSortByName();
            }

            if (v.getTag().equals(TAG_SORT_RATINGS)) {
                //call the sort by ratings method on any Fragment that implements sortlistener
                ((SortListener) fragment).onSortByRating();
            }
        }

    }


    private void toggleTranslateFAB(float slideOffset) {
        if (mFABMenu != null) {
            if (mFABMenu.isOpen()) {
                mFABMenu.close(true);
            }
            mFAB.setTranslationX(slideOffset * 200);
        }
    }

    public void onDrawerSlide(float slideOffset) {
        toggleTranslateFAB(slideOffset);
    }




    public class ViewPagerAdapter extends FragmentStatePagerAdapter{

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment=null;
            switch(position){
                case BOOK_ONE_T:
                    fragment= FragmentOneT.newInstance("");
                    break;
                case BOOK_GATE_E:
                    fragment= FragmentMpscUpsc.newInstance("", "");
                    break;
                case BOOK_MPSC_U:

                    fragment= FragmentEngineering.newInstance("", "");
                    break;
                case BOOK_OTHER:
                    fragment= FragmentOther.newInstance("", "");
                    break;

            }
            return  fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return  getResources().getStringArray(R.array.tabs)[position];
        }

        @Override
        public int getCount() {
            return TAB_COUNT;
        }


            }
    }




