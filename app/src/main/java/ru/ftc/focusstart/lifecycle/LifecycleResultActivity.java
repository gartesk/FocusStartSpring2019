package ru.ftc.focusstart.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import ru.ftc.focusstart.R;

public class LifecycleResultActivity extends AppCompatActivity {

    private static String TAG = "FocusStart_Sample";

    private static int REQUEST_CODE = 42;
    private static String RESULT_EXTRA_KEY = "lifecycle_result_activity.result";

    public static void startForResult(AppCompatActivity activity) {
        Intent intent = new Intent(activity, LifecycleResultActivity.class);
        activity.startActivityForResult(intent, REQUEST_CODE);
    }

    public static @Nullable String getResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            return data.getStringExtra(RESULT_EXTRA_KEY);
        }
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "LifecycleResultActivity::onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_result);
        final EditText resultText = findViewById(R.id.resultText);
        findViewById(R.id.resultButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(RESULT_EXTRA_KEY, resultText.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "LifecycleResultActivity::onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "LifecycleResultActivity::onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "LifecycleResultActivity::onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "LifecycleResultActivity::onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "LifecycleResultActivity::onDestroy");
        super.onDestroy();
    }
}
