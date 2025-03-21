package pe.joedayz.easyshop.auth.dto;

import java.util.Map;
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
public class OrderResponse {

  private UUID orderId;
  private Map<String,String> credentials;
  private String paymentMethod;
}
