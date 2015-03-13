package com.limitlessvirtual.droidsembla.repository;

import android.content.Context;

import java.util.List;


import com.limitlessvirtual.droidsembla.DaoApplication;
import com.limitlessvirtual.droidsembla.daos.ProjectDao;
import com.limitlessvirtual.droidsembla.models.Project;

/**
 * Created by keith on 2015/02/06.
 */
public class ProjectRepository {
    public static void insertOrUpdate(Context context, Project project) {
        getProjectDao(context).insertOrReplace(project);
    }

    public static void clearUsers(Context context) {
        getProjectDao(context).deleteAll();
    }

    public static void deleteUserWithId(Context context, long id) {
        getProjectDao(context).delete(getProjectForId(context, id));
    }

    public static Project getProjectForId(Context context, long id) {
        return getProjectDao(context).load(id);
    }

    public static List<Project> getAllUsers(Context context) {
        return getProjectDao(context).loadAll();
    }

    private static ProjectDao getProjectDao(Context c) {

        return ((DaoApplication) c.getApplicationContext()).getDaoSession().getProjectDao();
    }
}
