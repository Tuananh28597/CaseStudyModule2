package com.codegym.view;

import com.codegym.controller.UserManagement;
import com.codegym.model.User;

import static com.codegym.Main.scanner;

public class AccountMenu {
    public static UserManagement userManagement =new UserManagement();

    public void run(){

        int choice;
        do{
            menu();
            System.out.println("Nhập lựa chọn");
            choice =scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:{
                    showAllAccount();
                    break;
                }
                case 2:{
                    addNewAccount();
                    break;
                }
                case 3:{
                    changeThePassword();
                    break;
                }
                case 4:{
                    removeAccount();
                    break;
                }
            }
        }while(choice!=0);


    }

    private void changeThePassword() {
        System.out.println("-----Đổi Mật Khẩu-------");
        System.out.println("Nhập username :");
        String name = scanner.nextLine();
        userManagement.changePassword(name);
    }

    private void addNewAccount() {
        System.out.println("---Tạo tài khoản mới -----");
        System.out.println("Nhập username:");
        String username =scanner.nextLine();
        System.out.println("Nhập password: ");
        String password = scanner.nextLine();
        String role = "";
        do{
            System.out.println("Nhập quyền hạn cho account(admin/user): ");
            role = scanner.nextLine();
        }while(!role.equals("admin") && !role.equals("user"));
        User user = new User(username,password,role);
        userManagement.addNew(user);

    }

    private void removeAccount() {
        System.out.println("Nhập username của account muốn xóa: ");
        String name = scanner.nextLine();
        userManagement.removeByName(name);
    }

    private void showAllAccount() {
        userManagement.showAll();
    }

    private void menu() {
        System.out.println("-------Quản lý tài khoản-------");
        System.out.println("1.Hiển thị danh sách tài khoản");
        System.out.println("2.Thêm tài khoản");
        System.out.println("3.Đổi mật khẩu");
        System.out.println("4.Xóa tài khoản");
        System.out.println("0.Thoát");
    }

}
