package com.codegym.view;

import com.codegym.controller.CategoryManagement;
import com.codegym.model.Category;
import com.codegym.model.Product;

import static com.codegym.Main.scanner;
import static com.codegym.view.ProductMenu.productManagement;

public class CategoryMenu {

    public static CategoryManagement categoryManagement = new CategoryManagement();
    public static ProductMenu productMenu = new ProductMenu();
    public static AccountMenu accountMenu = new AccountMenu();
    public void run() {

        int choice;
        do {
            menu();
            System.out.println("Nhập lựa chọn");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    showAllCategory();
                    break;
                }

                case 2: {
                    addNewCategory();
                    break;
                }

                case 3: {
                    updateCategoryInfo();
                    break;
                }

                case 4: {
                    removeCategory();
                    break;
                }

                case 5: {
                    addProductToCategory();
                    break;
                }
                case 6: {
                    showProductInCategory();
                    break;
                }
                case 7: {
                    productMenu.run();
                    break;
                }
                case 8:{
                    accountMenu.run();
                    break;
                }
            }

        } while (choice != 0);
    }

    private void showProductInCategory() {
        System.out.println("Nhập tên danh sách muốn hiển thị: ");
        String name = scanner.nextLine();
        int index = categoryManagement.findByName(name);
        if (index != -1) {
            productManagement.displayByNameCategory(name);
        } else {
            System.out.println("Không có danh sách này !!");
        }
        System.out.println("");
        System.out.println("Nhấn Enter để tiếp tục !!");
        scanner.nextLine();

    }

    private void addProductToCategory() {
        System.out.println("Nhập mã danh sách muốn thêm sản phẩm vào: ");
        String id = scanner.nextLine();
        int index = categoryManagement.findById(id);
        if (index != -1) {
            Product product = inputNewProductToCatagory(id, index);
            productManagement.addNew(product);
            System.out.println("");
            System.out.println("Nhấn Enter để tiếp tục !!");
            scanner.nextLine();
        } else {
            System.out.println("Không có mã lớp này !!!");
            System.out.println(" Nhấn ENTER để quay về menu ");
            scanner.nextLine();
        }

    }

    private Product inputNewProductToCatagory(String id, int index) {
        Category category = categoryManagement.findById(index);
        System.out.println("Nhập id sản phẩm mà bạn muốn thêm vào danh sách: ");
        String productId = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm:  ");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày nhập kho: ");
        String wareHouseDay = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        double price = scanner.nextDouble();
        Product product = new Product(productId, name, wareHouseDay, price, category);
        return product;
    }

    private void removeCategory() {
        System.out.println(" Nhập mã danh sách sản phẩm muốn xóa: ");
        String id = scanner.nextLine();
        categoryManagement.removeByID(id);
        System.out.println("");
        System.out.println("Nhấn Enter để tiếp tục !!");
        scanner.nextLine();
    }

    private void updateCategoryInfo() {
        System.out.println("Nhập mã danh sách sản phẩm cần tìm: ");
        String id = scanner.nextLine();
        Category category = inputCategoryInfo();
        categoryManagement.updateById(id, category);
        System.out.println("");
        System.out.println("Nhấn Enter để tiếp tục !!");
        scanner.nextLine();
    }


    private void addNewCategory() {
        Category category = inputCategoryInfo();
        categoryManagement.addNew(category);
        System.out.println("");
        System.out.println("Nhấn Enter để tiếp tục !!");
        scanner.nextLine();
    }


    private Category inputCategoryInfo() {
        System.out.println("Nhập mã danh sách: ");
        String id = scanner.nextLine();
        System.out.println("Nhập tên danh sách: ");
        String name = scanner.nextLine();
        Category category = new Category(id, name);
        return category;
    }


    private void showAllCategory() {
        categoryManagement.showAll();
        System.out.println("");
        System.out.println("Nhấn Enter để tiếp tục !!");
        scanner.nextLine();
    }


    private void menu() {
        System.out.println("------Quản lí danh sách sản phẩm-------");
        System.out.println("1. Hiển thị danh sách sản phẩm");
        System.out.println("2. Thêm Danh sách sản phẩm");
        System.out.println("3. Cập nhật danh sách sản phẩm");
        System.out.println("4. Xóa danh sách sản phẩm");
        System.out.println("5. Thêm sản phẩm mới vào danh sách");
        System.out.println("6. Hiển thị sản phẩm theo danh sách");
        System.out.println("7. Quản lý sản phẩm");
        System.out.println("8. Quản lý tài khoản");
        System.out.println("0. Quay lại");
        System.out.println("---------------------------------------");
    }


}
