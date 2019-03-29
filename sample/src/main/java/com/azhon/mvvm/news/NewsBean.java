package com.azhon.mvvm.news;

import java.util.List;

/**
 * 项目名:    TODO-MVVM
 * 包名       com.azhon.mvvm.main
 * 文件名:    NewsBean
 * 创建时间:  2019-03-27 on 15:44
 * 描述:     TODO
 *
 * @author 阿钟
 */

public class NewsBean {

    /**
     * date : 20190327
     * stories : [{"images":["https://pic1.zhimg.com/v2-42b52e143568aa42ee3024a41fb6d5bc.jpg"],"type":0,"id":9709446,"ga_prefix":"032709","title":"传销和直销的区别是什么？「传销不用蹲监狱」是真的吗？"},{"images":["https://pic2.zhimg.com/v2-fb7336e352b74582b0496b4f13ec1695.jpg"],"type":0,"id":9709468,"ga_prefix":"032708","title":"也许是再生能力最强的动物，只有二十万分之一也能长出来"},{"images":["https://pic3.zhimg.com/v2-18f0af051c44aeef6ea006962b29b60e.jpg"],"type":0,"id":9709452,"ga_prefix":"032707","title":"跳槽之前，教你客观评估自己的身价"},{"images":["https://pic2.zhimg.com/v2-396249e3335c9aebc34df9ff20067591.jpg"],"type":0,"id":9709400,"ga_prefix":"032706","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic4.zhimg.com/v2-d3e3b3f665d2aec381da8face9b28f3b.jpg","type":0,"id":9709444,"ga_prefix":"032617","title":"由「硬」变「软」，这不是我认识的苹果了"},{"image":"https://pic1.zhimg.com/v2-0c526bff832d431d908a3d9cbde5ccfc.jpg","type":0,"id":9709390,"ga_prefix":"032607","title":"京都追樱，是一门玄学、科学，还是佛学？"},{"image":"https://pic4.zhimg.com/v2-bc8a1a7c2ba90b5b74d33b8d0519d21b.jpg","type":0,"id":9709135,"ga_prefix":"032521","title":"《都挺好》要大结局了，我有点想念倪大红"},{"image":"https://pic4.zhimg.com/v2-eb417877dc3ed82a18d3ecab4420b673.jpg","type":0,"id":9709395,"ga_prefix":"032509","title":"古代的人真的和现在流传的古人画像长得差不多吗？"},{"image":"https://pic4.zhimg.com/v2-9ed31149a9cc68792cfac1065f51a9b3.jpg","type":0,"id":9709374,"ga_prefix":"032508","title":"香港八卦杂志，一部全民吃瓜实录"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic1.zhimg.com/v2-42b52e143568aa42ee3024a41fb6d5bc.jpg"]
         * type : 0
         * id : 9709446
         * ga_prefix : 032709
         * title : 传销和直销的区别是什么？「传销不用蹲监狱」是真的吗？
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        @Override
        public String toString() {
            return "StoriesBean{" +
                    "type=" + type +
                    ", id=" + id +
                    ", ga_prefix='" + ga_prefix + '\'' +
                    ", title='" + title + '\'' +
                    ", images=" + images +
                    '}';
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic4.zhimg.com/v2-d3e3b3f665d2aec381da8face9b28f3b.jpg
         * type : 0
         * id : 9709444
         * ga_prefix : 032617
         * title : 由「硬」变「软」，这不是我认识的苹果了
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "TopStoriesBean{" +
                    "image='" + image + '\'' +
                    ", type=" + type +
                    ", id=" + id +
                    ", ga_prefix='" + ga_prefix + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "NewsBean{" +
                "date='" + date + '\'' +
                ", stories=" + stories +
                ", top_stories=" + top_stories +
                '}';
    }
}
