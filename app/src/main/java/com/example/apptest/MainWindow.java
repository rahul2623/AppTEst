package com.example.apptest;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainWindow extends AppCompatActivity {
    ImageView mainphoto;
    TextView username;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_window);

        mainphoto = findViewById(R.id.mainwindowphoto);
        username = findViewById(R.id.mainusname);

        // Retrieve data from Intent extras
        int imagevalue = getIntent().getIntExtra("image", -1);
        String name = getIntent().getStringExtra("name");

        // Set the image if valid
        if (imagevalue != -1) {
            mainphoto.setImageResource(imagevalue);
        }

        // Set the username if not null
        if (name != null) {
            username.setText(String.format("Hello,%s", name));
            username.setTextColor(ContextCompat.getColor(this, R.color.black));
        }

    }
}