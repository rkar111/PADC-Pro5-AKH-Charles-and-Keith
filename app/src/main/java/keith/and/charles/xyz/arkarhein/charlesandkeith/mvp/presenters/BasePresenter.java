package keith.and.charles.xyz.arkarhein.charlesandkeith.mvp.presenters;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import keith.and.charles.xyz.arkarhein.charlesandkeith.mvp.views.BaseView;

public abstract class BasePresenter<T extends BaseView> extends ViewModel {

    protected T mView;
    protected MutableLiveData<String> errorMsgLD;

    public void initPresenter(T mView) {
        this.mView = mView;
        errorMsgLD = new MutableLiveData<>();
    }

    public LiveData<String> getErrorLD() {
        return errorMsgLD;
    }
}
