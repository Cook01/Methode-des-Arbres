package Model;

import java.util.ArrayList;
import java.util.List;

public class Tree<T extends List> 
{

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
            for(int i = 0; i < data.size(); i++){
                if(i == 0){
                    System.out.println(prefix + (isTail ? "└── " : "├── ") + data.get(i).toString());
                } else {
                    System.out.println(prefix + (isTail ? "    " : "│   ") + data.get(i).toString());
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