package pe.joedayz.easyshop.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerErrorException;
import pe.joedayz.easyshop.auth.dto.RegistrationRequest;
import pe.joedayz.easyshop.auth.dto.RegistrationResponse;
import pe.joedayz.easyshop.auth.entities.Authority;
import pe.joedayz.easyshop.auth.entities.User;
import pe.joedayz.easyshop.auth.helper.VerificationCodeGenerator;
import pe.joedayz.easyshop.auth.repositories.UserDetailRepository;

/**
 * @author josediaz
 **/
@Service
public class RegistrationService {

  @Autowired
  private UserDetailRepository userDetailRepository;

  @Autowired
  private AuthorityService authorityService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public RegistrationResponse createUser(RegistrationRequest request) {
    User existing = userDetailRepository.findByEmail(request.getEmail());

    if(null != existing){
      return  RegistrationResponse.builder()
          .code(400)
          .message("Email already exist!")
          .build();
    }

    try{
      User user = new User();
      user.setFirstName(request.getFirstName());
      user.setLastName(request.getLastName());
      user.setEmail(request.getEmail());
      user.setEnabled(false);
      user.setPassword(passwordEncoder.encode(request.getPassword()));
      user.setProvider("manual");

      String code = VerificationCodeGenerator.generateCode();

      user.setVerificationCode(code);
      user.setAuthorities(authorityService.getUserAuthority());
      userDetailRepository.save(user);
      //emailService.sendMail(user);

      return RegistrationResponse.builder()
          .code(200)
          .message("User created!")
          .build();


    }catch (Exception e){
      throw new ServerErrorException(e.getMessage(), e.getCause());
    }


  }

}
