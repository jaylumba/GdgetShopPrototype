package jcl.com.gadgetshop.enums;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */

public enum  PRODUCT_CATEGORY {

    LAPTOP("Laptop"),
    MOBILEPHONE("MobilePhone"),
    ALL("All");

    String text;

    PRODUCT_CATEGORY(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }

    public static PRODUCT_CATEGORY fromString(String text) {
        if (text != null) {
            for (PRODUCT_CATEGORY stat : PRODUCT_CATEGORY.values()) {
                if (text.equalsIgnoreCase(stat.text)) {
                    return stat;
                }
            }
        }
        return null;
    }
}
