package org.me.pi4.model;

/**
 * @author 2016203311
 */
public class User {
    
    private int userId;      
    private String userCode;    
    private String userName;
    private String userPassword;
    private int userType;
    private String userImei;
    private String userNetwork;

    public User() {
    }

    public String getUserImei() {
        return userImei;
    }

    public void setUserImei(String userImei) {
        this.userImei = userImei;
    }

    public String getUserNetwork() {
        return userNetwork;
    }

    public void setUserNetwork(String userNetwork) {
        this.userNetwork = userNetwork;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
      
}
