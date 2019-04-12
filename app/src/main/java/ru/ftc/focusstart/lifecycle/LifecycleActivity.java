package ru.ftc.focusstart.lifecycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import ru.ftc.focusstart.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class LifecycleActivity extends AppCompatActivity {

    private static String TAG = "FocusStart_Sample";

    private static String STATE_TEXT_KEY = "lifecycle_activity.state.text";

    public static void start(Context context) {
        Intent intent = new Intent(context, LifecycleActivity.class);
        context.startActivity(intent);
    }

    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "LifecycleActivity::onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        resultText = findViewById(R.id.resultText);
        findViewById(R.id.resultButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LifecycleResultActivity.startForResult(LifecycleActivity.this);
            }
        });
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(TAG, "LifecycleActivity::onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        String savedText = savedInstanceState.getString(STATE_TEXT_KEY);
        if (savedText != null) {
            resultText.setText(savedText);
        } else {
            resultText.setText(R.string.no_result_text);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TEXT_KEY, resultText.getText().toString());
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "LifecycleActivity::onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "LifecycleActivity::onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "LifecycleActivity::onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "LifecycleActivity::onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "LifecycleActivity::onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.d(TAG, "LifecycleActivity::onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
        String result = LifecycleResultActivity.getResult(requestCode, resultCode, data);
        if (result != null) {
            resultText.setText(result);
        } else {
            resultText.setText(R.string.no_result_text);
        }
    }
}
