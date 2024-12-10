package camping.user.CampingUser.bussines.concretes;

import camping.user.CampingUser.bussines.Exception.UserException;
import camping.user.CampingUser.bussines.abstartc.UserService;
import camping.user.CampingUser.bussines.request.CreateUserRequest;
import camping.user.CampingUser.bussines.request.UpdateUserRequest;
import camping.user.CampingUser.bussines.response.GetAllActiveUserResponse;
import camping.user.CampingUser.bussines.response.GetAllUserResponse;
import camping.user.CampingUser.bussines.response.GetByIdDeactivateUserResponse;
import camping.user.CampingUser.bussines.response.GetByIdUserResponse;
import camping.user.CampingUser.bussines.rules.UserRules;
import camping.user.CampingUser.core.utulites.mappers.ModelMaperService;
import camping.user.CampingUser.dataAcsess.abstaract.UserRepository;
import camping.user.CampingUser.entites.concretes.User;
import org.hibernate.internal.util.collections.CollectionHelper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManager implements UserService {

    private final   UserRepository userRepository;
    private final ModelMaperService modelMaperService;
    private final UserRules userRules ;



    public UserManager(UserRepository userRepository, ModelMaperService modelMaperService, UserRules userRules) {
        this.userRepository = userRepository;
        this.modelMaperService = modelMaperService;
        this.userRules = userRules;

    }



    @Override
    public List<GetAllUserResponse> getAll() {

        List<User>users = userRepository.findAll();


//
List<GetAllUserResponse>userResponses = users.stream().
        map(user -> this.modelMaperService.forResponse().map(user,GetAllUserResponse.class)).collect(Collectors.toList());

return  userResponses;
    }

    @Override
    public void add(CreateUserRequest createUserRequest) {
        User user = this.modelMaperService.forRequest().map(createUserRequest ,User.class);
        this.userRules.checkIfUserEmailExists(user.getEmail());
        this.userRules.checkIfUserNameExists(user.getName());
        this.userRepository.save(user);

    }

    @Override
    public void delete(int id) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new UserException("User not found with ID: " + id));
     this.userRepository.deleteById(id);
    }

    @Override
    public GetByIdUserResponse getById(int id) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new UserException("User not found with ID: " + id));
        GetByIdUserResponse userResponse = this.modelMaperService.forResponse().map(user, GetByIdUserResponse.class);
        return userResponse;
    }

    @Override
    public GetByIdDeactivateUserResponse findById(int id) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new UserException("User not found with ID: " + id));
        user.setActive(false);
        GetByIdDeactivateUserResponse userResponse = this.modelMaperService.forResponse().map(user, GetByIdDeactivateUserResponse.class);
        return userResponse;

    }

    @Override
    public List<GetAllActiveUserResponse> getUsersActiveList() {
        List<User> users = userRepository.findAll(); // Tüm kullanıcıları getir

        //.filter ile sadece active kullanıcıları filtreler
        List<GetAllActiveUserResponse> userActiveResponse = users.stream()
                .filter(User::isActive) // Kullanıcıların aktif olanlarını filtreler
                .map(user -> this.modelMaperService.forResponse()
                        .map(user, GetAllActiveUserResponse.class)) // DTO'ya dönüştürür
                .collect(Collectors.toList());

        return userActiveResponse; // Filtrelenmiş ve dönüştürülmüş listeyi döner
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        // updateUserRequest tipini user.class çevirrerek user oluştuuryorruz .

       User user = this.modelMaperService.forRequest().map(updateUserRequest ,User.class);
        this.userRules.checkIfUserIdExists(Math.toIntExact(user.getId())); // id var mı yok mut ? hata dönme kısmı
        this.userRules.checkIfUserEmailExists(user.getEmail());
        this.userRules.checkIfUserNameExists(user.getName());
        this.userRepository.save(user);

    }

    ;

}
