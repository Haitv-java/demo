package com.aptech.ishop.service.impl;

import com.aptech.ishop.Storage.ProductStorage;
import com.aptech.ishop.entity.IProduct;
import com.aptech.ishop.entity.Product;
import com.aptech.ishop.model.ProductRequest;
import com.aptech.ishop.service.ProductService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductServiceServiceImpl implements ProductService {
    private final IProduct iProduct = new Product();
    private final ProductStorage productStorage = new ProductStorage();

    @Override
    public void createProduct(List<ProductRequest> requests) {
        List<Product> products = new ArrayList<>();
        requests.forEach(productRequest -> {
            System.out.println(iProduct.inputData(productRequest).toString());
            products.add(iProduct.inputData(productRequest));
        });
        productStorage.saveAll(products);
    }

    @Override
    public void getAllProducts() {
        List<Product> products = productStorage.getAll();
        products.forEach(System.out::println);
    }

    @Override
    public void calProfit() {
        List<Product> products = productStorage.getAll();
        for (Product product : products) {
            System.out.println("Da tinh xong loi nhuan san pham");
            iProduct.calProfit(product);
        }
    }

    public void updateProductStatus(String productId) {
        List<Product> products = productStorage.getAll();
        System.out.println("Nhap ma san pham muon cap nhat");
        for (Product product : products) {
            if (productId.equalsIgnoreCase(product.getProductID())) {
                product.setProductStatus(!product.isProductStatus());
            }
        }
        System.out.println("Trang thai san pham da duoc cap nhat");
    }

    public void sortExportPrice() {
        List<Product> products = productStorage.getAll();
        products.sort(Comparator.comparing(Product::getExportPrice));
        System.out.println("Danh sach san pham sau khi sap xep");
        for (Product product : products) {
            iProduct.displayData(product);
        }
    }

    public void sortProfit() {
        List<Product> products = productStorage.getAll();
        products.sort(Comparator.comparing(Product::getProfit));
        System.out.println("Danh sach san pham sau khi sap xep");
        for (Product product : products) {
            iProduct.displayData(product);
        }
    }

    public void findByName(String productName) {
        List<Product> products = productStorage.getAll();
        if (products.isEmpty()) System.out.println("Empty products!");
        Product product = null;
        for (Product productLocal : products) {
            if (productName.equalsIgnoreCase(productLocal.getProductName())) {
                product = productLocal;
            }
        }
        if (product == null) System.out.println("Not found Product with name: " + productName);
    }

    public void updateInfoProduct(ProductRequest request) {
        List<Product> products = productStorage.getAll();
        for (Product product : products) {
            if (!request.getProductID().equalsIgnoreCase(product.getProductID())) {
                System.out.println("Khong tim thay ma san pham can chinh sua");
                return;
            }
            do {
                if (request.getProductName().equalsIgnoreCase(product.getProductName())) {
                    System.out.println("Ten san pham da ton tai! try again.");
                } else {
                    product.setProductName(request.getProductName());
                    System.out.println("Update successfully!");
                    return;
                }
            } while (true);
        }
    }
}


