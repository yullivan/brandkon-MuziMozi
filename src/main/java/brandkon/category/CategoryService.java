package brandkon.category;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponse saveCategory(CategoryRequest request) {

        Category category = categoryRepository.save(new Category(request.name(), request.slug(), request.imageUrl()));
        return new CategoryResponse(category.getId(), category.getName(), category.getSlug(), category.getImageUrl());
    }

    public List<CategoryResponse> getCategory() {

        return categoryRepository.findAll()
                .stream()
                .map(category -> new CategoryResponse(
                        category.getId(),
                        category.getName(),
                        category.getSlug(),
                        category.getImageUrl()))
                .toList();
    }
}
