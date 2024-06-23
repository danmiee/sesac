package chap18_lambda.EX07_RefOfInstanceMethod_Type2_2;

interface A {
    int abc(String str);
}

public class RefOfInstanceMethod_Type2_2 {
    public static void main(String[] args) {
        A a1 = new A() {
            @Override
            public int abc(String str) { return str.length(); }
        };

        A a2 = (String str) -> str.length();

        A a3 = String::length;

        System.out.println(a1.abc("안녕"));
        System.out.println(a2.abc("안녕"));
        System.out.println(a3.abc("안녕"));
    }
}
