package android.itgenesis.com.dealyuser.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.itgenesis.com.dealyuser.R;
import android.itgenesis.com.dealyuser.activities.BottomNavigationActivity;
import android.itgenesis.com.dealyuser.activities.NavigationActivity;
import android.itgenesis.com.dealyuser.util.Common;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class ExploreFragment extends Fragment {

    private ViewPager viewPager;
    private LinearLayout dotsLayout,dotsLayout1,dotsLayout2;
    private int[] layouts,layouts1,layouts2;
    private TextView[] dots;
    private TextView[] dots1;
    private TextView[] dots2;
    private MyViewPagerAdapter myViewPagerAdapter;
    private MyViewPagerAdapter1 myViewPagerAdapter1;
    private MyViewPagerAdapter2 myViewPagerAdapter2;
    private Timer timer;
    private ViewPager viewPager1,viewPager2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=  inflater.inflate(R.layout.fragment_explore, container, false);


        viewPager = (ViewPager) view.findViewById ( R.id.view_pager );
        viewPager1 = (ViewPager) view.findViewById ( R.id.view_pager1 );
        viewPager2 = (ViewPager) view.findViewById ( R.id.view_pager2 );
        dotsLayout = (LinearLayout) view.findViewById ( R.id.layoutDots );
        dotsLayout1 = (LinearLayout) view.findViewById ( R.id.layoutDots1 );
        dotsLayout2 = (LinearLayout) view.findViewById ( R.id.layoutDots2);

        layouts = new int[]{
                R.layout.recommended_deal,
                R.layout.recommended_deal,
                R.layout.recommended_deal,
                R.layout.recommended_deal
                //R.layout.intro_login_sign_up
        };

        layouts1 = new int[]{
                R.layout.recommended_vendor,
                R.layout.recommended_vendor,
                R.layout.recommended_vendor,
                R.layout.recommended_vendor
        };


        layouts2 = new int[]{
                R.layout.people_near_you,
                R.layout.people_near_you,
                R.layout.people_near_you,
                R.layout.people_near_you
        };

        addBottomDots ( 0 );
        addBottomDots1 ( 0 );
        addBottomDots2( 0 );

        //addBottomDots2 ( 0 );
        //changeStatusBarColor ();

        myViewPagerAdapter = new MyViewPagerAdapter();
        myViewPagerAdapter1 = new MyViewPagerAdapter1();
        myViewPagerAdapter2 = new MyViewPagerAdapter2();

        viewPager.setAdapter ( myViewPagerAdapter );
        viewPager1.setAdapter ( myViewPagerAdapter1 );
        viewPager2.setAdapter ( myViewPagerAdapter2 );
      /*  final TimerTask timerTask = new TimerTask () {
            @Override
            public void run() {
                viewPager.post ( new Runnable () {

                    @Override
                    public void run() {
                        if (viewPager.getCurrentItem () == 4) {
                            Log.e ( "count", "" + layouts.length );


                        } else {
                            viewPager.setCurrentItem ( (viewPager.getCurrentItem () + 1) % layouts.length );

                            Log.e ( "stop", "stop" );

                        }
                    }
                } );
            }
        };
        timer = new Timer();
        timer.schedule ( timerTask, 3000, 3000 );
        viewPager.addOnPageChangeListener ( viewPagerPageChangeListener );*/

        return view;
    }



    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources ().getIntArray ( R.array.array_dot_active );
        int[] colorsInactive = getResources ().getIntArray ( R.array.array_dot_inactive );
        dotsLayout.removeAllViews ();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView ( getContext ());
            dots[i].setText ( Html.fromHtml ( "&#8226;" ) );
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage] );
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams ( ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT );
            layoutParams.setMargins ( 6, 0, 6, 0 );
            dotsLayout.addView ( dots[i], layoutParams );
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor ( colorsActive[currentPage] );
    }

    private void addBottomDots1(int currentPage) {
        dots1 = new TextView[layouts1.length];

        int[] colorsActive = getResources ().getIntArray ( R.array.array_dot_active );
        int[] colorsInactive = getResources ().getIntArray ( R.array.array_dot_inactive );
        dotsLayout1.removeAllViews ();
        for (int i = 0; i < dots1.length; i++) {
            dots1[i] = new TextView ( getContext () );
            dots1[i].setText(Html.fromHtml ( "&#8226;" ));
            dots1[i].setTextSize(35);
            dots1[i].setTextColor(colorsInactive[currentPage] );
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams ( ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT );
            layoutParams.setMargins( 6, 0, 6, 0 );
            dotsLayout1.addView (dots1[i], layoutParams);
        }

        if (dots1.length > 0)
            dots1[currentPage].setTextColor(colorsActive[currentPage]);
    }


    private void addBottomDots2(int currentPage) {
        dots2 = new TextView[layouts2.length];

        int[] colorsActive = getResources ().getIntArray ( R.array.array_dot_active );
        int[] colorsInactive = getResources ().getIntArray ( R.array.array_dot_inactive );
        dotsLayout2.removeAllViews ();
        for (int i = 0; i < dots2.length; i++) {
            dots2[i] = new TextView ( getContext () );
            dots2[i].setText(Html.fromHtml ( "&#8226;" ));
            dots2[i].setTextSize(35);
            dots2[i].setTextColor(colorsInactive[currentPage] );
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams ( ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT );
            layoutParams.setMargins( 6, 0, 6, 0 );
            dotsLayout2.addView (dots2[i], layoutParams);
        }

        if (dots2.length > 0)
            dots2[currentPage].setTextColor(colorsActive[currentPage]);
    }


    private int getItem(int i) {
        return viewPager.getCurrentItem () + i;
    }
    private int getItem1(int i) {
        return viewPager1.getCurrentItem () + i;
    }

    private int getItem2(int i) {
        return viewPager2.getCurrentItem () + i;
    }
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener () {

        @Override
        public void onPageSelected(int position) {
            addBottomDots (position);

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };


    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getContext ().getSystemService ( Context.LAYOUT_INFLATER_SERVICE );

            View view = layoutInflater.inflate ( layouts[position], container, false );
            container.addView ( view );

            view.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View view) {

                    startActivity ( new Intent ( getActivity (),BottomNavigationActivity.class )
                            .putExtra ( "command","burgurdeal" ));
                }
            } );
            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView ( view );
        }
    }

    public class MyViewPagerAdapter1 extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter1() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getContext ().getSystemService ( Context.LAYOUT_INFLATER_SERVICE );
            View view = layoutInflater.inflate(layouts1[position], container, false );
            container.addView (view);


            view.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View view) {

                    Common.ChangeFragment(getActivity (), new VendorProfileFragment (), true);

                }
            } );



            return view;
        }

        @Override
        public int getCount() {
            return layouts1.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView ( view );
        }
    }


    public class MyViewPagerAdapter2 extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter2() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getContext ().getSystemService ( Context.LAYOUT_INFLATER_SERVICE );
            View view = layoutInflater.inflate(layouts2[position], container, false );

            view.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View view) {

                    Common.ChangeFragment(getActivity (), new ProfileFragment (), true);

                }
            } );

            container.addView (view);
            return view;
        }

        @Override
        public int getCount() {
            return layouts2.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView ( view );
        }
    }


}
