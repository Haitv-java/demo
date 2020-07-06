package com.aptech.ishop.validate;

import com.aptech.ishop.model.ProductRequest;

import static com.aptech.ishop.utils.Constant.*;

public class ProductValidate {
    public static boolean inputValid(String field, String valueInput, ProductRequest product) {
        if (PRODUCT_TITLE.equals(field)) {
            if (valueInput.length() < 6 || valueInput.length() > 30) {
                System.out.println(field + " phai nhieu hon 6 va be hon 30 ky tu");
                return false;
            }
        }
        if (PRODUCT_PRICE_IMPORT.equals(field)) {
            if (Float.parseFloat(valueInput) < 0) {
                System.out.println(field + " phai lon hon 0");
                return false;
            }
        }
        if (PRODUCT_PRICE_EXPORT.equals(field)) {
            if (Float.parseFloat(valueInput) < (MIN_INTEREST_RATE * product.getImportPrice() + product.getImportPrice())) {
                System.out.println(field + " phai co gia tri lon hon gia ban it nhat la MIN_INTEREST_RATE lan ");
                return false;
            }
        }
        if (PRODUCT_DESCRIPTION.equals(field)) {
            if (valueInput == null) {
                System.out.println(field + " khong duoc de trong, vui long nhap lai");
                return false;
            }
        }
        if (PRODUCT_ID.equals(field)) {
            if (valueInput.equalsIgnoreCase(product.getProductID())) {
                System.err.println("Ma san pham nay da ton tai, vui long nhap lai");
                return false;
            }
            if (valueInput.length() < 4) {
                System.err.println("Ma san pham phai co it nhat 4 ky tu, vui long nhap lai");
                return false;
            }
            if(valueInput.charAt(0) != 'C') {
                System.err.println("Ma san pham phai bat dau bang ky tu C, vui long nhap lai");
                return false;
            }
        }
        if (PRODUCT_NAME.equals(field)) {
            if (valueInput.equalsIgnoreCase(product.getProductName())) {
                System.out.println("Ten san pham nay da ton tai, vui long nhap lai");
                return false;
            }
            if (valueInput.length() < 6 || valueInput.length() > 50) {
                System.err.println("Ten san pham phai gom 6-50 ky tu, vui long nhap lai");
                return false;
            }
        }
        return true;
    }
}
