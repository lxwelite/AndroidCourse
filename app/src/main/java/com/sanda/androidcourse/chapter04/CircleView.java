package com.sanda.androidcourse.chapter04;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CircleView extends View {
    public CircleView(Context context) {
        super(context);
    }
    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 获取 View 的宽高
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        // 计算正确的圆心坐标
        int centerX = width / 2;
        int centerY = height / 2;
        int r = Math.min(width, height) / 2; // 取最小值，确保圆形完全在 View 内

        // 设置画笔
        Paint paint = new Paint();
        paint.setColor(Color.RED); // 设置颜色

        // 绘制圆形
        canvas.drawCircle(centerX, centerY, r, paint);
    }
}

