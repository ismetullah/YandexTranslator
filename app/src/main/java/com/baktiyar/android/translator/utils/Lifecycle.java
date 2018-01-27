package com.baktiyar.android.translator.utils;

/**
 * Created by Ismet on 1/26/2018.
 */

public interface Lifecycle<V> {
    void bind(V view);

    void unbind();

    boolean isViewAttached();
}
