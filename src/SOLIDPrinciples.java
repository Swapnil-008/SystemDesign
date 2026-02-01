// S : Single Responsibility Principle
// Every class should have only one responsibility and one reason to change
import java.util.List;
import java.util.ArrayList;

//class Product
//{
//    int price;
//    String name;
//    Product(int price, String name)
//    {
//        this.price = price;
//        this.name = name;
//    }
//}
//
//class ShoppingCart
//{
//    private List<Product> products;
//    ShoppingCart()
//    {
//        products = new ArrayList<Product>();
//    }
//    void addProduct(Product product)
//    {
//        products.add(product);
//    }
//    List<Product> getProducts()
//    {
//        return products;
//    }
//    void calculateTotalPrice()
//    {
//        int total = 0;
//        for (Product product : products)
//        {
//            total += product.price;
//        }
//        System.out.println("\nTotal price is $" + total);
//    }
//}
//
//class CartInvoice
//{
//    ShoppingCart shoppingCart;
//    CartInvoice(ShoppingCart shoppingCart)
//    {
//        this.shoppingCart = shoppingCart;
//    }
//    void printCartInvoice()
//    {
//        System.out.println("Shopping cart invoice: ");
//        for(Product product : shoppingCart.getProducts())
//        {
//            System.out.println(product.name + ": $" + product.price);
//        }
//    }
//}
//
//class CartDBStorage
//{
//    ShoppingCart shoppingCart;
//    CartDBStorage(ShoppingCart shoppingCart)
//    {
//        this.shoppingCart = shoppingCart;
//    }
//    void saveToDB()
//    {
//        System.out.println("\nSaving shopping cart to database...");
//        for(Product product : shoppingCart.getProducts())
//        {
//            System.out.println(product.name + ": $" + product.price + " saved to database.");
//        }
//    }
//}
//
//public class SOLIDPrinciples
//{
//    public static void main(String[] args)
//    {
//        ShoppingCart shoppingCart = new ShoppingCart();
//        shoppingCart.addProduct(new Product(1500, "Laptop"));
//        shoppingCart.addProduct(new Product(50, "Mouse"));
//        shoppingCart.addProduct(new Product(500, "Tablet"));
//        shoppingCart.addProduct(new Product(400, "Phone"));
//
//        CartInvoice cartInvoice = new CartInvoice(shoppingCart);
//        CartDBStorage cartDBStorage = new CartDBStorage(shoppingCart);
//
//        cartInvoice.printCartInvoice();
//        shoppingCart.calculateTotalPrice();
//        cartDBStorage.saveToDB();
//    }
//}

// O : Open-Close Principle
// A class should be open for extension but close for modification

