package camping.user.CampingUser.bussines.response;

public class GetByIdDeactivateUserResponse {

    private Long id ;
    private String name ;
    private  String email ;
    private String firstName;
    private  String lastName;
    private  boolean active;
    private String fullName;

    public GetByIdDeactivateUserResponse(Long id, String name, String email, String firstName, String lastName, boolean active, String fullName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
        this.fullName = fullName;
    }

    public GetByIdDeactivateUserResponse() {
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
