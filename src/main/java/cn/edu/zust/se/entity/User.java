package cn.edu.zust.se.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {
    private String userNum;
    private Integer collegeNum;
    private Integer majorNum;
    private Integer classNum;
    private Integer userType;
    private String userName;
    private String password;
    private Boolean sex;
    private String telephone;
    private Integer state;

    private College college;
    private Major major;
    private List<Vacation> vacations;

    @Override
    public String toString() {
        return "User{" +
                "userNum='" + userNum + '\'' +
                ", collegeNum=" + collegeNum +
                ", majorNum=" + majorNum +
                ", classNum=" + classNum +
                ", userType=" + userType +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", telephone='" + telephone + '\'' +
                ", state=" + state +
                ", college=" + college +
                ", major=" + major +
                ", vacations=" + vacations +
                '}';
    }
}
