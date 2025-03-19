package pe.joedayz.easyshop.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.joedayz.easyshop.auth.entities.User;
import pe.joedayz.easyshop.auth.repositories.UserDetailRepository;

/**
 * @author josediaz
 **/
@Service
public class CustomUserDetailService implements UserDetailsService {

  @Autowired
  private UserDetailRepository userDetailRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userDetailRepository.findByEmail(username);
    if(null==user){
      throw new UsernameNotFoundException("User Not Found with username" + username);
    }
    return user;
  }
}
