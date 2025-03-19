package pe.joedayz.easyshop.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author josediaz
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationResponse {

  private int code;
  private String message;

}
