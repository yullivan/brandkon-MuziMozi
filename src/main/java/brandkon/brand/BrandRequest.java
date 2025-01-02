package brandkon.brand;

import brandkon.category.Category;

public record BrandRequest(String name, String imageUrl, String guidelines, Category category) {
}
