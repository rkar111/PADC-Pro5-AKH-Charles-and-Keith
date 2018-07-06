package keith.and.charles.xyz.arkarhein.charlesandkeith.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import keith.and.charles.xyz.arkarhein.charlesandkeith.data.vo.NewProductVO;
import keith.and.charles.xyz.arkarhein.charlesandkeith.persistence.dao.ProductDAO;

@Database(entities = {NewProductVO.class}, version = 1, exportSchema = false)
public abstract class AppDatabse extends RoomDatabase {
    private static AppDatabse objInstance;
    private static String DB_NAME = "Products_DB";

    public abstract ProductDAO productDAO();

    public static AppDatabse getObjInstance(Context context) {
        if (objInstance == null) {
            objInstance = Room.databaseBuilder(context, AppDatabse.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return objInstance;
    }
}
