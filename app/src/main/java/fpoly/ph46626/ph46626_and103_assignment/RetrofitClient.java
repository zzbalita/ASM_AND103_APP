package fpoly.ph46626.ph46626_and103_assignment;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    //10.24.13.234
    //192.168.1.2
    private static final String BASE_URL = "http://localhost:3000/api/"; // Thay đổi URL phù hợp với API của bạn
    private static Retrofit retrofit;


    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
