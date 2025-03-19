package pe.joedayz.easyshop.auth.controller;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.joedayz.easyshop.auth.config.JWTTokenHelper;
import pe.joedayz.easyshop.auth.entities.User;
import pe.joedayz.easyshop.auth.services.OAuth2Service;
import org.springframework.security.oauth2.core.user.OAuth2User;
/**
 * @author josediaz
 **/
@RestController
@CrossOrigin
@RequestMapping("/oauth2")
public class OAuth2Controller {

  @Autowired
  OAuth2Service oAuth2Service;

  @Autowired
  JWTTokenHelper jwtTokenHelper;

  @GetMapping("/success")
  public void callbackOAuth2(@AuthenticationPrincipal OAuth2User oAuth2User,
      HttpServletResponse response) throws IOException {

    String userName = oAuth2User.getAttribute("email");
    User user = oAuth2Service.getUser(userName);
    if(null==user){
      user = oAuth2Service.createUser(oAuth2User, "google");
    }

    String token = jwtTokenHelper.generateToken(user.getUsername());

    response.sendRedirect("http://localhost:5671/oauth2/callback?tokenn=" + token);
  }


}
