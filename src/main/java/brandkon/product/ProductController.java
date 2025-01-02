package brandkon.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductResponse> readAllProducts(@RequestParam(required = false) Long brandId) {
        return productService.getAll(brandId);
    }

    @GetMapping("/products/{productId}")
    public ProductDetailResponse readProduct(@PathVariable Long productId) {
        return productService.get(productId);
    }

    @GetMapping("/products/popular")
    public List<ProductResponse> readPopularProducts(
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Long brandId) {
        return productService.getPopular(categoryId, brandId);
    }
}
