package pe.joedayz.easyshop.services;

import java.security.Principal;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import pe.joedayz.easyshop.auth.entities.User;
import pe.joedayz.easyshop.dto.AddressRequest;
import pe.joedayz.easyshop.entities.Address;
import pe.joedayz.easyshop.repositories.AddressRepository;

/**
 * @author josediaz
 **/
@Service
public class AddressService {

  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  private AddressRepository addressRepository;

  public Address createAddress(AddressRequest addressRequest, Principal principal){
    User user= (User) userDetailsService.loadUserByUsername(principal.getName());
    Address address = Address.builder()
        .name(addressRequest.getName())
        .street(addressRequest.getStreet())
        .city(addressRequest.getCity())
        .state(addressRequest.getState())
        .zipCode(addressRequest.getZipCode())
        .phoneNumber(addressRequest.getPhoneNumber())
        .user(user)
        .build();
    return addressRepository.save(address);
  }

  public void deleteAddress(UUID id) {
    addressRepository.deleteById(id);
  }


}
