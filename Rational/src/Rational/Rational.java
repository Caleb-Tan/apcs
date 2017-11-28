package Rational;

public class Rational {
    int numerator, denominator;

    public Rational(){
        numerator = 0;
        denominator = 1;
    }

    /* constructs the rational number based on the parameters given */
    public Rational(int n, int d){
        numerator = n;
        denominator = d;
    }

    /* prints the rational number */
    public void printRational(Rational r){
        System.out.println(r.numerator + "/" + r.denominator);
    }

    /* makes the rational number either negative if positive or positive if negative */
    public void negate(Rational r){
        r.numerator = r.numerator * -1;
    }

    /* inverts the rational number by flipping the nuemrator and denominator*/
    public void invert(Rational r){
        int n, d;
        n = r.numerator;
        d = r.denominator;
        r.numerator = d;
        r.denominator = n;
    }

    /* converts to double. Due to upcasting, data may be lost */
    public double toDouble(Rational r){
        double rationalNum = r.numerator /  r.denominator;
        return rationalNum;
    }

    /* finds gcd of the rational number given by means of the gcd trick */
    public String reduce(Rational r){
        int numerator = r.numerator;
        int denominator = r.denominator;

        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);

        while(numerator != denominator) {
            if(numerator > denominator)
                numerator -= denominator;
            else
                denominator -= numerator;
        }

        return r.numerator/numerator + "/" + r.denominator/numerator;
    }

    public String add(Rational r1, Rational r2){
        int commonDenominator = r1.denominator * r2.denominator;    // cross multiplies
        int newNumerator1 = r1.numerator * r2.denominator;  // cross multiplying to get new numerators
        int newNumerator2 = r2.numerator * r1.denominator;
        int finalNumerator = newNumerator1 + newNumerator2;

        // these variables are used to get the final gcd and divide them by the actual final numerators and deonminators
        int numerator = Math.abs(finalNumerator);
        int denominator = Math.abs(commonDenominator);

        while(numerator != denominator) {
            if(numerator > denominator)
                numerator -= denominator;
            else
                denominator -= numerator;
        }

        return finalNumerator/numerator + "/" + commonDenominator/numerator;
    }
}
