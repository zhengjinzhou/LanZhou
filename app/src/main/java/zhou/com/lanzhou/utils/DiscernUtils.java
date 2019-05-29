package zhou.com.lanzhou.utils;

/**
 * Created by zhou
 * on 2019/5/22.
 */

public class DiscernUtils {
    private static final int single = 0;//单
    private static final int doubl = 1;//双

    private static final int big = 2;//小
    private static final int small = 3;//大

    public static int getDS(int num) {
        if (num / 2 == 0) {
            return doubl;
        } else {
            return single;
        }
    }

    public static int getDX(int num) {
        if (num >= 11) {
            return big;
        } else if (num <= 11) {
            return small;
        }
        return 0;
    }
}
