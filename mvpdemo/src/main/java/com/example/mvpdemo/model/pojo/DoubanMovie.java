package com.example.mvpdemo.model.pojo;

import java.util.List;

/**
 * Created by Administrator on 2018/1/11.
 */
public class DoubanMovie {

    /**
     * total : 250
     * title : 豆瓣电影Top250
     * count : 1
     * subjects : [{"id":"1292052","title":"肖申克的救赎","genres":["犯罪","剧情"],"alt":"https://movie.douban.com/subject/1292052/","subtype":"movie","original_title":"The Shawshank Redemption","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.jpg"},"year":"1994","casts":[{"id":"1054521","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.jpg"},"alt":"https://movie.douban.com/celebrity/1054521/","name":"蒂姆·罗宾斯"},{"id":"1054534","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34642.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34642.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34642.jpg"},"alt":"https://movie.douban.com/celebrity/1054534/","name":"摩根·弗里曼"},{"id":"1041179","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5837.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5837.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5837.jpg"},"alt":"https://movie.douban.com/celebrity/1041179/","name":"鲍勃·冈顿"}],"collect_count":1192769,"rating":{"min":0,"stars":"50","average":9.6,"max":10},"directors":[{"id":"1047973","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.jpg"},"alt":"https://movie.douban.com/celebrity/1047973/","name":"弗兰克·德拉邦特"}]}]
     * start : 0
     */

    private int total;
    private String title;
    private int count;
    private int start;
    private List<SubjectsBean> subjects;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public List<SubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }

    public static class SubjectsBean {


        private String id;
        private String title;
        private String alt;
        private String subtype;
        private String original_title;
        private ImagesBean images;
        private String year;
        private int collect_count;
        private RatingBean rating;
        private List<String> genres;
        private List<CastsBean> casts;
        private List<DirectorsBean> directors;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public int getCollect_count() {
            return collect_count;
        }

        public void setCollect_count(int collect_count) {
            this.collect_count = collect_count;
        }

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public List<CastsBean> getCasts() {
            return casts;
        }

        public void setCasts(List<CastsBean> casts) {
            this.casts = casts;
        }

        public List<DirectorsBean> getDirectors() {
            return directors;
        }

        public void setDirectors(List<DirectorsBean> directors) {
            this.directors = directors;
        }

        public static class ImagesBean {
            /**
             * small : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.jpg
             * medium : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.jpg
             * large : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.jpg
             */

            private String small;
            private String medium;
            private String large;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }
        }

        public static class RatingBean {
            /**
             * min : 0
             * stars : 50
             * average : 9.6
             * max : 10
             */

            private int min;
            private String stars;
            private double average;
            private int max;

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }

            public String getStars() {
                return stars;
            }

            public void setStars(String stars) {
                this.stars = stars;
            }

            public double getAverage() {
                return average;
            }

            public void setAverage(double average) {
                this.average = average;
            }

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }
        }

        public static class CastsBean {
            /**
             * id : 1054521
             * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.jpg"}
             * alt : https://movie.douban.com/celebrity/1054521/
             * name : 蒂姆·罗宾斯
             */

            private String id;
            private AvatarsBean avatars;
            private String alt;
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public AvatarsBean getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBean avatars) {
                this.avatars = avatars;
            }

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public static class AvatarsBean {
                /**
                 * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.jpg
                 * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.jpg
                 * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.jpg
                 */

                private String small;
                private String medium;
                private String large;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }
            }
        }

        public static class DirectorsBean {
            /**
             * id : 1047973
             * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.jpg"}
             * alt : https://movie.douban.com/celebrity/1047973/
             * name : 弗兰克·德拉邦特
             */

            private String id;
            private AvatarsBeanX avatars;
            private String alt;
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public AvatarsBeanX getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBeanX avatars) {
                this.avatars = avatars;
            }

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public static class AvatarsBeanX {
                /**
                 * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.jpg
                 * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.jpg
                 * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.jpg
                 */

                private String small;
                private String medium;
                private String large;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }
            }
        }
    }
}
