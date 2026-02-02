import java.io.IOException;

// Factory Design Pattern:
// - It is a creational design pattern that deals with object creation
// - Instead of creating objects directly using new, we delegate responsibility of object creation to a factory
// - Factory hides the logic of object creation
// - Factory design pattern provides an interface for creating objects and lets subclasses to decide which class to instantiate

// Why do we use factory:
// - Client code is tightly coupled with concrete classes
// - On every change in class have to make changes in client
// - Violates open-close principle

// Simple factory:
// - A single factory class decides which concrete class to instantiate
// - One factory class is used to create an object of multiple types

//interface Burger
//{
//    void prepare();
//}
//
//class SimpleBurger implements Burger
//{
//    @Override
//    public void prepare()
//    {
//        System.out.println("Preparing Simple Burger");
//    }
//}
//
//class StandardBurger implements Burger
//{
//    @Override
//    public void prepare()
//    {
//        System.out.println("Preparing Standard Burger");
//    }
//}
//
//class PremiumBurger implements Burger
//{
//    @Override
//    public void prepare()
//    {
//        System.out.println("Preparing Premium Burger");
//    }
//}
//
//class FactoryBurger
//{
//    static Burger createBurger(String type)
//    {
//        if(type.equals("Simple"))
//        {
//            return new SimpleBurger();
//        }
//        else if(type.equals("Standard"))
//        {
//            return new StandardBurger();
//        }
//        else if(type.equals("Premium"))
//        {
//            return new PremiumBurger();
//        }
//        throw new IllegalArgumentException("Invalid Burger Type");
//    }
//}
//
//public class FactoryDesignPattern
//{
//    public static void main(String[] args) throws IOException
//    {
//        Burger simpleBurger =  FactoryBurger.createBurger("Simple");
//        Burger standardBurger =  FactoryBurger.createBurger("Standard");
//        Burger premiumBurger =  FactoryBurger.createBurger("Premium");
//
//        simpleBurger.prepare();
//        standardBurger.prepare();
//        premiumBurger.prepare();
//    }
//}

// Factory Method:
// - Factory Method is a creational design pattern where object creation is delegated to subclasses instead of a single factory

//interface Burger
//{
//    void prepare();
//}
//
//class SimpleBurger implements Burger
//{
//    @Override public void prepare()
//    {
//        System.out.println("Preparing Simple Burger");
//    }
//}
//
//class StandardBurger implements Burger
//{
//    @Override public void prepare()
//    {
//        System.out.println("Preparing Standard Burger");
//    }
//}
//
//class PremiumBurger implements Burger
//{
//    @Override public void prepare()
//    {
//        System.out.println("Preparing Premium Burger");
//    }
//}
//
//class SimpleWheatBurger implements Burger
//{
//    @Override public void prepare()
//    {
//        System.out.println("Preparing Simple Wheat Burger");
//    }
//}
//
//class StandardWheatBurger implements Burger
//{
//    @Override public void prepare()
//    {
//        System.out.println("Preparing Standard Wheat Burger");
//    }
//}
//
//class PremiumWheatBurger implements Burger
//{
//    @Override public void prepare()
//    {
//        System.out.println("Preparing Premium Wheat Burger");
//    }
//}
//
//// Key difference from simple factory
//abstract class BurgerStore
//{
//    // Factory Method
//    protected abstract Burger createBurger(String type);
//
//    // Business Logic
//    public void orderBurger(String type)
//    {
//        Burger burger = this.createBurger(type);
//        burger.prepare();
//    }
//}
//
//class SingBurgerStore extends BurgerStore
//{
//    @Override protected Burger createBurger(String type)
//    {
//        if (type.equalsIgnoreCase("simple"))
//        {
//            return new SimpleBurger();
//        }
//        else if (type.equalsIgnoreCase("standard"))
//        {
//            return new StandardBurger();
//        }
//        else if (type.equalsIgnoreCase("premium"))
//        {
//            return new PremiumBurger();
//        }
//        throw new IllegalArgumentException("Invalid burger type");
//    }
//}
//
//class KingBurgerStore extends BurgerStore
//{
//
//    @Override protected Burger createBurger(String type)
//    {
//        if (type.equalsIgnoreCase("simple"))
//        {
//            return new SimpleWheatBurger();
//        }
//        else if (type.equalsIgnoreCase("standard"))
//        {
//            return new StandardWheatBurger();
//        }
//        else if (type.equalsIgnoreCase("premium"))
//        {
//            return new PremiumWheatBurger();
//        }
//        throw new IllegalArgumentException("Invalid burger type");
//    }
//}
//
//public class FactoryDesignPattern
//{
//    public static void main(String[] args)
//    {
//
//        BurgerStore store1 = new SingBurgerStore();
//        store1.orderBurger("simple");
//
//        BurgerStore store2 = new KingBurgerStore();
//        store2.orderBurger("standard");
//    }
//}

