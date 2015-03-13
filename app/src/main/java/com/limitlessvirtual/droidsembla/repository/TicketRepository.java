package com.limitlessvirtual.droidsembla.repository;

import android.content.Context;

import java.util.List;


import com.limitlessvirtual.droidsembla.DaoApplication;
import com.limitlessvirtual.droidsembla.daos.TicketDao;
import com.limitlessvirtual.droidsembla.models.Ticket;

/**
 * Created by keith on 2015/02/06.
 */
public class TicketRepository {
    public static void insertOrUpdate(Context context, Ticket ticket) {
        getTicketDao(context).insertOrReplace(ticket);
    }

    public static void clearTickets(Context context) {
        getTicketDao(context).deleteAll();
    }

    public static void deleteTicketWithId(Context context, long id) {
        getTicketDao(context).delete(getTicketForId(context, id));
    }

    public static Ticket getTicketForId(Context context, long id) {
        return getTicketDao(context).load(id);
    }

    public static List<Ticket> getAllTickets(Context context) {
        return getTicketDao(context).loadAll();
    }

    private static TicketDao getTicketDao(Context c) {

        return ((DaoApplication) c.getApplicationContext()).getDaoSession().getTicketDao();
    }
}
