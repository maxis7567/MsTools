package com.hinext.maxis7567.mstools;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.View;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;


public class VideoEnabledWebChromeClient extends WebChromeClient
{
    private View mCustomView;
    private CustomViewCallback mCustomViewCallback;
    protected FrameLayout mFullscreenContainer;
    private int mOriginalOrientation;
    private int mOriginalSystemUiVisibility;
    private Context context;

    public VideoEnabledWebChromeClient(Context context) {
        this.context = context;
    }

    public Bitmap getDefaultVideoPoster()
    {
        if (mCustomView == null) {
            return null;
        }
        return BitmapFactory.decodeResource(context.getApplicationContext().getResources(), 2130837573);
    }

    public void onHideCustomView()
    {
        ((FrameLayout)((Activity)context).getWindow().getDecorView()).removeView(this.mCustomView);
        this.mCustomView = null;
        ((Activity)context).getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
        ((Activity)context).setRequestedOrientation(this.mOriginalOrientation);
        this.mCustomViewCallback.onCustomViewHidden();
        this.mCustomViewCallback = null;
    }

    public void onShowCustomView(View paramView, CustomViewCallback paramCustomViewCallback)
    {
        if (this.mCustomView != null)
        {
            onHideCustomView();
            return;
        }
        this.mCustomView = paramView;
        this.mCustomView.setBackgroundColor(Color.BLACK);
        this.mOriginalSystemUiVisibility = ((Activity)context).getWindow().getDecorView().getSystemUiVisibility();
        this.mOriginalOrientation = ((Activity)context).getRequestedOrientation();
        this.mCustomViewCallback = paramCustomViewCallback;
        ((FrameLayout)((Activity)context).getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1));
        ((Activity)context).getWindow().getDecorView().setSystemUiVisibility(3846);
    }
}