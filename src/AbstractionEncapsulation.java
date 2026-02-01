import static java.lang.Thread.sleep;

interface Car
{
    void startEngine();
    void stopEngine();
    void accelerate();
    void brake();
}

class SportsCar implements Car
{
    String brand;
    String model;
    private String carId;
    private int currentSpeed;
    int currentGear;
    SportsCar(String brand, String model)
    {
        currentSpeed = 0;
        this.brand = brand;
        this.model = model;
        this.carId = String.valueOf((int)(Math.random() * 100000));
    }
    public void getCardId()
    {
        System.out.println("Sports Car ID: " + this.carId);
    }
    public void startEngine()
    {
        System.out.println(brand + " " + model  + " Starting engine ...");
        try{
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void stopEngine()
    {
        System.out.println(brand + " " + model  + " Stopping engine ...");
        try{
            sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void accelerate()
    {
        System.out.println(brand + " " + model  + " Accelerating ...");
        try{
            sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        while(currentSpeed < 80)
        {
            currentSpeed++;
            try{
                sleep(100);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Maximum speed " + currentSpeed + " is reached.");
    }
    public void brake()
    {
        System.out.println(brand + " " + model  + " Braking ...");
        try{
            sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    void setCurrentSpeed(int speed)
    {
        currentSpeed = speed;
    }
}

public class AbstractionEncapsulation
{
    void start()
    {
        SportsCar car = new SportsCar("BMW", "X7");
        car.startEngine();
        car.accelerate();
        car.brake();
//        car.currentSpeed = 45;
//        “Directly modifying internal state from outside the class violates encapsulation. The state should be private and changed only through controlled methods that preserve business rules.”
        car.setCurrentSpeed(50);   // This is a valid way to access the private properties from outside the class
        car.stopEngine();
        car.setCurrentSpeed(0);
    }
}