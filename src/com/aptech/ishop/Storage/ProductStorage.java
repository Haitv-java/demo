package com.aptech.ishop.Storage;

import com.aptech.ishop.entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.aptech.ishop.utils.Constant.FILE_PRODUCT_NAME;

public class ProductStorage {
    private List<Product> productRepository = new ArrayList<>();

    public void saveAll(List<Product> products) {
        System.out.println(productRepository);
        productRepository.addAll(products);
        writeObjectToFile(products);
        System.out.println("Save product successfully!");
    }

    public void save(Product product) {
        productRepository.add(product);
        writeObjectToFile(Collections.singletonList(product));
        System.out.println("Save product successfully!");
    }

    public List<Product> getAll() {
        return readObjectFromFile();
    }

    public void writeObjectToFile(List<Product> products) {
        try {
            products.addAll(readObjectFromFile());
            FileOutputStream fileOut = new FileOutputStream(FILE_PRODUCT_NAME);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(products);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
        } catch (Exception ex) {
            System.out.println("Writer file failed!");
        }
    }

    public List<Product> readObjectFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream(FILE_PRODUCT_NAME);
            ObjectInputStream ois = new ObjectInputStream(fileIn);
            return (List<Product>) ois.readObject();
        } catch (Exception ex) {
            System.out.println("Read file failed!");
            return new ArrayList<>();
        }
    }
}
