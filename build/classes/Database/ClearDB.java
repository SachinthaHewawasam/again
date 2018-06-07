package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClearDB {

    public static void main(String[] args) {
        ConnectDB db = new ConnectDB();
        try {
            db.conn.createStatement().execute("Drop table pastSummary");
            db.conn.createStatement().execute("Drop table inputDoc");
            db.conn.createStatement().execute("Drop table Users");
            //rs = db.conn.createStatement().executeQuery("Select * from Users u,inputDoc i,pastSummary p where u.Username = i.Uname and u.Username = p.Uname");
            System.out.println(db.getData());
        } catch (SQLException ex) {
            Logger.getLogger(ClearDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
