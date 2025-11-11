/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;
import com.example.tugasapp.model.Tugas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TugasController {

    @FXML private TextField tfJudul;
    @FXML private TextArea taDeskripsi;
    @FXML private DatePicker dpDeadline;
    @FXML private ComboBox<String> cbStatus;
    @FXML private TableView<Tugas> tableTugas;
    @FXML private TableColumn<Tugas, String> colJudul;
    @FXML private TableColumn<Tugas, String> colDeskripsi;
    @FXML private TableColumn<Tugas, String> colDeadline;
    @FXML private TableColumn<Tugas, String> colStatus;

    private ObservableList<Tugas> listTugas;

    @FXML
    public void initialize() {
        cbStatus.setItems(FXCollections.observableArrayList("Belum Dikerjakan", "Dikerjakan", "Selesai"));

        listTugas = FXCollections.observableArrayList();
        tableTugas.setItems(listTugas);

        colJudul.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getJudul()));
        colDeskripsi.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDeskripsi()));
        colDeadline.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(
                data.getValue().getTanggalDeadline() != null ? data.getValue().getTanggalDeadline().toString() : ""));
        colStatus.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getStatus()));

        tableTugas.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                tfJudul.setText(newSel.getJudul());
                taDeskripsi.setText(newSel.getDeskripsi());
                dpDeadline.setValue(newSel.getTanggalDeadline());
                cbStatus.setValue(newSel.getStatus());
            }
        });
    }

    @FXML
    private void handleAdd() {
        String judul = tfJudul.getText();
        String deskripsi = taDeskripsi.getText();
        var deadline = dpDeadline.getValue();
        String status = cbStatus.getValue();

        if (judul.isEmpty() || deskripsi.isEmpty() || deadline == null || status == null) {
            showAlert("Harap isi semua field!");
            return;
        }

        listTugas.add(new Tugas(judul, deskripsi, deadline, status));
        clearForm();
    }

    @FXML
    private void handleUpdate() {
        Tugas selected = tableTugas.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setJudul(tfJudul.getText());
            selected.setDeskripsi(taDeskripsi.getText());
            selected.setTanggalDeadline(dpDeadline.getValue());
            selected.setStatus(cbStatus.getValue());
            tableTugas.refresh();
            clearForm();
        } else {
            showAlert("Pilih data yang ingin diupdate!");
        }
    }

    @FXML
    private void handleDelete() {
        Tugas selected = tableTugas.getSelectionModel().getSelectedItem();
        if (selected != null) {
            listTugas.remove(selected);
            clearForm();
        } else {
            showAlert("Pilih data yang ingin dihapus!");
        }
    }

    @FXML
    private void handleClear() {
        clearForm();
    }

    private void clearForm() {
        tfJudul.clear();
        taDeskripsi.clear();
        dpDeadline.setValue(null);
        cbStatus.setValue(null);
        tableTugas.getSelectionModel().clearSelection();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
    
}
