package com.limitlessvirtual.droidsembla;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.limitlessvirtual.droidsembla.daos.DaoMaster;
import com.limitlessvirtual.droidsembla.daos.DaoSession;

/**
 * Created by keith on 2015/03/13.
 */
public class DaoApplication extends Application {
    public DaoSession daoSession;
    private static volatile DaoApplication instance = null;

    public static DaoApplication getInstance(Context context) {
        if(instance == null)
            instance = new DaoApplication();
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setupDatabase();
    }

    private void setupDatabase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "droidsembla-liv", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
