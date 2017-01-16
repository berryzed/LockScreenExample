package kr.co.userinsight.lockscreenexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import static android.view.WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD;
import static android.view.WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;

/**
 * android.intent.action.SCREEN_ON, SCREEN_OFF의 경우
 * Manifest에서는 적용이 안되서 수동으로 등록해줘야 한다.
 */

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(FLAG_DISMISS_KEYGUARD);
        getWindow().addFlags(FLAG_SHOW_WHEN_LOCKED);

        startService(new Intent(this, LockScreenService.class));
    }

    @Override
    public void onBackPressed() {
        // 뒤로가기 방지
        return;
    }

    public void onEmergencyClick(View view) {
        Toast.makeText(this, "비상호출이 되었습니다!", Toast.LENGTH_SHORT).show();
    }

    public void onUnlockClick(View view) {
//        finish();
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
