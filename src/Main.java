import java.util.*;
public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            x.add(rand.nextInt(11));
        }
        for (int i = 0; i < 7; i++) {
            y.add(rand.nextInt(11));
        }

        Collections.sort(x);
        Collections.sort(y);

        System.out.println("Lista x ordonată: " + x);
        System.out.println("Lista y ordonată: " + y);

        List<Integer> xPlusY = new ArrayList<>(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);
        System.out.println("xPlusY: " + xPlusY);

        Set<Integer> zSet = new TreeSet<>(x);
        zSet.retainAll(y);
        System.out.println("zSet (elemente comune, fără duplicate): " + zSet);

        List<Integer> xMinusY = new ArrayList<>(x);
        xMinusY.removeAll(y);
        System.out.println("xMinusY: " + xMinusY);

        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList<>();
        for (int num : xPlusY) {
            if (num <= p) {
                xPlusYLimitedByP.add(num);
            }
        }
        System.out.println("xPlusYLimitedByP (≤ " + p + "): " + xPlusYLimitedByP);
    }
}
