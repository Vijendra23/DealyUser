package android.itgenesis.com.dealyuser.fragments;


import android.content.Context;
import android.content.Intent;
import android.itgenesis.com.dealyuser.R;
import android.itgenesis.com.dealyuser.activities.BottomNavigationActivity;
import android.itgenesis.com.dealyuser.activities.MapsActivity;
import android.itgenesis.com.dealyuser.activities.NavigationActivity;
import android.itgenesis.com.dealyuser.adapter.LiveDataAdapter;
import android.itgenesis.com.dealyuser.util.Common;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class DealAndOfferFragment extends Fragment implements OnMapReadyCallback {

    TextView tvLive;
    TextView tvTrending;
    TextView tvHot;
    TextView tvLocation;
    TextView tvDeals;
    LinearLayout llRvLiveTrendingHot,llTurnOnTheLocation;
    View includeLocation,includeMap;
    private GoogleMap mMap;
    Context context;
    CardView cardViewMap;



    public DealAndOfferFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate( R.layout.fragment_deals_and_offer, container, false);

        NavigationActivity.tvTitle.setText (R.string.deals_and_offers);

        tvLive=view.findViewById (R.id.tv_live);
        tvTrending=view.findViewById (R.id.tv_trending);
        tvHot=view.findViewById (R.id.tv_hot);
        tvLocation=view.findViewById (R.id.tv_location);
        tvDeals=view.findViewById (R.id.tv_deals);
        llRvLiveTrendingHot=view.findViewById (R.id.ll_rv_live_trending_hot);
        includeLocation=view.findViewById ( R.id.include_location );
      //  includeMap=view.findViewById ( R.id.include_map );
        llTurnOnTheLocation=includeLocation.findViewById ( R.id.ll_turn_on_the_location );

        cardViewMap=view.findViewById ( R.id.cv_map );

        ImageView ivSearch=view.findViewById ( R.id.iv_search );
        RecyclerView liveDataRv =  view.findViewById(R.id.liveDataRv);

        LiveDataAdapter mAdapter = new LiveDataAdapter(getActivity ());
        liveDataRv.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager (getContext ());
        liveDataRv.setLayoutManager(mLayoutManager);
        liveDataRv.setAdapter(mAdapter);



        setTextAndColor ( 1 );



        tvLive.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                setTextAndColor ( 1 );


            }
        } );


        tvTrending.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                setTextAndColor (2);


            }
        } );


        tvHot.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                setTextAndColor (3);


            }
        } );


        tvLocation.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                setTextAndColor (4);


            }
        } );


        ivSearch.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Common.ChangeFragment(getActivity (), new SearchLiveFragment (), true);
            }
        } );


        llTurnOnTheLocation.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                setTextAndColor (5);

               /* SupportMapFragment mapFragment = (SupportMapFragment) getActivity ().getSupportFragmentManager ()
                        .findFragmentById ( R.id.map );
                mapFragment.getMapAsync ( (OnMapReadyCallback) getContext () );*/

               getActivity ().startActivity ( new Intent ( getActivity (),MapsActivity.class ).putExtra ( "command","home" ) );


            }
        } );

        return view;
    }


    void setTextAndColor(int btnNo)
    {
        switch (btnNo)
        {
            case 1:
                tvLive.setBackgroundColor ( getResources ().getColor ( R.color.colorRed ) );
                tvTrending.setBackgroundColor ( getResources ().getColor ( R.color.colorDarkRed ) );
                tvHot.setBackgroundColor ( getResources ().getColor ( R.color.colorDarkRed ) );
                tvLocation.setBackgroundColor ( getResources ().getColor ( R.color.colorDarkRed ) );
                tvDeals.setText ( R.string.live_deals );
                llRvLiveTrendingHot.setVisibility ( View.VISIBLE );
                includeLocation.setVisibility ( View.GONE );
                cardViewMap.setVisibility ( View.GONE );
              //  includeMap.setVisibility ( View.GONE );
                break;

            case 2:
                tvLive.setBackgroundColor ( getResources ().getColor ( R.color.colorDarkRed ) );
                tvTrending.setBackgroundColor ( getResources ().getColor ( R.color.colorRed ) );
                tvHot.setBackgroundColor ( getResources ().getColor ( R.color.colorDarkRed ) );
                tvLocation.setBackgroundColor ( getResources ().getColor ( R.color.colorDarkRed ) );
                tvDeals.setText ( R.string.trending_deals );

                llRvLiveTrendingHot.setVisibility ( View.VISIBLE );
                includeLocation.setVisibility ( View.GONE );
                cardViewMap.setVisibility ( View.GONE );
            //    includeMap.setVisibility ( View.GONE );
                break;

            case 3:
                tvLive.setBackgroundColor ( getResources ().getColor ( R.color.colorDarkRed ) );
                tvTrending.setBackgroundColor ( getResources ().getColor ( R.color.colorDarkRed ) );
                tvHot.setBackgroundColor ( getResources ().getColor ( R.color.colorRed ) );
                tvLocation.setBackgroundColor ( getResources ().getColor ( R.color.colorDarkRed ) );
                tvDeals.setText ( R.string.hot_deals );

                llRvLiveTrendingHot.setVisibility ( View.VISIBLE );
                includeLocation.setVisibility ( View.GONE );
                cardViewMap.setVisibility ( View.GONE );
               // includeMap.setVisibility ( View.GONE );
                break;


            case 4:
                tvLive.setBackgroundColor ( getResources ().getColor ( R.color.colorDarkRed ) );
                tvTrending.setBackgroundColor ( getResources ().getColor ( R.color.colorDarkRed ) );
                tvHot.setBackgroundColor ( getResources ().getColor ( R.color.colorDarkRed ) );
                tvLocation.setBackgroundColor ( getResources ().getColor ( R.color.colorRed ) );
                //tvDeals.setText ( R.string.location_deals );

                llRvLiveTrendingHot.setVisibility ( View.GONE );
                includeLocation.setVisibility ( View.VISIBLE );
                cardViewMap.setVisibility ( View.GONE );
                //includeMap.setVisibility ( View.GONE );
                break;


            case 5:
                tvLive.setBackgroundColor ( getResources ().getColor ( R.color.colorDarkRed ) );
                tvTrending.setBackgroundColor ( getResources ().getColor ( R.color.colorDarkRed ) );
                tvHot.setBackgroundColor ( getResources ().getColor ( R.color.colorDarkRed ) );
                tvLocation.setBackgroundColor ( getResources ().getColor ( R.color.colorRed ) );
                tvDeals.setText ("AT FOLEY SQUARE, NEW YARK");

                llRvLiveTrendingHot.setVisibility ( View.VISIBLE );
                includeLocation.setVisibility ( View.GONE );
                cardViewMap.setVisibility ( View.VISIBLE );

                break;
        }


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng ( -34, 151 );
        mMap.addMarker ( new MarkerOptions ().position ( sydney ).title ( "Marker in Sydney" ) );
        mMap.moveCamera ( CameraUpdateFactory.newLatLng ( sydney ) );
    }
}
