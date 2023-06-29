package il.co.lird.FS133.WS.DesignPattern.Observer;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher<E> {
    private List<Callback<E>> callbacks;

    public Dispatcher(){
        callbacks = new ArrayList<>();
    }

    public void broadcastSubscribers(E message)
    {
        for (Callback<E> v: callbacks)
        {
            v.update(message);
        }
    };

    public void addSubscriber(Callback<E> callback){
        callbacks.add(callback);
    };

    public void removeSubscriber(Callback<E> callback){
        callbacks.remove(callback);

    };

    public void stopDispatcher()
    {
        for (Callback<E> v: callbacks)
        {
            v.notifyDeath();
        }
    };

}


