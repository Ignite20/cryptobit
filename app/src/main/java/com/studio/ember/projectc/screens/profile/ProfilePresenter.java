package com.studio.ember.projectc.screens.profile;

public class ProfilePresenter implements ProfileContract.Presenter {

    private ProfileContract.View mView;

    public ProfilePresenter(ProfileContract.View mView) {
        this.mView = mView;
        this.mView.setPresenter(this);
    }

    @Override
    public void changeProfilePicture() {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
