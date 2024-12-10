package camping.user.CampingUser.bussines.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class UserException extends RuntimeException {

    public UserException(String messages) {
        super(messages);

    }

}

