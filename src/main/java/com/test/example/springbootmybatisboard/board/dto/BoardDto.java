package com.test.example.springbootmybatisboard.board.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class BoardDto {
    private int boardId;
    private int userSeq;
    private String userName;
    private String userProfileImage;
    private String title;
    private String content;
    private LocalDateTime regDt;
    private int readCount;

    private boolean sameUser; // 현재 로그인한 사용자

    public BoardDto(int userSeq, String title, String content) {
        this.userSeq = userSeq;
        this.title = title;
        this.content = content;
    }

    public BoardDto(int boardId, int userSeq, String userName, String userProfileImage, String title, String content, LocalDateTime regDt, int readCount, boolean sameUser) {
        this.boardId = boardId;
        this.userSeq = userSeq;
        this.userName = userName;
        this.userProfileImage = userProfileImage;
        this.title = title;
        this.content = content;
        this.regDt = regDt;
        this.readCount = readCount;
        this.sameUser = sameUser;
    }

    public BoardDto() {
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
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

    public String getUserProfileImage() {
        return userProfileImage;
    }

    public void setUserProfileImage(String userProfileImage) {
        this.userProfileImage = userProfileImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getRegDt() {
        return regDt;
    }

    // mybatis date mapping 처리 // LocalDateTime 으로 바로 처리 x
    public void setRegDt(Date regDt) {
        this.regDt = LocalDateTime.ofInstant(regDt.toInstant(), ZoneId.systemDefault());
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public boolean isSameUser() {
        return sameUser;
    }

    public void setSameUser(boolean sameUser) {
        this.sameUser = sameUser;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "boardId=" + boardId +
                ", userSeq=" + userSeq +
                ", userName='" + userName + '\'' +
                ", userProfileImage='" + userProfileImage + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", regDt=" + regDt +
                ", readCount=" + readCount +
                ", sameUser=" + sameUser +
                '}';
    }
}
