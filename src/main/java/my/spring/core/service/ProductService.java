package my.spring.core.service;


import lombok.Getter;
import my.spring.core.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//untuk membuat component cukup seperti ini

//kita juga bisa menambahkan beberapa annotation lain didalamnya seperti @Lazy dan @Scope
//@Lazy
//@Scope("prototype")
@Component//Class ini akan dibuatkan nama bean dari nama class yang di camelCase (productService)
public class ProductService {



    @Getter
    private ProductRepository productRepository;


    //Constructor-based Dependency Injection hanya mendukung 1 constuctor, jika ada 2 kita harus menggunakan @AutoWired dan memilih constructor mana yang ingin dijadikan constructor utamaw

    @Autowired//dengan menggunakan annotation ini kita bisa menulis multiple constructor, dengan syarat Spring akan mencari @AutoWired sebagai constructor yang digunakan
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    public ProductService(ProductRepository productRepository, String name) {
        this.productRepository = productRepository;
    }
}
