package com.studio.ember.cryptobit.screens.coins;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.studio.ember.cryptobit.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link CoinsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CoinsFragment extends Fragment implements CoinsContract.View{


    private CoinsContract.Presenter mPresenter;
    private LinearLayoutManager layoutManager;
    private Unbinder unbinder;

    @BindView(R.id.srl_cryptUpdate)
    SwipeRefreshLayout srl_cryptUpdate;

    @BindView(R.id.rvRecipeList)
    RecyclerView rvRecipeList;


    public CoinsFragment() {
        // Required empty public constructor
    }


    public static CoinsFragment newInstance() {
        CoinsFragment fragment = new CoinsFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coin, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void terminateUpdate() {
        srl_cryptUpdate.setRefreshing(false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mPresenter.start();
        layoutManager = new LinearLayoutManager(getActivity());
        mPresenter.adaptRecyclerView(rvRecipeList, layoutManager);

        srl_cryptUpdate.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.updateData();
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        unbinder.unbind();
    }


    @Override
    public void setPresenter(CoinsContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onCoinClick(int position) {

    }
}
