
//Facade Design Pattern:
// - It provides a simplified interface over a complex subsystem
// - Instead of interacting with multiple classes, the client interacts to a single facade class which internally coordinates subsystem operations
// - It improves coupling and improves readability

// Subsystems
class PowerSupply
{
    public void providePower()
    {
        System.out.println("Power Supply: Providing power...");
    }
}

class CoolingSystem
{
    public void startFans()
    {
        System.out.println("Cooling System: Fans started...");
    }
}

class CPU
{
    public void initialize()
    {
        System.out.println("CPU: Initialization started...");
    }
}

class Memory
{
    public void selfTest()
    {
        System.out.println("Memory: Self-test passed...");
    }
}

class HardDrive
{
    public void spinUp()
    {
        System.out.println("Hard Drive: Spinning up...");
    }
}

class BIOS
{
    public void boot(CPU cpu, Memory memory)
    {
        System.out.println("BIOS: Booting CPU and Memory checks...");
        cpu.initialize();
        memory.selfTest();
    }
}

class OperatingSystem
{
    public void load()
    {
        System.out.println("Operating System: Loading into memory...");
    }
}

// Facade
class ComputerFacade
{
    private final PowerSupply powerSupply = new PowerSupply();
    private final CoolingSystem coolingSystem = new CoolingSystem();
    private final CPU cpu = new CPU();
    private final Memory memory = new Memory();
    private final HardDrive hardDrive = new HardDrive();
    private final BIOS bios = new BIOS();
    private final OperatingSystem os = new OperatingSystem();

    public void startComputer()
    {
        System.out.println("----- Starting Computer -----");
        powerSupply.providePower();
        coolingSystem.startFans();
        bios.boot(cpu, memory);
        hardDrive.spinUp();
        os.load();
        System.out.println("Computer Booted Successfully!");
    }
}

// Client
public class FacadeDesignPattern
{
    public static void main(String[] args)
    {
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();
    }
}