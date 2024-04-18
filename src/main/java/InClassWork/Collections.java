package InClassWork;
/*
 * Collection in Java is a framework that provides an architecture to store and manipulate the group of objects
 *
 * Java collections can achieve all the operations that you perform on a data such as searching, sorting, insert, manipulation and deletion.
 *
 * What is a collection?
 * A collection in Java represents a single unit of object or a group.
 * Java collections provide a readymade architecture.
 * It represents a set of classes and interfaces
 * It is optional
 * It is an algorithm
 *
 *
 *
 *
 *
 *
 *                                   Iterable(Interface)
 *                                            |
 *                                    Collection(Interface)
 *                    /                      |                      \
 *                   /                       |                       \
 *     List(Interface)                Queue(Interface)                Set(Interface)
 *       |                                 |                               |               |
 * ArrayList(Class)           PriorityQueue(Class)          HashSet(Class)      LinkedHashSet(Class)
 * LinkedList                      Deque(Interface)                            |
 * Vector(Class)                   ArrayDeque(Class)                          SortedSet(Interface)
 * Stack(Class)                                                                TreeSet(Class)
 *
 * What is a Iterator Interface?
 * Iterator interface provides the facility of iterating the elements in a forward direction
 *
 *
 *
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Collections {
    public static void main(String[] args) {
        arrayListExample();

    }
    public static void  arrayListExample(){
        ArrayList<String> Al = new ArrayList<String>();

        Al.add("Java");
        Al.add("Python");
        Al.add("x86");
        Al.add("C");
        Al.add("Ruby");
        Al.add("Php");
        Al.trimToSize();

        int size = Al.size();
        System.out.println(size);

        System.out.println(Al.get(0));
        System.out.println(Al.get(1));

        System.out.println(Al.indexOf("Python"));



        Boolean containJava = Al.contains("Java");
        System.out.println(containJava);

        Al.remove("Java");
        System.out.println(Al);
        Iterator itr = Al.iterator();

        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println(Al);


    }


}
