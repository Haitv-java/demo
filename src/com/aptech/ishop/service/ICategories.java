package com.aptech.ishop.service;

import com.aptech.ishop.entity.Categories;

import java.util.List;
import java.util.Scanner;

public interface ICategories {
	void inputData(Scanner sc, List<Categories> categoriesList);
	void displayData(List<Categories> categoriesList);
	void treeCategories(List<Categories> categoriesList);
	void removeCategories(Scanner sc, List<Categories> categoriesList);
	void searchCategories(Scanner sc, List<Categories> categoriesList);
	void addCategoriestoProduct(Scanner sc, List<Categories> categoriesList);
	void inputData(Categories categories);
	void displayData(Categories categories);
}
