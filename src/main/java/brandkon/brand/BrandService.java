package brandkon.brand;

import brandkon.category.Category;
import brandkon.category.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private BrandRepository brandRepository;
    private CategoryRepository categoryRepository;

    public BrandService(BrandRepository brandRepository, CategoryRepository categoryRepository) {
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<BrandResponse> getBrandsByCategory(String slug) {

        Category category = categoryRepository.findBySlug(slug);
        return brandRepository.findALLByCategoryId(category.getId())
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
