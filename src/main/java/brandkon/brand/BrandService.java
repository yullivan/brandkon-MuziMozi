package brandkon.brand;

import brandkon.category.Category;
import brandkon.category.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private BrandRepository brandRepository;
    private CategoryRepository categoryRepository;
    private BrandCategoryRepository brandCategoryRepository;

    public BrandService(BrandRepository brandRepository, CategoryRepository categoryRepository, BrandCategoryRepository brandCategoryRepository) {
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
        this.brandCategoryRepository = brandCategoryRepository;
    }

    public List<BrandResponse> getBrandsByCategory(String slug) {

        Category category = categoryRepository.findBySlug(slug);
        return brandCategoryRepository.findBrandsByCategoryId(category.getId())
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
