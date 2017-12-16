package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CompanyController {
    private String FirstPage = "firstpage.fxml";

    @FXML
    private Button backButton;
    @FXML
    private Button insertBtn;
    @FXML
    private Button checkBtn;

    private DBType select = DBType.SELECT;
    private DBType update = DBType.UPDATE;

    @FXML
    private TextField companyNameField;
    @FXML
    private TextField companyIDField;
    @FXML
    private TextField companyAddrField;
    @FXML
    private TextField companyEmailField;
    @FXML
    private TextField companyTaxNOField;
    @FXML
    private TextField companyFaxField;
    @FXML
    private TextField companyPhoneField;

    @FXML
    private void initialize() {
        insertBtn.setDisable(true);
    }

    @FXML
    public void handleBackButton(ActionEvent event){
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        stage.setTitle("Main Menu");
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FirstPage));
        try{
            stage.setScene(new Scene(loader.load(),800,600));
            FirstPageController controller = (FirstPageController) loader.getController();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void onCheckCompanyHandleBtn(ActionEvent e) {
//        Connection connection = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
        DatabaseController dbController = new DatabaseController(select);
//        try {
//            connection = DriverManager.getConnection("jdbc:sqlite:sa.sqlite");
//            statement = connection.createStatement();
            String companyID=companyIDField.getText();
            String companyName=companyNameField.getText();
            String sqlStatement = "SELECT Company_ID, Company_Name "+
                    "FROM Companies "+
                    "WHERE Company_ID="+"\""+companyID+"\" "+
                    "OR Company_Name="+"\""+companyName+"\"";
            //System.out.println(sqlStatement);
            // If any field is empty
            if (companyID.equals("") || companyName.equals("")){
                // Popup Warning
                System.out.println("Please fill both Company ID and Company Name fields.");
                dbController.close();
            } else { // no field is empty
                dbController.execute(sqlStatement);
                // if record found
                if(dbController.getIsFound()) {
                    System.out.println("dbController.getIsFound(): "+dbController.getIsFound());
                    System.out.println("Duplicate found. Change Name and ID");
                } else { // duplicate found
                    lock();
                }
            }
//            resultSet = statement.executeQuery(sqlStatement);
//            if(!resultSet.isBeforeFirst()){ // no record found.
//                System.out.println("No data found: "+companyID+" "+companyName);
//            } else {
//                while (resultSet.next()) {
//                    System.out.println("Company ID: "+resultSet.getString("Company_ID"));
//                    System.out.println("Company Name: "+resultSet.getString("Company_Name"));
//                }
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            System.out.println("Closing connection...");
//            if(resultSet != null) {
//                try {
//                    resultSet.close();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//            }
//            if(statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//            }
//            if(connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//            }
//        }
        //System.out.println(companyIDField.getText()+" "+companyNameField.getText());
    }

    @FXML
    public void onCreateCompanyHandleBtn(ActionEvent e) {
        String companyID = companyIDField.getText();
        String companyName = companyNameField.getText();
        String companyAddress = companyAddrField.getText();
        String companyEMail = companyEmailField.getText();
        String companyTaxNO = companyTaxNOField.getText();
        String companyFax = companyFaxField.getText();
        String companyPhone = companyPhoneField.getText();
        DatabaseController dbController = new DatabaseController(update);
        String sqlStatement = "INSERT INTO Companies "+
                "VALUES("+"\""+ companyID +"\""+","+
                "\""+ companyName +"\""+","+
                "\""+ companyEMail +"\""+","+
                "\""+ companyAddress +"\""+","+
                "\""+ companyFax +"\""+","+
                "\""+ companyTaxNO +"\""+","+
                "\""+ companyPhone +"\""+")";
//        System.out.println(sqlStatement);
        if(companyID.equals("")||companyName.equals("")||companyAddress.equals("")||companyEMail.equals("")||companyTaxNO.equals("")
                ||companyFax.equals("")||companyPhone.equals("")){
            System.out.println("Fill all text.");
            dbController.close();
        } else {
            dbController.execute(sqlStatement);
        }
//        Connection connection = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//        try {
//            connection = DriverManager.getConnection("jdbc:sqlite:sa.sqlite");
//            statement = connection.createStatement();
//            String sqlStatement = "INSERT INTO Companies "+
//                                  "VALUES("+"\""+companyID+"\""+","+
//                                  "\""+companyName+"\""+","+
//                                  "\""+companyEMail+"\""+","+
//                                  "\""+companyAddress+"\""+","+
//                                  "\""+companyFax+"\""+","+
//                                  "\""+companyTaxNO+"\""+","+
//                                  "\""+companyPhone+"\""+")";
//            System.out.println(sqlStatement);
//            statement.executeUpdate(sqlStatement);
//        } catch (SQLException e1) {
//            e1.printStackTrace();
//        } finally {
//            if(resultSet != null) {
//                try {
//                    resultSet.close();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//            }
//            if(statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//            }
//            if(connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//            }
//        }
    }

    private void lock() {
        insertBtn.setDisable(false);
        companyIDField.setDisable(true);
        companyNameField.setDisable(true);
    }
}
