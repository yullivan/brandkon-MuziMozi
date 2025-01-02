package brandkon.brand;

import brandkon.category.Category;
import brandkon.category.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private BrandRepository brandRepository;
    private CategoryRepository categoryRepository;
    private CategoryBrandRepository categoryBrandRepository;

    public BrandService(BrandRepository brandRepository, CategoryRepository categoryRepository, CategoryBrandRepository categoryBrandRepository) {
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
        this.categoryBrandRepository = categoryBrandRepository;
    }

    public List<BrandResponse> getBrandsByCategory(String slug) {

        Category category = categoryRepository.findBySlug(slug);
        return categoryBrandRepository.findBrandsByCategoryId(category.getId())
                .stream()
                .map(brand -> new BrandResponse(
                        brand.getId(),
                        brand.getName(),
                        brand.getImageUrl()))
                .toList();
    }

    public BrandResponse getBrand(Long brandId) {

        Brand brand = brandRepository.findById(brandId).orElseThrow();
        return new BrandResponse(brand.getId(), brand.getName(), brand.getImageUrl());
    }
}
