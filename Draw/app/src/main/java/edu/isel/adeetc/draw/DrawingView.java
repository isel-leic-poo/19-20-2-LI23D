package edu.isel.adeetc.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawingView extends View {

    private final Paint brush;
    private final Drawing drawing;

    public DrawingView(Context context) {
        super(context);
        brush = new Paint();
        brush.setColor(Color.RED);
        brush.setStrokeWidth(10);
        brush.setStyle(Paint.Style.STROKE);

        drawing = new Drawing();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(0, 0, this.getWidth(), getHeight(), brush);
    }
}
