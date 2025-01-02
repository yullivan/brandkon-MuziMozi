package brandkon.product;

import brandkon.brand.Brand;

public record ProductRequest(Brand brand, String productName, int price, String imageUrl) {
}
