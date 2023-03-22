package rikkei.controller;

import rikkei.model.Product;
import rikkei.service.ProductServiceIMPL;

import java.util.List;

public class ProductController {
    ProductServiceIMPL productServiceIMPL = new ProductServiceIMPL();

    public List<Product> showListProduct() {
        return productServiceIMPL.findAll();
    }

    public void createProduct(Product product) {
        productServiceIMPL.save(product);
    }

    public void deleteProduct(int id) {
        productServiceIMPL.deleteById(id);
    }


}
