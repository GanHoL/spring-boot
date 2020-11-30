package com.wkcto.springboot.model;

/**
 * ClassName:Users
 * <p>
 * Package:com.wkcto.springboot.model
 * Description:
 *
 * @Date:2018/8/7 10:42
 * @Author:GanHoL
 */
public class Users {

    private Integer id;

    private String name;

    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
