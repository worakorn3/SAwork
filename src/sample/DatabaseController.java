package sample;

import java.sql.*;

public class DatabaseController {
    private final String DATABASENAME = "sa.sqlite";
    private String url = "jdbc:sqlite:"+DATABASENAME;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private DBType queryType;
    private DBType update = DBType.UPDATE;
    private DBType select = DBType.SELECT;
    private boolean isFound=false;
    String resultSetString="";

    String companyName="";
    String companyID="";
    String email="";
    String addr="";
    String fax="";
    String taxNO="";
    String phone="";

    public DatabaseController(DBType queryType) {
        if(queryType.equals(update)||queryType.equals(select)){
            this.queryType=queryType;
            try {
                System.out.println("Creating connection...");
                connection = DriverManager.getConnection(url);
                statement = connection.createStatement();
    //            // Test Query Executing
    //            resultSet = statement.executeQuery("SELECT * FROM Companies");
    //            while(resultSet.next()) {
    //                System.out.println(resultSet.getString("Company_Name"));
    //            }
    //            // End Query Executing
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else
            System.out.println("Wrong query type: \"update\" or \"select\" only.");
    }

    // Execute SQL query and close connection
    public void execute(String sqlQuery) {
        System.out.println("=================================================");
        System.out.println("SQL Query Debug inside DatabaseController Class: \n"+sqlQuery);
        System.out.println("=================================================");
        if(queryType.equals(update)) {
            try {
                statement.executeUpdate(sqlQuery);
                if(sqlQuery.matches("^INSERT")) {
                    System.out.println("Insert into table completed.");
                } else if(sqlQuery.matches("^DELETE")) {
                    System.out.println("Delete from table completed.");
                } else if(sqlQuery.matches("^UPDATE")) {
                    System.out.println("Record updated.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if(queryType.equals(select)) {
            try {
                resultSet = statement.executeQuery(sqlQuery);
                printStatement();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close();
    }

    private void printStatement(){
        try {
            if(!resultSet.isBeforeFirst()) {
                System.out.println("No data found.");
            } else {
                System.out.println("Result found:");
                isFound=true;

                while (resultSet.next()) {
                    companyID=resultSet.getString("Company_ID");
                    companyName=resultSet.getString("Company_Name");
                    email=resultSet.getString("Email");
                    addr=resultSet.getString("Address");
                    fax=resultSet.getString("Fax");
                    taxNO=resultSet.getString("TaxNO");
                    phone=resultSet.getString("Phone");

//                    System.out.println("Company ID: "+resultSet.getString("Company_ID"));
//                    System.out.println("Company Name: "+resultSet.getString("Company_Name"));
//                    System.out.println("Company Addr: "+resultSet.getString("Address"));
//                    System.out.println("---------------------------------------------------------------");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        System.out.println("Closing connection...");
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean getIsFound() {
        return isFound;
    }

    public String getCompanyName(){
        return companyName;
    }

    public String getCompanyID(){
        return companyID;
    }

    public String getAddr(){
        return addr;
    }

    public String getEmail(){
        return email;
    }

    public String getFax(){
        return fax;
    }

    public String getTaxNO(){
        return taxNO;
    }

    public String getPhone(){
        return phone;
    }
}
