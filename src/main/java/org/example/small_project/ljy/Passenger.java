package org.example.small_project.ljy;


public class Passenger {
    protected String id;
    protected int cash;
    protected int birth;  // YYYYMMDD
    protected String type;

    public Passenger(String id, int cash, int birth) {
        this.id = id;
        this.cash = cash;
        this.birth = birth;
    }

    public int getAge() {
        return 2025 - (birth / 10000);
    }

    public void setType(String type){
        this.type = type;
    }

    public boolean pay(int amount) {
        if (cash < amount) return false;
        cash -= amount;
        return true;
    }

    public void charge(int amount) {
        cash += amount;
    }

    public int getCash() {
        return cash;
    }
}
