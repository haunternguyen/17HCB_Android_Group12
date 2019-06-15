package com.example.opengl.render;

import android.content.Context;

public abstract class Shape {

    protected Context mContext;
    protected int mProgram;

    public Shape(Context context) {
        this.mContext = context;
    }

    protected abstract void createProgram();

    protected abstract void initData();

    public abstract void draw(float[] matrix);
}
