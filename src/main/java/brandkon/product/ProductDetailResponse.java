package brandkon.product;

import brandkon.brand.Brand;

public record ProductDetailResponse(Long productId, String productName, int price, BrandForDetailResponse brand, int expirationDays) {
}
