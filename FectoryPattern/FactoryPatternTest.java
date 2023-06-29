package il.co.lird.FS133.WS.DesignPattern.FectoryPattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



class FactoryPatternTest {


    static Dog createDod()
    {
        return new Dog();
    }

    FactoryPattern<String, Animal, Integer> Factory_animal ;

    @BeforeEach
    void setUp()
    {
        Factory_animal = new FactoryPattern<>();
    }


    @Test
    void createObject() {

        Cat cat = new Cat();
        Factory_animal.addCreator("Animal",param ->  new Animal(param));
        Factory_animal.addCreator("Dog",Dog ::ofStatic);
        Factory_animal.addCreator("Cat", cat::of);


        Animal animal = Factory_animal.createObject("Animal", 2);
        Animal dog = Factory_animal.createObject("Dog", 0);
        Animal cat_instance = Factory_animal.createObject("Cat", 100000);


        System.out.println(animal.getNumMasters());
        System.out.println(dog.getNumMasters());
        System.out.println(cat_instance.getNumMasters());

        assertNotNull(animal);
        assertEquals(2, animal.getNumMasters());
    }
}