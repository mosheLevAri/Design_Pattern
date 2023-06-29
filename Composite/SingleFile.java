package il.co.lird.FS133.WS.DesignPattern.Composite;

import il.co.lird.FS133.WS.DesignPattern.Composite.ComponentFile;

public class SingleFile implements ComponentFile {
    private String fileName;

    public SingleFile(String fileName)
    {
        this.fileName = fileName;
    }

    @Override
    public void print()
    {
        System.out.println("\t|---- " + this.fileName);
    }
}