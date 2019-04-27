package android.itgenesis.com.dealyuser.adapter;

import android.content.Context;
import android.content.Intent;
import android.itgenesis.com.dealyuser.R;
import android.itgenesis.com.dealyuser.activities.BottomNavigationActivity;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    Context context;

    int image[]={R.drawable.explore_ppl_near_you_img01_user,R.drawable.explore_ppl_near_you_img02_user,R.drawable.feed_img03_user
            ,R.drawable.explore_ppl_near_you_img01_user};

    private int row_index=-1;

    String name[]={"Jason Strong","Jenna Slim","Tina May","Sara Jane"};



    public NotificationAdapter(Context context) {

        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate( R.layout.notification_item, viewGroup, false);




        itemView.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                context.startActivity ( new Intent (context,BottomNavigationActivity.class )
                        .putExtra ( "command","order_confirmation" ));
            }
        } );

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
             // viewHolder.iv_image.setImageResource ( image[i] );
             // viewHolder.tvName.setText ( name[i] );

        if(i%2==0)
        {

            viewHolder.cvNotification.setBackground(context.getResources().getDrawable(R.color.colorLightGray));

        }


    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

     //   ImageView iv_image  ;
     //   TextView tvName;

        CardView cvNotification;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

           /// iv_image= itemView.findViewById ( R.id.img )  ;
            // tvName= itemView.findViewById ( R.id.tv_name)  ;
            cvNotification=itemView.findViewById ( R.id.cv_notification );


        }
    }
}