// Abstract factory method:
// - Abstract factory method provides an interface for creating families of related objects without specifying their concrete classes

interface Burger
{
    void prepare();
}

class SimpleBurger implements Burger
{
    @Override public void prepare()
    {
        System.out.println("Preparing Simple Burger");
    }
}

class StandardBurger implements Burger
{
    @Override public void prepare()
    {
        System.out.println("Preparing Standard Burger");
    }
}

class PremiumBurger implements Burger
{
    @Override public void prepare()
    {
        System.out.println("Preparing Premium Burger");
    }
}

class SimpleWheatBurger implements Burger
{
    @Override public void prepare()
    {
        System.out.println("Preparing Simple Wheat Burger");
    }
}

class StandardWheatBurger implements Burger
{
    @Override
    public void prepare()
    {
        System.out.println("Preparing Standard Wheat Burger");
    }
}

class  PremiumWheatBurger implements Burger
{
    @Override
    public void prepare()
    {
        System.out.println("Preparing Premium Wheat Burger");
    }
}

interface GarlicBread
{
    void prepare();
}

class SimpleGarlicBread implements GarlicBread
{
    @Override public void prepare()
    {
        System.out.println("Preparing Simple Garlic");
    }
}

class StandardGarlicBread implements GarlicBread
{
    @Override public void prepare()
    {
        System.out.println("Preparing Standard Garlic");
    }
}

class PremiumGarlicBread implements GarlicBread
{
    @Override public void prepare()
    {
        System.out.println("Preparing Premium Garlic");
    }
}

class SimpleWheatGarlicBread implements GarlicBread
{
    @Override
    public void prepare()
    {
        System.out.println("Preparing Simple Wheat Garlic");
    }
}

class StandardWheatGarlicBread implements GarlicBread
{
    @Override
    public void prepare()
    {
        System.out.println("Preparing Standard Wheat Garlic");
    }
}

class PremiumWheatGarlicBread implements GarlicBread
{
    @Override
    public void prepare()
    {
        System.out.println("Preparing Premium Wheat Garlic");
    }
}

interface Factory
{
    Burger createBurger(String type);
    GarlicBread createGarlicBread(String type);
}

class SingFactory implements Factory
{
    @Override
    public Burger createBurger(String type)
    {
        if(type.equalsIgnoreCase("simple"))
        {
            return new SimpleBurger();
        }
        else if(type.equalsIgnoreCase("standard"))
        {
            return new StandardBurger();
        }
        else if(type.equalsIgnoreCase("premium"))
        {
            return new PremiumBurger();
        }
        throw  new IllegalArgumentException("Invalid Burger");
    }

    @Override
    public GarlicBread createGarlicBread(String type)
    {
        if(type.equalsIgnoreCase("simple"))
        {
            return new SimpleGarlicBread();
        }
        else if(type.equalsIgnoreCase("standard"))
        {
            return new StandardGarlicBread();
        }
        else if(type.equalsIgnoreCase("premium"))
        {
            return new PremiumGarlicBread();
        }
        throw new IllegalArgumentException("Invalid GarlicBread");
    }
}

class KingFactory implements Factory
{
    @Override
    public Burger createBurger(String type)
    {
        if(type.equalsIgnoreCase("simple"))
        {
            return new SimpleWheatBurger();
        }
        else if(type.equalsIgnoreCase("standard"))
        {
            return new StandardWheatBurger();
        }
        else if(type.equalsIgnoreCase("premium"))
        {
            return new PremiumWheatBurger();
        }
        throw new IllegalArgumentException("Invalid Burger");
    }

    @Override
    public GarlicBread createGarlicBread(String type)
    {
        if(type.equalsIgnoreCase("simple"))
        {
            return new SimpleWheatGarlicBread();
        }
        else if(type.equalsIgnoreCase("standard"))
        {
            return new StandardWheatGarlicBread();
        }
        else if(type.equalsIgnoreCase("premium"))
        {
            return new PremiumWheatGarlicBread();
        }
        throw new IllegalArgumentException("Invalid GarlicBread");
    }
}

public class FactoryDesignPattern
{
    public static void main(String[] args)
    {
        Factory burgerFactory1 = new SingFactory();
        Burger burger1 = burgerFactory1.createBurger("simple");
        burger1.prepare();
        Factory burgerFactory2 = new KingFactory();
        Burger burger2 = burgerFactory2.createBurger("standard");
        burger2.prepare();
        Factory garlicFactory1 = new SingFactory();
        GarlicBread garlicBread1 = garlicFactory1.createGarlicBread("simple");
        garlicBread1.prepare();
        Factory garlicFactory2 = new KingFactory();
        GarlicBread garlicBread2 = garlicFactory2.createGarlicBread("standard");
        garlicBread2.prepare();
    }
}