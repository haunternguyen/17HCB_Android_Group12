package com.example.opengl.render;

import android.content.Context;

import com.example.opengl.R;

public class SkyBox extends BaseSkyBox {


    public SkyBox(Context context) {
        super(context);
    }

    @Override
    protected int getTextureId() {
        return TextureUtil.loadCubeMap(mContext,
                new int[]{R.drawable.left, R.drawable.right,
                        R.drawable.bottom, R.drawable.top,
                        R.drawable.front, R.drawable.back});
    }

}
