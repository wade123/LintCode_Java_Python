class Singleton {
    /**
     * @return: The same instance of this class every time
     */
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return INSTANCE;
    }
}

public class Singleton {
    private static volatile Singleton INSTANCE = null;
  
    // Private constructor suppresses 
    // default public constructor
    private Singleton() {}
  
    //thread safe and performance  promote 
    public static  Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized(Singleton.class) {
                //when more than two threads run into the first null check same time, 
                //to avoid instanced more than one time, it needs to be checked again.
                if (INSTANCE == null) { 
                    INSTANCE = new Singleton();
                }
            } 
        }
        return INSTANCE;
    }
}