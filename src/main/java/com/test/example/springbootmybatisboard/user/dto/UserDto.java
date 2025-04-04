package com.test.example.springbootmybatisboard.user.dto;

public class UserDto {
    private int userSeq;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userProfileImage;
    private String userRegisterDate;

    public UserDto() {
    }

    public UserDto(int userSeq, String userName, String userPassword, String userEmail, String userProfileImage, String userRegisterDate) {
        this.userSeq = userSeq;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userProfileImage = userProfileImage;
        this.userRegisterDate = userRegisterDate;
    }

    public int getUserSeq() {
        return userSeq;
    }

    public void setUserSeq(int userSeq) {
        this.userSeq = userSeq;
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserProfileImage() {
        return userProfileImage;
    }

    public void setUserProfileImage(String userProfileImage) {
        this.userProfileImage = userProfileImage;
    }

    public String getUserRegisterDate() {
        return userRegisterDate;
    }

    public void setUserRegisterDate(String userRegisterDate) {
        this.userRegisterDate = userRegisterDate;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userSeq=" + userSeq +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userProfileImage='" + userProfileImage + '\'' +
                ", userRegisterDate='" + userRegisterDate + '\'' +
                '}';
    }
}
