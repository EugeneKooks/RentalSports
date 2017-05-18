/**
 * Created by Ку on 16.05.2017.
 */
public class RentUnit {
    private SportEquipment [] units;
    private static final int RENT_LIMIT = 3;
    public RentUnit() {
        units = new SportEquipment[RENT_LIMIT];
    }
    public boolean addItem(SportEquipment itemToRent) {
        for (int i = 0; i < getUnits().length; i++) {
            if (getUnits()[i] == null) {
                getUnits()[i] = itemToRent;
                return true;
            }
        }
        return false;
    }
    public SportEquipment[] getUnits() {
        return units;
    }
}
