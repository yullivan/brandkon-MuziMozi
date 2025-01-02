package brandkon.brand;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    List<Brand> findALLByCategoryId(Long categoryId);
}
