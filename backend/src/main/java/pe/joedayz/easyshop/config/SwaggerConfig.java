package pe.joedayz.easyshop.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author josediaz
 **/
@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI customOpenAPI(){
    return new OpenAPI()
        .info(new Info().title("EasyShop API's").description("EasyShop E-commerce Application APIs")
            .version("1.0")
            .contact(new Contact()
                .name("The EasyShop")));
  }
}
