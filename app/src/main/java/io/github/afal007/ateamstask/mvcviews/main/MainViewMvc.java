package io.github.afal007.ateamstask.mvcviews.main;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.afal007.ateamstask.R;
import io.github.afal007.ateamstask.mvcviews.AbstractViewMvc;

/**
 * @author Alexander Fal (falalexandr007@gmail.com)
 */

public class MainViewMvc extends AbstractViewMvc {

    @BindView(R.id.main_bottom_navigation) BottomNavigationView mBottomNav;

    public MainViewMvc(@NonNull LayoutInflater layoutInflater,
                       @Nullable ViewGroup container) {
        setRootView(layoutInflater.inflate(R.layout.activity_main, container));
        ButterKnife.bind(this, getRootView());
    }

    public void setOnNavItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener listener) {
        mBottomNav.setOnNavigationItemSelectedListener(listener);
    }

    public int getFragmentContainerId() {
        return R.id.main_container;
    }
}
