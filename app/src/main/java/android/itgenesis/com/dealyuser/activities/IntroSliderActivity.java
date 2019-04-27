package android.itgenesis.com.dealyuser.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.itgenesis.com.dealyuser.R;
import android.os.Build;
import android.os.Handler;
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

public class IntroSliderActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;
    Timer timer;
    private TextView btnSkip;
    private boolean isClickSkipButton = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_intro_slider );
        isClickSkipButton = false;

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow ().getDecorView ().setSystemUiVisibility ( View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN );
        }
        viewPager = (ViewPager) findViewById ( R.id.view_pager );
        btnSkip = findViewById ( R.id.btn_skip );
        dotsLayout = (LinearLayout) findViewById ( R.id.layoutDots );

        layouts = new int[]{
                R.layout.intro1,
                R.layout.intro2,
                R.layout.intro3,
                R.layout.intro4
                //R.layout.intro_login_sign_up
        };
        addBottomDots ( 0 );
        changeStatusBarColor ();
        myViewPagerAdapter = new MyViewPagerAdapter ();
        viewPager.setAdapter ( myViewPagerAdapter );
        final TimerTask timerTask = new TimerTask () {
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
        timer = new Timer ();
        timer.schedule ( timerTask, 3000, 3000 );
        viewPager.addOnPageChangeListener ( viewPagerPageChangeListener );
        btnSkip.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                isClickSkipButton = true;
                launchHomeScreen ();
            }
        } );


        viewPager.setOnPageChangeListener ( new ViewPager.OnPageChangeListener () {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
                //Toast.makeText(MyActivity.this, i+"  Is Selected  "+data.size(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onPageSelected(int i) {
                // here you will get the position of selected page


                if (i == layouts.length - 1) {

                    new Handler ().postDelayed ( new Runnable () {

                        /*
                         * Showing splash screen with a timer. This will be useful when you
                         * want to show case your app logo / company
                         */

                        @Override
                        public void run() {
                            // This method will be executed once the timer is over
                            // Start your app main activity
                            if (!isClickSkipButton) {
                                Intent i = new Intent ( IntroSliderActivity.this, GetStartedActivity.class );
                                startActivity ( i );
                                finish ();

                            }


                            // close this activity
                        }
                    }, 2000 );

                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        } );


    }

    private void launchHomeScreen() {
        // prefManager.setFirstTimeLaunch(false);
        startActivity ( new Intent ( IntroSliderActivity.this, GetStartedActivity.class ) );
        finish ();
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources ().getIntArray ( R.array.array_dot_active );
        int[] colorsInactive = getResources ().getIntArray ( R.array.array_dot_inactive );
        dotsLayout.removeAllViews ();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView ( this );
            dots[i].setText ( Html.fromHtml ( "&#8226;" ) );
            dots[i].setTextSize ( 35 );
            dots[i].setTextColor ( colorsInactive[currentPage] );
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams ( ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT );
            layoutParams.setMargins ( 6, 0, 6, 0 );
            dotsLayout.addView ( dots[i], layoutParams );
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor ( colorsActive[currentPage] );
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem () + i;
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener () {

        @Override
        public void onPageSelected(int position) {
            addBottomDots ( position );

            // changing the next button text 'NEXT' / 'GOT IT'
            // if (position == layouts.length - 1) {
            // last page. make button text to GOT IT
            //btnNext.setText(getString(R.string.start));
            //   btnSkip.setVisibility(View.GONE);
            //  } else {
            // still pages are left
            //  btnNext.setText(getString(R.string.next));
            //  btnSkip.setVisibility(View.VISIBLE);
            //  }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow ();
            window.addFlags ( WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS );
            window.setStatusBarColor ( Color.TRANSPARENT );
        }
    }

    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService ( Context.LAYOUT_INFLATER_SERVICE );

            View view = layoutInflater.inflate ( layouts[position], container, false );
            container.addView ( view );
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
}
