package com.limitlessvirtual.droidsembla.daos;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.limitlessvirtual.droidsembla.models.User;
import com.limitlessvirtual.droidsembla.models.Project;
import com.limitlessvirtual.droidsembla.models.Ticket;

import com.limitlessvirtual.droidsembla.daos.UserDao;
import com.limitlessvirtual.droidsembla.daos.ProjectDao;
import com.limitlessvirtual.droidsembla.daos.TicketDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig projectDaoConfig;
    private final DaoConfig ticketDaoConfig;

    private final UserDao userDao;
    private final ProjectDao projectDao;
    private final TicketDao ticketDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        projectDaoConfig = daoConfigMap.get(ProjectDao.class).clone();
        projectDaoConfig.initIdentityScope(type);

        ticketDaoConfig = daoConfigMap.get(TicketDao.class).clone();
        ticketDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        projectDao = new ProjectDao(projectDaoConfig, this);
        ticketDao = new TicketDao(ticketDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(Project.class, projectDao);
        registerDao(Ticket.class, ticketDao);
    }
    
    public void clear() {
        userDaoConfig.getIdentityScope().clear();
        projectDaoConfig.getIdentityScope().clear();
        ticketDaoConfig.getIdentityScope().clear();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public ProjectDao getProjectDao() {
        return projectDao;
    }

    public TicketDao getTicketDao() {
        return ticketDao;
    }

}
