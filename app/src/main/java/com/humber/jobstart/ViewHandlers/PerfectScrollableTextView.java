package com.humber.jobstart.ViewHandlers;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;

/**
 * The type Perfect scrollable text view.
 * This is also a custom TextView class to dynamically scroll the text while in app
 */
public class PerfectScrollableTextView extends android.support.v7.widget.AppCompatTextView {
    /**
     * Instantiates a new Perfect scrollable text view.
     *
     * @param context  the context
     * @param attrs    the attrs
     * @param defStyle the def style
     */
    public PerfectScrollableTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setVerticalScrollBarEnabled(true);
        setHorizontallyScrolling(false);
    }

    /**
     * Instantiates a new Perfect scrollable text view.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public PerfectScrollableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setVerticalScrollBarEnabled(true);
        setHorizontallyScrolling(false);
    }

    /**
     * Instantiates a new Perfect scrollable text view.
     *
     * @param context the context
     */
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
