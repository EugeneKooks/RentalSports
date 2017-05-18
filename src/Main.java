import java.io.IOException;
import java.util.Map;

/**
 * Created by Ку on 16.05.2017.
 */
public class Main {
    public static void main(String[] args) {
            Map<SportEquipment, Integer> map;
            Shop shop;
            try {
                map = new RentalControlSystem().constructMapFromFile("C:\\Users\\Ку\\IdeaProjects\\RentalSports\\source_file.txt");
                shop = new Shop(map); }
                catch (IOException e) {
                e.printStackTrace();
                shop = new Shop(); }
            RentUnit rentUnit = new RentUnit();

            SportEquipment treadmill_in_rent = new SportEquipment(Category.EXERCISE_MACHINES, "treadmill", 13);
            SportEquipment ball_in_rent = new SportEquipment(Category.OTHERS, "ball", 10);
            SportEquipment bike_in_rent = new SportEquipment(Category.VEHICLES, "bike", 25);
            SportEquipment another_bike_in_rent = new SportEquipment(Category.VEHICLES, "bike", 30);

            RentalControlSystem.rentSomething(treadmill_in_rent, shop, rentUnit);
            RentalControlSystem.rentSomething(ball_in_rent, shop, rentUnit);
            RentalControlSystem.rentSomething(bike_in_rent, shop, rentUnit);
            RentalControlSystem.rentSomething(another_bike_in_rent, shop, rentUnit);

            RentalControlSystem.printGoods(shop.getGoods(), 1);
            RentalControlSystem.printGoods(shop.getRentedItems(), 2);
        }
    }

