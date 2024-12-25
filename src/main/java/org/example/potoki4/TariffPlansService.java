package org.example.potoki4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class TariffPlansService {
    private final TariffPlansRepository tariffPlansRepository;

    public TariffPlansService(TariffPlansRepository tariffPlansRepository) {
        this.tariffPlansRepository = tariffPlansRepository;
    }

    private final ObservableList<TariffPlans> tariffPlans_list = FXCollections.observableArrayList();

    public void read(TableView tariff_table,
                     TableColumn id_tariff_plans,
                     TableColumn name,
                     TableColumn cost,
                     TableColumn speed) {
        id_tariff_plans.setCellValueFactory(new PropertyValueFactory<>("id_tariff_plans"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        speed.setCellValueFactory(new PropertyValueFactory<>("speed"));
        tariffPlansRepository.read(tariff_table, tariffPlans_list);

    }

    public void create(int id_tariff_plans, String name, double cost, String speed) {
        tariffPlansRepository.create(id_tariff_plans, name, cost, speed);
    }

    public void update(int id_tariff_plans, String name, double cost, String speed) {
        tariffPlansRepository.update(id_tariff_plans, name, cost, speed);
    }

    public void delete(int id_tariff_plans) {
        tariffPlansRepository.delete(id_tariff_plans);
    }

}