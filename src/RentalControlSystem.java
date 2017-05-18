import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Ку on 16.05.2017.
 */
public class RentalControlSystem {
    public Map<SportEquipment, Integer> constructMapFromFile(String fileName) throws IOException{
        Map<SportEquipment, Integer> map = new LinkedHashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String readLine;
        List<String> lines = new ArrayList<>();
        while ((readLine = reader.readLine()) != null) {
            lines.add(readLine);
        }
        for (String line : lines) {
            String[] split = line.split(" ");
            map.put(new SportEquipment(Category.valueOf(split[0].toUpperCase()), split[1].toUpperCase(), Integer.parseInt(split[2])),
                    Integer.parseInt(split[3]));
        }
        return map;
    }
    public static void rentSomething(SportEquipment equipment, Shop shop, RentUnit rentUnit) {
        if (shop.getGoods().containsKey(equipment)) {                    // если в магазине вообще такой товар представлен
            Integer value = shop.getGoods().get(equipment);
            if (value != 0) {                                            // есть хоть одна единица
                if (rentUnit.addItem(equipment)) {                       // и если можно взять в прокат
                    shop.getGoods().put(equipment, --value);             // забираем 1 штуку из магазина
                    if (shop.getRentedItems().containsKey(equipment)) {  // если такую штуку уже взяли в корзину, то добавляем еще одну
                        value = shop.getRentedItems().get(equipment);
                        shop.getRentedItems().put(equipment, ++value);
                    } else {
                        shop.getRentedItems().put(equipment, 1);    // кладем во взятое в прокат единицу, если еще не брали такой товар
                    }
                }
            }
        }
    }
    public static void printGoods(Map<SportEquipment, Integer> map, int goodsType) {
        String info = null;
        if (goodsType == 1) {
            info = "AVAILABLE FOR RENT:";
        } else if (goodsType == 2) {
            info = "RENTED:";
        }
        if (!map.isEmpty()) {
            System.out.println("--------------------");
            System.out.println(info);
            System.out.println("--------------------");
            for (Map.Entry<SportEquipment,Integer> entry: map.entrySet())
            System.out.println(entry.getKey() + " = " + entry.getValue() + " piece(s)");
            System.out.println("****************************************************************************************");
        }
    }
}
