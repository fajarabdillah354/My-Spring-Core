package my.spring.core.service;

import lombok.Getter;
import my.spring.core.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryService {

    @Getter
    private CategoryRepository categoryRepository;

    @Autowired//kita juga bisa menggunakan setter yang di tambahkan dengan @AutoWired sebagai untuk Dependency ke Component
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
