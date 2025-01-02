package brandkon.brand;

import brandkon.category.Category;

public record BrandRequest(String name, String imageUrl, Category category) {
}
