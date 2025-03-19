package pe.joedayz.easyshop.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.joedayz.easyshop.auth.entities.User;

/**
 * @author josediaz
 **/
@Repository
public interface UserDetailRepository extends JpaRepository<User, Long> {
  User findByEmail(String username);

}
