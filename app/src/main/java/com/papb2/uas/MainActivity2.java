package com.papb2.uas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity2 extends AppCompatActivity {
    private Canvas justCanvas;
    private Paint circlePaint = new Paint();
    private Paint headPaint = new Paint();

    ImageView imageView;
    Bitmap theBitmap;
    private int colorBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView = findViewById(R.id.my_image_view);
        circlePaint.setColor(getResources().getColor(R.color.black));
        headPaint.setColor(getResources().getColor(R.color.white));

        FloatingActionButton nextBtn = findViewById(R.id.floatingBtn2);
        nextBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        int width = imageView.getWidth();
        int height = imageView.getHeight();

        theBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        imageView.setImageBitmap(theBitmap);
        colorBackground = ResourcesCompat.getColor(getResources(), R.color.yellow, null);
        justCanvas = new Canvas(theBitmap);
        justCanvas.drawColor(colorBackground);

//        drawHead();
//        drawRightEye();
//        drawLeftEye();
//        drawEyeConnector();
    }
}