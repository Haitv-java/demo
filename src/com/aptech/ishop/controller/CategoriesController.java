package com.aptech.ishop.controller;

import com.aptech.ishop.entity.Categories;
import com.aptech.ishop.service.ICategories;
import com.aptech.ishop.utils.ShowMenu;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.err;

public class CategoriesController {
    private ICategories service;

    public CategoriesController(ICategories service) {
        this.service = service;
    }

    public void rootOneCase(List<Categories> categoriesList, Scanner sc) {
        int choose1;
        do {
            ShowMenu.showMenuQL();
            choose1 = Integer.parseInt(sc.nextLine());
            switch (choose1) {
                case 1:
                    int choose1a = 0;
                    do {
                        ShowMenu.showMenuDS();
                        choose1a = Integer.parseInt(sc.nextLine());
                        switch (choose1a) {
                            case 1:
                                service.treeCategories(categoriesList);
                                break;
                            case 2:
                                service.displayData(categoriesList);
                                break;
                            case 3:
                                break;
                            default:
                                err.println("Nhap lai lua chon cua ban (1-3)");
                        }
                    } while (choose1a != 3);
                    break;

                case 2:
                    service.inputData(sc, categoriesList);
                    break;
                case 3:
                    service.removeCategories(sc, categoriesList);
                    break;
                case 4:
                    service.searchCategories(sc, categoriesList);
                    break;
                case 5:
                    break;
                default:
                    err.println("Nhap lai lua chon cua ban");
            }
        } while (choose1 != 5);
    }
}
