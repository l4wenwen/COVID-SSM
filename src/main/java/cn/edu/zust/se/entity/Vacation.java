package cn.edu.zust.se.entity;

public class Vacation {
    private Integer vacationNum;
    private String reason;
    private String startTime;
    private String endTime;
    private String requestTime;
    private String way;
    private String userNum;
    private String userName;
    private Integer state;
    public static final int STATE_PENDING = 0;
    public static final int STATE_REJECT = 1;
    public static final int STATE_ACCEPT = 2;
}
