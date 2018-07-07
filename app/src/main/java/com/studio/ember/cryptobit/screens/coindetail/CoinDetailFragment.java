package com.studio.ember.cryptobit.screens.coindetail;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.studio.ember.cryptobit.R;
import com.studio.ember.cryptobit.model.Coin;
import com.studio.ember.cryptobit.model.Currency;
import com.studio.ember.cryptobit.utils.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.studio.ember.cryptobit.utils.Constants.COIN_DETAILS;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CoinDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CoinDetailFragment extends Fragment implements CoinDetailContract.View {


    // region View Widgets
    @BindView(R.id.tv_coin_name)
    TextView tv_name;

    @BindView(R.id.tv_symbol)
    TextView tv_symbol;

    @BindView(R.id.tv_rank)
    TextView tv_rank;

    @BindView(R.id.tv_circulating_supply)
    TextView tv_circulating_supply;

    @BindView(R.id.tv_total_supply)
    TextView tv_total_supply;

    @BindView(R.id.tv_max_supply)
    TextView tv_max_supply;

    @BindView(R.id.tv_price2)
    TextView tv_price;

    @BindView(R.id.tv_volume_24h)
    TextView tv_volumne_24h;

    @BindView(R.id.tv_market_cap)
    TextView tv_market_cap;

    @BindView(R.id.tv_change_1h)
    TextView tv_change_1h;

    @BindView(R.id.tv_change_24h)
    TextView tv_change_24h;

    @BindView(R.id.tv_change_7d)
    TextView tv_change_7d;

    @BindView(R.id.spnr_market_coin)
    Spinner spnr_market_coin;
    // endregion

    private ArrayAdapter<CharSequence> marketCoinAdapter;
    @Override
    public void showInfo(Coin coin) {
        if(coin != null) {
            // Get currency object from coin for ease of use
            Currency curr = coin.getQuotes().get(mPresenter.getMarketCoin());

            if(curr != null) {
                // Set values to GUI
                tv_name.setText(coin.getName());
                tv_symbol.setText(coin.getSymbol());
                tv_rank.setText(String.valueOf(coin.getRank()));
                tv_circulating_supply.setText(StringUtils.formatFloat(coin.getCirculating_supply()));
                tv_total_supply.setText(StringUtils.formatFloat(coin.getTotal_supply()));
                tv_max_supply.setText(StringUtils.formatFloat(coin.getMax_supply()));
                tv_price.setText(StringUtils.formatFloat(curr.getPrice()));
                tv_volumne_24h.setText(StringUtils.formatFloat(curr.getVolume_24h()));
                tv_market_cap.setText(StringUtils.formatFloat(curr.getMarket_cap()));
                tv_change_1h.setText(StringUtils.formatFloat(curr.getPercent_change_1h()));
                tv_change_24h.setText(StringUtils.formatFloat(curr.getPercent_change_24h()));
                tv_change_7d.setText(StringUtils.formatFloat(curr.getPercent_change_7d()));
            }
        }
    }

    private CoinDetailContract.Presenter mPresenter;
    private View view;
    private Unbinder unbinder;

    public CoinDetailFragment() {
        // Required empty public constructor
    }


    public static CoinDetailFragment newInstance(Bundle bundle) {
        CoinDetailFragment fragment = new CoinDetailFragment();
        if(bundle != null)
            fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Log.d("details_fragment", getArguments().getSerializable(COIN_DETAILS).toString());
            mPresenter.setData((Coin) getArguments().getSerializable(COIN_DETAILS));
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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mPresenter.start();
        marketCoinAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.market_coins, android.R.layout.simple_list_item_1);
        marketCoinAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spnr_market_coin.setAdapter(marketCoinAdapter);
        spnr_market_coin.setSelection(marketCoinAdapter.getPosition(mPresenter.getMarketCoin()));
        spnr_market_coin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mPresenter.changeMarketCoin(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
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
    public void onDetach() {
        super.onDetach();
        unbinder.unbind();
    }
}
