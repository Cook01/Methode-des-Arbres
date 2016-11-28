package Model;

import java.util.ArrayList;
import java.util.List;



public class Tree<T extends List> 
{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private Node<T> root;

    public Tree(T rootData) {
        root            = new Node<T>();
        root.data       = rootData;
        root.children   = new ArrayList<Node<T>>();
    }

    public T getParent(){
        return root.parent.data;
    }

    public void addChildren(Tree children){
        root.addChildren(children.root);
    }

     public void print(){
            root.print("", true);
    }


    public static class Node<T extends List>{
        private T data;
        private Node<T> parent;
        private List<Node<T>> children;

        public void addChildren(Node children){
            children.parent = this;
            this.children.add(children);
        }

        private void print(String prefix, boolean isTail) {

            String color = "";

            for(int i = 0; i < data.size() + 1; i++){
                
                if ( i < data.size() && data.get(i) instanceof Lettre)
                    color = ANSI_GREEN;
                else
                    color = ANSI_CYAN;

                if(i == 0){
                    System.out.println(prefix + (isTail ? "└── " : "├── ") +  color + data.get(i).toString() + ANSI_RESET);
                } else if( i == data.size()) {
                    System.out.println(prefix + (isTail ? "    " : "│   "));
                } else {
                    System.out.println(prefix + (isTail ? "    " : "│   ") + color + data.get(i).toString() + ANSI_RESET);
                }
            } 

            for (int i = 0; i < children.size() - 1; i++) {
                children.get(i).print(prefix + (isTail ? "    " : "│   "), false);
            }

            if (children.size() > 0) {
                children.get(children.size() - 1).print(prefix + (isTail ?"    " : "│   "), true);
            }
        }
    }
}