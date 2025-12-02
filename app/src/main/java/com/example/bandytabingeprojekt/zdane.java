package com.example.bandytabingeprojekt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.media.MediaPlayer;
public class zdane extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_zdane);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            Button powrot = findViewById(R.id.powrot);
                    TextView punktey = findViewById(R.id.punkty);
                    Intent intent = getIntent();
                    int punkty = intent.getIntExtra("punkty", 0);
                    punktey.setText("punkty:"+punkty);
                    MediaPlayer muzyk = MediaPlayer.create(this, R.raw.yipe);
                    muzyk.start();

            powrot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(zdane.this , MainActivity.class);
                    startActivity(intent);
                }

        });
            return insets;
    }
        );}}