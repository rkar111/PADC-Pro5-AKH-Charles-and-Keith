package keith.and.charles.xyz.arkarhein.charlesandkeith.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import keith.and.charles.xyz.arkarhein.charlesandkeith.data.vo.NewProductVO;

public class GetNewProductResponse {

    @SerializedName("code")
    @Expose
    private int code;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("apiVersion")
    @Expose
    private String apiVersion;

    @SerializedName("page")
    @Expose
    private String page;

    @SerializedName("newProducts")
    @Expose
    private List<NewProductVO> newProducts;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<NewProductVO> getNewProducts() {
        return newProducts;
    }
}
