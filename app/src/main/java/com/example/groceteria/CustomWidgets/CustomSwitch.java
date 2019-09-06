package com.example.groceteria.CustomWidgets;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.SwitchCompat;

import com.example.groceteria.Constants.Constants;
import com.example.groceteria.R;


public class CustomSwitch extends SwitchCompat {


    private Context mContext;
    private String mFont;

    public CustomSwitch(Context context) {
        super(context, null);
        mContext = context;
        init();
    }

    public CustomSwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTextView,
                0, 0);
        try {
            mFont = a.getString(R.styleable.CustomTextView_fontName);
        } finally {
            a.recycle();
        }
        init();
    }

    public void init() {
        if (mFont != null) {
            Typeface tf = null;
            switch (mFont) {
                case "Poppins-Bold.ttf":
                    tf = Typeface.createFromAsset(mContext.getAssets(), Constants.poppinsBold);
                    break;
                case "Poppins-Light.ttf":
                    tf = Typeface.createFromAsset(mContext.getAssets(), Constants.poppinsLight);
                    break;
                case "Poppins-Regular.ttf":
                    tf = Typeface.createFromAsset(mContext.getAssets(), Constants.poppinsRegular);
                    break;
                case "Poppins-SemiBold.ttf":
                    tf = Typeface.createFromAsset(mContext.getAssets(), Constants.poppinsSemiBold);
                    break;
            }
            setTypeface(tf, Typeface.NORMAL);
        }
    }
}
