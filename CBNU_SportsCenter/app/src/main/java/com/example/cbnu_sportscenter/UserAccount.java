package com.example.cbnu_sportscenter;

/*
* 사용자 계정ㅈ ㅓㅇ보 모델 클래스
* */

public class UserAccount {
    private String id;          // 아이디
    private String password;    // 비밀번호
    private String idToken;     //Firebase Uid(고유 토근정보)

    public UserAccount() { }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
