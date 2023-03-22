package rikkei.view;

import rikkei.config.Config;
import rikkei.controller.ProductController;
import rikkei.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductView {
    ProductController productController = new ProductController();
    List<Product> productList = productController.showListProduct();

    public void showtableProduct() {
        System.out.println("*****************Product Manage****************");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(
                    productList.get(i).getId() + "\n"
                            + productList.get(i).getName() + "\n"
                            + productList.get(i).getPrice()
            );
        }

    }

    public void createProduct() {
        int id = productController.showListProduct().get(productController.showListProduct().size() - 1).getId() + 1;
        System.out.println("Nhap ten san pham: ");
        String productName = Config.scanner().nextLine();
        System.out.println("Nhap gia san pham: ");
        double productPrice = Config.scanner().nextDouble();
        Product newProduct = new Product(id, productName, productPrice);
        productController.createProduct(newProduct);

    }

    public void deleteProduct() {
        System.out.println("Nhap id san pham muon xoa: ");
        int deleteById = Integer.parseInt(Config.scanner().nextLine());
        productController.deleteProduct(deleteById);
//        if (!= null) {
//            productController.deleteProduct(deleteById);
//            System.out.println("Delete Success!");
//        } else {
//            System.out.println("This ID does not exist");
//        }
//        System.out.println("Enter any key to exit or type -back- to come back Menu");
//        String backMenu = Config.scanner().nextLine();
//        if (backMenu.equalsIgnoreCase("back")) {
//            new Main();
//        }
    }

    public void searchProduct() {
        System.out.println("Nhập tên sản phẩm muốn tìm là: ");
        String searchName = Config.scanner().nextLine().toUpperCase();
        List<Product> searchList = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().toUpperCase().contains(searchName)) {
                searchList.add(productList.get(i));
            }
        }
        if (searchList.size() == 0) {
            System.out.println("Khong co san pham nay trong danh sach");
        } else {
            System.out.println(searchList);
        }
    }

    public void editProduct() {
        System.out.println("Nhap Id can su");
        int id = Integer.parseInt(Config.scanner().nextLine());
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                System.out.println("Day laf san pham muon sua: " + productList.get(i).toString());
            }
        }
        System.out.println("Nhap ten moi: ");
        String newName = Config.scanner().nextLine();
        System.out.println("Nhap gia moi: ");
        double newPrice = Config.scanner().nextDouble();
        Product newProduct = new Product(id, newName, newPrice);
        productController.createProduct(newProduct);
    }
}

