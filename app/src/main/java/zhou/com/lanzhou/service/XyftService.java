package zhou.com.lanzhou.service;

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

/**
 * Created by zhou
 * on 2019/5/29.
 */

public class XyftService extends Service implements Runnable{


    private Thread thread;
    public XyftService() {
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyServer", "onCreate: 创建服务");

        List<Integer> oneDx = new ArrayList<>();
        List<Integer> towDx = new ArrayList<>();
        List<Integer> thereDx = new ArrayList<>();
        List<Integer> fourDx = new ArrayList<>();
        List<Integer> fiveDx = new ArrayList<>();
        List<Integer> sixDx = new ArrayList<>();
        List<Integer> sevenDx = new ArrayList<>();
        List<Integer> eightDx = new ArrayList<>();
        List<Integer> nightDx = new ArrayList<>();
        List<Integer> tenDx = new ArrayList<>();

        List<Integer> one = new ArrayList<>();
        List<Integer> tow = new ArrayList<>();
        List<Integer> there = new ArrayList<>();
        List<Integer> four = new ArrayList<>();
        List<Integer> five = new ArrayList<>();
        List<Integer> six = new ArrayList<>();
        List<Integer> seven = new ArrayList<>();
        List<Integer> eight = new ArrayList<>();
        List<Integer> night = new ArrayList<>();
        List<Integer> ten = new ArrayList<>();
        //onCreate的时候创建初始化
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyServer", "onCreate: 启动服务");
        //如果服务并停止了，重新生成一个新的
        if(thread.isInterrupted()){
            thread = new Thread(this);
            thread.start();
        }
        return Service.START_STICKY;
//        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void run() {
        while (true){
            try {
                //每10秒钟进行一次输出
                Thread.sleep(10000);
                //请求数据
                getXyft();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void getXyft() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("https://fh2094.com/native/lastResult.do?code=XYFT").build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("xyft", "onFailure: "+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.d("xyft", "onResponse: "+string);
                Gson gson = new Gson();
                DataBean dataBean = gson.fromJson(string, DataBean.class);
                int openStatus = dataBean.getContent().getOpenStatus();
                if (openStatus!=1){
                    Log.d("xyft", "onResponse: "+dataBean.getContent().getHaoMa());
                }
            }
        });
    }
}
