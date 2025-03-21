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
public class ProductVariantDto {
  private UUID id;
  private String color;
  private String size;
  private Integer stockQuantity;
}
