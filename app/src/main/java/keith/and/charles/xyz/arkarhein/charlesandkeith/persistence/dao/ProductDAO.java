package keith.and.charles.xyz.arkarhein.charlesandkeith.persistence.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import keith.and.charles.xyz.arkarhein.charlesandkeith.data.vo.NewProductVO;

@Dao
public interface ProductDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProducts(List<NewProductVO> newProductVOList);

    @Query("SELECT * From products")
    List<NewProductVO> getAllProduct();

    @Query("SELECT * FROM products Where productId=:productId")
    List<NewProductVO> getProductById(String productId);

    @Query("SELECT * From products")
    LiveData<List<NewProductVO>> getAllLiveData();

    @Query("SELECT * FROM products Where productId=:productId")
    LiveData<List<NewProductVO>> getLiveDataProductById(String productId);
}
