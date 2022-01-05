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
    private boolean sex;
    private String telephone;
    private Integer state;
    private List<Vacation> vacations;
}
