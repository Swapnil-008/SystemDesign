import java.util.ArrayList;
import java.util.List;

// Command Design Pattern:
// - It encapsulates a request as an object, and decouples the sender from the receiver
// - The invoker triggers the command, and the command delegates the execution to the receiver
// - It is useful to undo/redo like in text editor, and remote control style system

// Invoker
class RemoteController
{
    static final int numButtons = 4;
    List<Command> buttons = new ArrayList<Command>(numButtons);
    List<Boolean> buttonPressed = new ArrayList<Boolean>(numButtons);
    RemoteController()
    {
        for(int i = 0; i < numButtons; i++)
        {
            buttons.add(i, null);
            buttonPressed.add(i, false);
        }
    }
    void setCommand(Command command, int index)
    {
        if(index < 0 || index >= numButtons)
        {
            System.out.println("No command assigned at this button " + index + " please press valid button!");
            return;
        }
        buttons.set(index, command);
        buttonPressed.set(index, false);
    }
    void pressButton(int index)
    {
        if(index < 0 || index >= numButtons || buttons.get(index) == null)
        {
            System.out.println("No command assigned at button " + index + ", please press valid button!");            return;
        }
        if(buttonPressed.get(index))
        {
            buttons.get(index).execute();
        }
        else
        {
            buttons.get(index).undo();
        }
        buttonPressed.set(index, !buttonPressed.get(index));
    }
}

// Command Interface
interface Command
{
    void execute();
    void undo();
}

// Receiver
class Light
{
    void on()
    {
        System.out.println("Light is on");
    }
    void off()
    {
        System.out.println("Light is off");
    }
}
class Fan
{
    void on()
    {
        System.out.println("Fan is on");
    }
    void off()
    {
        System.out.println("Fan is off");
    }
}

// Concrete Command
class LightCommand implements Command
{
    Light light;
    LightCommand(Light light)
    {
        this.light = light;
    }
    @Override
    public void execute()
    {
        light.on();
    }
    @Override
    public void undo()
    {
        light.off();
    }
}
class FanCommand implements Command
{
    Fan fan;
    FanCommand(Fan fan)
    {
        this.fan = fan;
    }
    @Override
    public void execute()
    {
        fan.on();
    }
    @Override
    public void undo()
    {
        fan.off();
    }
}

// Client
public class CommandDesignPattern
{
    public static void main(String[] args)
    {
        RemoteController rc = new RemoteController();
        Light light = new Light();
        Fan fan = new Fan();
        rc.setCommand(new LightCommand(light), 0);
        rc.setCommand(new FanCommand(fan), 1);

        System.out.println("----- Toggling Light Button 0 -----");
        rc.pressButton(0);
        rc.pressButton(0);
        System.out.println("----- Toggling Fan Button 1 -----");
        rc.pressButton(1);
        rc.pressButton(1);

        System.out.println("----- Pressing Unassigned Button 2 -----");
        rc.pressButton(2);
    }
}

// Client -> Invoker -> Command -> Receiver
