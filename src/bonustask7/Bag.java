package bonustask7;

import javafx.util.Pair;

interface Weighable {
    public int weight();
}

/**
 * Class implements a bag that can contain a specified weight
 * of precisely one type of content.
 *
 * @author Oscar Brink
 * @version 1.0 2018-02-01
 *
 * @param <E> What type of content the bag will contain
 */
public class Bag<E> implements Weighable{

    private Pair<E, Integer> contents;

    public static void main(String[] args) {
        Bag bag = new Bag();

        bag.fillBagWith("Rice", 30);
        System.out.println(bag.weight());
        System.out.println(bag.emptyBag());
        System.out.println(bag.weight());
        System.out.println(bag);

        System.out.println(bag.emptyBag());

        bag.fillBagWith(32, 80);
        System.out.println(bag);
    }

    public Bag() {}

    public void fillBagWith(E content, int weight) {
        if (!isEmpty()) {
            emptyBag();
        }
        contents = new Pair<E, Integer>(content, weight);
    }

    public Pair<E, Integer> emptyBag() {
        if (isEmpty()) {
            return new Pair<E, Integer>(null, 0);
        }

        Pair<E, Integer> returnValue = contents;
        contents = new Pair<E, Integer>(null, 0);
        return returnValue;
    }

    public int weight() {
        return contents.getValue();
    }

    private boolean isEmpty() {
        try {
            return contents.getKey() == null;
        }
        catch (NullPointerException e) {
            return true;
        }
    }

    public String toString() {
        return contents.toString();
    }
}
