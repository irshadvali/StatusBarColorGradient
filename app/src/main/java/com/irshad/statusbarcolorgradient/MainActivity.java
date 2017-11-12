package com.irshad.statusbarcolorgradient;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //must be called before setContentView(...)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_main);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.rel);

        GradientDrawable drawable = new GradientDrawable();
        drawable.setColors(new int[] {
                Color.parseColor(CustomColorList.color_one),
                Color.parseColor(CustomColorList.color_two)
        });

        drawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        drawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        layout.setBackground(drawable);
    }
}
