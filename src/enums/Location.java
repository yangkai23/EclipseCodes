package enums;

public enum Location {
    NELLORE(524004), BENGALURU(514526), HYDERABAD(562478), CHENNAI(502369);
    private int pincode;

    private Location(int pincode) {
        this.pincode = pincode;
    }

    public static void main(String[] args) {
        System.out.println(Location.NELLORE.name());
        System.out.println(Location.CHENNAI.getDeclaringClass());
        System.out.println(Location.CHENNAI.getPincode());
        System.out.println(Location.NELLORE);
    }

    public int getPincode() {
        return this.pincode;
    }
}
