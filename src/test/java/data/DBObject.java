package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBObject {
    Properties property;
    public DBObject(){
       try {
           property = getProperty();
       }
       catch (IOException e) {

       }

    }

    public Properties getProperty() throws IOException {
        try {
            var property = new Properties();
            FileInputStream fis = new FileInputStream("artifacts/application.properties");
            property.load(fis);
            return property;
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage());
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

    public String executeQuery(String query) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection(property.getProperty("spring.datasource.url"), property.getProperty("spring.datasource.username"), property.getProperty("spring.datasource.password"));
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            return rs.getString("status");
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
