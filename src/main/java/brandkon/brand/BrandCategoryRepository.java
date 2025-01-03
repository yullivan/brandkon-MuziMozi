package brandkon.brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BrandCategoryRepository extends JpaRepository<BrandCategory, Long> {

    @Query("SELECT bc.brand FROM BrandCategory bc WHERE bc.category.id = :categoryId")
    List<Brand> findBrandsByCategoryId(@Param("categoryId") Long categoryId);
}
