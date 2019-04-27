package android.itgenesis.com.dealyuser.activities;

import android.content.Intent;
import android.itgenesis.com.dealyuser.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class GetStartedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView (R.layout.intro_login_sign_up);




        findViewById ( R.id.ll_new_user_sign_up).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                startActivity (new Intent ( GetStartedActivity.this,SignUpActivity.class ));
            }
        } );


        findViewById ( R.id.ll_already_member_sign_in ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                startActivity (new Intent ( GetStartedActivity.this,AlreadyMemberSignInActivity.class ));
            }
        } );


        findViewById ( R.id.btn_skip ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                startActivity (new Intent ( GetStartedActivity.this,NavigationActivity.class ));


            }
        } );
    }
}
