package com.itzixi.pojo;

import javax.persistence.Id;
import java.util.Date;

public class Teacher {
    @Id
    private String id;

    private String name;

    private Integer age;

    private String sex;

//    private Date birthday;
//    private Float amount;
//    private boolean haveChild;
//    private Stu stu;
//
//    public Stu getStu() {
//        return stu;
//    }
//
//    public void setStu(Stu stu) {
//        this.stu = stu;
//    }
//
//    public Date getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(Date birthday) {
//        this.birthday = birthday;
//    }
//
//    public Float getAmount() {
//        return amount;
//    }
//
//    public void setAmount(Float amount) {
//        this.amount = amount;
//    }
//
//    public boolean isHaveChild() {
//        return haveChild;
//    }
//
//    public void setHaveChild(boolean haveChild) {
//        this.haveChild = haveChild;
//    }

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
}