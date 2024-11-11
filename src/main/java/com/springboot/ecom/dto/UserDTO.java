package com.springboot.ecom.dto;

public class UserDTO {
    private int id;
    private String username;
    private String roleType;

    // Constructors
    public UserDTO() {}

    public UserDTO(int id, String username, String roleType) {
        this.id = id;
        this.username = username;
        this.roleType = roleType;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getRoleType() { return roleType; }
    public void setRoleType(String roleType) { this.roleType = roleType; }
}
