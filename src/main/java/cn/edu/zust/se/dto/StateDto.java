package cn.edu.zust.se.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StateDto implements Serializable {
    private Integer stateNum;
    private String userNum;
    private String stateTime;
    private Integer isTemperature;
    private Integer isCovid;
    private Integer isLikeCovid;
    private Integer quarantine;
    private Integer isRecentArea;
    private Integer isRecentCountry;
    private Integer isRecentPeople;
    private Integer isSymptom;
    private Integer isAbnormal;
    private Integer healthCodeType;
    private Integer isOutSchool;
    private Integer isOutCity;
}
