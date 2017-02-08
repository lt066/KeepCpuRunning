package example.com.keepcpuruning;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class Service1 extends Service {
    private final Timer timer = new Timer();
    private TimerTask task;
    private Context context;
    public Service1() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        this.context=context;
        task = new TimerTask() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                Message message = new Message();
                message.what = 1;
                handler.sendMessage(message);
            }
        };
        timer.schedule(task, 180000, 180000);

        return super.onStartCommand(intent, flags, startId);
    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            // 要做的事情
            Intent intent = new Intent();
            intent.setAction("CpuMyReceiver");
            sendBroadcast(intent);
            super.handleMessage(msg);
        }
    };
}
