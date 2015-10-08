package com.example.ykumawat.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by y.kumawat on 10/8/2015.
 */
public class SemiCircleDrawable extends Drawable {

    private Paint paint;
    private RectF rectF;
    private int color;
    private Direction angle;

    public enum Direction
    {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM
    }

    public SemiCircleDrawable() {
        this(Color.BLUE, Direction.LEFT);
    }

    public SemiCircleDrawable(int color, Direction angle) {
        this.color = color;
        this.angle = angle;
        paint = new Paint();
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
        rectF = new RectF();
    }

    public int getColor() {
        return color;
    }

    /**
     * A 32bit color not a color resources.
     * @param color
     */
    public void setColor(int color) {
        this.color = color;
        paint.setColor(color);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.save();

        Paint paintRing = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintRing.setColor(Color.argb(255, 152, 235, 255));
        paintRing.setStrokeWidth(25);
        paintRing.setStyle(Paint.Style.STROKE);

        Paint painttext1 = new Paint();
        painttext1.setColor(Color.argb(255, 152, 235, 255));
        painttext1.setTextSize(40);

        Paint painttext2 = new Paint();
        painttext2.setColor(Color.argb(255, 71, 170, 237));
        painttext2.setTextSize(40);

        Paint painttext3 = new Paint();
        painttext3.setColor(Color.argb(255, 0, 184, 138));
        painttext3.setTextSize(40);

        Paint painttext4 = new Paint();
        painttext4.setColor(Color.argb(255, 48, 52, 48));
        painttext4.setTextSize(50);



        Paint paintRing2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintRing2.setColor(Color.argb(255, 71, 170, 237));
        paintRing2.setStrokeWidth(25);
        paintRing2.setStyle(Paint.Style.STROKE);

        Paint paintRing3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintRing3.setColor(Color.argb(255, 0, 184, 138));
        paintRing3.setStrokeWidth(25);
        paintRing3.setStyle(Paint.Style.STROKE);

        Paint paintRing1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintRing1.setColor(Color.argb(0, 100, 100, 100));
        paintRing1.setStrokeWidth(5);
        paintRing1.setStyle(Paint.Style.STROKE);

        RectF ring = new RectF(0f,0f,600f,600f);
        RectF ring2 = new RectF(20f,20f,580f,580f);
        RectF ring3 = new RectF(40f,40f,560f,560f);
        RectF ring4 = new RectF(60f,60f,540f,540f);
        RectF ring5 = new RectF(80f,80f,520f,520f);
        RectF ring6 = new RectF(100f,100f,500f,500f);


        canvas.drawArc(ring, 90, 270, false, paintRing1);
        canvas.drawArc(ring2, 90, 240, false, paintRing);
        canvas.drawArc(ring3, 90, 270, false, paintRing1);
        canvas.drawArc(ring4, 90, 260, false, paintRing2);
        canvas.drawArc(ring5, 90, 270, false, paintRing1);
        canvas.drawArc(ring6, 90, 290, false, paintRing3);

        canvas.drawText("Bussiness 300", 300, 600, painttext1);
        canvas.drawText("Finance 500",300,555,painttext2);
        canvas.drawText("Marketing 800",300,510,painttext3);
        canvas.drawText("NCQ 2300",200,300,painttext4);
    }

    @Override
    public void setAlpha(int alpha) {
        // Has no effect
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        // Has no effect
    }

    @Override
    public int getOpacity() {
        // Not Implemented
        return 0;
    }

}