package com.codegym.view;


import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.model.User;

import static com.codegym.Main.scanner;
import static com.codegym.view.AccountMenu.userManagement;
import static com.codegym.view.CategoryMenu.categoryManagement;
import static com.codegym.view.ProductMenu.productManagement;

public class LoginMenu {


    public static void run() {
        addAccountInProgram();
        addCategoryInProgram();
        addNewProduct();
        int choice;
        do {
            menu();
            System.out.println("Nhập lựa chọn");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    doLogin();
                    break;
                }
                case 2: {
                    doRegister();
                    break;
                }
            }

        } while (choice != 0);
    }

    private static void addNewProduct() {
        productManagement.addNew(new Product("01","Cá hồi","7/9/2021",280000));
        productManagement.addNew(new Product("02","Cá ngừ","7/9/2021",200000));
        productManagement.addNew(new Product("03","Thịt bò mỹ","7/9/2021",100000));
        productManagement.addNew(new Product("04","Thịt bò việt","7/9/2021",90000));
        productManagement.addNew(new Product("05","Thịt lợn","7/9/2021",50000));
    }

    private static void addCategoryInProgram() {
        categoryManagement.addNew(new Category("1","Đồ tươi sống"));
        categoryManagement.addNew(new Category("2","Rau, củ, quả"));
        categoryManagement.addNew(new Category("3","Đồ khô"));
        categoryManagement.addNew(new Category("4","Bánh kẹo, sữa"));
        categoryManagement.addNew(new Category("5","Đồ uống"));
    }

    private static void addAccountInProgram() {
        userManagement.addNew(new User( "admin", "1", "admin"));
        userManagement.addNew(new User( "user1", "1", "user"));
        userManagement.addNew(new User( "user2", "1", "user"));
    }

    private static void doRegister() {
        System.out.println("Tạo tài khoản mới");
        System.out.println("Nhập username: ");
        String username = scanner.nextLine();
        System.out.println("Nhập password: ");
        String password = scanner.nextLine();
        User user = new User(username, password);
        user.setRole("user");
        userManagement.addNew(user);
    }

    private static void doLogin() {
        CategoryMenu categoryMenu = new CategoryMenu();
        ProductMenu productMenu = new ProductMenu();
        System.out.println("-----------LOGIN------------");
        System.out.println("Nhập username: ");
        String username = scanner.nextLine();
        System.out.println("Nhập password: ");
        String password = scanner.nextLine();
        System.out.println("----------------------------");
        User userLogin = new User(username, password);
        User user = userManagement.isLogin(userLogin);
        if (user != null) {
            if (userManagement.isLoginAdmin(user)) {
                showAdmin();
            } else {
                showUser();
            }
        } else {
            System.err.println("Sai tên tài khoản hoặc mật khẩu !!!!");
            scanner.nextLine();
    }


    }

    private static void showUser() {
        UserShoppingMenu userShoppingMenu = new UserShoppingMenu();
        userShoppingMenu.run();
    }

    private static void showAdmin() {
        CategoryMenu categoryMenu= new CategoryMenu();
        ProductMenu productMenu = new ProductMenu();
        int choice;
        do {
            menuAdmin();
            System.out.println("Nhập lựa chọn");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    categoryMenu.run();
                    break;
                }


            }
        } while (choice != 2);
    }

    private static void menu() {
        System.out.println("------ SIÊU THỊ GENGOLD KÍNH CHÀO QUÝ KHÁCH ------");
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng kí");
        System.out.println("3. Thoát");
        System.out.println("--------------------------------");
    }
    private static void menuAdmin() {
        System.out.println("--------Quản lý Bán Hàng--------");
        System.out.println("1. Quản lý danh sách sản phẩm");
        System.out.println("2. Đăng xuất");
        System.out.println("---------------------------------");
    }
}
