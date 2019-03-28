package com.humber.jobstart.ViewHandlers;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;

public class PerfectScrollableTextView extends android.support.v7.widget.AppCompatTextView {
    public PerfectScrollableTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setVerticalScrollBarEnabled(true);
        setHorizontallyScrolling(false);
    }

    public PerfectScrollableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setVerticalScrollBarEnabled(true);
        setHorizontallyScrolling(false);
    }

    public PerfectScrollableTextView(Context context) {
        super(context);
        setVerticalScrollBarEnabled(true);
        setHorizontallyScrolling(false);
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        if (focused)
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }

    @Override
    public void onWindowFocusChanged(boolean focused) {
        if (focused)
            super.onWindowFocusChanged(focused);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
