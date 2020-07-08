package com.aptech.ishop.model;

import com.aptech.ishop.utils.ScannerCommon;
import com.aptech.ishop.validate.ProductValidate;

import static com.aptech.ishop.utils.Constant.*;
import static com.aptech.ishop.utils.ScannerCommon.nextLine;

public class ProductRequest {
    private String productID;
    private String productName;
    private String title;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private String descriptions;
    private boolean productStatus;

    public String getProductID() {
        return productID;
    }
    public void setProductID(String productID) {
        this.productID = productID;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }
    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }
    public void setProfit(float profit) {
        this.profit = profit;
    }
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public float getImportPrice() {
        return importPrice;
    }
    public float getExportPrice() {
        return exportPrice;
    }
    public float getProfit() {
        return profit;
    }
    public String getDescriptions() {
        return descriptions;
    }
    public boolean isProductStatus() {
        return productStatus;
    }
    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }
    public boolean getProductStatus() {
        return this.productStatus;
    }
    public String getTitle() {
        return title;
    }

    public ProductRequest initRequestBody() {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setProductID(formInputText(PRODUCT_ID, productRequest));
//        productRequest.setProductName(formInputText(PRODUCT_NAME, productRequest));
//        productRequest.setTitle(formInputText(PRODUCT_TITLE, productRequest));
//        productRequest.setDescriptions(formInputText(PRODUCT_DESCRIPTION, productRequest));
//        productRequest.setImportPrice(formInputNumber(PRODUCT_PRICE_IMPORT, productRequest));
//        productRequest.setExportPrice(formInputNumber(PRODUCT_PRICE_EXPORT, productRequest));
        formInputBoolean(PRODUCT_STATUS, productRequest);

        return productRequest;
    }

    public String formInputText(String field, ProductRequest request) {
        System.out.println(field);
        do {
            String value = ScannerCommon.stringInput();
            if (value == null || value.isEmpty()) {
                System.out.println("Nhap lai " + field);
            } else if (ProductValidate.inputValid(field, value, request)) return value;
        } while (true);
    }

    public float formInputNumber(String field, ProductRequest request) {
        System.out.println(field);
        do {
            float value = ScannerCommon.floatInput();
            if(ProductValidate.inputValid(field, String.valueOf(value), request)) {
                ScannerCommon.nextLine();
                return value;
            }
        } while (true);
    }

    public void formInputBoolean(String field, ProductRequest request) {
        System.out.println(field);
        do {
            String status = ScannerCommon.stringInput();
            if ("true".equalsIgnoreCase(status) || "false".equalsIgnoreCase(status)) {
                if ("true".equalsIgnoreCase(status)) {
                    request.setProductStatus(true);
                }
                return;
            } else {
                System.out.println("Trang thai san pham khong hop le, vui long nhap lai");
            }
        } while (true);
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", title='" + title + '\'' +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", profit=" + profit +
                ", descriptions='" + descriptions + '\'' +
                ", productStatus=" + productStatus +
                '}';
    }
}
