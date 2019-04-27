package android.itgenesis.com.dealyuser.activities;

import android.content.Intent;
import android.itgenesis.com.dealyuser.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class AlreadyMemberSignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView (R.layout.activity_login );

        findViewById ( R.id.ll_login ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                startActivity ( new Intent (AlreadyMemberSignInActivity.this,NavigationActivity.class  ) );
            }
        } );


        findViewById ( R.id.ll_forgot_password ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                startActivity ( new Intent (AlreadyMemberSignInActivity.this,ForgotActivity.class  ) );
            }
        } );
    }
}
