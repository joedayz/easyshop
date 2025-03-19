package pe.joedayz.easyshop.auth.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * @author josediaz
 **/
@Table(name = "AUTH_USER_DETAILS")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User  {

  @Id
  @GeneratedValue
  private UUID id;

  private String firstName;

  private String lastName;

  @JsonIgnore
  private String password;

  private Date createdOn;

  private Date updatedOn;

  @Column(nullable = false, unique = true)
  private String email;

  private String phoneNumber;

  private String provider;

  private String verificationCode;

  private boolean enabled = false;

}