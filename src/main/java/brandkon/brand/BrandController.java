package brandkon.brand;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandController {

    private BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brands")
    public List<BrandResponse> readAllBrands(@RequestParam String category) {
        return brandService.getBrandsByCategory(category);
    }

    @GetMapping("/brands/{brandId}")
    public BrandResponse readBrand(@PathVariable Long brandId) {
        return brandService.getBrand(brandId);
    }
}
