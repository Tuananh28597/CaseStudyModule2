package com.codegym;

import com.codegym.view.CategoryMenu;
import com.codegym.view.LoginMenu;
import com.codegym.view.ProductMenu;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.run();


    }


}
