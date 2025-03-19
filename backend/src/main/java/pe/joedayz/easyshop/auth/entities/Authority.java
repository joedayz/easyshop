package pe.joedayz.easyshop.auth.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author josediaz
 **/
@Table(name = "AUTH_AUTHORITY")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Authority implements GrantedAuthority {

  @Id
  @GeneratedValue
  private UUID id;

  @Column(nullable = false)
  private String roleCode;

  @Column(nullable = false)
  private String roleDescription;

  @Override
  public String getAuthority() {
    return roleCode;
  }
}
