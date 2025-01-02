package brandkon.product;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByBrandId(Long brandId);
    @Query("SELECT p FROM Product p WHERE p.brand.id IN " +
            "(SELECT cb.brand.id FROM CategoryBrand cb WHERE cb.category.id = :categoryId)")
    List<Product> findProductsByCategoryId(@Param("categoryId") Long categoryId);
    @Query("SELECT p FROM Product p WHERE p.brand.id IN " +
            "(SELECT cb.brand.id FROM CategoryBrand cb WHERE cb.category.id = :categoryId) " +
            "ORDER BY p.sales DESC")
    List<Product> findTop5ByCategoryIdOrderBySalesDesc(@Param("categoryId") Long categoryId, Pageable pageable);
    List<Product> findTop5ByBrand_IdOrderBySalesDesc(Long brandId);

}
