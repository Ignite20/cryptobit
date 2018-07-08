package com.studio.ember.cryptobit;

public interface BaseView<T> {

    /**
     * Method to set the presenter to the view
     * @param presenter The presenter to be set
     */
    void setPresenter(T presenter);

    /**
     * Show Toast with desired message
     * @param message
     */
    void showToastMessage(String message);
}
