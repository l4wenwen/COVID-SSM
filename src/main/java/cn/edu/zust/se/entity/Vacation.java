package cn.edu.zust.se.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacation {
    private Integer vacationNum;
    private String reason;
    private String startTime;
    private String endTime;
    private String requestTime;
    private String way;
    private Integer state;
    private User user;
    public static final int STATE_PENDING = 0;
    public static final int STATE_REJECT = 1;
    public static final int STATE_ACCEPT = 2;
}
