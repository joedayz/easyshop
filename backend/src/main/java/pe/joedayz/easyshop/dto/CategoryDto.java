package pe.joedayz.easyshop.dto;

import java.util.List;
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
public class CategoryDto {

  private UUID id;
  private String name;
  private String code;
  private String description;
  private List<CategoryTypeDto> categoryTypes;

}
