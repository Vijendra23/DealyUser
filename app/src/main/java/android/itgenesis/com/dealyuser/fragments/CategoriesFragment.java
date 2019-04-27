package android.itgenesis.com.dealyuser.fragments;


import android.itgenesis.com.dealyuser.R;
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
public class CategoriesFragment extends Fragment {


    public CategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_category_item, container, false);


        view.findViewById ( R.id.cv_hotels ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Common.ChangeFragment ( getActivity (), new PopularDealOfferFragment (), true );

            }
        } );

        view.findViewById ( R.id.cv_Spa ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Common.ChangeFragment ( getActivity (), new PopularDealOfferFragment (), true );

            }
        } );

        view.findViewById ( R.id.cv_food).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Common.ChangeFragment ( getActivity (), new PopularDealOfferFragment (), true );

            }
        } );

        view.findViewById ( R.id.cv_recreation ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Common.ChangeFragment ( getActivity (), new PopularDealOfferFragment (), true );

            }
        } );

        view.findViewById ( R.id.cv_shoping ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Common.ChangeFragment ( getActivity (), new PopularDealOfferFragment (), true );

            }
        } );

        view.findViewById ( R.id.cv_case_deals ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Common.ChangeFragment ( getActivity (), new PopularDealOfferFragment (), true );

            }
        } );



        return view;
    }

}
