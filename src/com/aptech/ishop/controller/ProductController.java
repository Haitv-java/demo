package com.aptech.ishop.controller;

import com.aptech.ishop.model.ProductRequest;
import com.aptech.ishop.service.ProductService;
import com.aptech.ishop.service.impl.ProductServiceServiceImpl;
import com.aptech.ishop.utils.ScannerCommon;
import com.aptech.ishop.utils.ShowMenu;

import java.util.ArrayList;
import java.util.List;

public class ProductController {
    private final ProductService service = new ProductServiceServiceImpl();
    private final ProductRequest requestBody = new ProductRequest();

    public void productCase() {
        int choose;
        do {
            ShowMenu.showMenuQLSP();
            choose = ScannerCommon.integerInput();
            switch (choose) {
                case 1:
                    service.createProduct(formInputCreateProduct());
                    break;
                case 2:
                    service.calProfit();
                    break;
                case 3:
                    displayProductInfo();
                    break;
                case 4:
                    productSorted();
                    break;
                case 5:
                    service.updateInfoProduct(formInputUpdateProduct());
                    break;
                case 6:
                    System.out.println("Nhap productId muon cap nhat thong tin");
                    String productId = ScannerCommon.stringInput();
                    service.updateProductStatus(productId);
                    break;
                case 7:
                    break;
                default:
                    System.err.println("Nhap lai lua chon cua ban");
            }
        } while (choose != 7);
    }

    private void displayProductInfo() {
        int choose;
        do {
            ShowMenu.showMenuTTSP();
            choose = ScannerCommon.integerInput();
            switch (choose) {
                case 1:
                    service.getAllProducts();
                    break;
                case 2:
                    System.out.println("Nhap ten san pham ban muon tim");
                    ScannerCommon.nextLine();
                    service.findByName(ScannerCommon.stringInput());
                    break;
                default:
                    System.err.println("Nhap lai lua chon cua ban (1-3)");
            }
        } while (choose != 3);
    }

    private void productSorted() {
        int choose;
        do {
            ShowMenu.showMenuSXSP();
            choose = ScannerCommon.integerInput();
            switch (choose) {
                case 1:
                    service.sortExportPrice();
                    break;
                case 2:
                    service.sortProfit();
                    break;
                case 3:
                    break;
                default:
                    System.err.println("Nhap lai lua chon cua ban (1-3)");
            }
        } while (choose != 3);
    }

    private List<ProductRequest> formInputCreateProduct() {
        System.out.println("Nhap so san pham can them");
        List<ProductRequest> productRequests = new ArrayList<>();
        int addProductSize = ScannerCommon.integerInput();
        ScannerCommon.nextLine();
        for (int i = 0; i < addProductSize; i++) {
            productRequests.add(requestBody.initRequestBody());
        }
        return productRequests;
    }

    private ProductRequest formInputUpdateProduct() {
        System.out.println("Nhap productId muon cap nhat thong tin");
        String productId = ScannerCommon.stringInput();
        System.out.println("Nhap productName muon cap nhat thong tin");
        String productName = ScannerCommon.stringInput();
        ProductRequest productRequest = new ProductRequest();
        productRequest.setProductID(productId);
        productRequest.setProductName(productName);
        return productRequest;
    }
}
