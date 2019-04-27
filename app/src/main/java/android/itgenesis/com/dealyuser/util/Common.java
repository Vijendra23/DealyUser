package android.itgenesis.com.dealyuser.util;

import android.itgenesis.com.dealyuser.R;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by picon on 25-Oct-18.
 */

public class Common {

    public static void ChangeFragment(FragmentActivity activity , Fragment fragment, boolean BackAllow) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace( R.id.content, fragment);
        if (BackAllow)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