//class Product
//{
//    int price;
//    String name;
//    Product(int price, String name)
//    {
//        this.price = price;
//        this.name = name;
//    }
//}
//
//class ShoppingCart
//{
//    private List<Product> products;
//    ShoppingCart()
//    {
//        products = new ArrayList<Product>();
//    }
//    void addProduct(Product product)
//    {
//        products.add(product);
//    }
//    List<Product> getProducts()
//    {
//        return products;
//    }
//    void calculateTotalPrice()
//    {
//        int total = 0;
//        for (Product product : products)
//        {
//            total += product.price;
//        }
//        System.out.println("Total price is $" + total);
//    }
//}
//
//class CartInvoice
//{
//    ShoppingCart shoppingCart;
//    CartInvoice(ShoppingCart shoppingCart)
//    {
//        this.shoppingCart = shoppingCart;
//    }
//    void printCartInvoice()
//    {
//        System.out.println("Shopping cart invoice: ");
//        for(Product product : shoppingCart.getProducts())
//        {
//            System.out.println(product.name + ": $" + product.price);
//        }
//    }
//}
//
//interface DBPersistence
//{
//    void saveToDB(ShoppingCart shoppingCart);
//}
//
//class SQLPersistence implements DBPersistence
//{
//    @Override
//    public void saveToDB(ShoppingCart shoppingCart)
//    {
//        System.out.println("\nSaving shopping cart to  SQL database...");
//        for(Product product : shoppingCart.getProducts())
//        {
//            System.out.println(product.name + ": $" + product.price + " is saved into SQL database.");
//        }
//    }
//}
//
//class MongoDBPersistence implements DBPersistence
//{
//    @Override
//    public void saveToDB(ShoppingCart shoppingCart)
//    {
//        System.out.println("\nSaving shopping cart to  MongoDB database...");
//        for(Product product : shoppingCart.getProducts())
//        {
//            System.out.println(product.name + ": $" + product.price + " is saved into MongoDB database.");
//        }
//    }
//}
//
//class FilePersistence implements DBPersistence
//{
//    @Override
//    public void saveToDB(ShoppingCart shoppingCart)
//    {
//        System.out.println("\nSaving shopping cart to  File database...");
//        for(Product product : shoppingCart.getProducts())
//        {
//            System.out.println(product.name + ": $" + product.price +  " is saved into File database.");
//        }
//    }
//}
//
//public class SOLIDPrinciples
//{
//    public static void main(String[] args)
//    {
//        ShoppingCart shoppingCart = new ShoppingCart();
//        shoppingCart.addProduct(new Product(1500, "Laptop"));
//        shoppingCart.addProduct(new Product(50, "Mouse"));
//        shoppingCart.addProduct(new Product(500, "Tablet"));
//        shoppingCart.addProduct(new Product(400, "Phone"));
//
//        CartInvoice cartInvoice = new CartInvoice(shoppingCart);
//        cartInvoice.printCartInvoice();
//        shoppingCart.calculateTotalPrice();
//
//        DBPersistence sql = new SQLPersistence();
//        sql.saveToDB(shoppingCart);
//        DBPersistence mongoDB = new MongoDBPersistence();
//        mongoDB.saveToDB(shoppingCart);
//        DBPersistence filePersistence = new FilePersistence();
//        filePersistence.saveToDB(shoppingCart);
//    }
//}

// L : Liskov Substitution Principle
// It states that subclasses should be substitutable for their base class

// Code which violates the principles
//interface Account
//{
//    void deposit(int amount);
//    void withdraw(int amount);
//}
//
//class SavingsAccount implements Account
//{
//    double balance;
//    SavingsAccount()
//    {
//        this.balance = 0;
//    }
//    public void deposit(int amount)
//    {
//        balance += amount;
//        System.out.println("Deposited " + amount + " in savings account, new balance is " + balance);
//    }
//    public void withdraw(int amount)
//    {
//        if(balance >= amount)
//        {
//            balance -= amount;
//            System.out.println("Withdrawn " + amount + " from savings account, new balance is " + balance);
//        }
//        else
//        {
//            System.out.println("Cannot withdraw " + amount + " from savings account");
//        }
//    }
//}
//
//class CurrentAccount implements Account
//{
//    double balance;
//    CurrentAccount()
//    {
//        this.balance = 0;
//    }
//    public void deposit(int amount)
//    {
//        balance += amount;
//        System.out.println("Deposit " + amount + " in current account, new balance is " + balance);
//    }
//    public void withdraw(int amount)
//    {
//        if(balance >= amount)
//        {
//            balance -= amount;
//            System.out.println("Withdrawn " + amount + " from current account, new balance is " + balance);
//        }
//        else
//        {
//            System.out.println("Cannot withdraw " + amount + " from current account");
//        }
//    }
//}
//
//class FixedTermAccount implements Account
//{
//    double balance;
//    FixedTermAccount()
//    {
//        this.balance = 0;
//    }
//    public void deposit(int amount)
//    {
//        balance += amount;
//        System.out.println("Deposit " + amount + " in fixed account, new balance is " + balance);
//    }
//    // It will violate the Liskov Substitution Principle, because the FixedTermAccount's withdraw doesn't work as it should work, so it isn't substitutable for it's base class
//    public void withdraw(int amount)
//    {
//        System.out.println("Cannot withdraw " + amount + " in fixed account");
//    }
//}
//
//class BankAccount
//{
//    List<Account> accounts;
//    BankAccount(List<Account> accounts)
//    {
//        this.accounts = accounts;
//    }
//    void processTransactions()
//    {
//        for(Account account : this.accounts)
//        {
//            account.deposit(1000);
//            account.withdraw(1000);
//            // Otherwise we have to change the logic here, if the account is fixedTerm we have to skip the withdrawal for it
//            // Then it would violate the Open-Close principle
//        }
//    }
//}
//
//public class SOLIDPrinciples
//{
//    public static void main(String[] args)
//    {
//        List<Account>accounts;
//        accounts= new ArrayList<Account>();
//        accounts.add(new SavingsAccount());
//        accounts.add(new CurrentAccount());
//        accounts.add(new FixedTermAccount());
//        BankAccount bankAccount = new BankAccount(accounts);
//        bankAccount.processTransactions();
//    }
//}

