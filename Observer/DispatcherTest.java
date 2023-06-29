package il.co.lird.FS133.WS.DesignPattern.Observer;


class Client1<E>{

    Callback<E> callback;

    Client1(Dispatcher<E> dispatcher)
    {
        this.callback = new Callback<>(dispatcher, (val)-> System.out.println(val), ()-> System.out.println("bye client 1"));

    }
}

class Client2<E>{

    Callback<E> callback;

    Client2(Dispatcher<E> dispatcher)
    {
        this.callback = new Callback<>(dispatcher, (val)-> System.out.println(val), ()-> System.out.println("bye client 2"));

    }
}

class Client3<E>{

    Callback<E> callback;

    Client3(Dispatcher<E> dispatcher)
    {
        this.callback = new Callback<>(dispatcher, (val)-> System.out.println(val), ()-> System.out.println("bye client 3"));

    }
}

class DispatcherTest {



    public static void main(String[] args) {

        Dispatcher<String> dispatcher = new Dispatcher<>();
        Client1<String> client1 = new Client1<>(dispatcher);
        Client2<String> client2 = new Client2<>(dispatcher);
        Client3<String> client3 = new Client3<>(dispatcher);

        dispatcher.addSubscriber(client1.callback);
        dispatcher.addSubscriber(client2.callback);
        dispatcher.addSubscriber(client3.callback);


        dispatcher.broadcastSubscribers("hello world");


        client2.callback.stopSubscription();

        dispatcher.broadcastSubscribers("hello world second time");


        dispatcher.stopDispatcher();
    }

}