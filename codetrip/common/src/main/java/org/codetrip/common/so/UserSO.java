package org.codetrip.common.so;

import org.codetrip.common.enumerate.Gender;
import org.codetrip.common.enumerate.Nationality;
import org.codetrip.common.enumerate.Role;

/**
 * Created by RuFeng on 2015/4/4.
 */
public class UserSO {
    /*
    * 用户ID
    * */
    private Long id;

    /*
    * 密码，存储加密后的数据
    * */
    private String password;

    /*
    * 注册日期，日期格式：YYYY-MM-DD
    * */
    private String registeDate;

    /*
    * 昵称
    * */
    private String nikeName;

    /*
    * 邮箱地址
    * */
    private String email;

    /*
    * 角色，不同的角色有不同的权限
    * 角色分为：ADMIN，MEMBER，CAPTAIN
    * */
    private Role role;

    /*
    * 国籍
    * */
    private Nationality nationality;

    /*
    * 是否公开信息，YES / NO
    * */
    private Boolean publication;

    /*
    * 性别
    * */
    private Gender sex;

    /*
    * 年龄
    * */
    private Integer age;

    //setter 和 getter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegisteDate() {
        return registeDate;
    }

    public void setRegisteDate(String registeDate) {
        this.registeDate = registeDate;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Boolean getPublication() {
        return publication;
    }

    public void setPublication(Boolean publication) {
        this.publication = publication;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
