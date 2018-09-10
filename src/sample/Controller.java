package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class Controller {
    private ObservableList<PersonDTO> table;

    public Controller(){
        table = FXCollections.observableArrayList();
    }

    @FXML
    public void initialize() throws IOException {
        firstNameCol.setCellValueFactory(new PropertyValueFactory<PersonDTO, String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<PersonDTO, String>("lastName"));
        ageCol.setCellValueFactory(new PropertyValueFactory<PersonDTO, Integer>("age"));

        tableComp.setItems(table);
       // tableComp.getColumns().addAll(firstNameCol, lastNameCol, ageCol);
    }

    @FXML
    private TextField imie;

    @FXML
    private TextField nazwisko;

    @FXML
    private TextField wiek;

    @FXML
    private Button zapisz;

    @FXML
    private TableView<PersonDTO> tableComp;

    @FXML
    private TableColumn<PersonDTO, String> firstNameCol;

    @FXML
    private TableColumn<PersonDTO, String> lastNameCol;

    @FXML
    private TableColumn<PersonDTO, Integer> ageCol;

    @FXML
    void onZapiszAction(ActionEvent event) {

        PersonDTO person = new PersonDTO(imie.getText(), nazwisko.getText(), Integer.parseInt(wiek.getText()));
        table.add(person);
    }

    public static class PersonDTO {
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleIntegerProperty age;

        private PersonDTO(String fName, String lName, int age) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.age = new SimpleIntegerProperty(age);
        }

        public String getFirstName() {
            return firstName.get();
        }
        public void setFirstName(String fName) {
            firstName.set(fName);
        }

        public String getLastName() {
            return lastName.get();
        }
        public void setLastName(String fName) {
            lastName.set(fName);
        }

        public int getAge() {
            return age.get();
        }
        public void setAge(int age) {
            this.age.set(age);
        }

    }


}
