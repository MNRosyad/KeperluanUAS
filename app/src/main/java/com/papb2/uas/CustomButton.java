package com.papb2.uas;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomButton extends View {
    private Paint thePaint, textPaint;
    private boolean isPressed = false;
    private String btnText;

    public CustomButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        thePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        thePaint.setColor(getResources().getColor(R.color.accentOne));

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(getResources().getColor(R.color.white));
        textPaint.setTextSize(40);

        @SuppressLint("Recycle")
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.CustomButton);
        btnText = array.getString(R.styleable.CustomButton_btnText);
        array.recycle();

        setOnClickListener(view -> {
            isPressed = !isPressed;
            invalidate();
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (isPressed) {
            thePaint.setColor(getResources().getColor(R.color.accentThree));
        } else {
            thePaint.setColor(getResources().getColor(R.color.accentOne));
        }

        canvas.drawRect(0, 0, getWidth(), getHeight(), thePaint);

        if (btnText != null) {
            float textWidth = textPaint.measureText(btnText);
            float x = (getWidth() - textWidth) / 2;
            float y = (getHeight() + textPaint.getTextSize()) / 2;
            canvas.drawText(btnText, x, y, textPaint);
        }
    }
}
