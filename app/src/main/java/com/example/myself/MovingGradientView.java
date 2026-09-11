package com.example.myself;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

public class MovingGradientView extends View {
    private Paint paint = new Paint();
    private float angle = 0;
    private int color1 = Color.parseColor("#0F2027");
    private int color2 = Color.parseColor("#203A43");
    private int color3 = Color.parseColor("#2C5364");

    public MovingGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
        float width = getWidth();
        float height = getHeight();
        float radius = Math.min(width, height);
        
        float x = (float) (width / 2 + radius * Math.cos(Math.toRadians(angle)));
        float y = (float) (height / 2 + radius * Math.sin(Math.toRadians(angle)));
        
        RadialGradient gradient = new RadialGradient(
            x, y, Math.max(width, height),
            new int[]{color3, color2, color1},
            null,
            Shader.TileMode.CLAMP
        );
        
        paint.setShader(gradient);
        canvas.drawRect(0, 0, width, height, paint);
        
        angle += 0.5f; // Adjust speed here
        if (angle >= 360) angle = 0;
        
        invalidate(); // Redraw for animation
    }
}