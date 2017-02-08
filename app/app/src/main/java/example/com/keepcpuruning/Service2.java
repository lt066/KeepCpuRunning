package example.com.keepcpuruning;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

public class Service2 extends IntentService {

    public Service2() {
        super("Service2");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("测试","输出"+System.currentTimeMillis());
        MyReceiver.completeWakefulIntent(intent);
    }
}
