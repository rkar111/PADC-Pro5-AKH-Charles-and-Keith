package keith.and.charles.xyz.arkarhein.charlesandkeith.data.model;

import android.content.Context;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import keith.and.charles.xyz.arkarhein.charlesandkeith.network.ProductApi;
import keith.and.charles.xyz.arkarhein.charlesandkeith.persistence.AppDatabse;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by WaiPhyoAg on 6/29/18.
 */

public abstract class BaseModel {
    protected ProductApi theApi;
    protected AppDatabse mDatabase;

    protected BaseModel(Context context) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/ck/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        theApi = retrofit.create(ProductApi.class);
        mDatabase = AppDatabse.getObjInstance(context);

    }
}
