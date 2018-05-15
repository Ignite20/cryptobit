package com.studio.ember.projectc;

public interface BaseView<T> {
    void setPresenter(T presenter);

    void showToastMessage(String message);
}
