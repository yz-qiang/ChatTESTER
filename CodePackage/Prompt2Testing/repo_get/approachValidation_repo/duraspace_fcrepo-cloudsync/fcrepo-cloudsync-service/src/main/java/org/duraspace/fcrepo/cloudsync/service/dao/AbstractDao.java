package org.duraspace.fcrepo.cloudsync.service.dao;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

abstract class AbstractDao {

    protected final JdbcTemplate db;

    public AbstractDao(JdbcTemplate db) {
        this.db = db;
    }

    public abstract void initDb();

    protected String insert(final String sql, final Object... values)
            throws DuplicateKeyException {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        db.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection conn)
                    throws SQLException {
                PreparedStatement ps = conn.prepareStatement(sql,
                        new String[] { "ID" }); // must be caps
                for (int i = 1; i <= values.length; i++) {
                    // Value may be null, so here we depend on Derby's
                    // ability to handle this in version 10.7.1.1+
                    // https://issues.apache.org/jira/browse/DERBY-1938
                    ps.setObject(i, values[i-1]);
                }
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().toString();
    }
}
