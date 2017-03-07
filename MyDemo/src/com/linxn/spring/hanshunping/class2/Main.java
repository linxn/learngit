package com.linxn.spring.hanshunping.class2;

import com.linxn.spring.hanshunping.class2.util.ApplicationContextUtil;
import com.linxn.spring.hanshunping.class2.ByeService;

/**
 * Created by Linxn on 2017/3/7.
 *
 * 依赖注入Demo
 * 引用其他bean【ref=""】
 * 使用工具类  ApplicationContextUtil
 */
public class Main {
    public static void main(String[] args) {
        ((ByeService)(ApplicationContextUtil.getAc().getBean("byeService"))).sayBye();
    }
}
