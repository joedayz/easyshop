package pe.joedayz.easyshop.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author josediaz
 **/
@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

  @Id
  @GeneratedValue
  private UUID id;
  @Column(nullable = false)
  private String name;
  @Column
  private String description;
  @Column(nullable = false)
  private BigDecimal price;
  @Column(nullable = false)
  private String brand;
  @Column
  private Float rating;
  @Column(nullable = false)
  private boolean isNewArrival;
  @Column(nullable = false, unique = true)
  private String slug;
  private java.util.Date createdAt;
  private java.util.Date updatedAt;

  @PrePersist
  protected void onCreate(){
    createdAt = new java.util.Date();
    updatedAt = createdAt;
  }
  @PreUpdate
  protected void onUpdate(){
    updatedAt = new java.util.Date();
  }

}
