package brandkon.brand;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandResponse> getBrandsByCategory(String category) {

        return brandRepository.findALLByCategory(category)
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
