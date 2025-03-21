package pe.joedayz.easyshop.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.joedayz.easyshop.entities.Address;
import pe.joedayz.easyshop.entities.OrderStatus;

/**
 * @author josediaz
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetails {

  private UUID id;
  private Date orderDate;
  private Address address;
  private Double totalAmount;
  private OrderStatus orderStatus;
  private String shipmentNumber;
  private Date expectedDeliveryDate;
  private List<OrderItemDetail> orderItemList;

}