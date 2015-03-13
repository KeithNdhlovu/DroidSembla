package com.limitlessvirtual.droidsembla.repository;

import android.content.Context;

import java.util.List;

import com.limitlessvirtual.droidsembla.DaoApplication;
import com.limitlessvirtual.droidsembla.daos.UserDao;
import com.limitlessvirtual.droidsembla.models.User;

/**
 * Created by keith on 2015/02/06.
 */
public class UserRepository {

    public static void insertOrUpdate(Context context, User user) {
        getUserDao(context).insertOrReplace(user);
    }

    public static void clearUsers(Context context) {
        getUserDao(context).deleteAll();
    }

    public static void deleteUserWithId(Context context, long id) {
        getUserDao(context).delete(getUserOfId(context, id));
    }

    public static User getUserOfId(Context context, long id) {
        return getUserDao(context).load(id);
    }

    public static List<User> getAllUsers(Context context) {
        return getUserDao(context).loadAll();
    }

    private static UserDao getUserDao(Context c) {

        return ((DaoApplication) c.getApplicationContext()).getDaoSession().getUserDao();
    }
}
