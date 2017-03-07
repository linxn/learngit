package com.linxn.spring.hanshunping.class4;

/**
 * Created by Linxn on 2017/3/7.
 */
public class UpperCase implements ChangeLetter{

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    private String str;

    @Override
    public String Change() {
        return str.toUpperCase();
    }
}
