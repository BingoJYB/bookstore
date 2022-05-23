package com.company.www.utils;

import java.sql.Connection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JDBCUtilsTest {

    @Test
    public void testGetConnection() {

        Connection conn = JDBCUtils.getConnection();

        assertNotNull(conn);
    }

}
