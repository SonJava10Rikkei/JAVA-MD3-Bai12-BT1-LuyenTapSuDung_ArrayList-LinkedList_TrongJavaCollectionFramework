package rikkei.service;

import rikkei.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void deleteById(int id);


}
