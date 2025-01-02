package brandkon.category;

import brandkon.brand.Brand;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String slug;
    private String imageUrl;

    @ManyToMany
    @JoinTable(
            name = "category_brand", // 중간 테이블 이름
            joinColumns = @JoinColumn(name = "category_id"), // 카테고리 쪽 외래키
            inverseJoinColumns = @JoinColumn(name = "brand_id") // 브랜드 쪽 외래키
    )
    private Set<Brand> brands = new HashSet<>();

    public Category() {
    }

    public Category(String name, String slug, String imageUrl, Set<Brand> brands) {
        this.name = name;
        this.slug = slug;
        this.imageUrl = imageUrl;
        this.brands = brands;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<Brand> getBrands() {
        return brands;
    }

    public void setBrands(Set<Brand> brands) {
        this.brands = brands;
    }
}
