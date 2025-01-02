package brandkon.product;

import brandkon.brand.Brand;
import brandkon.brand.BrandRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private BrandRepository brandRepository;

    public ProductService(ProductRepository productRepository, BrandRepository brandRepository) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
    }

    public List<ProductResponse> getAll(Long brandId) {

        if (brandId == null) {
            return mappingProductToResponse(productRepository.findAll());
        }
        return mappingProductToResponse(productRepository.findAllByBrandId(brandId));
    }

    private List<ProductResponse> mappingProductToResponse(List<Product> products) {
        return products
                .stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getBrand().getName(),
                        product.getName(),
                        product.getPrice(),
                        product.getImageUrl())).toList();
    }

    public ProductDetailResponse get(Long productId) {

        Product product = productRepository.findById(productId).orElseThrow();
        Brand brand = brandRepository.findById(product.getBrand().getId()).orElseThrow();

        return new ProductDetailResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                new BrandForDetailResponse(brand.getId(), brand.getName(), brand.getGuidelines()),
                product.getExpirationDays());
    }

    public List<ProductResponse> getPopular(Long categoryId, Long brandId) {

        if (brandId == null) {
            Pageable pageable = PageRequest.of(0, 5); // 상위 5개 상품만 가져옴
            return mappingProductToResponse(productRepository.findTop5ByCategoryIdOrderBySalesDesc(categoryId, pageable));
        }
        return mappingProductToResponse(productRepository.findTop5ByBrand_IdOrderBySalesDesc(brandId));
    }
}
