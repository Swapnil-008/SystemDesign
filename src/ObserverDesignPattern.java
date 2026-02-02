import java.util.ArrayList;
import java.util.List;

// Observer Design Pattern:
// It defines a one-to-many relationship between  objects so that when one object changes state, all of its dependents are notified and updated automatically

// Observer
interface Channel
{
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers();
}

class ConcreteChannel implements Channel
{
    String name, latestVideo;
    List<Subscriber> subscribers = new ArrayList<Subscriber>();
    ConcreteChannel(String name)
    {
        this.name = name;
    }
    @Override
    public void subscribe(Subscriber subscriber)
    {
        if(!subscribers.contains(subscriber))
        {
            subscribers.add(subscriber);
        }
    }
    @Override
    public void unsubscribe(Subscriber subscriber)
    {
        subscribers.remove(subscriber);
    }
    @Override
    public void notifySubscribers()
    {
        for (Subscriber subscriber : subscribers)
        {
            subscriber.update();
        }
    }
    void uploadVideo(String title)
    {
        latestVideo = title;
        System.out.println("\n"+ name + " uploaded video: " + title);
        System.out.println();
        notifySubscribers();
    }
    String getVideo()
    {
        return "Checkout our new video: " +  latestVideo ;
    }
}

// Observable
interface Subscriber
{
    void update();
}
class ConcreteSubscriber implements Subscriber
{
    String name;
    ConcreteChannel concreteChannel;
    ConcreteSubscriber(String name, ConcreteChannel concreteChannel)
    {
        this.name = name;
        this.concreteChannel = concreteChannel;
    }
    @Override
    public void update()
    {
        System.out.println("Hey " + name + ", " + concreteChannel.getVideo());
    }
}
public class ObserverDesignPattern
{
    public static void main(String[] args)
    {
        ConcreteChannel concreteChannel = new ConcreteChannel("IndianCinema");
        Subscriber subscriber1 = new ConcreteSubscriber("Subscriber1", concreteChannel);
        Subscriber subscriber2 = new ConcreteSubscriber("Subscriber2", concreteChannel);
        Subscriber subscriber3 = new ConcreteSubscriber("Subscriber3", concreteChannel);
        Subscriber subscriber4 = new ConcreteSubscriber("Subscriber4", concreteChannel);
        Subscriber subscriber5 = new ConcreteSubscriber("Subscriber5", concreteChannel);
        concreteChannel.subscribe(subscriber1);
        concreteChannel.subscribe(subscriber2);
        concreteChannel.subscribe(subscriber3);
        concreteChannel.subscribe(subscriber4);
        concreteChannel.subscribe(subscriber5);
        concreteChannel.uploadVideo("Romeo");
        concreteChannel.unsubscribe(subscriber2);
        concreteChannel.unsubscribe(subscriber3);
        concreteChannel.uploadVideo("Toxic");
    }
}