// Valid code
//interface DepositOnlyAccount
//{
//    void deposit(int amount);
//}
//interface WithdrawalAccount extends DepositOnlyAccount
//{
//    void withdraw(int  amount);
//}
//class SavingAccount implements WithdrawalAccount
//{
//    double balance;
//    SavingAccount()
//    {
//        balance = 0;
//    }
//    public void deposit(int amount)
//    {
//        balance += amount;
//        System.out.println("Deposited " + amount + " in savings account, new balance is " + balance);
//    }
//    public void withdraw(int amount)
//    {
//        if(balance >= amount)
//        {
//            balance -= amount;
//            System.out.println("Withdrawn " + amount + " from savings account, new balance is " + balance);
//        }
//        else
//        {
//            System.out.println("Cannot withdraw " + amount + " from savings account");
//        }
//    }
//}
//class CurrentAccount implements WithdrawalAccount
//{
//    double balance;
//    CurrentAccount()
//    {
//        balance = 0;
//    }
//    public void deposit(int amount)
//    {
//        balance += amount;
//        System.out.println("Deposited " + amount + " in current account, new balance is " + balance);
//    }
//    public void withdraw(int amount)
//    {
//        if(balance >= amount)
//        {
//            balance -= amount;
//            System.out.println("Withdrawn " + amount + " from current account, new balance is " + balance);
//        }
//        else
//        {
//            System.out.println("Cannot withdraw " + amount + " from current account");
//        }
//    }
//}
//
//class FixedTermAccount implements DepositOnlyAccount
//{
//    double balance;
//    FixedTermAccount()
//    {
//        balance = 0;
//    }
//    public void deposit(int amount)
//    {
//        balance += amount;
//        System.out.println("Deposited " + amount + " in fixed account, new balance is " + balance);
//    }
//}
//
//class BankAccount
//{
//    List<DepositOnlyAccount> deposits;
//    List<WithdrawalAccount> withdrawals;
//    BankAccount(List<DepositOnlyAccount> deposits, List<WithdrawalAccount> withdrawals)
//    {
//        this.deposits = deposits;
//        this.withdrawals = withdrawals;
//    }
//    void processTransactions()
//    {
//        for(DepositOnlyAccount dpt: deposits)
//        {
//            dpt.deposit(1000);
//        }
//        for(WithdrawalAccount wd : withdrawals)
//        {
//            wd.deposit(1000);
//            wd.withdraw(1000);
//        }
//    }
//}
//
//public class SOLIDPrinciples
//{
//    public static void main(String[] args)
//    {
//        List<DepositOnlyAccount> deposits = new ArrayList<>();
//        List<WithdrawalAccount> withdrawals = new ArrayList<>();
//        withdrawals.add(new SavingAccount());
//        withdrawals.add(new CurrentAccount());
//        deposits.add(new FixedTermAccount());
//        BankAccount bankAccount = new BankAccount(deposits, withdrawals);
//        bankAccount.processTransactions();
//    }
//}

// Signature Rule:

// Method argument rule :
// Subtype method arguments can be identical or wider that the supertype
// It means a subtype should accept at least the parent accepts

