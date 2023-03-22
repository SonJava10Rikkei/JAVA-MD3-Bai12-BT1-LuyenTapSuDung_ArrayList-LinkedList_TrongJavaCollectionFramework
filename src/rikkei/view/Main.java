package rikkei.view;

import rikkei.config.Config;

import java.util.Collections;

import static rikkei.service.ProductServiceIMPL.productList;

public class Main {
    public Main() {
        System.out.println("1. Thêm sản phẩm\n" +
                "2. Sửa thông tin sản phẩm theo id\n" +
                "3. Xoá sản phẩm theo id\n" +
                "4. Hiển thị danh sách sản phẩm\n" +
                "5. Sắp xếp sản phẩm theo giá từ thấp đến cao\n" +
                "6. Tìm kiếm sản phẩm theo tên\n" +
                "0. Thoắt\n" +
                " Mời bạn lựa chọn: \n"
        );
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(Config.scanner().nextLine());
                break;
            } catch (NumberFormatException Err) {
                System.err.println("Hãy nhập lại từ 0 đến 5");
            }
        }
        switch (choice) {
            case 1:
                ProductView createProductView = new ProductView();
                createProductView.createProduct();
                break;
            case 2:
                ProductView editProductView = new ProductView();
                editProductView.editProduct();
                break;
            case 3:
                ProductView deleteProductView = new ProductView();
                deleteProductView.deleteProduct();
                break;
            case 4:
                ProductView productView = new ProductView();
                productView.showtableProduct();
                break;
            case 5:
                Collections.sort(productList);
                break;
            case 6:
                ProductView timkiem = new ProductView();
                timkiem.searchProduct();
                break;
            case 0:
                System.out.println("Đã thoắt chương trình !");
                System.exit(0);
                break;
            default:
                System.err.println("Hãy nhập lại từ 0 đến 5 ");
        }
    }

    public static void main(String[] args) {
        do {
            new Main();
        } while (true);
    }
}
