package LayeredArchitecture.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * The Class SetConnection.
 */
public class SetConnection {
	
	/** The jdbc driver. */
	private  String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    
    /** The db url. */
    private  String DB_URL = "jdbc:mysql://localhost/shopping";
    
    /** The DB user. */
    private  String DB_user  = "root";
    
    /** The db pass. */
    private  String DB_PASS = "root";
    
    /** The con. */
    private Connection con = null;
    
    /**
     * make Connection.
     *
     * @return the connection
     */
    public Connection connection(){
        try {
            Class.forName(JDBC_DRIVER);
            con = (Connection) DriverManager.getConnection(DB_URL, DB_user,
                    DB_PASS);
            return con;
        } catch (Exception e) {
            System.out.println("connection fail : ");
            return con;
        }
    }

}
