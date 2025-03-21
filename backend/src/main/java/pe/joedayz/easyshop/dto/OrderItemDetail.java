package pe.joedayz.easyshop.dto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.joedayz.easyshop.entities.Product;

/**
 * @author josediaz
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemDetail {

  private UUID id;
  private Product product;
  private UUID productVariantId;
  private Integer quantity;
  private Double itemPrice;
}
