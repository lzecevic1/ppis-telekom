package ba.unsa.etf.ppis.telekom.controllers.dto;

import ba.unsa.etf.ppis.telekom.models.User;

public class LoginResponseDTO {
    private User user;
    private String errorMessage;
    private String token;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(String errorMessage) {
        this.setErrorMessage(errorMessage);
    }

    public LoginResponseDTO(User user, String token) {
        this.setUser(user);
        this.setToken(token);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
