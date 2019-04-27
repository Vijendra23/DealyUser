package android.itgenesis.com.dealyuser.fragments;


import android.itgenesis.com.dealyuser.R;
import android.itgenesis.com.dealyuser.adapter.LiveDataAdapter;
import android.itgenesis.com.dealyuser.adapter.SearchAdapter;
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
public class SearchLiveFragment extends Fragment {




    public SearchLiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate( R.layout.fragment_live_search, container, false);




        RecyclerView searchDataRv =  view.findViewById(R.id.searchRv);

        SearchAdapter mAdapter = new SearchAdapter (getActivity ());
        searchDataRv.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager (getContext ());
        searchDataRv.setLayoutManager(mLayoutManager);
        searchDataRv.setAdapter(mAdapter);

        return view;
    }



}
