package org.codetrip.common.so;

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
    private String registerDate;

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
    private String role;

    /*
    * 国籍
    * */
    private String nationality;

    /*
    * 是否公开信息，YES / NO
    * */
    private String publicInfo;

    /*
    * 性别
    * */
    private String sex;

    /*
    * 年龄
    * */
    private Integer age;

    //setter and getter


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

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPublicInfo() {
        return publicInfo;
    }

    public void setPublicInfo(String publicInfo) {
        this.publicInfo = publicInfo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
