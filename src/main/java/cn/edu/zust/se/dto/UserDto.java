package cn.edu.zust.se.dto;

import cn.edu.zust.se.entity.College;
import cn.edu.zust.se.entity.Major;
import cn.edu.zust.se.entity.State;
import cn.edu.zust.se.entity.Vacation;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class UserDto implements Serializable {
    private String userNum;
    private Integer collegeNum;
    private Integer majorNum;
    private Integer classNum;
    private Integer userType;
    private String userName;
    private Boolean sex;
    private String telephone;
    private Integer state;

    private College college;
    private Major major;
    private List<Vacation> vacations;
}
