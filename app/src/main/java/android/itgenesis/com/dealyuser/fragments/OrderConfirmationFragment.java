package android.itgenesis.com.dealyuser.fragments;


import android.content.Intent;
import android.itgenesis.com.dealyuser.R;
import android.itgenesis.com.dealyuser.activities.BottomNavigationActivity;
import android.itgenesis.com.dealyuser.activities.NavigationActivity;
import android.itgenesis.com.dealyuser.util.Common;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderConfirmationFragment extends Fragment {


    public OrderConfirmationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragmet_order_confirmation, container, false);

        BottomNavigationActivity.tvTitle.setText ("ORDER CONFIRMATION");

        view.findViewById ( R.id.ll_view_more_deals ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                startActivity ( new Intent ( getActivity (),NavigationActivity.class )
                        .putExtra ( "command","home" ));


            }
        } );





        return view;
    }

}
