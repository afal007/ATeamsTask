package io.github.afal007.ateamstask.mvcviews.contacts;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import io.github.afal007.ateamstask.R;
import io.github.afal007.ateamstask.mvcviews.AbstractViewMvc;

/**
 * @author Alexander Fal (falalexandr007@gmail.com)
 */

public class ContactsViewMvc extends AbstractViewMvc {

    public ContactsViewMvc(@NonNull LayoutInflater inflater,
                           @Nullable ViewGroup container) {
        setRootView(inflater.inflate(R.layout.fragment_contacts, container, false));
    }
}
