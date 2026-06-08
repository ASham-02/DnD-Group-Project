package com.example.Create_Character.DTOs.user;

public class ApiResponse {
    private String message;
    private boolean success;
    private Long userID;

    public ApiResponse(String message, boolean success, Long userID) {
        this.message = message;
        this.success = success;
        this.userID = userID;
    }

    public Long getUserID() {
        return userID;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
