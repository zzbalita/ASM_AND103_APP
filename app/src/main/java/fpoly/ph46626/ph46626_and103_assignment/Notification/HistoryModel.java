package fpoly.ph46626.ph46626_and103_assignment.Notification;

import java.util.List;

import fpoly.ph46626.ph46626_and103_assignment.Home.Model.ProductModel;

public class HistoryModel {
    private String userId;
    private List<ProductModel> products;
    private double totalPrice;

    public HistoryModel(String userId, List<ProductModel> products, double totalPrice) {
        this.userId = userId;
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public HistoryModel() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
