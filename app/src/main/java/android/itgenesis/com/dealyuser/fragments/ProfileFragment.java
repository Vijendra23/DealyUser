package android.itgenesis.com.dealyuser.fragments;


import android.content.Intent;
import android.itgenesis.com.dealyuser.R;
import android.itgenesis.com.dealyuser.activities.BottomNavigationActivity;
import android.itgenesis.com.dealyuser.activities.NavigationActivity;
import android.itgenesis.com.dealyuser.adapter.LiveDataAdapter;
import android.itgenesis.com.dealyuser.adapter.ProfileDataAdapter;
import android.itgenesis.com.dealyuser.util.Common;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    TextView tvFollowing;
    TextView tvFollowers;
    TextView tvHeading;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_profile, container, false);
        RecyclerView liveDataRv =  view.findViewById(R.id.liveDataRv);



        NavigationActivity.tvTitle.setText ( R.string.profile);
        tvFollowing=view.findViewById ( R.id.tv_following );
        tvFollowers = view.findViewById ( R.id.tv_followers);
        tvHeading=view.findViewById ( R.id.tv_heading );
        LinearLayout llTransactions=view.findViewById ( R.id.ll_transactions);
        LinearLayout llFavoritesDeal=view.findViewById ( R.id.ll_favorites_deals);
        LinearLayout llStoresFollowed=view.findViewById ( R.id.ll_stores_followed);


        ProfileDataAdapter mAdapter = new ProfileDataAdapter (getActivity ());
        liveDataRv.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager (getContext ());
        liveDataRv.setLayoutManager(mLayoutManager);
        liveDataRv.setAdapter(mAdapter);


        llTransactions.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                startActivity ( new Intent ( getActivity (), BottomNavigationActivity.class )
                        .putExtra ( "command","transactions" ));
            }
        } );

        llStoresFollowed.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                startActivity ( new Intent ( getActivity (), BottomNavigationActivity.class )
                        .putExtra ( "command","stores" ));
            }
        } );

        llFavoritesDeal.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                startActivity ( new Intent ( getActivity (), BottomNavigationActivity.class )
                        .putExtra ( "command","favorites" ));
            }
        } );

        tvFollowing.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity ( new Intent ( getActivity (), BottomNavigationActivity.class )
                        .putExtra ( "command","following" ));


            }
        } );

        tvFollowers.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity ( new Intent ( getActivity (), BottomNavigationActivity.class )
                        .putExtra ( "command","followers" ));


            }
        } );



        return view;
    }

}
