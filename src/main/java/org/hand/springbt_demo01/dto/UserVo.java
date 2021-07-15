package org.hand.springbt_demo01.dto;

/**
 * @description:
 * @author:
 **/
public class UserVo  extends User{

    private int role_code;
    private String role_name;



    public int getRole_code() {
        return role_code;
    }

    public void setRole_code(int role_code) {
        this.role_code = role_code;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
