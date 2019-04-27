package android.itgenesis.com.dealyuser.activities;

import android.itgenesis.com.dealyuser.R;
import android.itgenesis.com.dealyuser.adapter.TransactionAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_transactions);

         RecyclerView transaction_rv =  findViewById(R.id.transaction_rv);

     //   TransactionAdapter mAdapter = new TransactionAdapter();
       // transaction_rv.setHasFixedSize(true);
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
  //      transaction_rv.setLayoutManager(mLayoutManager);
       // transaction_rv.setAdapter(mAdapter);

    }
}
