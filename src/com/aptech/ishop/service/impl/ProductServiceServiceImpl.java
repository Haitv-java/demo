package com.aptech.ishop.service.impl;

import com.aptech.ishop.entity.IProduct;
import com.aptech.ishop.entity.Product;
import com.aptech.ishop.service.ProductService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static com.aptech.ishop.utils.Constant.*;

public class ProductServiceServiceImpl implements ProductService {
    private final IProduct iProduct = new Product();

    @Override
    public void inputData(Scanner sc, List<Product> productList) {
        System.out.println("Nhap so san pham can them");
        int addProductSize = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < addProductSize ; i++) {
            Product product = new Product();
            if (productList.isEmpty()) {
                iProduct.inputData(product, sc, null);
            }
            for (Product existProduct : productList) {
                iProduct.inputData(product, sc, existProduct);
            }
            productList.add(product);
        }
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
            break;
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

    public static void writeObjectFileProduct(List<Product> productList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File file = new File(FILE_PRODUCT_NAME);
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<Product> readObjectProductList() {
        File file = new File(FILE_PRODUCT_NAME);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<Product> productList = new ArrayList<>();
        if(file.exists()) {
            try {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                productList = (List<Product>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
        return productList;
    }
}
