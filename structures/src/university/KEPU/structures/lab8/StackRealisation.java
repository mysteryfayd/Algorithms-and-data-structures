//package university.KEPU.structures.lab8;
//
//
//import java.util.Vector;
//
//public class StackRealisation {
//    Vector<Integer> storage;
//
//    public StackRealisation() {
//        storage = new Vector<Integer>();
//    }
//
//    public void push(int number) {
//        this.storage.add(number);
//    }
//
//    public int pop() {
//        int lastNumber = storage.lastElement();
//        storage.remove(storage.size() - 1);
//        return lastNumber;
//    }
//
//    public int back() {
//        int lastNumber = storage.lastElement();
//        return lastNumber;
//    }
//
//    public int size() {
//        return storage.size();
//    }
//
//    public void clear() {
//        storage.clear();
//    }
//
//    public String exit() {
//        return "StackOff";
//    }
//
//    public void print() {
//        for (Integer q : storage) {
//            System.out.println(q);
//        }
//    }
//}
//
