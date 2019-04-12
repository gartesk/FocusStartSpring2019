package ru.ftc.focusstart;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.WorkManager;
import ru.ftc.focusstart.lifecycle.LifecycleActivity;
import ru.ftc.focusstart.list.ListActivity;
import ru.ftc.focusstart.service.ExampleForegroundService;

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
        findViewById(R.id.serviceButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExampleForegroundService.startService(MainActivity.this);
            }
        });
        findViewById(R.id.stopServiceButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExampleForegroundService.stopService(MainActivity.this);
            }
        });
    }
}
