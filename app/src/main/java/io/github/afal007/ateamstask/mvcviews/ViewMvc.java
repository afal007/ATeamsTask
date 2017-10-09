package io.github.afal007.ateamstask.mvcviews;

import android.os.Bundle;
import android.view.View;

/**
 * @author Alexander Fal (falalexandr007@gmail.com)
 */

public interface ViewMvc {
    View getRootView();
    public Bundle getViewState();
}
