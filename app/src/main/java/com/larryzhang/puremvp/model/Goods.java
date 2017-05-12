package com.larryzhang.puremvp.model;

import java.util.List;

/**
 * 产品表
 */
public class Goods {
    /**
     * preview : http://7ktw9v.com1.z0.glb.clouddn.com/wp-content/uploads/2017/03/41-eWQVPNvL._SY450_.jpg
     * mall : amazon.co.jp
     * title : 春季出游用！SKATER 米菲兔水壶杯子便携套装1200円，直邮到手143元
     * srcSite : NB买海淘
     * abroad : 2
     * gotoUrl : ./go.html?id=872827
     * catalog : rybh
     * mallName : Amazon.co.jp
     * smallContent : スタッキング コップ 4個組 ケース付 ミッフィー miffy KS32S，SKATER 米菲兔水壶杯子便携套装，由4个杯子和一个水壶组成，杯子的容量是220m
     * images : -
     * price : 0.0
     * mallProductId :
     * contentImage : []
     * time : 16分钟
     * tags : Skater,
     * id : 872827
     * content : "adfasdfasdf"。
     <br>
     <br>
     <img class="aligncenter size-full wp-image-192840" src="http://www.nbmai.com/wp-content/uploads/2017/03/41-eWQVPNvL._SY450_.jpg" alt="SKATER" width="390" height="450">
     <br>
     <br>
     <img class="aligncenter size-large wp-image-192841" src="http://www.nbmai.com/wp-content/uploads/2017/03/41l4TdsM6ML._SX425_.jpg" alt="SKATER" width="425" height="404">
     <br>
     <br>
     <img class="aligncenter size-large wp-image-192842" src="http://www.nbmai.com/wp-content/uploads/2017/03/71cd145prSL._SL1052_-650x466.jpg" alt="SKATER" width="650" height="466">&nbsp;|
     <br>
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
    private int id;
    private String content;
    private List<?> contentImage;

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

    public List<?> getContentImage() {
        return contentImage;
    }

    public void setContentImage(List<?> contentImage) {
        this.contentImage = contentImage;
    }
}