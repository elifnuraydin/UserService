package camping.user.CampingUser.bussines.rules;

import camping.user.CampingUser.bussines.Exception.UserException;
import camping.user.CampingUser.dataAcsess.abstaract.UserRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service

public class UserRules {
private UserRepository userRepository ;

    public UserRules(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void checkIfUserNameExists(String name){
        if (this.userRepository.existsByName(name)){
            throw new UserException("User name is already exists " + name);

        }

    }
    public void checkIfUserEmailExists(String email){
        if (this.userRepository.existsByEmail(email)){
            throw new UserException("User email is already exists " + email);
        }

    }

    public void checkIfUserIdExists(Integer id) {
        if (!this.userRepository.existsById(id)) { // User Id  yok ise hata fırlat
            throw new UserException("User with ID: " + id + " does not exist" +id );
        }

    }


    }
