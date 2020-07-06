package com.aptech.ishop.Storage;

import com.aptech.ishop.entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.aptech.ishop.utils.Constant.FILE_PRODUCT_NAME;

public class ProductStorage {
    public static List<Product> productRepository = readObjectProductList();

    public void saveAll(List<Product> products) {
        System.out.println(productRepository);
        productRepository.addAll(products);
        System.out.println("Save product successfully!");
    }

    public void save(Product product) {
        productRepository.add(product);
        System.out.println("Save product successfully!");
    }

    public List<Product> getAll() {
        return productRepository;
    }

    public static void writeObjectFileProduct() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File file = new File(FILE_PRODUCT_NAME);
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(productRepository);
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
        if(file.exists()) {
            try {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                productRepository = (List<Product>) ois.readObject();
                if (productRepository == null) return new ArrayList<>();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return productRepository;
    }
}
