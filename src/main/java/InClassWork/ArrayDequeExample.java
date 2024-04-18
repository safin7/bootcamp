package InClassWork;

import org.apache.commons.math3.analysis.function.Sinc;

import java.util.ArrayDeque;

public class ArrayDequeExample {
    public static void main(String[] args) {
        ArrayDeque<Call> arrayDeque= new ArrayDeque<>();

        arrayDeque.add(new Call("John"));
        arrayDeque.add(new Call("Ann"));
        arrayDeque.add(new Call("Marry"));

        while (!arrayDeque.isEmpty()){
            Call incomingCall =arrayDeque.removeFirst();
            System.out.println("Handling incoming call "+ incomingCall);

            System.out.println("Call Handled "+incomingCall.getCallerName() );
        }
        System.out.println("incoming calls handled");
        arrayDeque.addFirst(new Call("Arthur"));
        arrayDeque.addFirst(new Call("Morgan"));

        while (!arrayDeque.isEmpty()){
            Call outgoingCall = arrayDeque.removeFirst();
            System.out.println("Handling outgoing call "+ outgoingCall);

        }
        System.out.println("All follow up calls made ");
    }
}
class Call{
    private String callerName;

    public Call(String callerName) {
        this.callerName = callerName;
    }

    public String getCallerName() {
        return callerName;
    }

    @Override
    public String toString() {
        return "Call from " + callerName ;
    }
}
