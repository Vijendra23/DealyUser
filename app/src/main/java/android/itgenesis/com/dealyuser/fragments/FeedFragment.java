package android.itgenesis.com.dealyuser.fragments;


import android.itgenesis.com.dealyuser.R;
import android.itgenesis.com.dealyuser.adapter.FeedAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment {


    public FeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_feed, container, false);

        RecyclerView transaction_rv =  view.findViewById(R.id.feed_rv);

        FeedAdapter mAdapter = new FeedAdapter (getActivity ());
        transaction_rv.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager (getContext ());
        transaction_rv.setLayoutManager(mLayoutManager);
        transaction_rv.setAdapter(mAdapter);




        return view;
    }

}
