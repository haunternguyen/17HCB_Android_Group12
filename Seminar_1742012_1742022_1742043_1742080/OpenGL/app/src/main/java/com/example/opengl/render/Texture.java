package com.example.opengl.render;

import android.content.Context;

import com.example.opengl.R;

public class Texture extends BaseTexture {

    public Texture(Context context) {
        super(context);
    }

    @Override
    protected int getTextureId() {
        return TextureUtil.loadTexture(mContext, R.drawable.test1);
    }
}
