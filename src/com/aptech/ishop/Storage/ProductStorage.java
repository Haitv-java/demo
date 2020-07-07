package com.aptech.ishop.Storage;

import com.aptech.ishop.entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.aptech.ishop.utils.Constant.FILE_PRODUCT_NAME;

public class ProductStorage {
    private static List<Product> productRepository = (List<Product>) readObjectFromFile();

    public void saveAll(List<Product> products) {
        System.out.println(productRepository);
        productRepository.addAll(products);
        products.forEach(this::writeObjectToFile);
        System.out.println("Save product successfully!");
    }

    public void save(Product product) {
        productRepository.add(product);
        writeObjectToFile(product);
        System.out.println("Save product successfully!");
    }

    public List<Product> getAll() {
        return productRepository;
    }

    public void writeObjectToFile(Object serObj) {
        try {
            FileOutputStream fileOut = new FileOutputStream(FILE_PRODUCT_NAME);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
        } catch (Exception ex) {
            System.out.println("Writer file failed!");
        }
    }

    public static Object readObjectFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream(FILE_PRODUCT_NAME);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;
        } catch (Exception ex) {
            System.out.println("Read file failed!");
            return new ArrayList<>();
        }
    }
}
