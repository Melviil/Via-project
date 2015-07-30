package cz.davidkocnar.dynamiclayout;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private LinearLayout layout;
    private int num = 0;

    private float x1,x2;
    static final int MIN_DISTANCE = 90;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //layout = new LinearLayout(this);
        //setContentView(layout);
        //layout.setOrientation(LinearLayout.VERTICAL);
        //Button bt = new Button(getApplicationContext());
        //bt.setText("Dynamic button");

        layout = (LinearLayout) findViewById(R.id.ll1);
    }


    public void click(View view) {
        TextView tv = new TextView(getApplicationContext());
        tv.setText("New Text! " + num);
        tv.setTextAppearance(this, R.style.text);
        num += 1;

        tv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        x1 = event.getX();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float x = (float) event.getX();
                        float delX = x - x1;
                        if (Math.abs(delX) > MIN_DISTANCE) {
                            Log.v("-------", "onTouch!!!2");
                            layout.removeView(v);
                        }
                        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) v.getLayoutParams();
                        float left = lp.leftMargin + (x - x1);
                        lp.leftMargin = (int) left;
                        v.setLayoutParams(lp);
                        break;
                    case MotionEvent.ACTION_UP:
                        x2 = event.getX();
                        float deltaX = x2 - x1;
                        if (Math.abs(deltaX) > MIN_DISTANCE)
                        {
                            Log.v("-------", "onTouch!!!");
                            layout.removeView(v);
                        }
                        else
                        {
                            // consider as something else - a screen tap for example
                        }
                        break;
                }
                return true;
            }
        });

        layout.addView(tv);
    }

// This reacts on swipe of every view, not only textViews!
/*
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                float deltaX = x2 - x1;
                if (Math.abs(deltaX) > MIN_DISTANCE)
                {
                    Toast.makeText(this, "left2right swipe "+event.getSource(), Toast.LENGTH_SHORT).show ();

                }
                else
                {
                    // consider as something else - a screen tap for example
                }
                break;
        }
        return super.onTouchEvent(event);
    }
*/
}
