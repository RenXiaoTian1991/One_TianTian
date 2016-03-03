package com.example.lenovo.one_tiantian.ui.home;

/**
 * Created by lenovo on 2016/2/25.
 */
public class Home {

    @Override
    public String toString() {
        return result+hpEntity.getStrContent();
    }

    /**
     * strLastUpdateDate : 2016-02-19 17:52:23
     * strDayDiffer :
     * strHpId : 1263
     * strHpTitle : VOL.1237
     * strThumbnailUrl : http://image.wufazhuce.com/Ft-14350dOICq4qost9bmPiGWy4d
     * strOriginalImgUrl : http://image.wufazhuce.com/Ft-14350dOICq4qost9bmPiGWy4d
     * strAuthor : 小客厅里的你和我&花芍子 作品
     * strContent : 洗手台上并排着的牙刷，被窝中碰到的脚，不知何时消失掉的冰箱中的布丁，先下楼梯，和在你的后面上楼梯……恋爱总有一天会变成生活，生活会变成喜悦。 from 《最完美的离婚》
     * strMarketTime : 2016-02-26
     * sWebLk : http://m.wufazhuce.com/one/1263
     * strPn : 6114
     * wImgUrl :
     */

    public HpEntityEntity hpEntity;
    /**
     * hpEntity : {"strLastUpdateDate":"2016-02-19 17:52:23","strDayDiffer":"","strHpId":"1263","strHpTitle":"VOL.1237","strThumbnailUrl":"http://image.wufazhuce.com/Ft-14350dOICq4qost9bmPiGWy4d","strOriginalImgUrl":"http://image.wufazhuce.com/Ft-14350dOICq4qost9bmPiGWy4d","strAuthor":"小客厅里的你和我&花芍子 作品","strContent":"洗手台上并排着的牙刷，被窝中碰到的脚，不知何时消失掉的冰箱中的布丁，先下楼梯，和在你的后面上楼梯\u2026\u2026恋爱总有一天会变成生活，生活会变成喜悦。 from 《最完美的离婚》","strMarketTime":"2016-02-26","sWebLk":"http://m.wufazhuce.com/one/1263","strPn":"6114","wImgUrl":""}
     * result : SUCCESS
     */

    private String result;

    public void setHpEntity(HpEntityEntity hpEntity) {
        this.hpEntity = hpEntity;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public HpEntityEntity getHpEntity() {
        return hpEntity;
    }

    public String getResult() {
        return result;
    }

    public static class HpEntityEntity {
        private String strLastUpdateDate;
        private String strDayDiffer;
        private String strHpId;
        private String strHpTitle;
        private String strThumbnailUrl;
        private String strOriginalImgUrl;
        private String strAuthor;
        private String strContent;
        private String strMarketTime;
        private String sWebLk;
        private String strPn;
        private String wImgUrl;

        public void setStrLastUpdateDate(String strLastUpdateDate) {
            this.strLastUpdateDate = strLastUpdateDate;
        }

        public void setStrDayDiffer(String strDayDiffer) {
            this.strDayDiffer = strDayDiffer;
        }

        public void setStrHpId(String strHpId) {
            this.strHpId = strHpId;
        }

        public void setStrHpTitle(String strHpTitle) {
            this.strHpTitle = strHpTitle;
        }

        public void setStrThumbnailUrl(String strThumbnailUrl) {
            this.strThumbnailUrl = strThumbnailUrl;
        }

        public void setStrOriginalImgUrl(String strOriginalImgUrl) {
            this.strOriginalImgUrl = strOriginalImgUrl;
        }

        public void setStrAuthor(String strAuthor) {
            this.strAuthor = strAuthor;
        }

        public void setStrContent(String strContent) {
            this.strContent = strContent;
        }

        public void setStrMarketTime(String strMarketTime) {
            this.strMarketTime = strMarketTime;
        }

        public void setSWebLk(String sWebLk) {
            this.sWebLk = sWebLk;
        }

        public void setStrPn(String strPn) {
            this.strPn = strPn;
        }

        public void setWImgUrl(String wImgUrl) {
            this.wImgUrl = wImgUrl;
        }

        public String getStrLastUpdateDate() {
            return strLastUpdateDate;
        }

        public String getStrDayDiffer() {
            return strDayDiffer;
        }

        public String getStrHpId() {
            return strHpId;
        }

        public String getStrHpTitle() {
            return strHpTitle;
        }

        public String getStrThumbnailUrl() {
            return strThumbnailUrl;
        }

        public String getStrOriginalImgUrl() {
            return strOriginalImgUrl;
        }

        public String getStrAuthor() {
            return strAuthor;
        }

        public String getStrContent() {
            return strContent;
        }

        public String getStrMarketTime() {
            return strMarketTime;
        }

        public String getSWebLk() {
            return sWebLk;
        }

        public String getStrPn() {
            return strPn;
        }

        public String getWImgUrl() {
            return wImgUrl;
        }
    }
}
