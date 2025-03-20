package pe.joedayz.easyshop.auth.dto;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.joedayz.easyshop.entities.Address;

/**
 * @author josediaz
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDto {

  private UUID id;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String email;
  private Object authorityList;
  private List<Address> addressList;
}

