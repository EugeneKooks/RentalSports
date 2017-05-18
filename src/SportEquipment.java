/**
 * Created by Ку on 16.05.2017.
 */
public class SportEquipment {
    private Category category;
    private String title;
    private int price;
    public SportEquipment(Category category, String title, int price) {
        this.category = category;
        this.title = title.toUpperCase();
        this.price = price;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportEquipment that = (SportEquipment) o;
        if (getPrice() != that.getPrice()) return false;
        if (getCategory() != that.getCategory()) return false;
        return getTitle() != null ? getTitle().equals(that.getTitle()) : that.getTitle() == null;
    }
    @Override
    public int hashCode() {
        int result = getCategory() != null ? getCategory().hashCode() : 0;
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + getPrice();
        return result;
    }
   @Override
    public String toString() {
        return "SportEquipment{" + "category : " + category + ", title : " + title + ',' + " price : " + price + "$ per/month" + '}';}
    public Category getCategory() {
        return category;
    }
    public String getTitle() {
        return title;
    }
    public int getPrice() {
        return price;
    }
}
