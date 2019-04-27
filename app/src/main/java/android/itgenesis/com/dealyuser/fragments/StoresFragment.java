package android.itgenesis.com.dealyuser.fragments;


import android.itgenesis.com.dealyuser.R;
import android.itgenesis.com.dealyuser.util.Common;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoresFragment extends Fragment {


    public StoresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_stores2, container, false);


        view.findViewById ( R.id.card_view_burgur_bar ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Common.ChangeFragment (getActivity (), new VendorProfileFragment (), false );
            }
        } );

        view.findViewById ( R.id.card_view_burgur_bar2 ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Common.ChangeFragment (getActivity (), new VendorProfileFragment (), false );
            }
        } );

        view.findViewById ( R.id.card_view_burgur_king ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Common.ChangeFragment (getActivity (), new VendorProfileFragment (), false );
            }
        } );

        view.findViewById ( R.id.card_view_burgur_king2 ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Common.ChangeFragment (getActivity (), new VendorProfileFragment (), false );
            }
        } );






        return view;
    }

}
