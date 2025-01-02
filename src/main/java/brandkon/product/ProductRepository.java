package brandkon.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByBrandId(Long brandId);
    List<Product> findByBrand_Category_Id(Long categoryId);
    List<Product> findTop5ByBrand_Category_IdOrderBySalesDesc(Long categoryId);
    List<Product> findTop5ByBrand_IdOrderBySalesDesc(Long brandId);

}
