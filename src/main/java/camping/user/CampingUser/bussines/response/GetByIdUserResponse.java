package camping.user.CampingUser.bussines.response;

import jakarta.persistence.Column;

public class GetByIdUserResponse {
    private Long id ;
    private String name ;
    private  String email ;
    private String firstName;
    private  String lastName;
    private  boolean active;
    private String fullName;

    public GetByIdUserResponse() {
    }

    public GetByIdUserResponse(String fullName) {
        this.fullName = fullName;
    }

    public GetByIdUserResponse(Long id, String name, String firstName, String email, boolean active, String lastName) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.active = active;
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

