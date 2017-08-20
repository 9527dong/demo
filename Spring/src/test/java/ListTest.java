import java.util.*;

public class ListTest {
    public static void main(String[] args)  {
        ArrayList<String> list = new ArrayList<String>();
        for(int i =0;i<10;i++){
            list.add("sh"+i);
        }
        LinkedList<String> list1 = new LinkedList<String>(list);
        String[] s = new String[10];
        new Vector<String>(list1);
        ListIterator<String> stringListIterator = list1.listIterator(0);
        while (stringListIterator.hasNext()){
            String next = stringListIterator.next();
            stringListIterator.remove();
            System.out.println(next);
        }

    }
}
