package InClassWork;

import java.util.HashSet;
import java.util.Set;

public class SetsExample {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        names.add("John");
        names.add("Johnny");
        names.add("John");
        names.add("r9");
        names.add("Maradonna");

        System.out.println("Set Elements "+ names );
        System.out.println(names.remove("John"));
        System.out.println(names.contains("r9"));
        System.out.println(names);

        System.out.println(names.size());

        names.clear();
        System.out.println(names.isEmpty());
    }
}
