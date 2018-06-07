package Database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectDB {

    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String JDBC_URL = "jdbc:derby:Summarizer;create=true";
    Connection conn;

    public ConnectDB() {

        DatabaseMetaData meta;
        ResultSet tables;

        try {
            this.conn = DriverManager.getConnection(JDBC_URL);
            if (conn != null) {
                System.out.println("Connected");
            }
            meta = conn.getMetaData();
            tables = meta.getTables(null, null, "USERS", null);
            if (!tables.next()) {
                createTables();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createTables() {
        try {
            conn.createStatement().execute("Create Table Users(Username varchar(50) NOT NULL, Password varchar(50),PRIMARY KEY (Username))");
            conn.createStatement().execute("Create Table inputDoc(DocLocation varchar(255), Uname varchar(50), PRIMARY KEY (DocLocation), FOREIGN KEY (Uname) REFERENCES Users(Username))");
            conn.createStatement().execute("Create Table pastSummary(Uname varchar(50), DocLoc varchar(255), keyphrase varchar(255), PRIMARY KEY (DocLoc, keyphrase), FOREIGN KEY (Uname) REFERENCES Users(Username), FOREIGN KEY (DocLoc) REFERENCES inputDoc(DocLocation))");
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String createUser(String uName, char[] c) {
        String pass = new String(c);
        ResultSet r;
        try {
            r = conn.createStatement().executeQuery(String.format("SELECT * from Users WHERE Username = '%s'", uName));
            if (r.next()) {
                return "Username already exists";
            }
            conn.createStatement().execute(String.format("Insert into Users(Username,Password) Values('%s','%s')", uName, pass));
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public String inputDoc(String docLocation ,String uName) {
        ResultSet r;
        try {
            r = conn.createStatement().executeQuery(String.format("Select * From inputDoc where DocLocation='%s' and Uname = '%s'",docLocation,uName));
            if(r.next()){
                return r.getString(1);
            }
            conn.createStatement().execute(String.format("Insert into inputDoc(DocLocation,Uname) Values('%s','%s')", docLocation, uName));
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void inputSummary(String keyphrase, String uName, String DocLoc) {
        try {
            conn.createStatement().execute(String.format("Insert into pastSummary(keyphrase, Uname, DocLoc) Values('%s','%s','%s')", keyphrase, uName, DocLoc));
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getData() {
        String data = "";
        ResultSet r;
        try {
            r = conn.createStatement().executeQuery("Select * From pastSummary");
            while (r.next()) {
                data += r.getString(1) + "\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }

    public String login(String uName, char[] c) {
        ResultSet r,rs;
        String pass = new String(c);
        try {
            r = conn.createStatement().executeQuery(String.format("Select * From Users Where Username = '%s'", uName));
            if (!r.next()) {
                return "No such user exists";
            } else {
                rs = conn.createStatement().executeQuery(String.format("Select * From Users Where Username = '%s' and Password = '%s'", uName, pass));
                if (rs.next()) {
                    return uName;
                } else {
                    return "Incorrect Password";
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String checkSummaryKey(String DocLoc, String keyphrase) {
        ResultSet r;
        try {
            r = conn.createStatement().executeQuery(String.format("Select summaryLocation From pastSummary Where keyphrase = '%s' and DocLoc = '%s'", keyphrase, DocLoc));
            if (r.next()) {
                return r.getString(1);
            } else {
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     

}
