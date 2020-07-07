package com.aptech.ishop.service.impl;

import com.aptech.ishop.Storage.ProductStorage;
import com.aptech.ishop.entity.IProduct;
import com.aptech.ishop.entity.Product;
import com.aptech.ishop.model.ProductRequest;
import com.aptech.ishop.service.ProductService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductServiceServiceImpl implements ProductService {
    private final IProduct iProduct = new Product();
    private final ProductStorage productStorage = new ProductStorage();

    @Override
    public void save(List<ProductRequest> requests) {
        List<Product> products = new ArrayList<>();
        requests.forEach(productRequest -> {
            System.out.println(iProduct.inputData(productRequest).toString());
            products.add(iProduct.inputData(productRequest));
        });
        productStorage.saveAll(products);
    }

    @Override
    public void calProfit(List<Product> productList) {
        for (Product product : productList) {
            System.out.println("Da tinh xong loi nhuan san pham");
            iProduct.displayData(product);
        }
    }

    public void updateProductStatus(Scanner sc, List<Product> productList) {
        System.out.println("Nhap ma san pham muon cap nhat");
        String statusByID = sc.nextLine();
        for (Product product : productList) {
            if (statusByID.equalsIgnoreCase(product.getProductID())) {
                product.setProductStatus(!product.isProductStatus());
            }
        }
        System.out.println("Trang thai san pham da duoc cap nhat");
    }

    public void sortExportPrice(List<Product> productList) {
        productList.sort(Comparator.comparing(Product::getExportPrice));
        System.out.println("Danh sach san pham sau khi sap xep");
        for (Product product : productList) {
            iProduct.displayData(product);
        }
    }

    public void sortProfit(List<Product> productList) {
        productList.sort(Comparator.comparing(Product::getProfit));
        System.out.println("Danh sach san pham sau khi sap xep");
        for (Product product : productList) {
            iProduct.displayData(product);
        }
    }

    public void findByName(Scanner sc, List<Product> productList) {
        System.out.println("Nhap ten san pham ban muon tim");
        String nameFind = sc.nextLine();
        for (Product product : productList) {
            if (nameFind.equalsIgnoreCase(product.getProductName())) {
                iProduct.displayData(product);
            }
        }
    }

    public void updateInfoProduct(Scanner sc, List<Product> productList) {
        System.out.println("Nhap vao ma san pham muon cap nhat thong tin");
        String productId = null;
        try {
            productId = sc.nextLine();
        } catch (Exception e) {
            System.out.println("Ma san pham la so nguyen");
        }

        if (productId == null) return;
        for (Product product : productList) {
            if (!productId.equalsIgnoreCase(product.getProductID())) {
                System.out.println("Khong tim thay ma san pham can chinh sua");
                return;
            }

            String newName = sc.nextLine();
            do {
                if (newName.equalsIgnoreCase(product.getProductName())) {
                    System.out.println("Ten san pham da ton tai! try again.");
                } else {
                    product.setProductName(newName);
                    System.out.println("Update successfully!");
                    return;
                }
            } while (true);
        }
    }
}
