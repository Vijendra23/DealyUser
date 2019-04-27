package android.itgenesis.com.dealyuser.fragments;


import android.itgenesis.com.dealyuser.R;
import android.itgenesis.com.dealyuser.adapter.FollowerAdapter;
import android.itgenesis.com.dealyuser.adapter.FollowingAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FollowerFragment extends Fragment {


    RecyclerView rvFollowing;

    public FollowerFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_follower, container, false);
        TextView tvHeading=view.findViewById ( R.id.tv_heading );

        rvFollowing=view.findViewById ( R.id.rv_following );

        Bundle bundle=getArguments ();
        tvHeading.setText ( ""+bundle.getString ( "heading" ,"") );


        FollowerAdapter mAdapter = new FollowerAdapter (getActivity ());
        rvFollowing.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager (getContext ());
        rvFollowing.setLayoutManager(mLayoutManager);
        rvFollowing.setAdapter(mAdapter);
        return view;
    }

}
