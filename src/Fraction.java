public class Fraction {
    
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }
    
    public Fraction(double value){
        this.numerator = (int) (value * 10 * Double.toString(value).split("\\.")[1].length());
        this.denominator = 10 * Double.toString(value).split("\\.")[1].length();
//        int myNumber = 0;
//        int index = 0;
//        while (value != 0){
//            myNumber = (int) Math.floor(value) + myNumber * 10;
//            value -= Math.floor(value);
//            value *= 10;
//            index++;
//            if (index == 7) break;
//        }
//        numerator = myNumber;
//        denominator = (int) Math.pow(10,index-1);
          
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
    
    public Fraction add(Fraction addend){
        return new Fraction((numerator * addend.denominator) + (addend.numerator * denominator),
                             denominator * addend.denominator).simplify();
    }
    
    public Fraction subtract(Fraction subtrahend){
        return this.add(new Fraction(subtrahend.numerator*(-1),subtrahend.denominator));
    }
    
    public Fraction product(Fraction multiplicand){
        return new Fraction(numerator * multiplicand.numerator, denominator * multiplicand.denominator).simplify();
    }
    
    public Fraction divide(Fraction divisor){
        return this.product(new Fraction(divisor.denominator,divisor.numerator));
    }
    
    private Fraction simplify(){
        int gcd = euclideanGCD(numerator, denominator);
        return new Fraction(numerator/gcd, denominator/gcd);
    }
    
    private int euclideanGCD(int a, int b){
        if (b == 0)
            return a;
        else
            return euclideanGCD(b, a % b);
    }
    
    public void showFraction(){
        System.out.println(numerator + " / " + denominator);
    }
    
    @Override
    public String toString(){
        return String.valueOf((double) numerator / (double) denominator);
    }
}
