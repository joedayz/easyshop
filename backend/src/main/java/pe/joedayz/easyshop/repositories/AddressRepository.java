package pe.joedayz.easyshop.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import pe.joedayz.easyshop.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
}
