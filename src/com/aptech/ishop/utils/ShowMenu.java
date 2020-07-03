package com.aptech.ishop.utils;

public class ShowMenu {
    public static void showMenu() {
        System.out.println("**********************MENU**********************");
        System.out.println("1. Quan ly danh muc");
        System.out.println("2. Quan ly san pham");
        System.out.println("3. Thoat");
        System.out.println("Lua chon cua ban la");
    }

    public static void showMenuQL(){
        System.out.println("**********************QUAN LY DANH MUC**********************");
        System.out.println("1. Danh sach danh muc");
        System.out.println("2. Them danh muc");
        System.out.println("3. Xoa danh muc");
        System.out.println("4. Tim kiem danh muc");
        System.out.println("5. Quay lai");
        System.out.println("Lua chon cua ban la");
    }

    public static void showMenuDS() {
        System.out.println("**********************DANH SACH DANH MUC**********************");
        System.out.println("1. Danh sach cay danh muc");
        System.out.println("2. Thong tin chi tiet danh muc");
        System.out.println("3. Quay lai");
        System.out.println("Lua chon cua ban la: ");
    }

    public static void showMenuQLSP() {
        System.out.println("**********************QUAN LY SAN PHAM**********************");
        System.out.println("1. Them san pham moi");
        System.out.println("2. Tinh loi nhuan san pham");
        System.out.println("3. Hien thi thong tin san pham");
        System.out.println("4. Sap xep san pham");
        System.out.println("5. Cap nhap thong tin san pham");
        System.out.println("6. Cap nhat trang thai san pham");
        System.out.println("7. Quay lai");
        System.out.println("Lua chon cua ban la: ");
    }

    public static void showMenuTTSP() {
        System.out.println("**********************THONG TIN SAN PHAM**********************");
        System.out.println("1. Hien thi san pham theo danh muc");
        System.out.println("2. Hien thi chi tiet san pham");
        System.out.println("3. Quay lai");
        System.out.println("Lua chon cua ban la: ");
    }

    public static void showMenuSXSP() {
        System.out.println("**********************SAP XEP SAN PHAM**********************");
        System.out.println("1. Sap xep san pham theo gia suat tang dan");
        System.out.println("2. Sap xep san pham theo loi nhuan tang dan");
        System.out.println("3. Quay lai");
        System.out.println("Lua chon cua ban la: ");
    }
}
