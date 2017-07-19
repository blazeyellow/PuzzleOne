package PuzzleOne.numbers;

class SuperClass {

    boolean super_DefaultAccessMod_boolean;

    public SuperClass() {
        System.out.println("constructing public SuperClass");

    }

    public void go() {
        System.out.println("executing public SuperClass.go()");

    }
}

public class SubClass extends SuperClass {

    public SubClass() {
        System.out.println("constructing public SubClass");

    }

    private SubClass(int i) {
        System.out.println("constructing orivate SubClass");

    }

    public static void main(String[] args) {
        SubClass myClass = new SubClass();
        myClass.go();

        System.out.println("super class uninitialized def access boolean accessed from subclass: " + myClass.super_DefaultAccessMod_boolean);

        int methodInt;
        //System.out.println("method int uninitialized: " + methodInt);


    }

    public void go() {
        System.out.println("executing public SubClass.go()");

    }

}
