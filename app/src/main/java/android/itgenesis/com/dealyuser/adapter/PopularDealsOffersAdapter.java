package android.itgenesis.com.dealyuser.adapter;

import android.content.Intent;
import android.itgenesis.com.dealyuser.R;
import android.itgenesis.com.dealyuser.activities.BottomNavigationActivity;
import android.itgenesis.com.dealyuser.fragments.VendorProfileFragment;
import android.itgenesis.com.dealyuser.util.Common;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PopularDealsOffersAdapter extends RecyclerView.Adapter<PopularDealsOffersAdapter.ViewHolder> {


    FragmentActivity activity;

    public PopularDealsOffersAdapter(FragmentActivity activity) {

        this.activity=activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.popular_deal_offer_item, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.ivLiveDealsImageUser.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                activity.startActivity ( new Intent ( activity,BottomNavigationActivity.class )
                        .putExtra ( "command","burgurdeal" ));
            }
        } );


        viewHolder.tvRedeem.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                activity.startActivity ( new Intent ( activity,BottomNavigationActivity.class )
                        .putExtra ( "command","burgurdeal" ));
            }
        } );


        viewHolder.tvBurgerKing.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Common.ChangeFragment(activity, new VendorProfileFragment (), true);

            }
        } );


        viewHolder.ivBurgerKing.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Common.ChangeFragment(activity, new VendorProfileFragment (), true);

            }
        } );



    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvRedeem;
        TextView tvBurgerKing;
        ImageView ivBurgerKing;
        ImageView ivLiveDealsImageUser;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvRedeem= itemView.findViewById ( R.id.tv_redeem );
            tvBurgerKing= itemView.findViewById ( R.id.tv_burger_king );
            ivBurgerKing= itemView.findViewById ( R.id.iv_burger_king );
            ivLiveDealsImageUser= itemView.findViewById ( R.id.iv_live_deals_deal_image_user );
        }
    }
}
