package keith.and.charles.xyz.arkarhein.charlesandkeith.mvp.presenters;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import keith.and.charles.xyz.arkarhein.charlesandkeith.data.model.ProductModel;
import keith.and.charles.xyz.arkarhein.charlesandkeith.data.vo.NewProductVO;
import keith.and.charles.xyz.arkarhein.charlesandkeith.delegates.NewProductDelegate;
import keith.and.charles.xyz.arkarhein.charlesandkeith.mvp.views.NewListView;

public class NewListPresenter extends BasePresenter<NewListView> implements NewProductDelegate {

    private MutableLiveData<List<NewProductVO>> mProductsLD;

    @Override
    public void initPresenter(NewListView mView) {
        super.initPresenter(mView);
        mProductsLD = new MutableLiveData<>();
        ProductModel.getmInstance().startLoadingProducts(mProductsLD, errorMsgLD);
    }

    public LiveData<List<NewProductVO>> getNewProductLD() {
        return mProductsLD;
    }

    @Override
    public void onTapProduct() {
        mView.launchProductDetailScreen();
    }
}
