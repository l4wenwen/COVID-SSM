package cn.edu.zust.se.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String userNum;
    private Integer collegeNum;
    private Integer majorNum;
    private Integer classNum;
    private Integer userType;
    private String userName;
    private boolean sex;
    private String telephone;
    private Integer state;
}
