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
            product.inputData();
            productList.add(product);
        }
    }

    @Override
    public void displayData() {

    }

    @Override
    public void calProfit(List<Product> productList) {
        for(int i = 0; i < productList.size(); i++) {
            productList.get(i).calProfit();
        }
        System.out.println("Da tinh xong loi nhuan san pham");
        for (Product product : productList) {
            product.displayData();
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
            product.displayData();
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
            product.displayData();
        }
    }

    public void findByName(Scanner sc, List<Product> productList) {
        System.out.println("Nhap ten san pham ban muon tim");
        String nameFind = sc.nextLine();
        for(int i = 0; i < productList.size(); i++) {
            if(nameFind.equalsIgnoreCase(productList.get(i).getProductName())) {
                productList.get(i).displayData();
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
                productList.get(i).inputData();
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

    public static void readObjectProductList(List<Product> productList) {
        File file = new File(FILE_PRODUCT_NAME);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        if(file.exists()) {
            try {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                productList = (ArrayList<Product>) ois.readObject();
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
    }
}
