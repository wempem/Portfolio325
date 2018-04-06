package Fitness;

/**
 * Created by Jay on 4/28/2017.
 */
public class stuff {
    public static void throwit () {
        System.out.print("throwit ");
        throw new RuntimeException();
    }
    public static void main(String [] args) {
        try {
            System.out.print("hello ");
            throwit();
            System.out.print("good bye ");

        } catch (Exception re ) {
            System.out.print("caught ");
        } finally {
            System.out.print("finally ");
        }
        System.out.println("after ");
    }
}

