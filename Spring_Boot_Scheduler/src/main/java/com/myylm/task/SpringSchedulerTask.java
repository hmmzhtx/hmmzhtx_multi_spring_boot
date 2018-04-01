package com.myylm.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author hmmzhtx
 */
@Component
public class SpringSchedulerTask {


    private int a = 0;

    /**
     * 标识：在此调度执行完毕1分钟后再次执行
     */
    @Scheduled(fixedDelay= 60 * 1000)
    public void fixedDelayProcess(){
        System.out.println("this is scheduler task 《fixedDelayProcess》 runing  "+(a++));
    }



    /**
     * 标识：一分钟自动执行一次（不管此任务会执行多长时间）
     */
    @Scheduled(fixedRate= 60 * 1000)
    public void fixedRateProcess(){
        System.out.println("this is scheduler task 《fixedRateProcess》 runing  "+(a++));
    }



    /**
     * 根据cron表达式格式触发定时任务
     *  cron表达式格式:
     *      1.Seconds Minutes Hours DayofMonth Month DayofWeek Year
     *      2.Seconds Minutes Hours DayofMonth Month DayofWeek
     *  顺序:
     *      秒（0~59）
     *      分钟（0~59）
     *      小时（0~23）
     *      天（月）（0~31，但是你需要考虑你月的天数）
     *      月（0~11）
     *      天（星期）（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）
     *      年份（1970－2099）
     *
     *  注:其中每个元素可以是一个值(如6),一个连续区间(9-12),一个间隔时间(8-18/4)(/表示每隔4小时),一个列表(1,3,5),通配符。
     *  由于"月份中的日期"和"星期中的日期"这两个元素互斥的,必须要对其中一个设置?.
     */

    @Scheduled(cron="*/6 * * * * ?")
    public void process(){
        System.out.println("this is scheduler task 《process》 runing  "+(a++));
    }

}
