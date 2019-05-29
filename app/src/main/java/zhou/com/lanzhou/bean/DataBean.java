package zhou.com.lanzhou.bean;

/**
 * Created by zhou
 * on 2019/5/22.
 */

public class DataBean {

    /**
     * issue : 20190521180
     * openNum : 7,9,8,4,5,3,6,1,10,2
     * openDateTime : 1558469040000
     */

    private String issue;
    private String openNum;
    private long openDateTime;

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getOpenNum() {
        return openNum;
    }

    public void setOpenNum(String openNum) {
        this.openNum = openNum;
    }

    public long getOpenDateTime() {
        return openDateTime;
    }

    public void setOpenDateTime(long openDateTime) {
        this.openDateTime = openDateTime;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "issue='" + issue + '\'' +
                ", openNum='" + openNum + '\'' +
                ", openDateTime=" + openDateTime +
                '}';
    }
}
