package example.com.keepcpuruning;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.WakefulBroadcastReceiver;

import java.util.Timer;
import java.util.TimerTask;

public class MyReceiver extends WakefulBroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service = new Intent(context, Service2.class);
        startWakefulService(context, service);

    }

}
