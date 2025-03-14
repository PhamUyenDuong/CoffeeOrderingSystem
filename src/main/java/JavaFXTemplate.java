import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


interface Coffee{
	public double makeCoffee();
}

class BasicCoffee implements Coffee{

	private double cost = 4.50;

	@Override
	public double makeCoffee() {
		// TODO Auto-generated method stub
		System.out.println("Black Coffee: $4.50");

		return cost;
	}
}

abstract class CoffeeDecorator implements Coffee{
	protected Coffee specialCoffee;

	public CoffeeDecorator(Coffee specialCoffee) {
		this.specialCoffee = specialCoffee;
	}

	public double makeCoffee() {
		return specialCoffee.makeCoffee();
	}
}

class ExtraShot extends CoffeeDecorator{

	private double cost = 1.20;

	ExtraShot(Coffee specialCoffee){
		super(specialCoffee);
	}

	public double makeCoffee() {
		return specialCoffee.makeCoffee() + addShot();
	}

	private double addShot() {
		System.out.println(" + extra shot: $1.20");

		return cost;
	}
}

class Cream extends CoffeeDecorator{

	private double cost = .50;
	Cream(Coffee specialCoffee){
		super(specialCoffee);
	}

	public double makeCoffee() {
		return specialCoffee.makeCoffee() + addCream();
	}

	private double addCream() {

		System.out.println(" + cream: $.50");

		return cost;
	}
}

class Sugar extends CoffeeDecorator{

	private double cost = .50;

	Sugar(Coffee specialCoffee){
		super(specialCoffee);
	}

	public double makeCoffee() {
		return specialCoffee.makeCoffee()+ addSugar();
	}

	private double addSugar() {

		System.out.println(" + sugar: $.50");

		return cost;
	}
}

class Chocolate extends CoffeeDecorator{

	private double cost = 1.0;

	Chocolate(Coffee specialCoffee){
		super(specialCoffee);
	}

	public double makeCoffee() {
		return specialCoffee.makeCoffee()+ addChocolate();
	}

	private double addChocolate() {

		System.out.println(" + Chocolate: $1.0");

		return cost;
	}
}

class Gold extends CoffeeDecorator{

	private double cost = 10.0;

	Gold(Coffee specialCoffee){
		super(specialCoffee);
	}

	public double makeCoffee() {
		return specialCoffee.makeCoffee()+ addGold();
	}

	private double addGold() {

		System.out.println(" + Gold: $10.0");

		return cost;
	}
}

class Order{
	private Coffee currCoffee;
	private String addOns;
	private int count;
	private String finalOrder;

	Order(){
		count = 1;
		addOns = "1.  Black Coffee: $4.5\n";
		finalOrder = "Black Coffee: $4.5\n";
		currCoffee = new BasicCoffee();
	}

	public void addItems(String item){
		count += 1;
		addOns += count + ".  " + item + "\n";
		finalOrder += " + " + item + "\n";
	}

	public void clear(){
		count = 1;
		addOns = "1.  Basic Coffee: $4.5\n";
		finalOrder = "Basic Coffee: $4.5\n";
		currCoffee = new BasicCoffee();
	}

	public void cream_addOn(){
		addItems("Cream: $0.5");
		currCoffee = new Cream(currCoffee);
	}

	public void sugar_addOn(){
		addItems("Sugar: $0.5");
		currCoffee = new Sugar(currCoffee);
	}

	public String to_string(){
		return addOns;
	}

	public void extraShot_addOn(){
		addItems("ExtraShot: $1.2");
		currCoffee = new ExtraShot(currCoffee);
	}

	public void chocolate_addOn(){
		addItems("Chocolate: $1.0");
		currCoffee = new Chocolate(currCoffee);
	}

	public void gold_addOn(){
		addItems("Gold: $10.0");
		currCoffee = new Gold(currCoffee);
	}

	public double calculateTotal(){
		return currCoffee.makeCoffee();
	}

	public String getFinalOrder(){
		return finalOrder;
	}
}

public class JavaFXTemplate extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/FXML/Coffee.fxml"));
		Scene scene = new Scene(root, 500,500);
		scene.getStylesheets().add("/Style/coffee.css");

		primaryStage.setTitle("Energy = milk x coffee^2");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}


