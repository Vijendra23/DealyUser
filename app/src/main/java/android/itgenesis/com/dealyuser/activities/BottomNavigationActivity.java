package android.itgenesis.com.dealyuser.activities;

import android.content.Intent;
import android.itgenesis.com.dealyuser.R;
import android.itgenesis.com.dealyuser.fragments.BurgurDealFragment;
import android.itgenesis.com.dealyuser.fragments.CategoriesFragment;
import android.itgenesis.com.dealyuser.fragments.DealAndOfferFragment;
import android.itgenesis.com.dealyuser.fragments.EditProfileFragment;
import android.itgenesis.com.dealyuser.fragments.ExploreFragment;
import android.itgenesis.com.dealyuser.fragments.FaqFragment;
import android.itgenesis.com.dealyuser.fragments.FavoriteFragment;
import android.itgenesis.com.dealyuser.fragments.FollowerFragment;
import android.itgenesis.com.dealyuser.fragments.FollowingFragment;
import android.itgenesis.com.dealyuser.fragments.InviteFriendsFragment;
import android.itgenesis.com.dealyuser.fragments.MoreFragment;
import android.itgenesis.com.dealyuser.fragments.NotificationFragment;
import android.itgenesis.com.dealyuser.fragments.OrderConfirmationFragment;
import android.itgenesis.com.dealyuser.fragments.PrivacyPolicyFragment;
import android.itgenesis.com.dealyuser.fragments.ProfileFragment;
import android.itgenesis.com.dealyuser.fragments.PromiseFragment;
import android.itgenesis.com.dealyuser.fragments.SettingsFragment;
import android.itgenesis.com.dealyuser.fragments.StoresFragment;
import android.itgenesis.com.dealyuser.fragments.SupportFragment;
import android.itgenesis.com.dealyuser.fragments.TermsOfUseFragment;
import android.itgenesis.com.dealyuser.fragments.TransactionsFragment;
import android.itgenesis.com.dealyuser.util.Common;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BottomNavigationActivity extends AppCompatActivity {

   public static TextView tvTitle;

    ImageView ivNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        ivNotification=findViewById ( R.id.iv_notification );


         tvTitle= findViewById ( R.id.title );


      /*  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
*/




        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationBottom);
        navigation.setOnNavigationItemSelectedListener ( new BottomNavigationView.OnNavigationItemSelectedListener () {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                switch (menuItem.getItemId()) {
                    case R.id.action_home:


                        startActivity ( new Intent ( BottomNavigationActivity.this,NavigationActivity.class )
                                .putExtra ( "command","home" ));
                        return true;


                    case R.id.action_explore:
                        startActivity ( new Intent ( BottomNavigationActivity.this,NavigationActivity.class )
                                .putExtra ( "command","explore" ));

                        return true;
                    case R.id.action_category:

                        startActivity ( new Intent ( BottomNavigationActivity.this,NavigationActivity.class )
                                .putExtra ( "command","categories" ));

                        return true;
                    case R.id.action_feed:

                        startActivity ( new Intent ( BottomNavigationActivity.this,NavigationActivity.class )
                                .putExtra ( "command","feed" ));

                        return true;

                    case R.id.action_profile:


                        startActivity ( new Intent ( BottomNavigationActivity.this,NavigationActivity.class )
                                .putExtra ( "command","profile" ));

                        return true;
                }


                return false;
            }
        } );


      findViewById (R.id.iv_back_arrow ).setOnClickListener ( new View.OnClickListener () {
          @Override
          public void onClick(View view) {
              onBackPressed();
          }
      } );

        navigate ();


        ivNotification.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                TextView tvTitle= findViewById ( R.id.title );

                Common.ChangeFragment(BottomNavigationActivity.this, new NotificationFragment (), false);
                tvTitle.setText (R.string.notifications);
            }
        } );
    }



    public void navigate() {

       TextView tvTitle= findViewById ( R.id.title );

        String command = getIntent().getStringExtra("command");

        if (command.equals("transactions")) {
            Common.ChangeFragment(BottomNavigationActivity.this, new TransactionsFragment (), false);
            tvTitle.setText ( R.string.transactions);
        }else if (command.equals("editprofile")) {

            Common.ChangeFragment(BottomNavigationActivity.this, new EditProfileFragment (), false);
            tvTitle.setText ( R.string.edit_profile);

        } else if (command.equals("settings")) {

            Common.ChangeFragment(BottomNavigationActivity.this, new SettingsFragment (), false);
            tvTitle.setText ( R.string.settings);

        } else if (command.equals("supportfeedback")) {

            Common.ChangeFragment(BottomNavigationActivity.this, new SupportFragment (), false);
            tvTitle.setText ( R.string.support);
        }

        else if (command.equals("more")) {

            Common.ChangeFragment(BottomNavigationActivity.this, new MoreFragment (), false);
            tvTitle.setText ( R.string.more);
        }

        else if (command.equals("faq")) {

            Common.ChangeFragment(BottomNavigationActivity.this, new FaqFragment (), false);
            tvTitle.setText ( R.string.faq_short);
        }

        else if (command.equals("privacy_policy")) {

            Common.ChangeFragment(BottomNavigationActivity.this, new PrivacyPolicyFragment (), false);
            tvTitle.setText ( R.string.privacy_policy);
        }

        else if (command.equals("promise")) {

            Common.ChangeFragment(BottomNavigationActivity.this, new PromiseFragment (), false);
            tvTitle.setText ("PROMISE");
        }

        else if (command.equals("terms_of_use")) {

            Common.ChangeFragment(BottomNavigationActivity.this, new TermsOfUseFragment (), false);
            tvTitle.setText ("TERMS");
        }

        else if (command.equals("invitefriends")) {

            Common.ChangeFragment(BottomNavigationActivity.this, new InviteFriendsFragment (), false);
            tvTitle.setText ("INVITE FRIENDS");
        }

        else if (command.equals("stores")) {

            Common.ChangeFragment(BottomNavigationActivity.this, new StoresFragment (), false);
            tvTitle.setText ("STORES");
        }

        else if (command.equals("following")) {

            Fragment fragment=new FollowingFragment ();
            Bundle bundle=new Bundle ();
            bundle.putString ( "heading","FOLLOWING (4)" );
            fragment.setArguments ( bundle );
            Common.ChangeFragment(BottomNavigationActivity.this, fragment, false);
            tvTitle.setText (R.string.profile);
        }

        else if (command.equals("followers")) {

            Fragment fragment=new FollowerFragment ();
            Bundle bundle=new Bundle ();
            bundle.putString ( "heading","FOLLOWERS (4)" );
            fragment.setArguments ( bundle );
            Common.ChangeFragment(BottomNavigationActivity.this, fragment, false);
            tvTitle.setText (R.string.profile);
        }

        else if (command.equals("notifications")) {

            Common.ChangeFragment(BottomNavigationActivity.this, new NotificationFragment (), false);
            tvTitle.setText (R.string.notifications);
        }

        else if (command.equals("burgurdeal")) {

            Common.ChangeFragment(BottomNavigationActivity.this, new BurgurDealFragment (), false);
            tvTitle.setText (R.string.burger_deal_20_20);
        }

        else if (command.equals("order_confirmation")) {

            Common.ChangeFragment(BottomNavigationActivity.this, new OrderConfirmationFragment (), false);
            tvTitle.setText (getString( R.string.order_confirmation));
        }


        else if (command.equals("favorites")) {

            Common.ChangeFragment(BottomNavigationActivity.this, new FavoriteFragment (), false);
            tvTitle.setText (getString( R.string.favorites));
        }


    }



}
