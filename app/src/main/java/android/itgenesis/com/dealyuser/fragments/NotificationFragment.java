package android.itgenesis.com.dealyuser.fragments;


import android.itgenesis.com.dealyuser.R;
import android.itgenesis.com.dealyuser.adapter.NotificationAdapter;
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
public class NotificationFragment extends Fragment {

    RecyclerView rvNotification;

    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_notification, container, false);
                   rvNotification=view.findViewById ( R.id.notificationRv );

        NotificationAdapter mAdapter = new NotificationAdapter (getContext ());
        rvNotification.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager (getContext ());
        rvNotification.setLayoutManager(mLayoutManager);
        rvNotification.setAdapter(mAdapter);


         getActivity ().findViewById ( R.id.iv_notification ).setVisibility ( View.GONE );


        return view;
    }

}
