package keith.and.charles.xyz.arkarhein.charlesandkeith.mvp.presenters;

import android.arch.lifecycle.LiveData;

import java.util.List;

import keith.and.charles.xyz.arkarhein.charlesandkeith.activities.ProductDetailActivity;
import keith.and.charles.xyz.arkarhein.charlesandkeith.data.model.ProductModel;
import keith.and.charles.xyz.arkarhein.charlesandkeith.data.vo.NewProductVO;
import keith.and.charles.xyz.arkarhein.charlesandkeith.mvp.views.ProductDetailView;

public class ProductDetailPresenter extends BasePresenter<ProductDetailView> {
    @Override
    public void initPresenter(ProductDetailView mView) {
        super.initPresenter(mView);
    }

    public LiveData<List<NewProductVO>> getProductLDId(String id) {
        return ProductModel.getmInstance().getProductLiveDataById(id);
    }

    public LiveData<List<NewProductVO>> getProductDetail() {
        return ProductModel.getmInstance().getAllProductLiveData();
    }
}
