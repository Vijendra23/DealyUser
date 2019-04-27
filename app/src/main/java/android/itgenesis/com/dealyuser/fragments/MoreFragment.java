package android.itgenesis.com.dealyuser.fragments;


import android.content.Intent;
import android.itgenesis.com.dealyuser.R;
import android.itgenesis.com.dealyuser.activities.BottomNavigationActivity;
import android.itgenesis.com.dealyuser.activities.NavigationActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {


    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_more, container, false);
        view.findViewById ( R.id.cv_terms_of_use ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                startActivity ( new Intent ( getContext (),BottomNavigationActivity.class )
                        .putExtra ( "command","terms_of_use" ));

            }
        } );

        view.findViewById ( R.id.cv_privacy_plicy ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                startActivity ( new Intent ( getContext (),BottomNavigationActivity.class )
                        .putExtra ( "command","privacy_policy" ));

            }
        } );

        view.findViewById ( R.id.cv_faq ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                startActivity ( new Intent ( getContext (),BottomNavigationActivity.class )
                        .putExtra ( "command","faq" ));
            }
        } );

        view.findViewById ( R.id.cv_promise ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                startActivity ( new Intent ( getContext (),BottomNavigationActivity.class )
                        .putExtra ( "command","promise" ));
            }
        } );



        return view;
    }

}
