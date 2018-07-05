package com.studio.ember.cryptobit.screens.coindetail;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.studio.ember.cryptobit.R;
import com.studio.ember.cryptobit.model.Coin;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CoinDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CoinDetailFragment extends Fragment implements CoinDetailContract.View {

    private CoinDetailContract.Presenter mPresenter;
    private View view;
    private Unbinder unbinder;

    public CoinDetailFragment() {
        // Required empty public constructor
    }


    public static CoinDetailFragment newInstance() {
        CoinDetailFragment fragment = new CoinDetailFragment();
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
        view = inflater.inflate(R.layout.fragment_coin_detail, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void changePicture() {

    }

    @Override
    public void setInfo(Coin coin) {

    }

    @Override
    public void setPresenter(CoinDetailContract.Presenter presenter) {
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
