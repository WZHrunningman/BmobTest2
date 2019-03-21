package com.example.wzh.bmobtest2.bean;

import cn.bmob.v3.BmobObject;

/**
 * Author by wzh,Date on 2019/3/17.
 * PS: Not easy to write code, please indicate.
 * 类描述：    继承BmobObject的用户实体类
 */
public class UserBean extends BmobObject {

    private static final long serialVersionUID = 1L;
    private String loginId;
    private String userName;
    private String password;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserBean [loginId=" + loginId + ", userName=" + userName
                + ", password=" + password + "]";
    }
}
