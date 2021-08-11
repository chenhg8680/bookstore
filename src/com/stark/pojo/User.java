package com.stark.pojo;

import lombok.Data;

/**
 * User: C.H.G
 * Date: 2021/8/11
 * Time: 下午4:01
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;

    public User() {
    }

    public User(Integer id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
