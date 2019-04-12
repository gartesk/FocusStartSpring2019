package ru.ftc.focusstart;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import ru.ftc.focusstart.lifecycle.LifecycleActivity;
import ru.ftc.focusstart.list.ListActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.lifecycleButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LifecycleActivity.start(MainActivity.this);
            }
        });
        findViewById(R.id.listButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListActivity.start(MainActivity.this);
            }
        });
    }
}
