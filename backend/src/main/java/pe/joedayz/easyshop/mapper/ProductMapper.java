package pe.joedayz.easyshop.mapper;

import java.util.List;
import org.springframework.stereotype.Component;
import pe.joedayz.easyshop.dto.ProductDto;
import pe.joedayz.easyshop.dto.ProductResourceDto;
import pe.joedayz.easyshop.dto.ProductVariantDto;
import pe.joedayz.easyshop.entities.Product;
import pe.joedayz.easyshop.entities.Resources;
import pe.joedayz.easyshop.entities.ProductVariant;
/**
 * @author josediaz
 **/
@Component
public class ProductMapper {


  public ProductDto mapProductToDto(Product product) {

    return ProductDto.builder()
        .id(product.getId())
        .brand(product.getBrand())
        .name(product.getName())
        .price(product.getPrice())
        .isNewArrival(product.isNewArrival())
        .rating(product.getRating())
        .description(product.getDescription())
        .slug(product.getSlug())
        .thumbnail(getProductThumbnail(product.getResources())).build();
  }

  public List<ProductResourceDto> mapProductResourcesListDto(List<Resources> resources) {
    return resources.stream().map(this::mapResourceToDto).toList();
  }

  private ProductResourceDto mapResourceToDto(Resources resources) {
    return ProductResourceDto.builder()
        .id(resources.getId())
        .url(resources.getUrl())
        .name(resources.getName())
        .isPrimary(resources.getIsPrimary())
        .type(resources.getType())
        .build();
  }

  public List<ProductVariantDto> mapProductVariantListToDto(List<ProductVariant> productVariants) {
    return productVariants.stream().map(this::mapProductVariantDto).toList();
  }

  private ProductVariantDto mapProductVariantDto(ProductVariant productVariant) {
    return ProductVariantDto.builder()
        .color(productVariant.getColor())
        .id(productVariant.getId())
        .size(productVariant.getSize())
        .stockQuantity(productVariant.getStockQuantity())
        .build();
  }

  private String getProductThumbnail(List<Resources> resources) {
    return resources.stream().filter(Resources::getIsPrimary).findFirst().orElse(null).getUrl();
  }
}
