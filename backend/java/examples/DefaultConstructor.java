package examples;

class DCA {
    int m;
    void work() {
        System.out.println(m);
    }
}

class DCB {
    int m;
    void work() {
        System.out.println(m);
    }
    DCB() {}
}

class DCC {
    int m;
    void work() {
        System.out.println(m);
    }
    DCC(int a) {
        m=a;
    }
}

public class DefaultConstructor {
    public static void main(String[] args) {
        DCA a = new DCA();
        DCB b = new DCB();
//        DCC c = new DCC();
        DCC c = new DCC(3);

        a.work();
        b.work();
        c.work();
    }
}