//class Parent
//{
//    void print(String msg)
//    {
//        System.out.println("Parent: " + msg);
//    }
//}
//
//class Child extends Parent
//{
//    @Override
//    void print(String msg)
//    {
// //        super.print(msg);
//        System.out.println("Child: " + msg);
//    }
//}
//
//class Client
//{
//    private Parent p;
//    Client(Parent p)
//    {
//        this.p = p;
//    }
//    void printMsg()
//    {
//        p.print("Hello");
//    }
//}
//
//public class SOLIDPrinciples
//{
//    public static void main(String[] args)
//    {
//        Client c = new Client(new Child());
//        c.printMsg();
//    }
//}

// Return Type rule:

// A method from parent class has X return type ( Y is child class of X ) and that same method is overridden in child class then that method can return X as well it can return Y, as Y is a child class of X, but it can't have return type of base class of parent class
//class LivingThing {}
//
//class Animal extends LivingThing {}
//
//class Dog extends Animal {}
//
//class Parent
//{
//    Animal getAnimal()
//    {
//        System.out.println("Parent: Returning Animal instance");
//        return new Animal();
//    }
//}
//
//class Child extends Parent
//{
// //    @Override
// //    LivingThing random()   // Generates error as violates the return type rule
// //    {
// //        return new LivingThing();
// //    }
//    @Override
//    Dog getAnimal()   // valid for Animal and Dog return type only
//    {
//        System.out.println("Child: Returning Dog instance");
//        return new Dog();
//    }
//    // It's also called covariance -> When we use the return type for overridden method as child's object of actual method's return type
//    // Covariant return type allows an overridden method to return a more specific (subtype) object than the return type declared in the parent method.
//}
//
//class Client
//{
//    private Parent p;
//    Client(Parent p)
//    {
//        this.p = p;
//    }
//    void takeAnimal()
//    {
//        p.getAnimal();
//    }
//}
//
//public class SOLIDPrinciples
//{
//    public static void main(String[] args)
//    {
//        Client c = new Client(new Child());
//        c.takeAnimal();
//    }
//}

// Exception Rule:

// An overridden method cannot throw broader or additional checked exceptions, but it may throw fewer or narrower ones. This preserves Liskov Substitution Principle.
// Exception rule applies ONLY to checked exceptions
// Unchecked exceptions (RuntimeException) are not restricted.

// Checked Exception example
//class Parent
//{
//    void getValue() throws Exception431
//    {
//        throw new Exception("Parent exception");
//    }
//}
//class Child extends Parent
//{
// //    @Override
// //    void getValue() throws Throwable // compile-time error, As the Throwable is broader than Exception class
// //    {
// //        throw new Throwable("Child exception");
// //    }
//
//    @Override
//    void getValue() throws IOException // narrower
//    {
//        throw new IOException("Child exception");
//    }
//    // Throwing no exception is also valid
//}

// Unchecked Exception example

//class Parent
//{
//    void getValue()
//    {
//        throw new RuntimeException("Parent runtime exception");
//    }
//}
//class Child extends Parent
//{
//    @Override
//    void getValue()
//    {
//        throw new IllegalArgumentException("Child runtime exception");
//    }
//}
//
//class Client
//{
//    private Parent p;
//    Client(Parent p)
//    {
//        this.p = p;
//    }
//    void takeValue()
//    {
//        try {
//            p.getValue();
//        }
//        catch (Exception e)
//        {
//            System.out.println("Exception occurred: " + e.getMessage());
//        }
//    }
//}
//
//public class SOLIDPrinciples
//{
//    public static void main(String[] args)
//    {
//        Parent parent = new Parent();
//        Parent child = new Child();   // substitution
//
//        Client client = new Client(child);
//        client.takeValue();
//    }
//}

// Property Rule:

    // Class Invariant:
    // Class Invariant of a parent class Object should not be broken by child class Object
    // Hence child class can either maintain or strengthen the invariant but never narrows it down

