package com.mantis.lambda.pojo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: wei.wang
 * @since: 2020/8/5 18:16
 * @history: 1.2020/8/5 created by wei.wang
 */
public class Role {

    private String groupName;
    private String groupCode;
    private String employeeId;
    private String displayName;
    private String roleName;
    private String roleCode;
    private String stationName;
    private String stationCode;
    private String stationType;

    public Role() {
    }

    public Role(String groupName, String groupCode, String employeeId, String displayName, String roleName, String roleCode, String stationName, String stationCode, String stationType) {
        this.groupName = distinctString(groupName);
        this.groupCode = distinctString(groupCode);
        this.employeeId = distinctString(employeeId);
        this.displayName = distinctString(displayName);
        this.roleName = distinctString(roleName);
        this.roleCode = distinctString(roleCode);
        this.stationName = distinctString(stationName);
        this.stationCode = distinctString(stationCode);
        this.stationType = distinctString(stationType);
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationType() {
        return stationType;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType;
    }

    @Override
    public String toString() {
        return "Role{" +
                "groupName='" + groupName + '\'' +
                ", groupCode='" + groupCode + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", displayName='" + displayName + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleCode='" + roleCode + '\'' +
                ", stationName='" + stationName + '\'' +
                ", stationCode='" + stationCode + '\'' +
                ", stationType='" + stationType + '\'' +
                '}';
    }

    /**
     * 删除重复内容
     * @param str
     * @return
     */
    private String distinctString(String str) {
        return String.join(",", new HashSet<>(Arrays.stream(str.split(","))
                .filter(Objects::nonNull)
                .filter(o -> !"".equals(o))
                .collect(Collectors.toList())));
    }
}
