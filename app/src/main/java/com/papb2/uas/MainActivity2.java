package com.papb2.uas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity2 extends AppCompatActivity {
    private Canvas justCanvas;
    private Paint circlePaint = new Paint();
    private Paint headPaint = new Paint();

    ImageView imageView;
    Bitmap theBitmap;
    private int colorBackground;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView = findViewById(R.id.my_image_view);
        circlePaint.setColor(getResources().getColor(R.color.black));
        headPaint.setColor(getResources().getColor(R.color.white));

        imageView.setOnClickListener(v -> {
            if (count == 0) {
                drawBaymax();
                animateFadeIn(imageView);
                count += 1;
            } else if (count == 1) {
                animateFlipVertical(imageView);
                count += 1;
            } else if (count == 2) {
                animateFadeOut(imageView);
            }
        });

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
    }

    private void drawBaymax() {
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        int halfWidth = width / 2;
        int halfHeight = height / 2;

        theBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        imageView.setImageBitmap(theBitmap);
        colorBackground = ResourcesCompat.getColor(getResources(), R.color.yellow, null);
        justCanvas = new Canvas(theBitmap);
        justCanvas.drawColor(colorBackground);
        // Draw head
        justCanvas.drawOval(halfWidth - 400, halfHeight - 250, halfWidth + 400, halfHeight + 250, headPaint);
        // Draw eyes
        justCanvas.drawCircle(halfWidth - 145, halfHeight, 45, circlePaint);
        justCanvas.drawCircle(halfWidth + 145, halfHeight, 45, circlePaint);
        // Draw eye connector
        justCanvas.drawRect(halfWidth - 145, halfHeight + 7, halfWidth + 145, halfHeight - 7, circlePaint);

        imageView.invalidate();
    }

    private void animateFadeIn(View viewToFadeIn) {
        int fadeDuration = 1500;

        ObjectAnimator fadeInAnimator = ObjectAnimator.ofFloat(viewToFadeIn, "alpha", 0f, 1f);
        fadeInAnimator.setDuration(fadeDuration);
        fadeInAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(@NonNull Animator animator) {
                viewToFadeIn.setVisibility(View.VISIBLE);
                viewToFadeIn.setAlpha(0);
            }

            @Override
            public void onAnimationEnd(@NonNull Animator animator) {
                //
            }

            @Override
            public void onAnimationCancel(@NonNull Animator animator) {
                //
            }

            @Override
            public void onAnimationRepeat(@NonNull Animator animator) {
                //
            }
        });
        fadeInAnimator.start();
    }
    private void animateFadeOut(View viewToFadeOut) {
        int fadeDuration = 1500;

        ObjectAnimator fadeOutAnimator = ObjectAnimator.ofFloat(viewToFadeOut, "alpha", 1f, 0f);
        fadeOutAnimator.setDuration(fadeDuration);
        fadeOutAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(@NonNull Animator animator) {
                //
            }

            @Override
            public void onAnimationEnd(@NonNull Animator animator) {
                viewToFadeOut.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(MainActivity2.this, MainActivity2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

            @Override
            public void onAnimationCancel(@NonNull Animator animator) {
                //
            }

            @Override
            public void onAnimationRepeat(@NonNull Animator animator) {
                //
            }
        });
        fadeOutAnimator.start();
    }
    private void animateFlipVertical(View viewToFlip) {
        int flipDuration = 1500;

        ObjectAnimator flipAnimator = ObjectAnimator.ofFloat(viewToFlip, "rotationY", 0f, 180f);
        flipAnimator.setDuration(flipDuration);
        flipAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(@NonNull Animator animator) {
                //
            }

            @Override
            public void onAnimationEnd(@NonNull Animator animator) {
                //
            }

            @Override
            public void onAnimationCancel(@NonNull Animator animator) {
                //
            }

            @Override
            public void onAnimationRepeat(@NonNull Animator animator) {
                //
            }
        });
        flipAnimator.start();
    }
}