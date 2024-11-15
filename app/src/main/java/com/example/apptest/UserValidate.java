package com.example.apptest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UserValidate extends AppCompatActivity {

ImageView imageView;
Button mainwindow;
int selectedImageResource = -1;
EditText username;
    ImageView[] imageViews;
    int[] imageResources;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_validate);
        username=findViewById(R.id.etuseranme);

        imageView = findViewById(R.id.mainphoto);
        mainwindow = findViewById(R.id.mainbtn);

        // Initialize arrays for ImageViews and corresponding drawables
        imageViews = new ImageView[] {
                findViewById(R.id.imm1), findViewById(R.id.imageView5), findViewById(R.id.imageView4),
                findViewById(R.id.imageView3), findViewById(R.id.img5), findViewById(R.id.img7),
                findViewById(R.id.img8), findViewById(R.id.img6), findViewById(R.id.img9),
                findViewById(R.id.img11), findViewById(R.id.img12), findViewById(R.id.img10)
        };
        ImageView data = null;

        imageResources = new int[] {
                R.drawable.img_2, R.drawable.img_3, R.drawable.img_4,
                R.drawable.img_5, R.drawable.img_6, R.drawable.img_7,
                R.drawable.img_8, R.drawable.img_9, R.drawable.img,
                R.drawable.img_11, R.drawable.img_12, R.drawable.img_13
        };
        for (int i = 0; i < imageViews.length; i++) {
            int resource = imageResources[i];
            imageViews[i].setOnClickListener(v -> {
                imageView.setImageResource(resource);
                        selectedImageResource = resource;
            });


        }
        mainwindow.setOnClickListener(view -> {
            String name = username.getText().toString();

            // Pass both the selected image and the username to MainWindow
            Intent sendimage = new Intent(UserValidate.this, MainWindow.class);
            sendimage.putExtra("image", selectedImageResource);
            sendimage.putExtra("name", name);
            startActivity(sendimage);
        });
    }
}