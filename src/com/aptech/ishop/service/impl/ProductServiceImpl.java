package com.aptech.ishop.service.impl;

import com.aptech.ishop.entity.Product;
import com.aptech.ishop.service.IProduct;

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

import static com.aptech.ishop.utils.Constant.FILE_PRODUCT_NAME;
import static com.aptech.ishop.utils.Constant.MIN_INTEREST_RATE;

public class ProductServiceImpl implements IProduct {

    @Override
    public void inputData(Scanner sc, List<Product> productList) {
        System.out.println("Nhap so san pham can them");
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0; i < n ; i++ ) {
            Product product = new Product();
            // NHAP MA SAN PHAM
            System.out.println("Nhap ma san pham");
            do {
                String productID = sc.nextLine();
                boolean checkID = false;
                for(int j = 0; j < productList.size(); j++) {
                    if(productID.equalsIgnoreCase(productList.get(j).getProductID())) {
                        checkID = true;
                        break;
                    }
                }
                if(checkID) {
                    System.err.println("Ma san pham nay da ton tai, vui long nhap lai");
                }else {
                    if(productID.length()==4) {
                        if(productID.charAt(0) == 'C') {
                            product.setProductID(productID);
                            break;
                        }else {
                            System.err.println("Ma san pham phai bat dau bang ky tu C, vui long nhap lai");
                        }
                    }else {
                        System.err.println("Ma san pham phai co it nhat 4 ky tu, vui long nhap lai");
                    }
                }
            } while (true);
            // NHAP TEN SAN PHAM
            System.out.println("Nhap ten san pham");
            do {
                String productName = sc.nextLine();
                boolean checkName = false;
                for(int k = 0; k < productList.size(); k++) {
                    if(productName.equalsIgnoreCase(productList.get(k).getProductName())) {
                        checkName = true;
                        break;
                    }
                }
                if(checkName) {
                    System.out.println("Ten san pham nay da ton tai, vui long nhap lai");
                }else {
                    if(productName.length() >= 6 && productName.length() <= 50) {
                        product.setProductName(productName);
                        break;
                    }else {
                        System.err.println("Ten san pham phai gom 6-50 ky tu, vui long nhap lai");
                    }
                }
            } while (true);
            inputData(productList.get(i));
            productList.add(product);
        }
    }

    @Override
    public void inputData(Product product) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tieu de san pham");
        do {
            try {
                product.setTitle(sc.nextLine());
                if(product.getTitle().length() >= 6 && product.getTitle().length() <= 30) {
                    break;
                }else {
                    System.out.println("Tieu de danh muc phai nhieu hon 6 va be hon 30 ky tu");
                }
            } catch (Exception e) {
                System.out.println("Nhap lai tieu de san pham");
            }
        } while (true);

        System.out.println("Nhap gia san pham");
        do {
            try {
                product.setImportPrice(Float.parseFloat(sc.nextLine()));
                if(product.getImportPrice() > 0) {
                    break;
                }else {
                    System.out.println("Gia nhap phai lon hon 0, vui long nhap lai");
                }
            } catch (Exception e) {
                System.out.println("Gia nhap san pham khong hop le, vui long nhap lai");
            }
        } while (true);

        System.out.println("Nhap gia ban san pham");
        do {
            try {
                product.setExportPrice(Float.parseFloat(sc.nextLine()));
                if(product.getExportPrice() >= (MIN_INTEREST_RATE * product.getImportPrice() + product.getImportPrice()) ) {
                    break;
                }else {
                    System.out.println("Gia ban san pham phai co gia tri lon hon gia ban it nhat la MIN_INTEREST_RATE lan ");
                }
            } catch (Exception e) {
                System.out.println("Gia ban san pham khong hop le, vui long nhap lai");
            }
        } while (true);
        System.out.println("Nhap mo ta san pham");
        do {
            try {
                product.setDecriptions(sc.nextLine());
                if(product.getDecriptions() != null) {
                    break;
                }else {
                    System.out.println("Mo ta san pham khong duoc de trong, vui long nhap lai");
                }
            } catch (Exception e) {
                System.out.println("Mo ta san pham khong hop le, vui long nhap lai");
            }
        } while (true);
        System.out.println("Nhap trang thai san pham");
        do {
            try {
                product.setProductStatus(sc.nextBoolean());
                break;
            } catch (Exception e) {
                System.out.println("Trang thai san pham khong hop le, vui long nhap lai");
                sc.next();
            }
        } while (true);
    }

    @Override
    public void displayData(Product product) {
        String trangThai;
        if(product.isProductStatus()) {
            trangThai = "Hoat dong";
        }else {
            trangThai = "Khong hoat dong";
        }
        System.out.printf("Ma san pham: %d - Ten san pham: %s\n", product.getProductID(), product.getProductName());
        System.out.printf("Tieu de san pham: %s\n", product.getDecriptions());
        System.out.printf("Gia nhap san pham: %f - Gia ban sam pham: %f\n", product.getImportPrice(), product.getExportPrice());
        System.out.printf("Loi nhuan san pham: %f\n", product.getProfit());
        System.out.printf("Mo ta san pham: %s - Trang thai: %s\n", product.getDecriptions(), trangThai);
    }

    @Override
    public void calProfit(Product product) {
        product.setProfit(product.getExportPrice() - product.getImportPrice());
    }

    @Override
    public void calProfit(List<Product> productList) {
        for(int i = 0; i < productList.size(); i++) {
            displayData(productList.get(i));
        }
        System.out.println("Da tinh xong loi nhuan san pham");
        for (Product product : productList) {
            displayData(product);
        }
    }

    public void updateProductStatus(Scanner sc, List<Product> productList) {
        System.out.println("Nhap ma san pham muon cap nhat");
        String statusByID = sc.nextLine();
        for(int i = 0; i < productList.size(); i++) {
            if(statusByID.equalsIgnoreCase(productList.get(i).getProductID())) {
                productList.get(i).setProductStatus(!productList.get(i).isProductStatus());
            }
            break;
        }
        System.out.println("Trang thai san pham da duoc cap nhat");
    }

    public void sortExportPrice(List<Product> productList) {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.getExportPrice() > o2.getExportPrice()) {
                    return -1;
                }else {
                    return 1;
                }
            }
        });
        System.out.println("Danh sach san pham sau khi sap xep");
        for (Product product : productList) {
            displayData(product);
        }
    }

    public void sortProfit(List<Product> productList) {
        Collections.sort(productList, new Comparator<Product>() {

            @Override
            public int compare(Product o1, Product o2) {
                if(o1.getProfit() > o2.getProfit()) {
                    return 1;
                }else {
                    return -1;
                }
            }
        });
        System.out.println("Danh sach san pham sau khi sap xep");
        for (Product product : productList) {
            displayData(product);
        }
    }

    public void findByName(Scanner sc, List<Product> productList) {
        System.out.println("Nhap ten san pham ban muon tim");
        String nameFind = sc.nextLine();
        for(int i = 0; i < productList.size(); i++) {
            if(nameFind.equalsIgnoreCase(productList.get(i).getProductName())) {
                displayData(productList.get(i));
            }
        }
    }

    public void updateInfoProduct(Scanner sc, List<Product> productList) {
        System.out.println("Nhap vao ma san pham muon cap nhat thong tin");
        String idEdit = null;
        try {
            idEdit = sc.nextLine();
        } catch (Exception e) {
            System.out.println("Ma san pham la so nguyen");
        }
        for(int i = 0; i < productList.size(); i++) {
            if(idEdit.equalsIgnoreCase(productList.get(i).getProductID())) {
                String newName = sc.nextLine();
                boolean check = false;
                do {
                    if(newName.equalsIgnoreCase(productList.get(i).getProductName())) {
                        System.out.println("Ten san pham da ton tai");
                        check = true;
                        break;
                    }else {
                        productList.get(i).setProductName(newName);
                    }
                } while (true);
                inputData(productList.get(i));
            }else {
                System.out.println("Khong tim thay ma san pham can chinh sua");
            }
        }
    }

    public static void writeObjectFileProduct(List<Product> productList) {
        File file = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        String fileProductName = null;
        file = new File(fileProductName);
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }finally {
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
