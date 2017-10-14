import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        // get a, b, and c from scanner
        System.out.print("a of quadratic equation:");
        int a = sc.nextInt();
        System.out.print("b of quadratic equation:");
        int b = sc.nextInt();
        System.out.print("c of quadratic equation:");
        int c = sc.nextInt();
        solve(a, b, c);
    }

    /* solve method which takes a, b, and c of the quadratic equation as parameters */
    public static void solve (int a, int b, int c) {

        // if c is less than zero, there are more possibilities - b can be
        if (c < 0) {
            for (int i = c; i < 0; i++) {
                if (c % i == 0) {
                    if (a*(c/i)+i == b) {
                        System.out.print("(" + a + "x" + i + ")(x+" + c/i + ")");
                        System.exit(0);
                    } else if (a*i+(c/i) == b) {
                        System.out.print("(" + a + "x+" + c/i + ")(x" + i + ")");
                        System.exit(0);
                    }
                }
            }
        } else if (c > 0) {
            for (int i = c; i > 0; i--) {
                if (c % i == 0) {
                    if (a*(c/i)+i == b) {
                        System.out.print("(" + a + "x+" + i + ")(x+" + c/i + ")");
                        System.exit(0);
                    } else if (a*(c/-i)-i == b) {
                        System.out.print("(" + a + "x" + -i + ")(x" + -c/i + ")");
                        System.exit(0);
                    }
                }
            }
        }

        System.out.println("Cannot be factored");
    }
}
