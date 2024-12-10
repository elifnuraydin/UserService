package camping.user.CampingUser;

import camping.user.CampingUser.bussines.Exception.UserException;
import camping.user.CampingUser.bussines.Exception.UserProblemException;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@SpringBootApplication
@RestControllerAdvice
public class CampingUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampingUserApplication.class, args);
	}
	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public UserProblemException handleBusinessException (UserException userException){
		UserProblemException userProblemException = new UserProblemException();
		userProblemException.setMessages(userException.getMessage());
		return userProblemException;
	}






}
