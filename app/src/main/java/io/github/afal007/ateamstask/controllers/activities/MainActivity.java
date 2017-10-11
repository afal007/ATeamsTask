package io.github.afal007.ateamstask.controllers.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import io.github.afal007.ateamstask.R;
import io.github.afal007.ateamstask.controllers.fragment.ContactsFragment;
import io.github.afal007.ateamstask.controllers.fragment.DashboardFragment;
import io.github.afal007.ateamstask.mvcviews.contacts.ContactsViewMvc;
import io.github.afal007.ateamstask.mvcviews.main.MainViewMvc;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener,
        DashboardFragment.OnFragmentInteractionListener,
        ContactsFragment.OnFragmentInteractionListener{

    private MainViewMvc mViewMvc;
    private static int state;
    private final static int DASHBOARD = 0;
    private final static int CONTACTS = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewMvc = new MainViewMvc(getLayoutInflater(), null);
        setContentView(mViewMvc.getRootView());

        mViewMvc.setOnNavItemSelectedListener(this);

        Fragment fragment = DashboardFragment.newInstance();

        state = DASHBOARD;

        getSupportFragmentManager().beginTransaction()
                .add(mViewMvc.getFragmentContainerId(), fragment)
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_dashboard:
                if(state != DASHBOARD) {
                    swapFragment(DashboardFragment.newInstance());
                    state = DASHBOARD;
                }
                return true;
            case R.id.navigation_contacts:
                if(state != CONTACTS) {
                    swapFragment(ContactsFragment.newInstance());
                    state = CONTACTS;
                }
                return true;
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mViewMvc.setOnNavItemSelectedListener(null);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private void swapFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(mViewMvc.getFragmentContainerId(), fragment)
                .commit();
    }
}
