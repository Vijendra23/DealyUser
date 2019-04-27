package android.itgenesis.com.dealyuser.fragments;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.itgenesis.com.dealyuser.R;
import android.itgenesis.com.dealyuser.activities.BottomNavigationActivity;
import android.itgenesis.com.dealyuser.activities.MapsActivity;
import android.itgenesis.com.dealyuser.activities.NavigationActivity;
import android.itgenesis.com.dealyuser.util.Common;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class VendorProfileFragment extends Fragment {


    public VendorProfileFragment() {
        // Required empty public constructor
    }


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_vendor_profie, container, false);

        NavigationActivity.tvTitle.setText (R.string.vendor_profile);

        startActivity ( new Intent ( getContext (),MapsActivity.class).putExtra ( "command","vendorprofile" ) );



        view.findViewById ( R.id.iv_about_vendor_menu_thumbnail_user1 ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                showImagePopup (  );
            }
        } );
        view.findViewById ( R.id.iv_about_vendor_menu_thumbnail_user2 ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                showImagePopup (  );
            }
        } );

        view.findViewById ( R.id.iv_about_vendor_menu_thumbnail_user3 ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                showImagePopup (  );
            }
        } );

        view.findViewById ( R.id.iv_about_vendor_menu_thumbnail_user4 ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                showImagePopup (  );
            }
        } );

        view.findViewById ( R.id.iv_about_vendor_menu_thumbnail_user5 ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                showImagePopup (  );
            }
        } );

        view.findViewById ( R.id.ll_deal_posted ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Common.ChangeFragment ( getActivity (), new MoreDealsFragment (), false );
            }
        } );


        view.findViewById ( R.id.ll_followers ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity ( new Intent ( getActivity (), BottomNavigationActivity.class )
                        .putExtra ( "command","followers" ));


            }
        } );

        view.findViewById ( R.id.rl_view_map ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {


                startActivity ( new Intent ( getActivity (), MapsActivity.class) );


            }
        } );


        return view;
    }



    public void showImagePopup(){


        LayoutInflater inf = (LayoutInflater)getActivity ().getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inf.inflate(R.layout.image_alert_popup, null);
        final AlertDialog builder = new AlertDialog.Builder(getActivity (),R.style.CustomDialog).create();
        builder.setCancelable(false);


        final ImageView ivproductImage = (ImageView) view.findViewById(R.id.iv_product_image);
        final ImageView ivMultiply = (ImageView) view.findViewById(R.id.iv_multiply);
        final ImageView ivLeftArrow = (ImageView) view.findViewById(R.id.iv_left_arrow);
        final ImageView ivRightArrow = (ImageView) view.findViewById(R.id.iv_right_arrow);


        // final AlertDialog alertDialog = builder.create();
        builder.setView(view);

        ivMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                builder.dismiss();
            }
        });

        builder.show();

    }

}
