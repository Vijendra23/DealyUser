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

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{

    FragmentActivity activity;

    public SearchAdapter(FragmentActivity activity) {

        this.activity=activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.search_item, viewGroup, false);

        itemView.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                activity.startActivity ( new Intent ( activity,BottomNavigationActivity.class )
                        .putExtra ( "command","burgurdeal" ));
            }
        } );

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {


        viewHolder.tvRedeem.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                activity.startActivity ( new Intent ( activity,BottomNavigationActivity.class )
                        .putExtra ( "command","burgurdeal" ));
            }
        } );
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvRedeem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRedeem= itemView.findViewById ( R.id.tv_redeem );
        }
    }
}
