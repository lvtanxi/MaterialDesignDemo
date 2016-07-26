/*
 * Copyright (C) 2013 Andreas Stuetz <andreas.stuetz@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.loonggg.materialdesigndemo.fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.loonggg.materialdesigndemo.R;

public class PaletteFragment extends BaseFragment {

    private static final String ARG_POSITION = "position";

    private int position;
    private static final int[] drawables = {R.mipmap.wallpaper_4, R.mipmap.two, R.mipmap.four, R.mipmap
            .three, R.mipmap.five};
    private TextView mTest;
    private LinearLayout testLay;

    public static PaletteFragment newInstance(int position) {
        PaletteFragment f = new PaletteFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(ARG_POSITION);
    }




    @Override
    protected int loadLayoutId() {
        Log.d("PaletteFragment", "loadLayoutId" + position);
        return R.layout.palette_fragment;
    }

    @Override
    protected void initViews() {
        mTest = $(R.id.test);
        testLay = $(R.id.testLay);
        Log.d("PaletteFragment", "initViews" + position);
    }

    @Override
    protected void initData() {
        testLay.setBackgroundResource(drawables[position]);
        mTest.setText("CARD " + (position + 1));
    }

    /**
     * 提供当前Fragment的主色调的Bitmap对象,供Palette解析颜色
     *
     * @return
     */
    public static int getBackgroundBitmapPosition(int selectViewPagerItem) {
        return drawables[selectViewPagerItem];
    }

}