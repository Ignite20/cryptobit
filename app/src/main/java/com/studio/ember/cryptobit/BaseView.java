package com.studio.ember.cryptobit;

public interface BaseView<T> {
    void setPresenter(T presenter);

    void showToastMessage(String message);
}
