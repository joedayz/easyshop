package pe.joedayz.easyshop.dto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author josediaz
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemRequest {

  private UUID productId;
  private UUID productVariantId;
  private Double discount;
  private Integer quantity;
}

