package com.larryzhang.puremvp.model;

import java.util.List;

/**
 * Created by Administrator on 2017/3/17.
 * 产品详细表
 */

public class GoodsInfo {
        /**
         * preview : http://7ktw9v.com1.z0.glb.clouddn.com/wp-content/uploads/2017/03/41-eWQVPNvL._SY450_.jpg
         * mall : amazon.co.jp
         * title : 春季出游用！SKATER 米菲兔水壶杯子便携套装1200円，直邮到手143元
         * srcSite : NB买海淘
         * abroad : 2
         * gotoUrl : http://count.chanet.com.cn/click.cgi?a=532083&d=381499&u=py&e=1&url=https://www.amazon.co.jp/dp/B00HUICNQE
         * catalog : rybh
         * mallName : Amazon.co.jp
         * smallContent : スタッキング コップ 4個組 ケース付 ミッフィー miffy KS32S，SKATER 米菲兔水壶杯子便携套装，由4个杯子和一个水壶组成，杯子的容量是220m
         * images : ["http://www.nbmai.com/wp-content/uploads/2017/03/41-eWQVPNvL._SY450_.jpg","http://www.nbmai.com/wp-content/uploads/2017/03/41l4TdsM6ML._SX425_.jpg","http://www.nbmai.com/wp-content/uploads/2017/03/71cd145prSL._SL1052_-650x466.jpg"]
         * price : 0.0
         * mallProductId :
         * contentImage : ["http://pyimg.nbmai.com/wp-content/uploads/2017/03/41-eWQVPNvL._SY450_.jpg","http://pyimg.nbmai.com/wp-content/uploads/2017/03/41l4TdsM6ML._SX425_.jpg","http://pyimg.nbmai.com/wp-content/uploads/2017/03/71cd145prSL._SL1052_-650x466.jpg"]
         * time : 25分钟
         * tags : Skater,
         * url : http://www.nbmai.com/pyfx/872827?fr=c
         * id : 872827
         * content : スタッキング コップ 4個組 ケース付 ミッフィー miffy KS32S，SKATER 米菲兔水壶杯子便携套装，由4个杯子和一个水壶组成，杯子的容量是220ml，水壶的容量是850ml，杯子可以叠放起来放置于水壶内，十分节省空间。表面印有大人气的米菲图案，颜色清朗明快，日常或者郊游野餐使用都很不错。
         日亚自营1296円，可直邮中国，退税后实付1200円，运费加税1142円，到手约143元。 日本亚马逊直邮中国攻略
         |

         */

        private String preview;
        private String mall;
        private String title;
        private String srcSite;
        private int abroad;
        private String gotoUrl;
        private String catalog;
        private String mallName;
        private String smallContent;
        private String images;
        private double price;
        private String mallProductId;
        private String time;
        private String tags;
        private String url;
        private int id;
        private String content;
        private List<String> contentImage;

        public String getPreview() {
            return preview;
        }

        public void setPreview(String preview) {
            this.preview = preview;
        }

        public String getMall() {
            return mall;
        }

        public void setMall(String mall) {
            this.mall = mall;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSrcSite() {
            return srcSite;
        }

        public void setSrcSite(String srcSite) {
            this.srcSite = srcSite;
        }

        public int getAbroad() {
            return abroad;
        }

        public void setAbroad(int abroad) {
            this.abroad = abroad;
        }

        public String getGotoUrl() {
            return gotoUrl;
        }

        public void setGotoUrl(String gotoUrl) {
            this.gotoUrl = gotoUrl;
        }

        public String getCatalog() {
            return catalog;
        }

        public void setCatalog(String catalog) {
            this.catalog = catalog;
        }

        public String getMallName() {
            return mallName;
        }

        public void setMallName(String mallName) {
            this.mallName = mallName;
        }

        public String getSmallContent() {
            return smallContent;
        }

        public void setSmallContent(String smallContent) {
            this.smallContent = smallContent;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getMallProductId() {
            return mallProductId;
        }

        public void setMallProductId(String mallProductId) {
            this.mallProductId = mallProductId;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<String> getContentImage() {
            return contentImage;
        }

        public void setContentImage(List<String> contentImage) {
            this.contentImage = contentImage;
        }
    }
