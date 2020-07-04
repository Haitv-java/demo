package com.aptech.ishop.controller;

import com.aptech.ishop.entity.Product;
import com.aptech.ishop.service.ProductService;
import com.aptech.ishop.service.impl.ProductServiceServiceImpl;
import com.aptech.ishop.utils.ShowMenu;

import java.util.List;
import java.util.Scanner;

public class ProductController {
    private final ProductService service = new ProductServiceServiceImpl();

    public void productCase(Scanner sc, List<Product> productList) {
        int choose;
        do {
            ShowMenu.showMenuQLSP();
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    service.inputData(sc, productList);
                    break;
                case 2:
                    service.calProfit(productList);
                    break;
                case 3:
                    displayProductInfo(productList, sc);
                    break;
                case 4:
                    productSorted(productList, sc);
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
        } while (choose != 7);
    }

    private void displayProductInfo(List<Product> productList, Scanner scanner) {
        int choose;
        do {
            ShowMenu.showMenuTTSP();
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    break;
                case 2:
                    service.findByName(scanner, productList);
                    break;
                case 3:
                    break;
                default:
                    System.err.println("Nhap lai lua chon cua ban (1-3)");
            }
            break;
        } while (choose != 3);
    }

    private void productSorted(List<Product> productList, Scanner scanner) {
        int choose;
        do {
            ShowMenu.showMenuSXSP();
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
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
        } while (choose != 3);
    }
}
