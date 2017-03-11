package com.linxn.spring.hanshunping.class10;

import java.util.Properties;

/**
 * Created by Linxn on 2017/3/8.
 */
public class Degree extends Sutdent{
    public String getDegree() {
        return Degree;
    }

    public void setDegree(String degree) {
        Degree = degree;
    }

    private String Degree;

    public Properties getPp() {
        return pp;
    }

    public void setPp(Properties pp) {
        this.pp = pp;
    }

    private Properties pp;
}
