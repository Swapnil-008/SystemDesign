class Singleton
{
    // Instance is defined static for getting accessed inside static getInstance
    // Volatile is used to avoid the creation of multiple copies by multiple threads and visibility issues
    private static volatile Singleton instance = null;
    // private static Singleton instance = new Singleton();
    // This makes the code simple, but it is not good idea, because if there is no need to create an object, but as we are creating at the time of initialization it would be wastage of resources
    private Singleton()
    {
        System.out.println("Singleton object created");
    };
    // getInstance() is defined static for getting accessed from outside, object doesn't exist to call
    // Defining the synchronized to complete method makes the execution slow (synchronization every time)
    // public static synchronized Singleton getInstance()
    public static Singleton getInstance()
    {
        if(instance == null)
        {
            // Inner 'if' is used to avoid the multiple object creation
            // If multiple threads entered simultaneously inside outer 'if', then synchronized would allow to only one thread to get access and keep the other threads in waiting state,
            // but after completing the execution of that thread other thread would get access and create new instance, because of that inner 'if' is added to avoid new instance
            synchronized (Singleton.class)
            {
                if(instance == null)
                {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

public class SingletonDesignPattern
{
    public static void main(String[] args)
    {
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(System.identityHashCode(singleton1));
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(System.identityHashCode(singleton2));
    }
}