//class BankAccount
//{
//    protected double balance;
//    BankAccount()
//    {
//        balance = 0;
//    }
//    BankAccount(double balance)
//    {
//        if(balance < 0)
//        {
//            throw new IllegalArgumentException("Balance cannot be negative");
//        }
//        this.balance = balance;
//    }
//    public void withdraw(double balance)
//    {
//        if(this.balance - balance < 0)
//        {
//            throw new IllegalArgumentException("Insufficient balance");
//        }
//        this.balance -= balance;
//        System.out.println("Remaining Balance: " + this.balance);
//    }
//}
//
//class CheatAccount extends BankAccount
//{
//    CheatAccount(double balance)
//    {
//        super(balance);
//    }
//    @Override
//    public void withdraw(double balance)
//    {
//        this.balance -=  balance;   // This is narrowing the Invariant of the Parent object, Breaking LSP
//        System.out.println("Remaining Balance: " + this.balance);
//    }
//}
//
//public class SOLIDPrinciples
//{
//    public static void main(String[] args)
//    {
//        CheatAccount cheatAccount = new CheatAccount(200);
//        cheatAccount.withdraw(500);
//    }
//}

    // History Constraint:

//class Account
//{
//    double balance;
//    Account(double balance)
//    {
//        this.balance = balance;
//    }
//    public  void deposit(double balance)
//    {
//        this.balance += balance;
//    }
//    public void withdraw(double amount)
//    {
//        if (balance - amount < 0)
//        {
//            throw new IllegalArgumentException("Insufficient funds.");
//        }
//        this.balance -= amount;
//    }
//}
//
//class FixedDeposit extends Account
//{
//    FixedDeposit(double balance)
//    {
//        super(balance);
//    }
//    @Override
//    public void deposit(double balance)
//    {
//        this.balance += balance;
//    }
//    @Override
//    public void withdraw(double balance)  // Breaks the history constraint, as the parent class supports the withdrawal but child not
//    {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//}
//
//public class SOLIDPrinciples
//{
//    public static void main(String[] args)
//    {
//        FixedDeposit fixedDeposit = new FixedDeposit(200);
//        fixedDeposit.withdraw(500);
//    }
//}

// If a parent class has immutable properties or methods, if the child class make it to mutable, it also breaks the history constraint

// Method Rule:

    // Pre-condition: A Pre-condition must be satisfied before a method can be executed
    // Sub classes can weaken the pre-condition but cannot strengthen it

//class User
//{
//    // Pre-condition: Password must be at least 8 characters long
//    void setPassword(String password)
//    {
//        if(password.length() < 8)
//        {
//            throw new IllegalArgumentException("Password too short");
//        }
//        System.out.println("Password set successfully");
//    }
//}
//
//class AdminUser extends User
//{
//    // Pre-condition: Password must be at least 6 characters long
//    @Override
//    void setPassword(String password)
//    {
//        if(password.length() < 6)  // Weaken the pre-condition
//        {
//            throw new IllegalArgumentException("Password too short");
//        }
//        System.out.println("Password set successfully");
//    }
//}

    // Post-condition: Post-condition must be satisfied after a method is executed.
    // Subclasses can strengthen the post-conditions but cannot weaken it

//class Car3
//{
//    protected int speed;
//    public Car3()
//    {
//        speed = 0;
//    }
//
//    public void accelerate()
//    {
//        System.out.println("Accelerating");
//        speed += 20;
//    }
//
//    // PostCondition: Speed must reduce after brake
//    public void brake()
//    {
//        System.out.println("Applying brakes");
//        speed -= 20;
//    }
//}
//
// // Subclass can strengthen postcondition - Does not violate LSP
//class HybridCar extends Car3
//{
//    private int charge;
//
//    public HybridCar()
//    {
//        super();
//        charge = 0;
//    }
//    // PostCondition: Speed must reduce after brake
//    // PostCondition: Charge must increase.
//    @Override
//    public void brake()
//    {
//        System.out.println("Applying brakes");
//        speed -= 20;
//        charge += 10;
//    }
//}
//
//public class SOLIDPrinciples
//{
//    public static void main(String[] args)
//    {
//        Car3 hybridCar = new HybridCar();
//        hybridCar.brake();  // Works fine: HybridCar reduces speed and also increases charge.
//
//        //Client feels no difference in substituting Hybrid car in place of Car.
//    }
//}

// I : Interface Segregation Principle (ISP)
// It states that many client specific interfaces are better than one general purpose interface
// Client shouldn't be forced to implement methods they don't need

