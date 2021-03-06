package android.itgenesis.com.dealyuser.fragments;


import android.itgenesis.com.dealyuser.R;
import android.itgenesis.com.dealyuser.activities.NavigationActivity;
import android.itgenesis.com.dealyuser.adapter.LiveDataAdapter;
import android.itgenesis.com.dealyuser.adapter.PopularDealsOffersAdapter;
import android.itgenesis.com.dealyuser.adapter.SearchAdapter;
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
public class PopularDealOfferFragment extends Fragment {




    public PopularDealOfferFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate( R.layout.fragment_popular_deals_offers, container, false);
        NavigationActivity.tvTitle.setText ( R.string.categories );

        RecyclerView liveDataRv =  view.findViewById(R.id.liveDataRv);

        PopularDealsOffersAdapter mAdapter = new PopularDealsOffersAdapter(getActivity ());
        liveDataRv.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager (getContext ());
        liveDataRv.setLayoutManager(mLayoutManager);
        liveDataRv.setAdapter(mAdapter);

        return view;
    }



}
