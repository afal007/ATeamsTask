package io.github.afal007.ateamstask.controllers.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import io.github.afal007.ateamstask.R;
import io.github.afal007.ateamstask.controllers.fragment.DashboardFragment;
import io.github.afal007.ateamstask.mvcviews.dashboard.DashboardViewMvc;
import io.github.afal007.ateamstask.mvcviews.main.MainViewMvc;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener,
        DashboardFragment.OnFragmentInteractionListener{

    private MainViewMvc mViewMvc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewMvc = new MainViewMvc(getLayoutInflater(), null);
        setContentView(mViewMvc.getRootView());

        mViewMvc.setOnNavItemSelectedListener(this);

        Fragment fragment = DashboardFragment.newInstance();

        getSupportFragmentManager().beginTransaction()
                .add(mViewMvc.getFragmentContainerId(), fragment)
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_dashboard:
                Toast.makeText(this, "Dashboard", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.navigation_contacts:
                Toast.makeText(this, "Contacts", Toast.LENGTH_SHORT).show();
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
}
