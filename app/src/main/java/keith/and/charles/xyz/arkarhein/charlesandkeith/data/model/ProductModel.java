package keith.and.charles.xyz.arkarhein.charlesandkeith.data.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import keith.and.charles.xyz.arkarhein.charlesandkeith.CharlesAndKeithApp;
import keith.and.charles.xyz.arkarhein.charlesandkeith.data.vo.NewProductVO;
import keith.and.charles.xyz.arkarhein.charlesandkeith.network.response.GetNewProductResponse;

public class ProductModel extends BaseModel {

    private static ProductModel mInstance;
    private String pageIndex = "1";

    protected ProductModel(Context context) {
        super(context);
    }

    public static ProductModel getmInstance() {
        if (mInstance != null) {
            return mInstance;
        }
        throw new RuntimeException("Runtime Error");
    }

    public static void initProductModel(Context context) {
        mInstance = new ProductModel(context);
    }

    public void startLoadingProducts(final MutableLiveData<List<NewProductVO>> mProductLD, final MutableLiveData<String> mErrorLD) {
        Observable<GetNewProductResponse> getNewProductResponseObservable = theApi.loadProduct(pageIndex, CharlesAndKeithApp.ACCESS_TOKEN);
        getNewProductResponseObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetNewProductResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetNewProductResponse getNewProductResponse) {
                        if (getNewProductResponse != null && getNewProductResponse.getNewProducts().size() > 0) {
                            mProductLD.setValue(getNewProductResponse.getNewProducts());
                            addNewProductsToDB(getNewProductResponse.getNewProducts());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mErrorLD.setValue(e.getMessage());
                        mProductLD.setValue(mDatabase.productDAO().getAllProduct());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void addNewProductsToDB(List<NewProductVO> productsVOS) {
        mDatabase.clearAllTables();
        mDatabase.productDAO().insertProducts(productsVOS);
        Log.d(CharlesAndKeithApp.LOG_TAG, "product list" + mDatabase.productDAO().getAllProduct().size());
    }

    public List<NewProductVO> getProductById(String productId) {
        return mDatabase.productDAO().getProductById(productId);
    }

    public LiveData<List<NewProductVO>> getAllProductLiveData() {
        return mDatabase.productDAO().getAllLiveData();
    }

    public LiveData<List<NewProductVO>> getProductLiveDataById(String id) {
        return mDatabase.productDAO().getLiveDataProductById(id);
    }

    public List<NewProductVO> getAllProduct() {
        return mDatabase.productDAO().getAllProduct();
    }


}
