package android.itgenesis.com.dealyuser.adapter;

import android.content.Intent;
import android.itgenesis.com.dealyuser.R;
import android.itgenesis.com.dealyuser.activities.BottomNavigationActivity;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

  FragmentActivity activity;

    public TransactionAdapter(FragmentActivity activity) {

        this.activity=activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate( R.layout.transaction_item2, viewGroup, false);



        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {


        viewHolder.tvViewCode.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                activity.startActivity ( new Intent (activity,BottomNavigationActivity.class )
                        .putExtra ( "command","order_confirmation" ));
            }
        } );
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView  tvViewCode;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvViewCode=itemView.findViewById ( R.id.tv_view_code );
        }
    }
}
