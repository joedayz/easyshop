package pe.joedayz.easyshop.auth.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.joedayz.easyshop.auth.entities.Authority;
import pe.joedayz.easyshop.auth.repositories.AuthorityRepository;

/**
 * @author josediaz
 **/
@Service
public class AuthorityService {

  @Autowired
  private AuthorityRepository authorityRepository;

  public List<Authority> getUserAuthority(){
    List<Authority> authorities=new ArrayList<>();
    Authority authority= authorityRepository.findByRoleCode("USER");
    authorities.add(authority);
    return  authorities;
  }

  public Authority createAuthority(String role, String description){
    Authority authority= Authority.builder().roleCode(role).roleDescription(description).build();
    return authorityRepository.save(authority);
  }
}
