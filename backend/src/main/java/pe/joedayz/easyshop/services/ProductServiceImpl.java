package pe.joedayz.easyshop.services;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.joedayz.easyshop.dto.ProductDto;
import pe.joedayz.easyshop.entities.Product;
import pe.joedayz.easyshop.repositories.ProductRepository;

/**
 * @author josediaz
 **/
@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public Product addProduct(ProductDto product) {
    return null;
  }

  @Override
  public List<ProductDto> getAllProducts(UUID categoryId, UUID typeId) {
    return List.of();
  }

  @Override
  public ProductDto getProductBySlug(String slug) {
    return null;
  }

  @Override
  public ProductDto getProductById(UUID id) {
    return null;
  }

  @Override
  public Product updateProduct(ProductDto productDto, UUID id) {
    return null;
  }

  @Override
  public Product fetchProductById(UUID uuid) throws Exception {
    return null;
  }
}
