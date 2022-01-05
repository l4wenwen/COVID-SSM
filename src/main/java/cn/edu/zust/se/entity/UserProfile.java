package cn.edu.zust.se.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfile {
    private String userNum;
    private String userName;
    private String sex;
    private String collegeName;
    private String majorName;
    private String userType;
    private String telephone;

    public UserProfile(String userNum, String userName, String sex, String collegeName, String majorName, String userType) {
        this.userNum = userNum;
        this.userName = userName;
        this.sex = sex;
        this.collegeName = collegeName;
        this.majorName = majorName;
        this.userType = userType;
    }

    public UserProfile() {
    }
}
