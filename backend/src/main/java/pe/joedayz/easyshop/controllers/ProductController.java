package pe.joedayz.easyshop.controllers;

import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.joedayz.easyshop.dto.ProductDto;
import pe.joedayz.easyshop.entities.Product;
import pe.joedayz.easyshop.services.ProductService;

/**
 * @author josediaz
 **/
@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {

  private ProductService productService;

  @Autowired
  public ProductController(ProductService productService){
    this.productService = productService;
  }

  @GetMapping  //http://localhost:8080/api/products
  public ResponseEntity<List<ProductDto>> getAllProducts(@RequestParam(required = false,name = "categoryId",value = "categoryId") UUID categoryId,
      @RequestParam(required = false,name = "typeId",value = "typeId") UUID typeId,  @RequestParam(required = false)  String slug, HttpServletResponse response){
    List<ProductDto> productList = new ArrayList<>();
    if(StringUtils.isNotBlank(slug)){  // http://localhost:8080/api/products?slug=zapatillas-nike-men
      ProductDto productDto = productService.getProductBySlug(slug);
      productList.add(productDto);
    }
    else {
      productList = productService.getAllProducts(categoryId, typeId);
    }
    response.setHeader("Content-Range",String.valueOf(productList.size()));
    return new ResponseEntity<>(productList, HttpStatus.OK);
  }

  @GetMapping("/{id}") //http://localhost:8080/api/products/123412343124
  public ResponseEntity<ProductDto> getProductById(@PathVariable UUID id){
    ProductDto productDto = productService.getProductById(id);
    return new ResponseEntity<>(productDto, HttpStatus.OK);
  }

  //   create Product
  @PostMapping
  public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto){
    Product product = productService.addProduct(productDto);
    return new ResponseEntity<>(product,HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Product> updateProduct(@RequestBody ProductDto productDto,@PathVariable UUID id){
    Product product = productService.updateProduct(productDto,id);
    return new ResponseEntity<>(product,HttpStatus.OK);
  }



}
