package il.co.lird.FS133.WS.DesignPattern.FectoryPattern;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FactoryPattern<K,T,D>
{
    private final Map<K, Function<D, ? extends T>> creators =  new HashMap<>();;



    public void addCreator(K key, Function<D,? extends T> constructor)
    {
        creators.put(key, constructor);
    }

    public T createObject(K key, D params)
    {
        Function<D, ? extends T> creator = creators.get(key);

        if (creator == null) {
            throw new IllegalArgumentException("No creator for key " + key);
        }
        return creator.apply(params);
    }
}

