package Rational;

import Rational.Rational;

public class Main {
    public static void main(String[] args) {
        Rational rational = new Rational(50,30);
        Rational r1 = new Rational(50, 40);
        Rational r2 = new Rational(60,30);

        rational.invert(rational);
        rational.printRational(rational);
        System.out.println(rational.add(r1, r2));
        System.out.println(r1.add(rational, r2));
    }
}
