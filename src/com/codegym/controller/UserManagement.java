package com.codegym.controller;

import com.codegym.model.User;

import java.util.ArrayList;
import java.util.List;

import static com.codegym.Main.scanner;

public class UserManagement implements IGeneralManagement<User> {
    private List<User> users = new ArrayList<>();



    public List<User> getUsers() {
        return users;
    }


    public void setUsers(List<User> users) {
        this.users = users;
    }



    @Override
    public void showAll() {
        int count =0;
        for (User user : users) {
            System.out.println("user"+(count+1)+user);
            count++;
        }
    }


    @Override
    public void addNew(User user) {
        users.add(user);
    }


    @Override
    public void updateById(String name, User user) {
        int index = findById(name);
        if(index !=-1){
            users.set(index,user);
        }else{
            System.err.println("tên tài khoản không hợp lệ !!!");
            scanner.nextLine();
        }
    }



    public void removeByName(String name) {
        int index = findByName(name);
        if(index !=-1){
            users.remove(index);
        }else{
            System.err.println("tên tài khoản không hợp lệ !!!");
            scanner.nextLine();
        }
    }



    public int findByName(String username) {
        int index = -1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(username)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public void removeByID(String id) {

    }

    @Override
    public int findById(String id) {
        return 0;
    }

    public User isLogin(User user) {
        for (User user1 : users) {
            if (user.getUserName().equals(user1.getUserName()) && user.getPassWord().equals(user1.getPassWord())) {
                return user1;
            }
        }
        return null;
    }
    public boolean isLoginAdmin(User user){
        if(user.getRole().equals("admin")){
            return true;
        }
        return false;
    }

    public void changePassword(String username){
       int index = findByName(username);
       if(index!=-1){
           System.out.println("Nhập mật khẩu mới:");
           String password = scanner.nextLine();
           users.get(index).setPassWord(password);
           System.out.println("Đã đổi mật khẩu thành công !!!");
       }else{
           System.out.println("Không có tài khoản này!!!");
       }
        scanner.nextLine();
    }

}
