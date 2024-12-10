package camping.user.CampingUser.bussines.abstartc;

import camping.user.CampingUser.bussines.request.CreateUserRequest;
import camping.user.CampingUser.bussines.request.UpdateUserRequest;
import camping.user.CampingUser.bussines.response.GetAllActiveUserResponse;
import camping.user.CampingUser.bussines.response.GetAllUserResponse;
import camping.user.CampingUser.bussines.response.GetByIdDeactivateUserResponse;
import camping.user.CampingUser.bussines.response.GetByIdUserResponse;

import java.util.List;

public interface UserService {
    List<GetAllUserResponse> getAll();
   public void add(CreateUserRequest createUserRequest);
    void delete(int id);
    GetByIdUserResponse getById( int id) ;
   GetByIdDeactivateUserResponse findById(int id);
    List<GetAllActiveUserResponse> getUsersActiveList();
    void update(UpdateUserRequest updateUserRequest);



}
