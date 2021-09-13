package com.codegym.view;

import com.codegym.controller.ProductManagement;
import com.codegym.model.Product;

import static com.codegym.Main.scanner;

public class ProductMenu {
    public static ProductManagement productManagement = new ProductManagement();

    public void run(){

        int choice;
        do{
            menu();
            System.out.println("Nhập lựa chọn");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:{
                    showProductList();
                    break;
                }

                case 2:{
                    addNewProduct();
                    break;
                }

                case 3:{
                    updateProductInfo();
                    break;
                }
                case 4:
                {
                    deleteProduct();
                    break;
                }
                case 5:{
                    findProductByName();
                    break;
                }
                case 6:{
                    writeProductListToFile();
                    break;
                }
                case 7:{
                    ReadProductFromFile();
                    break;
                }
                case 8:{
                    sortProductList();
                    break;
                }

            }
        }while(choice!=0);




    }

    private void sortProductList() {
        productManagement.sortProduct();
    }

    private void ReadProductFromFile() {
        productManagement.readProductFromFile();
    }

    private void writeProductListToFile() {
        productManagement.writeProductToFile();
    }

    private void findProductByName() {
        System.out.println("Nhập tên sản phẩm muốn tìm: ");
        String name = scanner.nextLine();
        productManagement.findProductByNameFromKeyBoard(name);



    }

    private void deleteProduct() {
        System.out.println("Nhập mã sản phẩm muốn xóa: ");
        String id = scanner.nextLine();
        productManagement.removeByID(id);
    }

    private void updateProductInfo() {
        System.out.println("Nhập mã sản phẩm cần chỉnh sửa: ");
        String id = scanner.nextLine();
        Product product = inputNewProdcutInfo();
        productManagement.updateById(id,product);

    }

    private void addNewProduct() {
        Product product = inputNewProdcutInfo();
        productManagement.addNew(product);


    }

    private Product inputNewProdcutInfo() {
        System.out.println("Nhập id sản phẩm: ");
        String id = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        double price = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập ngày nhập kho: ");
        String wareHouseDay = scanner.nextLine();

        Product product = new Product(id,name,wareHouseDay,price);
        return product;
    }

    private void showProductList() {
        productManagement.showAll();
    }

    private void menu() {
        System.out.println("");
        System.out.println("---------Quản lý sản phẩm---------");
        System.out.println("1.Hiển thị danh sách sản phẩm");
        System.out.println("2.Thêm sản phẩm");
        System.out.println("3.Cập nhật thông tin sản phẩm");
        System.out.println("4.Xóa sản phẩm");
        System.out.println("5.Tìm kiếm sản phẩm");
        System.out.println("6.Ghi danh sách sản phẩm ra File");
        System.out.println("7.Đọc dữ liệu File");
        System.out.println("8.Sắp xếp lại danh sách theo giá tiền");
        System.out.println("0. Thoát");
        System.out.println("----------------------------------");
    }
}
