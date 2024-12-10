package camping.user.CampingUser.bussines.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data

public class CreateUserRequest {
    @NonNull
    @NotNull
    private String firstName;

    @NonNull
    @NotNull
    private String lastName ;
    @NonNull
    @NotNull
    private String email ;
    @NonNull
    @NotNull

    private boolean active ;
    @NonNull
    @NotNull
    private String name ;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String firstName, String lastName, String email, boolean active, String name) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
