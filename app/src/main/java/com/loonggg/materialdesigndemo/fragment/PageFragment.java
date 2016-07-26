package com.loonggg.materialdesigndemo.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.loonggg.materialdesigndemo.R;
import com.loonggg.materialdesigndemo.adapter.XituRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;


public class PageFragment extends BaseFragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private RecyclerView lv;

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment pageFragment = new PageFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    protected int loadLayoutId() {
        return R.layout.fragment_page;
    }

    @Override
    protected void initViews() {
        lv =$(R.id.lv);
    }

    @Override
    protected void initData() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        lv.setLayoutManager(layoutManager);

    }

    @Override
    protected void onProcessLogic() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            list.add(i + "");
        }
        lv.setAdapter(new XituRecyclerViewAdapter(list));
    }
}
