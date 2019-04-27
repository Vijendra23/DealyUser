package android.itgenesis.com.dealyuser.fragments;


import android.content.Intent;
import android.itgenesis.com.dealyuser.R;
import android.itgenesis.com.dealyuser.activities.BottomNavigationActivity;
import android.itgenesis.com.dealyuser.activities.MapsActivity;
import android.itgenesis.com.dealyuser.activities.NavigationActivity;
import android.itgenesis.com.dealyuser.util.Common;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BurgurDealFragment extends Fragment {


    public BurgurDealFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_burgur_deal, container, false);
        TextView tvRedeem=view.findViewById ( R.id.tv_redeem );
        Button btnViewMap=view.findViewById ( R.id.btnViewMap);
        ConstraintLayout conMoreDeals=view.findViewById ( R.id.constMoreDeals);
        ConstraintLayout consAbout=view.findViewById ( R.id.constAbout);

        startActivity ( new Intent ( getContext (),MapsActivity.class).putExtra ( "command","burgurdeal" ) );


        tvRedeem.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                startActivity ( new Intent (getActivity (),BottomNavigationActivity.class )
                        .putExtra ( "command","order_confirmation" ));
            }
        } );


        btnViewMap.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                startActivity ( new Intent ( getActivity (), MapsActivity.class ) );
            }
        } );


        conMoreDeals.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                startActivity ( new Intent ( getActivity (),NavigationActivity.class )
                        .putExtra ( "command","moredeals" ));
            }
        } );

        consAbout.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Common.ChangeFragment (getActivity (), new VendorProfileFragment (), false );

                startActivity ( new Intent ( getActivity (),NavigationActivity.class )
                        .putExtra ( "command","vendorprofile" ));

            }
        } );




        return view;
    }

}
