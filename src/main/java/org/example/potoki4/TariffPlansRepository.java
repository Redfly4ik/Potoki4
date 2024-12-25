package org.example.potoki4;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TariffPlansRepository {
    private final Database db = new Database();
    private final Connection connection = db.getConnection();

    public void read(TableView TariffTable, ObservableList<TariffPlans> tariffPlansList) {
        tariffPlansList.clear();
        String sql = "SELECT id_tariff_plans, name, cost, speed FROM tariff_plans";
        try (PreparedStatement statement = this.connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id_tariff_plans = resultSet.getInt("id_tariff_plans");
                String name = resultSet.getString("name");
                double cost = resultSet.getDouble("cost");
                int speed = resultSet.getInt("speed");
                TariffPlans tariffPlans = new TariffPlans(id_tariff_plans, name, cost, speed);
                tariffPlansList.add(tariffPlans);
            }
            TariffTable.setItems(tariffPlansList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create(int id_tariff_plans, String name, double cost, String speed) {
        String sql = "INSERT INTO tariff_plans (id_tariff_plans, name, cost, speed) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setInt(1, id_tariff_plans);
            statement.setString(2, name);
            statement.setDouble(3, cost);
            statement.setString(4, speed);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id_tariff_plans, String name, double cost, String speed) {
        String sql = "UPDATE tariff_plans SET name = ?, cost = ?, speed = ? WHERE id_tariff_plans = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setDouble(2, cost);
            statement.setString(3, speed);
            statement.setInt(4, id_tariff_plans);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id_tariff_plans) {
        String sql = "DELETE FROM tariff_plans WHERE id_tariff_plans = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setInt(1, id_tariff_plans);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}