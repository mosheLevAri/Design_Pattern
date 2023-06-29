package il.co.lird.FS133.WS.DesignPattern.Composite;


class TreeTest {


    public static void main(String[] args) {
        String s = args[0];
        Tree t = new Tree(s);
        t.print();
    }
}