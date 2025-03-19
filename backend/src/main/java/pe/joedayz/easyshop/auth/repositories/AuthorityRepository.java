package pe.joedayz.easyshop.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.joedayz.easyshop.auth.entities.Authority;

/**
 * @author josediaz
 **/
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
  Authority findByRoleCode(String user);
}
