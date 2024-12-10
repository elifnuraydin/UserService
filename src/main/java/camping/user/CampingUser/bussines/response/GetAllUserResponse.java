package camping.user.CampingUser.bussines.response;

import lombok.*;


public class GetAllUserResponse {
    private Long id;
    private String name;
    private String firstName;
    private String lastName;
    private String email;
    private boolean active ;

    private String fullName;

    public GetAllUserResponse() {
    }

    public GetAllUserResponse(Long id, String fullName, String email, boolean active, String lastName, String firstName, String name) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.active = active;
        this.lastName = lastName;
        this.firstName = firstName;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}