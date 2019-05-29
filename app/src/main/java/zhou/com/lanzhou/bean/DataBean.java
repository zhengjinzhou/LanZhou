package zhou.com.lanzhou.bean;

/**
 * Created by zhou
 * on 2019/5/29.
 * 最后一期开奖数据
 * 其中与bjsc、fksc是相同的样式
 */

public class DataBean {

    /**
     * success : true
     * accessToken : 74c9eee6-7eaa-4533-8223-44a8835f1ec1
     * content : {"lotCode":"XYFT","openStatus":3,"qiHao":"20190529054","id":23118368,"haoMa":"08,10,06,07,09,04,05,01,02,03"}
     */

    private boolean success;
    private String accessToken;
    private ContentBean content;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * lotCode : XYFT
         * openStatus : 3
         * qiHao : 20190529054
         * id : 23118368
         * haoMa : 08,10,06,07,09,04,05,01,02,03
         */

        private String lotCode;
        private int openStatus;
        private String qiHao;
        private int id;
        private String haoMa;

        public String getLotCode() {
            return lotCode;
        }

        public void setLotCode(String lotCode) {
            this.lotCode = lotCode;
        }

        public int getOpenStatus() {
            return openStatus;
        }

        public void setOpenStatus(int openStatus) {
            this.openStatus = openStatus;
        }

        public String getQiHao() {
            return qiHao;
        }

        public void setQiHao(String qiHao) {
            this.qiHao = qiHao;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getHaoMa() {
            return haoMa;
        }

        public void setHaoMa(String haoMa) {
            this.haoMa = haoMa;
        }

        @Override
        public String toString() {
            return "ContentBean{" +
                    "lotCode='" + lotCode + '\'' +
                    ", openStatus=" + openStatus +
                    ", qiHao='" + qiHao + '\'' +
                    ", id=" + id +
                    ", haoMa='" + haoMa + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "XYFTBean{" +
                "success=" + success +
                ", accessToken='" + accessToken + '\'' +
                ", content=" + content +
                '}';
    }
}
