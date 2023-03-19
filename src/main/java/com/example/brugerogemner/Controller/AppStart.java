package com.example.brugerogemner.Controller;


import com.example.brugerogemner.Mapper.ConnectionPool;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppStart implements ServletContextListener
{


    private static ConnectionPool connectionPool;

    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
      ServletContextListener.super.contextInitialized(sce);


        try {
            Class.forName("org.slf4j.impl.StaticLoggerBinder");
            connectionPool = new ConnectionPool();
        } catch (ClassNotFoundException e) {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage(), e);
        }




    }


    public static ConnectionPool getConnectionPool()
    {
        return connectionPool;
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {
        Logger.getLogger("web").log(Level.INFO, "Shutting down application and connection pool");
        unregisterJDBCdrivers();
        connectionPool.close();
    }

    private void unregisterJDBCdrivers()
    {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        // Loop through all drivers
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            if (driver.getClass().getClassLoader() == cl) {
                // This driver was registered by the webapp's ClassLoader, so deregister it:
                try {
                    Logger.getLogger("web").log(Level.INFO, "Deregistering JDBC driver");
                    DriverManager.deregisterDriver(driver);
                } catch (SQLException ex) {
                    Logger.getLogger("web").log(Level.SEVERE, "Error deregistering JDBC driver");
                }
            } else {
                // driver was not registered by the webapp's ClassLoader and may be in use elsewhere
                Logger.getLogger("web").log(Level.WARNING, "Error deregistering JDBC driver");
            }
        }
    }



}
