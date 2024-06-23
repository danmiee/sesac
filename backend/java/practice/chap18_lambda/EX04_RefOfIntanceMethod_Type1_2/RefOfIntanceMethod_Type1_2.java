package chap18_lambda.EX04_RefOfIntanceMethod_Type1_2;

interface A {
    void abc(int k);
}

public class RefOfIntanceMethod_Type1_2 {
    public static void main(String[] args) {
        A a1 = new A() {
            @Override
            public void abc(int k) {
                System.out.println(k);
            }
        };

        A a2 = (int k) -> {
            System.out.println(k);
        };

        A a3 = System.out::println;

        a1.abc(3);
        a2.abc(3);
        a3.abc(3);
    }
}
