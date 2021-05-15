package edu.guet.user_center.entity.vo;

import lombok.Data;

@Data
public class RegisterVo {
    private String nickname;
    private String mobile;
    private String mail;
    private String password;
    private String code;
}
