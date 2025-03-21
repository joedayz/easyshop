package pe.joedayz.easyshop.specification;

import java.util.UUID;
import org.springframework.data.jpa.domain.Specification;
import pe.joedayz.easyshop.entities.Product;

/**
 * @author josediaz
 **/
public class ProductSpecification {

  public static Specification<Product> hasCategoryId(UUID categorId){
    return  (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("category").get("id"),categorId);
  }

  public static Specification<Product> hasCategoryTypeId(UUID typeId){
    return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("categoryType").get("id"),typeId);
  }
}

