package vip.hewe.data.domain;

import java.util.Date;

public class Mprofile {
    private String id;

    private String name;

    private Date bth;

    private Integer sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getBth() {
        return bth;
    }

    public void setBth(Date bth) {
        this.bth = bth;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}