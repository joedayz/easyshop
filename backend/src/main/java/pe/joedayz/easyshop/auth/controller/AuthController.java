package pe.joedayz.easyshop.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.joedayz.easyshop.auth.config.JWTTokenHelper;
import pe.joedayz.easyshop.auth.dto.LoginRequest;
import pe.joedayz.easyshop.auth.dto.RegistrationRequest;
import pe.joedayz.easyshop.auth.dto.RegistrationResponse;
import pe.joedayz.easyshop.auth.dto.UserToken;
import pe.joedayz.easyshop.auth.entities.User;
import pe.joedayz.easyshop.auth.services.RegistrationService;

/**
 * @author josediaz
 **/
@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  RegistrationService registrationService;

  @Autowired
  JWTTokenHelper jwtTokenHelper;

  @PostMapping("/login")
  public ResponseEntity<UserToken> login(@RequestBody LoginRequest loginRequest){
    try {
      Authentication authentication = UsernamePasswordAuthenticationToken
          .unauthenticated(loginRequest.getUserName(), loginRequest.getPassword());
      Authentication authenticationResponse = this.authenticationManager.authenticate(
          authentication);

      if (authenticationResponse.isAuthenticated()) {
          User user = (User) authenticationResponse.getPrincipal();
          if(!user.isEnabled()){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
          }
          String token = jwtTokenHelper.generateToken(user.getEmail());
          UserToken userToken = UserToken.builder().token(token).build();
        return new ResponseEntity<>(userToken, HttpStatus.OK);
      }
    }catch (BadCredentialsException e){
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
  }

  @PostMapping("/register")
  public ResponseEntity<RegistrationResponse> register(@RequestBody RegistrationRequest request){
    RegistrationResponse registrationResponse = registrationService.createUser(request);
    return new ResponseEntity<>(registrationResponse,
        registrationResponse.getCode() == 200 ? HttpStatus.OK: HttpStatus.BAD_REQUEST);
  }

}
