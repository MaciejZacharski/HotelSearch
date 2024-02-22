package Model;

public enum FlightClass {

    BUSINESS("business"),
    ECONOMY("economy"),
    FIRST("first");
    String name;
    public String getName() {
        return name;
    }

    FlightClass(String name) {
        this.name = name;
    }



}
