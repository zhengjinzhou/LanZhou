package zhou.com.lanzhou;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import zhou.com.lanzhou.bean.DataBean;
import zhou.com.lanzhou.utils.DiscernUtils;

/**
 * Created by zhou
 * on 2019/5/22.
 */

public class startService extends Service implements Runnable {

    private static final String TAG = "startService";
    private Thread thread;
    private int num = 0;
    public startService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //onCreate的时候创建初始化
        thread = new Thread(this);
        thread.start();

        List<Integer> bigNum = new ArrayList<>();
        List<Integer> smallNum = new ArrayList<>();
        List<Integer> doubleNum = new ArrayList<>();
        List<Integer> singleNum = new ArrayList<>();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (thread.isInterrupted()) {
            thread = new Thread(this);
            thread.start();
        }
        return Service.START_STICKY;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                //每10秒钟进行一次输出
                Thread.sleep(10000);

                String url = "https://api.cp3166.com/data/xyft/last.json";
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder().url(url).build();
                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d("----", "onFailure: " + e.getMessage());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String string = response.body().string();
                        if (response.code() == 404) return;
                        if (string == null) return;
                        String substring = string.substring(string.indexOf("{"), string.indexOf("}")+1);
                        Gson gson = new Gson();
                        DataBean dataBean = gson.fromJson(substring, DataBean.class);
                        MyPlan(dataBean);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 验证时间见到了
     * @param dataBean
     */
    private void MyPlan(DataBean dataBean) {
        Log.d(TAG, "MyPlan: "+dataBean.toString());
        String FirstNum = dataBean.getOpenNum().substring(0, dataBean.getOpenNum().indexOf(","));
        int indexOf = dataBean.getOpenNum().indexOf(",");
        int indexOf1 = dataBean.getOpenNum().indexOf(",", indexOf + 1);
        String Second = dataBean.getOpenNum().substring(indexOf + 1, indexOf1);
        //得出了冠亚单独的两个字了
        //将他们int型然后求和
        int sum = Integer.parseInt(FirstNum) + Integer.parseInt(Second);
        Log.d(TAG, "冠亚和: "+sum);
        DS(sum);
        DX(sum);
    }

    /**
     * 有关大小的比较
     * @param sum
     */
    private void DX(int sum) {

    }

    /**
     * 有关单双的比较
     * @param sum
     */
    private void DS(int sum) {

    }
}
