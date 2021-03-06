package android.itgenesis.com.dealyuser.fragments;


import android.itgenesis.com.dealyuser.R;
import android.itgenesis.com.dealyuser.adapter.FavoritesAdapter;
import android.itgenesis.com.dealyuser.adapter.TransactionAdapter;
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
public class FavoriteFragment extends Fragment {


    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_favorites, container, false);


        RecyclerView transaction_rv =  view.findViewById(R.id.transaction_rv);

        FavoritesAdapter mAdapter = new FavoritesAdapter (getActivity ());
        transaction_rv.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager (getContext ());
        transaction_rv.setLayoutManager(mLayoutManager);
        transaction_rv.setAdapter(mAdapter);

        return view;
    }

}
