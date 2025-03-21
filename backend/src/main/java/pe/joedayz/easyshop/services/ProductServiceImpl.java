package pe.joedayz.easyshop.services;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pe.joedayz.easyshop.dto.ProductDto;
import pe.joedayz.easyshop.entities.Product;
import pe.joedayz.easyshop.exceptions.ResourceNotFoundEx;
import pe.joedayz.easyshop.mapper.ProductMapper;
import pe.joedayz.easyshop.repositories.ProductRepository;
import pe.joedayz.easyshop.specification.ProductSpecification;

/**
 * @author josediaz
 **/
@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ProductMapper productMapper;

  @Override
  public Product addProduct(ProductDto product) {
    return null;
  }

  @Override
  public List<ProductDto> getAllProducts(UUID categoryId, UUID typeId) {
    Specification<Product> productSpecification= Specification.where(null);

    if(null != categoryId){
      productSpecification = productSpecification.and(ProductSpecification.hasCategoryId(categoryId));
    }
    if(null != typeId){
      productSpecification = productSpecification.and(ProductSpecification.hasCategoryTypeId(typeId));
    }

    List<Product> products = productRepository.findAll(productSpecification);
    return productMapper.getProductDtos(products);
  }

  @Override
  public ProductDto getProductBySlug(String slug) {
    Product product= productRepository.findBySlug(slug);
    if(null == product){
      throw new ResourceNotFoundEx("Product Not Found!");
    }
    ProductDto productDto = productMapper.mapProductToDto(product);
    productDto.setCategoryId(product.getCategory().getId());
    productDto.setCategoryTypeId(product.getCategoryType().getId());
    productDto.setVariants(productMapper.mapProductVariantListToDto(product.getProductVariants()));
    productDto.setProductResources(productMapper.mapProductResourcesListDto(product.getResources()));
    return productDto;
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
