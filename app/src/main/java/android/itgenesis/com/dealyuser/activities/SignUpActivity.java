package android.itgenesis.com.dealyuser.activities;

import android.content.Intent;
import android.itgenesis.com.dealyuser.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView (R.layout.activity_sign_up);

        findViewById (R.id.rl_sign_up_now).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                startActivity ( new Intent ( SignUpActivity.this,CongrtulationActivity.class ) );
            }
        } );


        findViewById (R.id.tv_already_member_sign_in).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                startActivity ( new Intent ( SignUpActivity.this,AlreadyMemberSignInActivity.class ) );
            }
        } );
    }
}
