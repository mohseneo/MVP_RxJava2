package com.example.app.core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Base Fragment that will link to a Presenter (extending the {@link BasePresenter})
 */
public class BaseFragment<T extends BasePresenter> extends Fragment {

    //Presenter linked to this Fragment
    protected T mPresenter;

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mPresenter != null) {
            mPresenter.onViewAttached();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.onViewDetached();
        }
    }
}
