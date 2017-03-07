package jcl.com.gadgetshop.enums;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */

public enum ORDER_STATUS {

    DRAFT("Draft"),
    CANCELLED("Cancelled"),
    COMPLETED("Completed");

    String text;

    ORDER_STATUS(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }

    public static ORDER_STATUS fromString(String text) {
        if (text != null) {
            for (ORDER_STATUS stat : ORDER_STATUS.values()) {
                if (text.equalsIgnoreCase(stat.text)) {
                    return stat;
                }
            }
        }
        return null;
    }
}
