package edu.isel.adeetc.animationdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class AnimationView extends View {

    private final Ball ball;
    private final Paint brush;
    private boolean firstDraw;

    public AnimationView(Context context, Ball ball) {
        super(context);
        this. ball = ball;
        brush = new Paint();
        brush.setColor(Color.RED);
        brush.setStrokeWidth(5);
        brush.setStyle(Paint.Style.FILL_AND_STROKE);
        firstDraw = true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (firstDraw) {
            firstDraw = false;
            ball.setBounds(new Vector(getWidth(), getHeight()));
            ball.setCenter(new Vector((getWidth()/ 2), getHeight() / 2));
        }
        canvas.drawCircle(ball.getCenter().x, ball.getCenter().y, ball.getRadius(), brush);
    }
}
