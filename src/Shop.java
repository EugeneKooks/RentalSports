import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ку on 16.05.2017.
 */
public class Shop {
    private Map<SportEquipment,Integer> goods; // value - доступный товар
    private Map<SportEquipment, Integer> rentedItems;
    public Shop() {
        goods = new HashMap<>();
        rentedItems = new HashMap<>();
    }
    public Shop(Map<SportEquipment, Integer> goods) {
        this.goods = goods;
        rentedItems = new HashMap<>();
    }
    public Map<SportEquipment, Integer> getGoods() {
        return goods;
    }
    public Map<SportEquipment, Integer> getRentedItems() {
        return rentedItems;
    }
}
