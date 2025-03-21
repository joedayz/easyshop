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
public class ProductResourceDto {

  private UUID id;
  private String name;
  private String url;
  private String type;
  private  Boolean isPrimary;
}
