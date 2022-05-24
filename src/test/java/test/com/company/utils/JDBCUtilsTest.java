package test.com.company.utils;

import java.sql.Connection;

import com.company.utils.JDBCUtils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JDBCUtilsTest {

    @Test
    public void testGetConnection() {

        Connection conn = JDBCUtils.getConnection();

        assertNotNull(conn);
    }

}
