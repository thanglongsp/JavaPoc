package Book.controller;

import Book.model.Category;
import Book.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/category")
public class RestCategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/delete/{id}")
    public Boolean deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteCategory(id);
        return true;
    }

}