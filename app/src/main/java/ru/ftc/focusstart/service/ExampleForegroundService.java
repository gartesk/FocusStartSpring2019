package ru.ftc.focusstart.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import ru.ftc.focusstart.R;

public class ExampleForegroundService extends Service {

    private static final int NOTIFICATION_ID = 1;

    public static void startService(Context context) {
        Intent intent = new Intent(context, ExampleForegroundService.class);
        context.startService(intent);
    }

    public static void stopService(Context context) {
        Intent intent = new Intent(context, ExampleForegroundService.class);
        context.stopService(intent);
    }

    private Thread thread;

    @Override
    public void onCreate() {
        Log.d("WTF", "onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Notification notification = createNotification(0);
        startForeground(NOTIFICATION_ID, notification);
        doWork();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d("WTF", "onDestroy");
        super.onDestroy();
        thread.interrupt();
    }

    private void doWork() {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 20; ++i) {
                        Log.d("WTF", "tick " + i + " " + ExampleForegroundService.this.toString());
                        Notification notification = createNotification(i);
                        ((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE))
                                .notify(NOTIFICATION_ID, notification);
                        Thread.sleep(1000L);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    stopForeground(STOP_FOREGROUND_DETACH);
                } else {
                    stopForeground(false);
                }
                stopSelf();
            }
        });
        thread.start();
    }

    private Notification createNotification(int progress) {
        return new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_android_black)
                .setSubText("QWERTY " + progress)
                .build();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
