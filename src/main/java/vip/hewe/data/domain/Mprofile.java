package vip.hewe.data.domain;

public class Mprofile {
  private String id;
  private String name;
  private java.sql.Date bth;
  private Long sex;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public java.sql.Date getBth() {
    return bth;
  }

  public void setBth(java.sql.Date bth) {
    this.bth = bth;
  }

  public Long getSex() {
    return sex;
  }

  public void setSex(Long sex) {
    this.sex = sex;
  }
}
