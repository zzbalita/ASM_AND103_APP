package fpoly.ph46626.ph46626_and103_assignment;

import java.util.List;

import fpoly.ph46626.ph46626_and103_assignment.Cart.Model.BillModel;
import fpoly.ph46626.ph46626_and103_assignment.Cart.TotaPriceResponse;
import fpoly.ph46626.ph46626_and103_assignment.Home.Model.ProductModel;
import fpoly.ph46626.ph46626_and103_assignment.Notification.HistoryModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {

    @GET("products")
    Call<List<ProductModel>> getProduct();

    @GET("products/{id}")
    Call<ProductModel> getProductById(@Path("id") String id);

    @POST("products")
    Call<ProductModel> createProduct(@Body ProductModel productModel);

    @PUT("products/{id}")
    Call<ProductModel> updateProduct(@Path("id") String id, @Body ProductModel productModel);

    //  bill
    @GET("bills")
    Call<List<BillModel>> getBill();

    @DELETE("bills/{id}")
    Call<Void> deleteBill(@Path("id") String id);

    @POST("bills")
    Call<BillModel> createBill(@Body BillModel billModel);

    // Thêm phương thức mới để lấy tổng tiền
    @GET("bills/total")
    Call<TotaPriceResponse> getTotalPrice();

    //    history
    @POST("historys")
    Call<Void> addBillsToHistory();

    // Phương thức để lấy tất cả dữ liệu từ historys
    @GET("historys")
    Call<List<HistoryModel>> getAllHistories();

    // Thêm phương thức để xóa tất cả hóa đơn
    @DELETE("bills")
    Call<Void> deleteAllBills();


}
