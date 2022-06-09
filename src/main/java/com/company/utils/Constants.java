package com.company.utils;

public class Constants {

    // JDBC
    public static final String BOOKSTORE_DB_PROPS = "bookstore_db.properties";

    // User
    public static final String USER_METHOD_KEY = "method";

    // Page
    public static final int DEFAULT_PAGE_SIZE = 4;

    // Manager
    public static final String MANAGER_PAGING_URL = "BookServlet?method=getAllManagerAfter";

    // Home
    public static final String HOME_PAGING_URL = "BookServlet?method=getAllHomeAfter";
    public static final String HOME_PAGING_BY_PRICE_URL = "BookServlet?method=getAllHomeByPrice";

}
