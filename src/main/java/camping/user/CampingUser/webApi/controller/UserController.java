package camping.user.CampingUser.webApi.controller;


import camping.user.CampingUser.bussines.abstartc.UserService;
import camping.user.CampingUser.bussines.request.CreateUserRequest;
import camping.user.CampingUser.bussines.request.UpdateUserRequest;
import camping.user.CampingUser.bussines.response.GetAllActiveUserResponse;
import camping.user.CampingUser.bussines.response.GetAllUserResponse;
import camping.user.CampingUser.bussines.response.GetByIdDeactivateUserResponse;
import camping.user.CampingUser.bussines.response.GetByIdUserResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    // tüm veriyi listleme işlemi
    @GetMapping()
   public List<GetAllUserResponse> getAll(){
        return userService.getAll();
   }
    @GetMapping("/active")
    public List<GetAllActiveUserResponse> getUsersActiveList(){
        return userService.getUsersActiveList();
    }
    // id 'ye göre getirme işlemi
    @GetMapping("/{id}")
    public GetByIdUserResponse getById(@PathVariable int id) {
        return userService.getById(id); //userservisten gelen id ye göre
    }
   // veri ekleme işlemi htppSatatus ile 201 dönme kısmı
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a new user")
    public void add(
            @RequestBody( required = true)
            @Valid CreateUserRequest createUserRequest) {
        System.out.println("create " + createUserRequest.getName() + createUserRequest.getFirstName() + createUserRequest.getLastName());
        this.userService.add(createUserRequest);
    }


    // id 'ye göre silme işlemi
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.userService.delete(id);
    }


    // aktifliğini değiştirme işlemi
    @PutMapping("/{id}/deactivate")
    public GetByIdDeactivateUserResponse deactivateUser(@PathVariable int id) {
       return userService.findById(id);

}



    @PutMapping()
public void  update(UpdateUserRequest updateUserRequest){
      this.userService.update(updateUserRequest);

    }


}
