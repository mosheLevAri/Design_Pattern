package il.co.lird.FS133.WS.DesignPattern.Composite;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Tree {
    private List<ComponentFile> tree;
    String Path;


    public Tree(String Path) {
        this.Path = Path;
        tree = new ArrayList<>();
        initDirectoryAndFileToTree(Path);
    }


    private void initDirectoryAndFileToTree(String Path) {
        File fileEntry = new File(Path);

        if (fileEntry.isDirectory()) {
            tree.add(new CompositeDirectory(fileEntry.getName()));
            listFilesForFolder(fileEntry, tree.get(0));
        } else {
            if (fileEntry.isFile()) {
                tree.add(new SingleFile(fileEntry.getName()));
            }
        }
    }


    private static void listFilesForFolder(final File folder, ComponentFile Directory) {


        if (folder != null) {
            for (final File fileEntry : folder.listFiles()) {
                if (fileEntry.isDirectory()) {
                    CompositeDirectory temp = (CompositeDirectory) Directory;

                    temp.add(new CompositeDirectory(fileEntry.getName()));

                    listFilesForFolder(fileEntry, temp);
                } else {
                    if (fileEntry.isFile()) {

                        CompositeDirectory temp = (CompositeDirectory) Directory;

                        temp.add(new SingleFile(fileEntry.getName()));

                    }
                }
            }
        } else {
            return;
        }
    }

    public void print() {
        tree.get(0).print();
    }
}


class CompositeDirectory implements ComponentFile {

    private String directoryName;
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_BLUE = "\u001B[34m";

    private List<ComponentFile> children;

    public CompositeDirectory(String directoryName) {
        this.directoryName = directoryName;
        children = new ArrayList<>();
    }

    public void add(ComponentFile file) {
        children.add(file);
    }

    public void remove(ComponentFile file) {
        children.remove(file);
    }

    public ComponentFile get(int position) {
        return children.get(position);
    }

    @Override
    public void print() {

        System.out.println(ANSI_GREEN  +this.directoryName + ANSI_RESET);

        for (int i = 0; i < children.size(); ++i) {
            children.get(i).print();
        }
    }


}