package chap18_lambda.EX03_RefOfIntanceMethod_Type1_1;

interface A { void abc(); }
class B { void bcd() {
    System.out.println("메서드");
}}

public class RefOfIntanceMethod_Type_1 {
    public static void main(String[] args) {

        A a1 = new A() {
            public void abc() {
                B b = new B();
                b.bcd();
            }
        };

        A a2 = () -> {
            B b = new B();
            b.bcd();
        };

        B b = new B();
        A a3 = b::bcd;

        a1.abc();
        a2.abc();
    }
}
