package tech.poechiang.app.poechat;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;


public abstract class NavigationBarActivity extends PoeActivity {

    private BottomNavigationView navView;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        navView = findViewById(R.id.bottomNavigationView);


        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.setSelectedItemId(R.id.nav_msg);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            restoreNavBarItemIcon();
            restoreNavPageVisibility();
            MenuItem mi = navView.getMenu().findItem(item.getItemId());
            switch (item.getItemId()) {
                case R.id.nav_msg:
                    mi.setIcon(R.drawable.ic_msg_sel);
                    findViewById(R.id.msgpanel).setVisibility(View.VISIBLE);
                    return true;
                case R.id.nav_find:
                    mi.setIcon(R.drawable.ic_find_sel);
                    findViewById(R.id.findpanel).setVisibility(View.VISIBLE);
                    return true;
                case R.id.nav_contact:
                    mi.setIcon(R.drawable.ic_contact_sel);
                    findViewById(R.id.contactpanel).setVisibility(View.VISIBLE);
                    return true;
                case R.id.nav_my:
                    mi.setIcon(R.drawable.ic_my_sel);
                    findViewById(R.id.mypanel).setVisibility(View.VISIBLE);
                    return true;
            }
            return false;
        }
    };

    protected void restoreNavPageVisibility(){
        findViewById(R.id.msgpanel).setVisibility(View.INVISIBLE);
        findViewById(R.id.contactpanel).setVisibility(View.INVISIBLE);
        findViewById(R.id.findpanel).setVisibility(View.INVISIBLE);
        findViewById(R.id.mypanel).setVisibility(View.INVISIBLE);
    }

    private void restoreNavBarItemIcon(){
        navView.getMenu().findItem(R.id.nav_msg).setIcon(R.drawable.ic_msg_unsel);
        navView.getMenu().findItem(R.id.nav_contact).setIcon(R.drawable.ic_contact_unsel);
        navView.getMenu().findItem(R.id.nav_find).setIcon(R.drawable.ic_find_unsel);
        navView.getMenu().findItem(R.id.nav_my).setIcon(R.drawable.ic_my_unsel);
    }



}
