package pe.joedayz.easyshop.controllers;

import java.security.Principal;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.joedayz.easyshop.dto.AddressRequest;
import pe.joedayz.easyshop.entities.Address;
import pe.joedayz.easyshop.services.AddressService;

/**
 * @author josediaz
 **/
@RestController
@RequestMapping("/api/address")
@CrossOrigin
public class AddressController {

  @Autowired
  private AddressService addressService;

  @PostMapping
  public ResponseEntity<Address> createAddress(@RequestBody AddressRequest addressRequest, Principal principal){
    Address address = addressService.createAddress(addressRequest,principal);
    return new ResponseEntity<>(address, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteAddress(@PathVariable UUID id){
    addressService.deleteAddress(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}