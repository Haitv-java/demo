package com.aptech.ishop.controller;

import com.aptech.ishop.entity.Product;
import com.aptech.ishop.service.IProduct;
import com.aptech.ishop.utils.ShowMenu;

import java.util.List;
import java.util.Scanner;

public class ProductController {
    private IProduct service;

    public ProductController(IProduct service) {
        this.service = service;
    }

    public void rootTwoCase(Scanner sc, List<Product> productList) {
        int choose2;
        do {
            ShowMenu.showMenuQLSP();
            choose2 = Integer.parseInt(sc.nextLine());
            switch (choose2) {
                case 1:
                    service.inputData(sc, productList);
                    break;
                case 2:
                    service.calProfit(productList);
                    break;
                case 3:
                    int choose2a;
                    do {
                        ShowMenu.showMenuTTSP();
                        choose2a = Integer.parseInt(sc.nextLine());
                        switch (choose2a) {
                            case 1:
                                break;
                            case 2:
                                service.findByName(sc, productList);
                                break;
                            case 3:
                                break;
                            default:
                                System.err.println("Nhap lai lua chon cua ban (1-3)");
                        }
                        break;
                    } while (choose2a != 3);

                    break;
                case 4:
                    int choose2b;
                    do {
                        ShowMenu.showMenuSXSP();
                        choose2b = Integer.parseInt(sc.nextLine());
                        switch (choose2b) {
                            case 1:
                                service.sortExportPrice(productList);
                                break;
                            case 2:
                                service.sortProfit(productList);
                                break;
                            case 3:
                                break;
                            default:
                                System.err.println("Nhap lai lua chon cua ban (1-3)");
                        }
                    } while (choose2b != 3);
                    break;
                case 5:
                    service.updateInfoProduct(sc, productList);
                    break;
                case 6:
                    service.updateProductStatus(sc, productList);
                    break;
                case 7:
                    break;
                default:
                    System.err.println("Nhap lai lua chon cua ban");
            }
        } while (choose2 != 7);
    }
}
