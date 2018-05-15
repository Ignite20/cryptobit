package com.studio.ember.projectc.screens.profile;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.studio.ember.projectc.R;
import com.studio.ember.projectc.model.User;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment implements ProfileContract.View {

    private ProfileContract.Presenter mPresenter;
    private View view;
    private Unbinder unbinder;

    public ProfileFragment() {
        // Required empty public constructor
    }


    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void changePicture() {

    }

    @Override
    public void setInfo(User user) {

    }

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onStop() {
        super.onStop();
        unbinder.unbind();
    }
}