//interface shape
//{
//    int area();
//    int volume();
//}
//
//class Square implements shape
//{
//    @Override
//    public int area()
//    {
//        System.out.println("Square area...");
//        return 0;
//    }
//    @Override
//    public int volume()  // Square class is forced to implement the volume, which it doesn't need
//    {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//}
//
//class Cube implements shape
//{
//    @Override
//    public int area()
//    {
//        System.out.println("Cube area...");
//        return 0;
//    }
//    @Override
//    public int volume()
//    {
//        System.out.println("Cube volume...");
//        return 0;
//    }
//}

// For validating the ISP Define the different interface as per the class need

//interface TwoDimensionalShape
//{
//    void area();
//}
//
//interface ThreeDimensionalShape
//{
//    void volume();
//}
//
//class Square implements TwoDimensionalShape
//{
//    double side;
//    @Override
//    public void area()
//    {
//        System.out.println("Area of Square: " + side * side);
//    }
//}
//
//class Rectangle implements TwoDimensionalShape
//{
//    double length;
//    double width;
//    @Override
//    public void area()
//    {
//        System.out.println("Area of Rectangle: " + length * width);
//    }
//}
//
//class Cube implements ThreeDimensionalShape
//{
//    double side;
//    @Override
//    public void volume()
//    {
//        System.out.println("Area of Cube: " + side * side * side);
//    }
//}

// Dependency Inversion Principle (DIP):
// It states that high level module shouldn't depend on low level module but rather both should depend on abstraction
// High level module -> business logic
// Low level module -> database layer, API

// Violates the DIP
//class MySQLDatabase
//{  // Low-level module
//    public void saveToSQL(String data)
//    {
//        System.out.println("Executing SQL Query: INSERT INTO users VALUES('" + data + "');");
//    }
//}
//
//class MongoDBDatabase
//{  // Low-level module
//    public void saveToMongo(String data)
//    {
//        System.out.println("Executing MongoDB Function: db.users.insert({name: '" + data + "'})");
//    }
//}
//
//class UserService
//{  // High-level module (Tightly coupled)
//    private final MySQLDatabase sqlDb = new MySQLDatabase();
//    private final MongoDBDatabase mongoDb = new MongoDBDatabase();
//
//    public void storeUserToSQL(String user)
//    {
//        // MySQL-specific code
//        sqlDb.saveToSQL(user);
//    }
//
//    public void storeUserToMongo(String user)
//    {
//        // MongoDB-specific code
//        mongoDb.saveToMongo(user);
//    }
//}
    // If client want's to use one another different type of service then it has to update the UserService class which would violate the Open-Close principle
//
//public class SOLIDPrinciples
//{
//    public static void main(String[] args)
//    {
//        UserService service = new UserService();
//        service.storeUserToSQL("Aditya");
//        service.storeUserToMongo("Rohit");
//    }
//}

// Valid code
// Abstraction (Interface)
interface Database
{
    void save(String data);
}

 // MySQL implementation (Low-level module)
class MySQLDatabase implements Database
{
    @Override
    public void save(String data)
    {
        System.out.println("Executing SQL Query: INSERT INTO users VALUES('" + data + "');");
    }
}

 // MongoDB implementation (Low-level module)
class MongoDBDatabase implements Database
{
    @Override
    public void save(String data)
    {
        System.out.println("Executing MongoDB Function: db.users.insert({name: '" + data + "'})");
    }
}

 // High-level module (Now loosely coupled via Dependency Injection)
class UserService
{
    private final Database db;
    public UserService(Database database)
    {
        this.db = database;
    }
    public void storeUser(String user)
    {
        db.save(user);
    }
}

public class SOLIDPrinciples
{
    public static void main(String[] args)
    {
        MySQLDatabase mysql = new MySQLDatabase();
        MongoDBDatabase mongodb = new MongoDBDatabase();

        UserService service1 = new UserService(mysql);
        service1.storeUser("Aditya");

        UserService service2 = new UserService(mongodb);
        service2.storeUser("Rohit");
    }
}