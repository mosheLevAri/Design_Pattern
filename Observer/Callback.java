package il.co.lird.FS133.WS.DesignPattern.Observer;

import java.util.function.Consumer;

//Concrete observer class
class Callback<E> {

    private Dispatcher<E> dispatcher;
    private final Consumer<E> notifyFunc;
    private final Runnable notifyDeath;

    //ctor
    public Callback(Dispatcher<E> dispatcher,  Consumer<E> notifyFunc, Runnable notifyDeath)
    {
        this.dispatcher = dispatcher;
        this.notifyDeath = notifyDeath;
        this.notifyFunc = notifyFunc;
    };

    public void update(E message){
        if (null != dispatcher &&  null != notifyFunc)
        {
            notifyFunc.accept(message);
        }
    };

    public void stopSubscription()
    {
        if (null != dispatcher )
        {
            dispatcher.removeSubscriber(this);
        }
    };

    public void notifyDeath()
    {
        if (null != dispatcher &&  null != notifyDeath)
        {
            notifyDeath.run();
        }
        dispatcher = null;
    };
}
