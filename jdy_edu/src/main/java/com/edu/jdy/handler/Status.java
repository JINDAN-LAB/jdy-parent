package com.edu.jdy.handler;

import java.util.concurrent.TimeUnit;

public abstract   class Status {

    /**
     * 过期时间相关枚举
     */
    public static enum ExpireEnum{
        UNREAD_MSG(30L, TimeUnit.DAYS)
        ;


        private Long time;

        private TimeUnit timeUnit;

        ExpireEnum(Long time, TimeUnit timeUnit) {
            this.time = time;
            this.timeUnit = timeUnit;
        }

        public Long getTime() {
            return time;
        }

        public TimeUnit getTimeUnit() {
            return timeUnit;
        }
    }


}
