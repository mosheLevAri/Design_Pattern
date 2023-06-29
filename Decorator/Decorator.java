package il.co.lird.FS133.WS.DesignPattern.Decorator;

interface Pizza {
    String getDescription();
    int getPrice();
}

class PeppyPaneer implements Pizza {
    @Override
    public String getDescription() {
        return "Peppy Paneer pizza";
    }

    @Override
    public int getPrice() {
        return 10;
    }
}

class Farmhouse implements Pizza {
    @Override
    public String getDescription() {
        return "Farmhouse pizza";
    }

    @Override
    public int getPrice() {
        return 11;
    }
}

class Margherita implements Pizza {
    @Override
    public String getDescription() {
        return "Margherita pizza";
    }

    @Override
    public int getPrice() {
        return 12;
    }
}

class ChickenFiesta implements Pizza {
    @Override
    public String getDescription() {
        return "Chicken Fiesta pizza";
    }

    @Override
    public int getPrice() {
        return 13;
    }
}
//--------------------------------------------------------------------------------------------------------------------//
abstract class PizzaDecor implements Pizza {
    protected Pizza pizza;

    public PizzaDecor (Pizza pizza) {
        this.pizza = pizza;
    }
}

class FreshTomatoTopping extends PizzaDecor {
    public FreshTomatoTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " with Fresh Tomato";
    }

    @Override
    public int getPrice() {
        return pizza.getPrice() + 1;
    }
}

class PaneerTopping extends PizzaDecor {
    public PaneerTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " with Paneer";
    }

    @Override
    public int getPrice() {
        return pizza.getPrice() + 2;
    }
}

class JalapenoTopping extends PizzaDecor {
    public JalapenoTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " with Jalapeno";
    }

    @Override
    public int getPrice() {
        return pizza.getPrice() + 4;
    }
}

class CapsicumTopping extends PizzaDecor {
    public CapsicumTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " with Capsicum";
    }

    @Override
    public int getPrice() {
        return pizza.getPrice() + 3;
    }
}

class BBQTopping extends PizzaDecor {
    public BBQTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " with BBQ";
    }

    @Override
    public int getPrice() {
        return pizza.getPrice() + 5;
    }
}
//--------------------------------------------------------------------------------------------------------------------//
public class Decorator {
    public static void main(String[] args) {
        Pizza myPizza = new PeppyPaneer();
        System.out.println("The price of " + myPizza.getDescription() + " is " + myPizza.getPrice());
        // Should Print: The price of Peppy Paneer pizza is 10

        myPizza = new JalapenoTopping(myPizza);
        System.out.println("The price of " + myPizza.getDescription() + " is " + myPizza.getPrice());
        // Should Print: The price of Peppy Paneer pizza with Jalapeno is 14

        myPizza = new JalapenoTopping(myPizza);
        System.out.println("The price of " + myPizza.getDescription() + " is " + myPizza.getPrice());
        // Should Print: The price of Peppy Paneer pizza with Jalapeno with Jalapeno is 18

        myPizza = new BBQTopping(myPizza);
        System.out.println("The price of " + myPizza.getDescription() + " is " + myPizza.getPrice());
        // Should Print:
        // The price of Peppy Paneer pizza with Jalapeno with Jalapeno with BBQ is 23
    }
}
