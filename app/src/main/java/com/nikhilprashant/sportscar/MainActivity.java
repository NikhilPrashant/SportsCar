package com.nikhilprashant.sportscar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnforward, btnBack, btnReset, drawButton;
    ImageView imageView;
    TranslateAnimation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBack = findViewById(R.id.btnback);
        btnforward = findViewById(R.id.btnforward);
        btnReset = findViewById(R.id.btnreset);
        imageView = findViewById(R.id.imageView);
        drawButton = (Button)findViewById(R.id.button);
        drawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap imageBitmap = Bitmap.createBitmap(imageView.getWidth(),
                        imageView.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(imageBitmap);
                float scale = getResources().getDisplayMetrics().density;
                Paint paint = new Paint();
                Path path = new Path();
                int radius = 74;

                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.TRANSPARENT);

                canvas.drawPaint(paint);

                paint.setColor(Color.parseColor("#de8118"));
                Point a = new Point(74, 200);
                Point b = new Point(200, 100);
                Point c = new Point( 560, 100);
                Point d = new Point(610, + 290);
                Point e = new Point(74, + 290);
                path.setFillType(Path.FillType.EVEN_ODD);
                path.lineTo(a.x, a.y);
                path.lineTo(b.x, b.y);
                path.lineTo(c.x, c.y);
                path.lineTo(d.x, d.y);
                path.lineTo(e.x, e.y);
                path.lineTo(a.x, a.y);
                path.close();
                canvas.drawPath(path, paint);

                paint.setColor(Color.parseColor("#000000"));
                canvas.drawRect(200, 121, 560, 192, paint);

                paint.setColor(Color.parseColor("#77aaaa"));
                canvas.drawCircle(250, 280, radius, paint);

                paint.setColor(Color.parseColor("#77aaaa"));
                canvas.drawCircle(470, 280, radius, paint);
                imageView.setImageBitmap(imageBitmap);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               imageView.animate().translationX(0).translationY(0);
               imageView.clearAnimation();
               btnforward.animate().translationX(0).translationY(0);
               imageView.clearAnimation();
               btnBack.animate().translationX(0).translationY(0);
               imageView.clearAnimation();
            }
        });

        btnforward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation = new TranslateAnimation(0.0f, -800.0f,
                        0.0f, -0.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
                animation.setDuration(2000);  // animation duration
                animation.setRepeatCount(0);  // animation repeat count
                animation.startNow();
                //animation.setRepeatMode(2);   // repeat animation (left to right, right to left )
                animation.setFillAfter(true);
                imageView.startAnimation(animation);
                btnforward.startAnimation(animation);
                btnBack.startAnimation(animation);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAnimation animation = new TranslateAnimation(0.0f, 800.0f,
                        0.0f, -0.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
                animation.setDuration(2000);  // animation duration
                animation.setRepeatCount(0);  // animation repeat count
                animation.startNow();
                //animation.setRepeatMode(2);   // repeat animation (left to right, right to left )
                animation.setFillAfter(true);
                imageView.startAnimation(animation);
                btnforward.startAnimation(animation);
                btnBack.startAnimation(animation);
            }
        });
    }
}