package zhou.com.lanzhou.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import zhou.com.lanzhou.base.Constant;
import zhou.com.lanzhou.bean.DataBean;

/**
 * Created by zhou
 * on 2019/5/29.
 */

public class appApi {
    public static appApi appApi;
    private appApiService service;
    public appApi(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(okHttpClient)
                .build();
        service = retrofit.create(appApiService.class);
    }

    public Observable<DataBean> getData(String code){
        return service.getData(code);
    }

}
