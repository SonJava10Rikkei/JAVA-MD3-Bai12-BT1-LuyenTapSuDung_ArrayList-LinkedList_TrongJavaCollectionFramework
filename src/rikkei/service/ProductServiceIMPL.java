package rikkei.service;

import rikkei.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceIMPL implements IProductService {
    public static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Ao thun", 100000));
        productList.add(new Product(2, "Quan au", 300000));
        productList.add(new Product(3, "Giay da", 200000));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        if (findById(product.getId()) != null) {
            int index = productList.indexOf(findById(product.getId()));
            productList.set(index, product);
        } else {
            productList.add(product);
        }

    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(i);
            }
        }
    }

}
