package com.example.myself;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myself.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnKnowMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.edtName.getText().toString().trim();
                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your name first", Toast.LENGTH_SHORT).show();
                } else {
                    binding.btnKnowMe.setVisibility(View.GONE);
                    binding.llOptions.setVisibility(View.VISIBLE);
                }
            }
        });

        binding.btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.edtName.getText().toString().trim();
                Intent intent = new Intent(MainActivity.this, IntroductionActivity.class);
                intent.putExtra("USER_NAME", name);
                startActivity(intent);
                // Add slide transition
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });

        binding.btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.llOptions.setVisibility(View.GONE);
                binding.btnKnowMe.setVisibility(View.VISIBLE);
            }
        });
    }
}