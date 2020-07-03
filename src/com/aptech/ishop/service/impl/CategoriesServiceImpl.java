package com.aptech.ishop.service.impl;

import com.aptech.ishop.entity.Categories;
import com.aptech.ishop.service.ICategories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.aptech.ishop.utils.Constant.FILE_CATALOG_NAME;
import static java.lang.System.*;

public class CategoriesServiceImpl implements ICategories {

    @Override
    public void inputData(Scanner sc, List<Categories> categoriesList) {
        out.println("Nhap so danh muc san pham muon them");
        int n = 0;
        do {
            try {
                n = Integer.parseInt(sc.nextLine());
                if(n > 0) {
                    break;
                }else {
                    err.println("So danh muc muon them phai lon hon khong, vui long nhap lai");
                }
            } catch (Exception e) {
                err.println("Nhap lai mot so nguyen");
            }
        } while (true);
        for(int i = 0 ; i < n; i++) {
            Categories categories = new Categories();
            out.println("Nhap ma danh muc");
            do {
                try {
                    int catalogID = Integer.parseInt(sc.nextLine());
                    if(catalogID > 0) {
                        categories.setCatalogID(catalogID);
                        break;
                    }else {
                        out.println("Ma danh muc phai lon hon khong, vui long nhap lai");
                    }
                } catch (Exception e) {
                    out.println("Ma danh muc khong hop le, vui long nhap lai");
                }
            } while (true);
            categories.inputData();
            categoriesList.add(categories);
        }
    }

    @Override
    public void displayData(List<Categories> categoriesList) {
        for(int i = 0; i < categoriesList.size(); i++) {
            categoriesList.get(i).displayData();
        }
    }

    public void treeCategories(List<Categories> categoriesList) {
        int stt0 = 0, stt1 = 0, stt2 = 0;
        for(int i = 0; i < categoriesList.size(); i++) {
            if(categoriesList.get(i).getParentID() == 0) {
                stt0++;
                out.printf("%d.%s\n", stt0, categoriesList.get(i).getCatalogName());
                for(int j = 0; j < categoriesList.size(); j++) {
                    if(categoriesList.get(j).getParentID() == 1) {
                        stt1++;
                        out.printf("\t%d.%d.%s\n", stt0, stt1, categoriesList.get(j).getCatalogName());
                        for(int k = 0; k < categoriesList.size(); k++) {
                            if(categoriesList.get(k).getParentID() == 2) {
                                stt2++;
                                out.printf("\t\t%d.%d.%d.%s\n", stt0, stt1, stt2, categoriesList.get(k).getCatalogName());
                            }
                        }
                    }
                }
            }
        }
    }

    public void removeCategories(Scanner sc, List<Categories> categoriesList) {
        int findRemove;
        do {
            try {
                findRemove = Integer.parseInt(sc.nextLine());
                if(findRemove > 0) {
                    break;
                }else {
                    System.err.println("Vui long nhap lai mot so lon hon khong");
                }
            } catch (Exception e) {
                System.err.println("Vui long nhap lai mot so nguyen");
            }
        } while (true);
        for (int i = 0; i < categoriesList.size(); i++) {
            if(findRemove == categoriesList.get(i).getCatalogID()) {
                categoriesList.remove(i);
            }
        }
        System.out.println("Da xoa ma danh muc");
    }

    public void searchCategories(Scanner sc, List<Categories> categoriesList) {
        String nameSearch = sc.nextLine();
        for (Categories categories : categoriesList) {
            if(nameSearch.equalsIgnoreCase(categories.getCatalogName())) {
                categories.displayData();
            }else {
                System.out.println("Khong tim thay danh muc nao");
            }
        }
    }

    public void addCategoriestoProduct(Scanner sc, List<Categories> categoriesList) {
        System.out.println("Nhap danh muc san pham cua san pham");
        do {
            String ctProduct = sc.nextLine();
            for (Categories categories : categoriesList) {
                if(ctProduct.equalsIgnoreCase(categories.getCatalogName())) {
                    break;
                }else {
                    System.out.println("Ten danh muc san pham khong co trong danh muc");
                }
            }
        } while (true);
    }

    public void displayCategories() {

    }

    public static void writeObjectFileCategories(List<Categories> categoriesList) {
        File file = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        String fileCatalogName = null;
        file = new File(fileCatalogName);
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(categoriesList);
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

    public static void readObjectFileCategories(List<Categories> categoriesList) {
        File file = new File(FILE_CATALOG_NAME);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        if (file.exists()) {
            try {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                categoriesList = (ArrayList<Categories>) ois.readObject();

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
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
    }
}
