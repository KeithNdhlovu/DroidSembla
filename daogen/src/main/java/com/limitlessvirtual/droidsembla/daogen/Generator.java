package com.limitlessvirtual.droidsembla.daogen;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

public class Generator {
    public static void main(String[] args)
    {
        Schema schema = new Schema(1, "com.limitlessvirtual.droidsembla.models");
        schema.setDefaultJavaPackageDao("com.limitlessvirtual.droidsembla.daos");
        schema.enableKeepSectionsByDefault();

        /************************************
         * Models implementation
         * @User
         * @Project
         * @Ticket
         ************************************/

        //Create a User entity
        Entity user = schema.addEntity("User");
        user.addIdProperty();
        user.addStringProperty("name");
        user.addStringProperty("email");
        user.addStringProperty("loginId");
        user.addStringProperty("type");

        //Create a Project entity
        Entity project = schema.addEntity("Project");
        project.addIdProperty();
        project.addStringProperty("name");
        project.addStringProperty("description");

        //Create a Ticket entity
        Entity ticket = schema.addEntity("Ticket");
        ticket.addIdProperty();
        ticket.addStringProperty("summary");
        ticket.addStringProperty("status");
        ticket.addIntProperty("number");

        /************************************
         * @Relationships implementation
         ************************************/

        //User and Project relationship
        Property userId = project.addLongProperty("userId").notNull().getProperty();
        ToMany userToProjects = user.addToMany(project, userId);
        userToProjects.setName("projects"); //optional

        //Project and Ticket relationship
        Property projectId = ticket.addLongProperty("projectId").notNull().getProperty();
        ToMany projectToTicket = project.addToMany(ticket, projectId);
        projectToTicket.setName("tickets"); // Optional

        try {
            new DaoGenerator().generateAll(schema, args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
