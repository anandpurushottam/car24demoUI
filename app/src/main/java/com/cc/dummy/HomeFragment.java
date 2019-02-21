package com.cc.dummy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class HomeFragment extends Fragment {
    public final int ALL_CARS = 10;
    public final int LIVE_CARS = 2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getLayoutInflater().inflate(R.layout.activity_scrolling, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final MyAdapter adapter = new MyAdapter(4);
        final RecyclerView rv = view.findViewById(R.id.recyclerView);
        final RecyclerView rvRecentlyViewed = view.findViewById(R.id.rvRecentlyViewed);
        final RecyclerView rvOcb = view.findViewById(R.id.rvOcb);


        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvRecentlyViewed.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvOcb.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rv.setAdapter(adapter);
        rvOcb.setAdapter(new MyAdapterMini(23));
        rvRecentlyViewed.setAdapter(new MyAdapterMini(2));

        Switch toogle = view.findViewById(R.id.toogle);

        final TextView tvTitle = view.findViewById(R.id.tvTitle);
        toogle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    tvTitle.setText("All Cars (" + ALL_CARS + ")");
                    rv.setAdapter(new MyAdapter(ALL_CARS));

                } else {
                    tvTitle.setText("Live Cars (" + LIVE_CARS + ")");
                    rv.setAdapter(new MyAdapter(LIVE_CARS));

                }
            }
        });

    }

    public static HomeFragment newInstance() {
        return new HomeFragment();

    }


}
