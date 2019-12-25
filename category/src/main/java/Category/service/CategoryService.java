package Category.service;

import Category.model.Category;
import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    List<Category> findById(Integer id);
}
