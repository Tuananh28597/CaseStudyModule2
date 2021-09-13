package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductManagement implements IGeneralManagement<Product> {
    private List<Product> products = new ArrayList<>();



    public List<Product> getProducts() {
        return products;
    }




    public void setProducts(List<Product> products) {
        this.products = products;
    }



    public void showShoppingProductList(){
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).display());
        }
    }


    @Override
    public void showAll() {
        for (Product product : products) {
            System.out.println(product);
        }
    }




    @Override
    public void addNew(Product product) {
        products.add(product);
    }





    @Override
    public void updateById(String id, Product product) {
        int index = findById(id);
        if (index != -1) {
            products.set(index, product);
        } else {
            System.out.println("ID không hợp lệ !!!");
        }
    }





    @Override
    public void removeByID(String id) {
        int index = findById(id);
        if (index != -1) {
            products.remove(index);
        } else {
            System.out.println("ID không hợp lệ !!!");
        }
    }




    @Override
    public int findById(String id) {
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }


    public int findByName(String name){
            int index = -1;
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getName().equals(products)) {
                    index = i;
                    break;
                }
            }
            return index;
        }
        public void displayByNameCategory(String name){
        int index = findByName(name);
        if(index !=-1){
            if(products.get(index).getCategory().equals(findByName(name))){
                for (Product product: products) {
                    System.out.println(product);
                }
            }
        }
        }


    public void addProductToCategory(int index, Category category){
        Product product = products.get(index);
        product.setCategory(category);
        products.set(index,product);
    }




    public void findProductByNameFromKeyBoard(String name){
        for(Product product:products){
            if(product.getName().equals(name)){
                System.out.println(product);
            }else{
                System.out.println("Không có sản phẩm nào có tên vừa nhập !!!");
            }
        }
    }



    //Đọc và ghi file sản phẩm
    public  void writeProductToFile() {
        try {
            FileWriter fw = new FileWriter("productList.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Product product : products) {
                bw.write(String.valueOf(product));
                bw.newLine();
            }
            bw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Ghi thành công !!!!");

    }
    public  void readProductFromFile(){
        try {
            FileReader fileReader = new FileReader("productList.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";

            while (true){
                if(line== null){
                    break;
                }
                line =bufferedReader.readLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void sortProduct() {
//        Collections.sort(products, new Comparator<Product>() {
//            @Override
//            public int compare(Product o1, Product o2) {
//                if (o1.getPrice() < o2.getPrice()) {
//                    return -1;
//                }
//                return 1;
//            }
//        });
//    }
    public void sortProduct() {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                }else if(o1.getPrice() == o2.getPrice()){
                    return 0;
                }else{
                    return -1;
                }
            }
        });
    }

}
