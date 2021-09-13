package com.codegym.controller;

import com.codegym.model.Category;

import java.util.ArrayList;
import java.util.List;


public class CategoryManagement implements IGeneralManagement<Category> {
    private List<Category> categories = new ArrayList<>();


    public List<Category> getCategories() {
        return categories;
    }


    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }




    public List<Category> getClassProducts() {
        return categories;
    }




    public void setClassProducts(List<Category> categories) {
        this.categories = categories;
    }




    @Override
    public void showAll() {
        for (Category category : categories) {
            System.out.println(category);
        }
    }



    @Override
    public void addNew(Category category) {
        categories.add(category);
    }




    @Override
    public void updateById(String id, Category category) {
        int index = findById(id);
        if (index != -1) {
            categories.set(index, category);
        } else {
            System.out.println("ID không hợp lệ !!!");
        }
    }



    @Override
    public void removeByID(String id) {
        int index = findById(id);
        if (index != -1) {
            categories.remove(index);
        } else {
            System.out.println("ID không hợp lệ !!!");
        }
    }




    @Override
    public int findById(String id) {
        int index = -1;
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int findByName(String name){
        int index = -1;
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getName().equals(name)) {
                index = i;
                break;
            }
        }
        return index;
    }
    public void displayByNameCategory(String name){
        int index = findByName(name);
        if(index !=-1){

        }
    }



    public Category findById(int index){
        return categories.get(index);
    }



}
