package cn.edu.zust.se.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateDto {
    private Integer stateNum;
    private String userNum;
    private String stateTime;
    private boolean isTemperature;
    private boolean isCovid;
    private boolean isLikeCovid;
    private Integer quarantine;
    private boolean isRecentArea;
    private boolean isRecentCountry;
    private boolean isRecentPeople;
    private boolean isSymptom;
    private boolean isAbnormal;
    private Integer healthCodeType;
    private boolean isOutSchool;
    private boolean isOutCity;
}
