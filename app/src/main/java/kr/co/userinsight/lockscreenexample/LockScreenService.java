package kr.co.userinsight.lockscreenexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class LockScreenService extends Service {
    private final String TAG = getClass().getSimpleName();

    private Intent activityIntent = null;
    private LockScreenReceiver lockScreenReceiver;

    @Override
    public IBinder onBind(Intent intent) {
        throw null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

//        activityIntent = new Intent(this, MainActivity.class);
//        activityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        lockScreenReceiver = new LockScreenReceiver();
        registerReceiver(lockScreenReceiver, LockScreenReceiver.intentFilter);
        Log.i(TAG, "Service onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        return super.onStartCommand(intent, flags, startId);
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Service onDestroy");
        unregisterReceiver(lockScreenReceiver);

//        startService(activityIntent);
    }
}
