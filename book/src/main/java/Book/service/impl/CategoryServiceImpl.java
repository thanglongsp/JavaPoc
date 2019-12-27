package Book.service.impl;

import Book.model.Category;
import Book.repository.BookRepository;
import Book.repository.CategoryRepository;
import Book.service.BookService;
import Book.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> findById(Integer id) {
        return null;
    }

    @Transactional
    @Override
    public Boolean deleteCategory(int id) {
        try {
            categoryRepository.deleteById(id);
            bookRepository.deleteByCategory(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}