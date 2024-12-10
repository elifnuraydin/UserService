package camping.user.CampingUser.dataAcsess.abstaract;

import camping.user.CampingUser.entites.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {
    List<User> findAll();
    boolean existsByName(String name);
    boolean existsByEmail(String name);
    boolean existsById(Long id);

}
