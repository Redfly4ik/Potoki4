package org.example.potoki4;
import javafx.scene.control.*;
public class TariffPlansController {

    public TableView tariff_table;
    public TableColumn id_tariff_plans;
    public TableColumn name;
    public TableColumn cost;
    public TableColumn speed;

    public Label id_tariff_plansLabel;
    public Label nameLabel;
    public Label costLabel;
    public Label speedLabel;


    public TextField id_tariff_plansTextField;
    public TextField nameTextField;
    public TextField costTextField;
    public TextField speedTextField;
    TariffPlansRepository dbCtrl = new TariffPlansRepository();
    TariffPlansService uCtrl = new TariffPlansService(dbCtrl);

    public void initialize() {
        read();
        autofill();
    }

    private void read() {
        uCtrl.read(tariff_table, id_tariff_plans, name, cost, speed);
    }

    public void createButton() {
        uCtrl.create(Integer.parseInt(id_tariff_plansTextField.getText()),
                nameTextField.getText(),
                Double.parseDouble(costTextField.getText()),
                speedTextField.getText());
        read();
    }

    public void updateButton() {
        uCtrl.update(Integer.parseInt(id_tariff_plansTextField.getText()),
                nameTextField.getText(),
                Double.parseDouble(costTextField.getText()),
                speedTextField.getText());
        read();
    }

    public void deleteButton() {
        uCtrl.delete(Integer.parseInt(id_tariff_plansTextField.getText()));
        read();
    }

    private void autofill() {
        tariff_table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue == null) return;
            TariffPlans selectedTariffPlans = (TariffPlans) newValue;
            id_tariff_plansTextField.setText(String.valueOf(selectedTariffPlans.getId_tariff_plans()));
            nameTextField.setText(selectedTariffPlans.getName());
            costTextField.setText(String.valueOf(selectedTariffPlans.getCost()));
            speedTextField.setText(String.valueOf(selectedTariffPlans.getSpeed()));
        });
    }
}
