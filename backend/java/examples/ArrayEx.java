package examples;

class Declaration {
    void method() {
        int a;
        int[] b;
//        System.out.println(a);
//        System.out.println(b);

        int c=0;
        int[] d=null;
        System.out.println(c);
        System.out.println(d);
    }
}

class StringTest {
    void method() {
        java.lang.String str1 = "안녕";
        java.lang.String str2 = str1;

        System.out.println(1 + str1);
        System.out.println(2 + str2);

        str1 = "안녕하세요";

        System.out.println(3 + str1);
        System.out.println(4 + str2);

        str1 = str2;
        str2 = null;

        System.out.println(5+str1);
        System.out.println(6+str2);
    }
}

class A {
    int m;
    int n;

    void work1() {
        int k;
//        System.out.println(k);  //오류
    }
}

public class ArrayEx {
    public static void main(String[] args) {
//        Declaration dec = new Declaration();
//        dec.method();

//        StringTest strt = new StringTest();
//        strt.method();

//        A a = new A();
//        System.out.println(a.m);
//        System.out.println(a.n);
    }
}