package com.codegym.view;
import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.model.User;

import static com.codegym.Main.scanner;
import static com.codegym.view.AccountMenu.userManagement;
import static com.codegym.view.CategoryMenu.categoryManagement;
import static com.codegym.view.ProductMenu.productManagement;

public class UserShoppingMenu {

    public static void run(){
        int choice;

        do {
            menu();
            System.out.println("NHẬP LỰA CHỌN CỦA QUÝ KHÁCH");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:{
                    joinShoppingMenu();
                    break;
                }
                case 2:{
                    cartManager();
                    break;
                }
                case 3:{
                    accountManager();
                    break;
                }

            }
        }while(choice!=4);





    }

    private static void accountManager() {
    }


    private static void cartManager() {
    }


    private static void joinShoppingMenu() {
        System.out.println("Tất cả sản phẩm");
        productManagement.showShoppingProductList();
        scanner.nextLine();
    }


    private static void menu() {
        System.out.println("-------SIÊU THỊ SIÊU VIP MÙA DỊCH KÍNH CHÀO QUÝ KHÁCH---------");
        System.out.println("1.MUA HÀNG");
        System.out.println("2.QUẢN LÝ GIỎ HÀNG");
        System.out.println("3.QUẢN LÝ TÀI KHOẢN");
        System.out.println("4.ĐĂNG XUẤT");
    }
}
