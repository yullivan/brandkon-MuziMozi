package brandkon.brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryBrandRepository extends JpaRepository<CategoryBrand, Long> {

    @Query("SELECT cb.brand FROM CategoryBrand cb WHERE cb.category.id = :categoryId")
    List<Brand> findBrandsByCategoryId(@Param("categoryId") Long categoryId);
}
