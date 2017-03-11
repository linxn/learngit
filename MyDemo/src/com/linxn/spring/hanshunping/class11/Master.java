package com.linxn.spring.hanshunping.class11;

/**
 * Created by Linxn on 2017/3/9.
 */
public class Master {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    private Cat cat;
}
