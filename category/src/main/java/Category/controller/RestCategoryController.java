package Category.controller;

import Category.model.Category;
import Category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

