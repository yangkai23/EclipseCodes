package generics;

public class Generics<T> {
    T age;

    public <T extends Number> void get(T local) {

    }

    public static void main(String[] args) {
        Generics <Integer> generics=new Generics<>();

    }
}
