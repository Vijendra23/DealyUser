package android.itgenesis.com.dealyuser.activities;

import android.content.Intent;
import android.itgenesis.com.dealyuser.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CongrtulationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.congratulations_screen );
        findViewById (R.id.ll_click_to_login ).setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity ( new Intent ( CongrtulationActivity.this,AlreadyMemberSignInActivity.class ) );
            }
        } );
    }
}
