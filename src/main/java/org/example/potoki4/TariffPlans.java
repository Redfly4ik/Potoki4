package org.example.potoki4;

public class TariffPlans {
    private final int id_tariff_plans;
    private final String name;
    private final double cost;
    private final int speed;

    public TariffPlans(int id_tariff_plans, String name, double cost, int speed) {
        this.id_tariff_plans = id_tariff_plans;
        this.name = name;
        this.cost = cost;
        this.speed = speed;
    }

    public int getId_tariff_plans() {
        return id_tariff_plans;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getSpeed() {
        return speed;
    }
}