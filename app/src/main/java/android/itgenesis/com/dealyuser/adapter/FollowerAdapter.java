package android.itgenesis.com.dealyuser.adapter;

import android.content.Intent;
import android.itgenesis.com.dealyuser.R;
import android.itgenesis.com.dealyuser.activities.BottomNavigationActivity;
import android.itgenesis.com.dealyuser.activities.NavigationActivity;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FollowerAdapter extends RecyclerView.Adapter<FollowerAdapter.ViewHolder> {

  FragmentActivity activity;

    int image[]={R.drawable.explore_ppl_near_you_img01_user,R.drawable.explore_ppl_near_you_img02_user,R.drawable.feed_img03_user
            ,R.drawable.explore_ppl_near_you_img01_user};

    String name[]={"Jason Strong","Jenna Slim","Tina May","Sara Jane"};

    public FollowerAdapter(FragmentActivity activity) {

        this.activity=activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate( R.layout.follower_item, viewGroup, false);


           itemView.setOnClickListener ( new View.OnClickListener () {
               @Override
               public void onClick(View view) {

                   activity.startActivity ( new Intent (activity ,NavigationActivity.class )
                           .putExtra ( "command","profile" ));
               }
           } );
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
              viewHolder.iv_image.setImageResource ( image[i] );
              viewHolder.tvName.setText ( name[i] );
    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_image  ;
        TextView tvName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_image= itemView.findViewById ( R.id.img )  ;
             tvName= itemView.findViewById ( R.id.tv_name)  ;


        }
    }
}
