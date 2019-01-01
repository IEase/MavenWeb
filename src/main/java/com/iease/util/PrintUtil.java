package com.iease.util;

/*
 * Copyright 2017 SF Airlines Co., Ltd. All rights reserved.
 * 本文件仅限于顺丰航空有限公司内部传阅，禁止外泄以及用于其他的商业目的�com.iease.utilmodule.common.util;
 */
import java.util.Date;
import org.apache.commons.lang.StringUtils;

/**
 * @author 89003699
 *
 */
public class PrintUtil {

    private static String FORMAT = "�?%1$s】�?�共用了:%2$s�?";
    public static final Double MS = 1000D;
    /**
     * 设置�?般的级别输出
     * 
     * @param title
     *            标题
     * @param startTime
     *            �?始时�? System.currentTimeMillis()
     * @param endTime
     *            结束时间 System.currentTimeMillis()
     */
    public static void info(String title, Long startTime, Long endTime) {
        Double time = (endTime - startTime) / MS;
        String msg = String.format(FORMAT, title, time);
        System.out.println(msg);
    }

    /**
     * 
     * 
     * @param title
     * @param startDate
     * @param endDate
     * @return
     */
    public static String retInfo(String title, Date startDate, Date endDate) {
        long startTime = (null == startDate) ? 0L : startDate.getTime();
        long endTime = (null == endDate) ? 0L : endDate.getTime();
        Double time = (endTime - startTime) / MS;
        return String.format(FORMAT, title, time);
    }
    
    public static String kkk(){
    	return StringUtils.EMPTY;
    }
}
