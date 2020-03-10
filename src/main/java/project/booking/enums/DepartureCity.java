package project.booking.enums;

public enum DepartureCity {
    KIEV("KBP");

    private final String code;

    DepartureCity(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}