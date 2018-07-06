package keith.and.charles.xyz.arkarhein.charlesandkeith.network;

import io.reactivex.Observable;
import keith.and.charles.xyz.arkarhein.charlesandkeith.network.response.GetNewProductResponse;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ProductApi {
    @FormUrlEncoded
    @POST("getNewProducts.php")
    Observable<GetNewProductResponse> loadProduct(
            @Field("page") String page,
            @Field("access_token") String accessToken);
}
