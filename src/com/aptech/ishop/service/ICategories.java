package com.aptech.ishop.service;

import com.aptech.ishop.entity.Categories;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public interface ICategories {
	void insertData(Scanner sc, Map<Integer, List<Categories>> categoriesMap);
	void displayData(List<Categories> categoriesList);
	void treeCategories(Map<Integer, List<Categories>> categoriesMap);
	void removeCategories(Scanner sc, List<Categories> categoriesList);
	void searchCategories(Scanner sc, List<Categories> categoriesList);
	void addCategoriestoProduct(Scanner sc, List<Categories> categoriesList);
	void insertData(Categories categories);
	void displayData(Categories categories);
}
