package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


import java.io.IOException;

public class FindpageController {
    public  String searchKey;
    private String FirstPage = "firstpage.fxml";
    private String DetailPage = "detailpage.fxml";



    //Table Value==================================
    @FXML
    private TextField filterField;
    @FXML
    private TableView<FindTable> findTable;
    @FXML
    private TableColumn<FindTable,String> IDColum;
    @FXML
    private TableColumn<FindTable, String> TypeColum;
    @FXML
    private TableColumn<FindTable, String> CompNameColum;
    @FXML
    private TableColumn<FindTable, String> CompIDColum;
    @FXML
    private TableColumn<FindTable, String> dateColum;

    private ObservableList<FindTable> masterData = FXCollections.observableArrayList();//master == all data
    private ObservableList<FindTable> filteredData = FXCollections.observableArrayList();//filter == your fillter


    //==RadioBtn FXID===================================================
    @FXML
    private RadioButton name;
    @FXML
    private RadioButton ID;
    @FXML
    private RadioButton date;
    @FXML
    private RadioButton poOrsoID;

    //==Btn FXID=====================================================
    @FXML
    private Button backButton;
    @FXML
    private Button submitBtn;
    @FXML
    private Button detailBtn;

    //Action========================================================
    @FXML
    public void submitBtnAction(ActionEvent event){
        masterData.add(new FindTable("01", "PO","wan","1","1/2/2566"));
        masterData.add(new FindTable("02", "SO","tan","2","1/2/2558"));
        masterData.add(new FindTable("03", "SO","arm","3","2/1/2070"));
        masterData.add(new FindTable("04", "PO","bird","4","5/5/2555"));
        masterData.add(new FindTable("05", "PO","arm","3","8/5/2569"));
        masterData.add(new FindTable("06", "SO","tan","2","7/5/2693"));
        if (ID.isSelected()){
            searchKey = "ID";


            System.out.println("search by ID");
        }else if (name.isSelected()){
            searchKey = "Name";
            System.out.println("search by Name");
        }else if (date.isSelected()){
            searchKey = "Date";
            System.out.println("search by Date");
        }else if (poOrsoID.isSelected()){
            searchKey = "PO/SO ID";
            System.out.println("search by PO/SO ID");
        }
        else{
            System.out.println("Not Select");
            System.out.println(masterData.toString());
        }
    }
    @FXML
    public void detailBtnAction(ActionEvent event){
        System.out.println("Detail");




    }
    @FXML
    public void handleBackButtonAction(ActionEvent e){
        Button b = (Button) e.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setTitle("Main Menu");
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FirstPage));
        try{
            stage.setScene(new Scene(loader.load(),800,600));
            FirstPageController controller = (FirstPageController) loader.getController();

        } catch (IOException e1){
            e1.printStackTrace();
        }
    }



}
