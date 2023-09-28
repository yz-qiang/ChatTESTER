package org.duraspace.fcrepo.cloudsync.service.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import org.duraspace.fcrepo.cloudsync.api.ServiceInfo;

public class ServiceInfoDao extends AbstractDao {
    
    public ServiceInfoDao(JdbcTemplate db, UserDao userDao) {
        super(db);
    }

    @Override
    public void initDb() {
        db.execute("CREATE TABLE ServiceInfo (initialized BOOLEAN NOT NULL)");
        db.execute("INSERT INTO ServiceInfo VALUES (false)");
    }

    public ServiceInfo getServiceInfo() {
        return db.query("SELECT * FROM ServiceInfo",
                new ResultSetExtractor<ServiceInfo>() {
                    @Override
                    public ServiceInfo extractData(ResultSet rs)
                            throws SQLException {
                        rs.next();
                        ServiceInfo c = new ServiceInfo();
                        c.setInitialized(rs.getBoolean("initialized"));
                        c.setVersion(System.getProperty("cloudsync.version"));
                        c.setBuildDate(System.getProperty("cloudsync.builddate"));
                        return c;
                    }
                });
    }

    public void setInitialized() {
        db.update("UPDATE ServiceInfo SET initialized = true");
    }

}
