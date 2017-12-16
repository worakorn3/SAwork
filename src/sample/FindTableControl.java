package sample;

import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FindTableControl {
    @FXML
    private TextField filterField;
    @FXML
    private TableView<FindTable> findTable;
    @FXML
    private TableColumn<FindTable, String> IDColum;
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

    public FindTableControl() {
        // Add to master
        masterData.add(new FindTable("01", "PO","wan","1","1/2/2566"));
        masterData.add(new FindTable("02", "SO","tan","2","1/2/2558"));
        masterData.add(new FindTable("03", "SO","arm","3","2/1/2070"));
        masterData.add(new FindTable("04", "PO","bird","4","5/5/2555"));
        masterData.add(new FindTable("05", "PO","arm","3","8/5/2569"));
        masterData.add(new FindTable("06", "SO","tan","2","7/5/2693"));


        // Add to filter
        filteredData.addAll(masterData);

        // Listen for changes in master data.
        // Whenever the master data changes we must also update the filtered data.
        masterData.addListener(new ListChangeListener<FindTable>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends FindTable> change) {
                updateFilteredData();
            }
        });
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the FindTable table
        IDColum.setCellValueFactory(
                new PropertyValueFactory<FindTable, String>("ID"));
        TypeColum.setCellValueFactory(
                new PropertyValueFactory<FindTable, String>("Type"));

        // Add filtered data to the table
        findTable.setItems(filteredData);

        // Listen for text changes in the filter text field
        filterField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {

                updateFilteredData();
            }
        });
    }

    /**
     * Updates the filteredData to contain all data from the masterData that
     * matches the current filter.
     */
    private void updateFilteredData() {
        filteredData.clear();

        for (FindTable p : masterData) {
            if (matchesFilter(p)) {
                filteredData.add(p);
            }
        }

        // Must re-sort table after items changed
//        reapplyTableSortOrder();
    }

    /**
     * Returns true if the fiiTable matches the current filter. Lower/Upper case
     * is ignored.
     *
     * @param findTable
     * @return
     */
    private boolean matchesFilter(FindTable findTable) {
        String filterString = filterField.getText();
        if (filterString == null || filterString.isEmpty()) {
            // No filter --> Add all.
            return true;
        }

        String lowerCaseFilterString = filterString.toLowerCase();

//        if (FindTable.getID().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
//            return true;
//        } else if (FindTable.getType().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
//            return true;
//        }

        return false; // Does not match
    }

//    private void reapplyTableSortOrder() {
//        ArrayList<TableColumn<FindTable, ?>> sortOrder = new ArrayList<>(FindTable.getSortOrder());
//        FindTable.getSortOrder().clear();
//        FindTable.getSortOrder().addAll(sortOrder);
//    }




}

