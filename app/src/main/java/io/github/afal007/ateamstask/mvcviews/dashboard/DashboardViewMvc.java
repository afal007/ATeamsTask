package io.github.afal007.ateamstask.mvcviews.dashboard;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.afal007.ateamstask.R;
import io.github.afal007.ateamstask.mvcviews.AbstractViewMvc;
import io.github.afal007.ateamstask.utils.picasso.RoundCornersTransformation;
import io.github.afal007.ateamstask.utils.picasso.RoundTransformation;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * @author Alexander Fal (falalexandr007@gmail.com)
 */

public class DashboardViewMvc extends AbstractViewMvc {
    
    @BindView(R.id.et_dashboard_posts)           EditText mPostIdEditText;
    @BindView(R.id.button_dashboard_posts)       Button mShowPostButton; 
    
    @BindView(R.id.et_dashboard_comments)        EditText mCommentIdEditText;
    @BindView(R.id.button_dashboard_comments)    Button mShowCommentButton;
    
    @BindView(R.id.rv_dashboard_users)           RecyclerView mUsersRecyclerView;
    
    @BindView(R.id.iv_dashboard_image)           ImageView mImageView;
    
    @BindView(R.id.tv_dashboard_todo_username)   TextView mTodoUsernameTextView;
    @BindView(R.id.tv_dashboard_todo_details)    TextView mTodoDetailsTextView;
    @BindView(R.id.iv_dashboard_todo_image)      ImageView mTodoImageView;
    
    public DashboardViewMvc(@NonNull LayoutInflater inflater,
                            @Nullable ViewGroup container) {
        setRootView(inflater.inflate(R.layout.fragment_dashboard, container, false));
        ButterKnife.bind(this, getRootView());

        loadImage();
    }

    private void loadImage() {
        Picasso.with(getContext())
                .load(R.drawable.img_lights)
                .placeholder(R.drawable.placeholder_fbc_loading_your_image)
                .transform(new RoundedCornersTransformation(5, 0))
                .into(mImageView);
    }
}
