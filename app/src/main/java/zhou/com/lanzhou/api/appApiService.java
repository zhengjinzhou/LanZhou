package zhou.com.lanzhou.api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import zhou.com.lanzhou.bean.DataBean;

/**
 * Created by zhou
 * on 2019/5/29.
 */

public interface appApiService {
    @GET("/native/lastResult.do")
    Observable<DataBean> getData(@Query("code") String code);
}
