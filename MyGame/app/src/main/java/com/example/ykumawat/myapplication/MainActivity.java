package com.example.ykumawat.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.Random;


public class MainActivity extends Activity {

    private ObjectAnimator animation1,animation3,animation5;
    private ObjectAnimator animation2,animation4,animation6;
    private Button button, button2, button3, button4, button5, button6;
    private Random randon;
    private int width;
    private int height;
    private AnimatorSet set;
    private float dX, dY;
    private SemiCircleDrawable mArc;
    private final static int ANIMATION_DURATION = 6000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mArc = new SemiCircleDrawable();

        width = getWindowManager().getDefaultDisplay().getWidth();
        height = getWindowManager().getDefaultDisplay().getHeight();
        randon = new Random();

        set = createAnimation();
        initView();
        startAnimation();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);

        button4.setOnDragListener(myDragListener);
        button5.setOnDragListener(myDragListener);
        button6.setOnClickListener(myClickListener);

        button.setOnLongClickListener(myLongClick);
        button2.setOnLongClickListener(myLongClick);
        button3.setOnLongClickListener(myLongClick);
    }

    private void startAnimation() {
        set.start();
        set.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                int nextX = randon.nextInt(width-80);
                int nextY = randon.nextInt(height/3);
                int nextX2 = randon.nextInt(width-80);
                int nextY2 = (height / 3) + randon.nextInt(height/3);
                int nextX3 = randon.nextInt(width-80);
                int nextY3 = ((2*height) / 3) + randon.nextInt(height/3)-80;

                animation1 = ObjectAnimator.ofFloat(button, "x", button.getX(), nextX);
                animation1.setDuration(ANIMATION_DURATION);
                animation2 = ObjectAnimator.ofFloat(button, "y", button.getY(),nextY);
                animation2.setDuration(ANIMATION_DURATION);

                animation3 = ObjectAnimator.ofFloat(button2, "x", button2.getX(), nextX2);
                animation3.setDuration(ANIMATION_DURATION);
                animation4 = ObjectAnimator.ofFloat(button2, "y", button2.getY(), nextY2);
                animation4.setDuration(ANIMATION_DURATION);

                animation5 = ObjectAnimator.ofFloat(button3, "x", button3.getX(), nextX3);
                animation5.setDuration(ANIMATION_DURATION);
                animation6 = ObjectAnimator.ofFloat(button3, "y", button3.getY(), nextY3);
                animation6.setDuration(ANIMATION_DURATION);

                set.playTogether(animation1, animation2, animation3, animation4, animation5, animation6);
                set.start();
            }
        });
    }

    private AnimatorSet createAnimation() {

        int nextX = randon.nextInt(width-80);
        int nextY = randon.nextInt(height/3);
        int nextX2 = randon.nextInt(width-80);
        int nextY2 = (height / 3) + randon.nextInt(height/3);
        int nextX3 = randon.nextInt(width-80);
        int nextY3 = ((2*height) / 3) + randon.nextInt(height/3)-80;

        button = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        animation1 = ObjectAnimator.ofFloat(button, "x", nextX);
        animation1.setDuration(ANIMATION_DURATION);
        animation2 = ObjectAnimator.ofFloat(button, "y", nextY);
        animation2.setDuration(ANIMATION_DURATION);

        animation3 = ObjectAnimator.ofFloat(button2, "x", nextX2);
        animation3.setDuration(ANIMATION_DURATION);
        animation4 = ObjectAnimator.ofFloat(button2, "y", nextY2, nextY2);
        animation4.setDuration(ANIMATION_DURATION);

        animation5 = ObjectAnimator.ofFloat(button3, "x", nextX3);
        animation5.setDuration(ANIMATION_DURATION);
        animation6 = ObjectAnimator.ofFloat(button3, "y", nextY3,nextY3);
        animation6.setDuration(ANIMATION_DURATION);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(animation1, animation2, animation3, animation4, animation5, animation6);

        return set;
    }

    View.OnTouchListener myTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent event) {
            switch (event.getActionMasked()) {

                case MotionEvent.ACTION_DOWN:

                    dX = view.getX() - event.getRawX();
                    dY = view.getY() - event.getRawY();
                    break;

                case MotionEvent.ACTION_MOVE:

                    view.animate()
                            .x(event.getRawX() + dX)
                            .y(event.getRawY() + dY)
                            .setDuration(0)
                            .start();
                    break;
                default:
                    return false;
            }
            return true;
        }

        ;
    };

    private View.OnLongClickListener myLongClick = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            if(v.getId() == R.id.button1) {
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
            }
            else if(v.getId() == R.id.button2) {
                button.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
            }
            else if(v.getId() == R.id.button3) {
                button.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
            }
            button4.setVisibility(View.VISIBLE);
            button5.setVisibility(View.VISIBLE);
            View.DragShadowBuilder shadow = new View.DragShadowBuilder(v);
            v.setVisibility(View.GONE);
            v.startDrag(null, shadow, null, 0);
            return false;
        };
    };

    private View.OnDragListener myDragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.v("yogesh","Drag Enter");

                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    Log.v("yogesh", "Drag Ended");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            button4.setVisibility(View.GONE);
                            button5.setVisibility(View.GONE);
                            button.setVisibility(View.VISIBLE);
                            button2.setVisibility(View.VISIBLE);
                            button3.setVisibility(View.VISIBLE);
                        }
                    }, 3000);

                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.v("yogesh", "Drag Exited");
                    v.setBackground(getResources().getDrawable(R.drawable.button_bg));
                    break;
                case DragEvent.ACTION_DROP:
                    Log.v("yogesh", "Drag Drop");
                    v.setBackground(getResources().getDrawable(R.drawable.check));
                    
                    break;
                case DragEvent.ACTION_DRAG_LOCATION:
                    v.setBackground(getResources().getDrawable(R.drawable.button_bg_selected));
                    Log.v("yogesh","Drag Location");
                    break;

            }
            return true;
        };
    };
    private View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(i);
        };
    };
}
