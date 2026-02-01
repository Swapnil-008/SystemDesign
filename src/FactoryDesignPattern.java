import java.io.IOException;

// Simple factory:
// A single factory class decides which concrete class to instantiate

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
//        else {
//            return null;
//        }
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
//
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
//
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