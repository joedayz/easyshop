package pe.joedayz.easyshop.auth.helper;

import java.util.Random;

/**
 * @author josediaz
 **/
public class VerificationCodeGenerator {

  public static String generateCode(){
    Random random=new Random();
    int code = 100000 + random.nextInt(900000);
    return String.valueOf(code);
  }
}
