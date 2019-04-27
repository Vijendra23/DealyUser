package android.itgenesis.com.dealyuser.activities;

import android.content.Intent;
import android.itgenesis.com.dealyuser.R;
import android.itgenesis.com.dealyuser.fragments.CategoriesFragment;
import android.itgenesis.com.dealyuser.fragments.DealAndOfferFragment;
import android.itgenesis.com.dealyuser.fragments.ExploreFragment;
import android.itgenesis.com.dealyuser.fragments.FeedFragment;
import android.itgenesis.com.dealyuser.fragments.MoreDealsFragment;
import android.itgenesis.com.dealyuser.fragments.NotificationFragment;
import android.itgenesis.com.dealyuser.fragments.ProfileFragment;
import android.itgenesis.com.dealyuser.fragments.TransactionsFragment;
import android.itgenesis.com.dealyuser.fragments.VendorProfileFragment;
import android.itgenesis.com.dealyuser.util.Common;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class NavigationActivity extends AppCompatActivity {

    public static TextView tvTitle;
     ImageView ivNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        tvTitle=findViewById ( R.id.title );

        final LinearLayout ll_my_transactions = findViewById(R.id.ll_my_transactions);
        final NavigationView nav_view = findViewById(R.id.nav_view);
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        TextView tvMyTransactions=findViewById ( R.id.tv_my_transactions );
        TextView tvEditProfile=findViewById ( R.id.tv_edit_profile );
        TextView tvSettings=findViewById ( R.id.tv_settings );

        TextView tvInviteFriens=findViewById ( R.id.tv_invite_friends );
        TextView tvFaqs=findViewById ( R.id.tv_faqs );
        TextView tvMore=findViewById ( R.id.tv_more );
        TextView tvLogout=findViewById ( R.id.tv_logout );
        ivNotification=findViewById ( R.id.iv_notification );




        findViewById(R.id.menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer( GravityCompat.START);
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        tvTitle.setText ( R.string.deals_and_offers);
        Common.ChangeFragment(NavigationActivity.this, new DealAndOfferFragment (), false);


       navigate ();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationBottom);
        navigation.setOnNavigationItemSelectedListener ( new BottomNavigationView.OnNavigationItemSelectedListener () {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                switch (menuItem.getItemId()) {
                    case R.id.action_home:

                        String command = getIntent().getStringExtra("command");
                        Common.ChangeFragment(NavigationActivity.this, new DealAndOfferFragment (), false);
                        tvTitle.setText ( R.string.deals_and_offers);
                        return true;


                    case R.id.action_explore:
                        Common.ChangeFragment(NavigationActivity.this, new ExploreFragment (), false);
                        tvTitle.setText ( R.string.explore);

                        return true;
                    case R.id.action_category:

                        Common.ChangeFragment(NavigationActivity.this, new CategoriesFragment (), false);
                        tvTitle.setText ( R.string.categories);

                        return true;
                    case R.id.action_feed:
                        Common.ChangeFragment(NavigationActivity.this, new FeedFragment (), false);
                        tvTitle.setText ( R.string.feed);

                        return true;

                    case R.id.action_profile:


                        Common.ChangeFragment(NavigationActivity.this, new ProfileFragment (), false);
                        tvTitle.setText ( R.string.profile);

                        return true;
                }


                return false;
            }
        } );


     ivNotification.setOnClickListener ( new View.OnClickListener () {
         @Override
         public void onClick(View view) {

             //Common.ChangeFragment(NavigationActivity.this, new NotificationFragment (), false);
            // tvTitle.setText (R.string.notifications);

             startActivity ( new Intent ( NavigationActivity.this,BottomNavigationActivity.class )
                     .putExtra ( "command","notifications" ));
         }
     } );



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    public void sideBarNav(View view) {
        int id=view.getId();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        switch (id)
        {
            case R.id.ll_my_transactions:
                startActivity ( new Intent ( NavigationActivity.this,BottomNavigationActivity.class )
                        .putExtra ( "command","transactions" ));

                drawer.closeDrawer(GravityCompat.START);
                break;


            case R.id.ll_edit_profile:
                startActivity ( new Intent ( NavigationActivity.this,BottomNavigationActivity.class )
                        .putExtra ( "command","editprofile" ));

                 drawer.closeDrawer(GravityCompat.START);

                break;

            case R.id.ll_settings:

                startActivity ( new Intent ( NavigationActivity.this,BottomNavigationActivity.class )
                        .putExtra ( "command","settings" ));
                drawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.ll_invite_frnds:

                startActivity ( new Intent ( NavigationActivity.this,BottomNavigationActivity.class )
                        .putExtra ( "command","invitefriends" ));
                drawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.ll_faqs:

                startActivity ( new Intent ( NavigationActivity.this,BottomNavigationActivity.class )
                        .putExtra ( "command","faq" ));
                drawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.ll_support_feedback:

                startActivity ( new Intent ( NavigationActivity.this,BottomNavigationActivity.class )
                        .putExtra ( "command","supportfeedback" ));
                drawer.closeDrawer(GravityCompat.START);
                break;


            case R.id.ll_more:

                startActivity ( new Intent ( NavigationActivity.this,BottomNavigationActivity.class )
                        .putExtra ( "command","more" ));
                drawer.closeDrawer(GravityCompat.START);
                break;


            case R.id.ll_logout:
                startActivity ( new Intent ( NavigationActivity.this,GetStartedActivity.class ) );
                finish ();
                drawer.closeDrawer(GravityCompat.START);


        }
    }




    public void navigate() {

        TextView tvTitle = findViewById ( R.id.title );




            String command = getIntent ().getStringExtra ( "command" );

        if(command!=null) {

            if (command.equals ( "home" )) {
                Common.ChangeFragment ( NavigationActivity.this, new DealAndOfferFragment (), false );
                tvTitle.setText ( R.string.deals_and_offers );
            } else if (command.equals ( "explore" )) {

                Common.ChangeFragment ( NavigationActivity.this, new ExploreFragment (), true );
                tvTitle.setText ( R.string.explore );

            } else if (command.equals ( "categories" )) {

                Common.ChangeFragment ( NavigationActivity.this, new CategoriesFragment (), true );
                tvTitle.setText ( R.string.categories );

            } else if (command.equals ( "feed" )) {

                Common.ChangeFragment ( NavigationActivity.this, new FeedFragment (), true );
                 tvTitle.setText ( R.string.feed);
            } else if (command.equals ( "profile" )) {

                Common.ChangeFragment ( NavigationActivity.this, new ProfileFragment (), true );
                tvTitle.setText ( R.string.profile );
            }

            else if (command.equals ( "moredeals" )) {

                Common.ChangeFragment ( NavigationActivity.this, new MoreDealsFragment (), true );
            }

            else if (command.equals ( "vendorprofile" )) {

                Common.ChangeFragment ( NavigationActivity.this, new VendorProfileFragment (), true );
            }
        }
    }
}
