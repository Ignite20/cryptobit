package com.studio.ember.projectc.screens.profile;

import com.studio.ember.projectc.BasePresenter;
import com.studio.ember.projectc.BaseView;
import com.studio.ember.projectc.model.User;

public interface ProfileContract {
    interface View extends BaseView<ProfileContract.Presenter> {
        void changePicture();

        void setInfo(User user);
    }

    interface Presenter extends BasePresenter {
        void changeProfilePicture();


    }
}
