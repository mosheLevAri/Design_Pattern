package il.co.lird.FS133.WS.DesignPattern.FectoryPattern;

class Animal{

    static {
        System.out.println("Static block Animal 1");
    }

    {
        System.out.println("Instance initialization block Animal");
    }

    public Animal(){
        System.out.println("Animal Ctor");
        this.ID = ++counter;
        sayHello();
        showCounter();
        System.out.println(toString());
        System.out.println(super.toString());
    }

    public Animal(int num_masters){
        System.out.println("Animal Ctor int");
        this.ID = ++counter;
        this.num_masters = num_masters;
    }

    public void sayHello(){
        System.out.println("Animal Hello!");
        System.out.println("I have "+ num_legs + " legs");
    }

    public static void showCounter(){
        System.out.println(counter);
    }

    public int getNumMasters(){
        return this.num_masters;
    }

    @Override
    public String toString(){
        return "Animal with ID: " + ID;
    }

    @Override
    protected void finalize() throws Throwable{
        System.out.println("finalize Animal with ID:" + this.ID);
        super.finalize();
    }

    static {
        System.out.println("Static block Animal 2");
    }

    private int num_legs = 5;
    public static int counter = 0;
    private int num_masters = 1;
    int ID;
}

class Dog extends Animal {
    public Dog(){
        super(2);
        System.out.println("Dog Ctor");
    }

    private Dog(Integer num_masters){
        super(num_masters);
        System.out.println("Dog Ctor");
    }

    static {
        System.out.println("Static block Dog");
    }

    public void sayHello(){
        System.out.println("Dog Hello!");
        System.out.println("I have "+ num_legs + " legs");
    }

    {
        System.out.println("Instance initialization block Dog");
    }

    @Override
    protected void finalize() throws Throwable{
        System.out.println("finalize Dog with ID:" + this.ID);
        super.finalize();
    }

    @Override
    public String toString(){
        return "Dog with ID: " + ID;
    }



    private int num_legs = 4;
    int x = 5;

    public static Dog ofStatic(Integer integer) {
        return new Dog(integer);
    }

}

class Cat extends Animal {
    public Cat(){
        this("black");
        System.out.println("Cat Ctor");
        this.num_masters = 2;
    }

    static {
        System.out.println("Static block Cat");
    }

    public Cat(String colors){
        this.colors = colors;
        System.out.println("Cat Ctor with color: " + this.colors);
    }

    @Override
    protected void finalize() throws Throwable{
        System.out.println("finalize Cat with ID:" + this.ID);
        super.finalize();
    }

    @Override
    public String toString(){
        return "Cat with ID: " + ID;
    }

    public Cat of(Integer num){
        System.out.println("Cat with number " + num);
        return new Cat();
    }

    private String colors;
    private int num_masters = 5;
}

class LegendaryAnimal extends Cat {
    public LegendaryAnimal(){
        System.out.println("Legendary Ctor");
    }


    static {
        System.out.println("Static block Legendary Animal");
    }

    public void sayHello(){
        System.out.println("Legendary Hello!");
    }

    @Override
    protected void finalize() throws Throwable{
        System.out.println("finalize LegendaryAnimal with ID:" + this.ID);
        super.finalize();
    }

    @Override
    public String toString(){
        return "LegendaryAnimal with ID: " + ID;
    }
}