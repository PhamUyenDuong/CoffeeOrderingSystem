import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class MyController {
    @FXML
    private TextArea currentOrder, checkOutItems;

//    @FXML
//    private TextArea

    private Order order = new Order();
    boolean isCreated = false;

    public void displayOrder(){
        currentOrder.clear();
        currentOrder.setText(order.to_string());
    }

    public void newCoffee(){
        isCreated = true;
        order.clear();
        displayOrder();
    }

    public void addOnCream(){
        if (!isCreated) return;
        order.cream_addOn();
        displayOrder();
    }

    public void addOnSugar(){
        if (!isCreated) return;
        order.sugar_addOn();
        displayOrder();
    }

    public void addOnChocolate(){
        if (!isCreated) return;
        order.chocolate_addOn();
        displayOrder();
    }

    public void addOnGold(){
        if (!isCreated) return;
        order.gold_addOn();
        displayOrder();
    }

    public void addOnExtraShot(){
        if (!isCreated) return;
        order.extraShot_addOn();
        displayOrder();
    }

    public void deleteCoffee(){
        isCreated = false;
        order.clear();
        currentOrder.clear();
        checkOutItems.clear();
    }

    public void checkOut(){
        isCreated = false;
        double total = order.calculateTotal();
        String itemsList = order.getFinalOrder();

        checkOutItems.setText(itemsList + "\nTotal: $" + total);
    }
}
