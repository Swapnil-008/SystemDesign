import static java.lang.Thread.sleep;

// Inheritance
abstract class Car1
{
    protected String brand;
    protected String model;
    protected boolean isEngineOn;
    protected int currentSpeed;
    Car1(String brand, String model)
    {
        this.brand = brand;
        this.model = model;
        this.isEngineOn = false;
        this.currentSpeed = 0;
    }
    public void startEngine()
    {
        this.isEngineOn = true;
        System.out.println(brand + "'s Engine is started");
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
        this.isEngineOn = false;
        System.out.println(brand + "'s Engine is stopped\n");
        try{
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
//    public void accelerate()
//    {
//        if(!isEngineOn)
//        {
//            System.out.println("Cannot accelerate! Engine is stopped");
//            return;
//        }
//        this.currentSpeed += 10;
//        System.out.println(brand + " " + model + " Accelerated to " + currentSpeed);
//        try{
//            Thread.sleep(1000);
//        }
//        catch (Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
//    }
    abstract void accelerate();   // Commented code is used for inheritance
    abstract void brake();
//    public void brake()
//    {
//        currentSpeed -= 10;
//        if (currentSpeed < 0)
//        {
//            currentSpeed = 0;
//        }
//        System.out.println(brand + " " + model + " Braked to " + currentSpeed);
//        try{
//            Thread.sleep(1000);
//        }
//        catch (Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
//    }
}

class ManualCar extends Car1
{
    private int currentGear;
    ManualCar(String brand, String model)
    {
        super(brand, model);
        this.currentGear = 0;
    }
    public void shiftGear(int gear)
    {
        currentGear = gear;
        System.out.println(brand + " " + model + " Shifted to " + currentGear + " Gear");
        try{
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void accelerate()
    {
        if(!isEngineOn)
        {
            System.out.println("Cannot accelerate! Engine is stopped");
            return;
        }
        this.currentSpeed += 20;   // Manual car accelerates the speed by 20
        System.out.println(brand + " " + model + " Accelerated to " + currentSpeed);
        try{
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void brake()
    {
        currentSpeed -= 15;   // Manual car reduces the speed by 15 on break
        if (currentSpeed < 0)
        {
            currentSpeed = 0;
        }
        System.out.println(brand + " " + model + " Braked to " + currentSpeed);
        try{
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}

class ElectricCar extends Car1
{
    private int batteryLevel;
    ElectricCar(String brand, String model)
    {
        super(brand, model);
        this.batteryLevel = 100;
    }
    public void chargeBattery()
    {
        this.batteryLevel = 100;
        System.out.println(brand + " " + model + " Charged to " + batteryLevel);
        try{
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void accelerate()
    {
        if(!isEngineOn)
        {
            System.out.println("Cannot accelerate! Engine is stopped");
            return;
        }
        this.currentSpeed += 15;   // Electric car accelerates the speed by 15
        System.out.println(brand + " " + model + " Accelerated to " + currentSpeed);
        try{
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void brake()
    {
        currentSpeed -= 10;   // Electric car reduces the speed by 10 on break
        if (currentSpeed < 0)
        {
            currentSpeed = 0;
        }
        System.out.println(brand + " " + model + " Braked to " + currentSpeed);
        try{
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}

public class InheritancePolymorphism
{
    public void start()
    {
        ManualCar manualCar = new ManualCar("Manual Car", "Mn");
        manualCar.startEngine();
        manualCar.accelerate();
        manualCar.shiftGear(2);
        manualCar.accelerate();
        manualCar.shiftGear(3);
        manualCar.accelerate();
        manualCar.shiftGear(4);
        manualCar.brake();
        manualCar.shiftGear(3);
        manualCar.accelerate();
        manualCar.shiftGear(4);
        manualCar.stopEngine();

        ElectricCar electricCar = new ElectricCar("Electrical Car", "Et");
        electricCar.startEngine();
        electricCar.accelerate();
        electricCar.accelerate();
        electricCar.accelerate();
        electricCar.accelerate();
        electricCar.chargeBattery();
        electricCar.brake();
        electricCar.stopEngine();
    }
}