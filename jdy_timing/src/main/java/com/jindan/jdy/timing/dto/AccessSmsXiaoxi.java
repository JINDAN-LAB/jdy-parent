package com.jindan.jdy.timing.dto;

import lombok.Data;

@Data
public class AccessSmsXiaoxi {

    private String touser;
    private String template_id;
    private String url;
    private Miniprogram miniprogram;
    private Datas data;

    public class Miniprogram {
        private String appid;
        private String pagepath;

    }
    public class Datas {

        private First first;

        public class First {
            private String value;
            private String color;
        }

        public class Keyword1 {
            private String value;
            private String color;
        }

        public class Keyword2 {
            private String value;
            private String color;
        }
        public class Keyword3 {
            private String value;
            private String color;
        }
        public class remark {
            private String value;
            private String color;
        }

    }



}


