class c{
    static class ic1{
        void fun(){
            System.out.println("ic1 success");
        }
    }
    class ic2{
        void fun(){
            System.out.println("ic2 success");
        }
    }
    static void fun(){
        c out=new c();
        ic2 o2=out.new ic2();
        ic1 o=new ic1();
        o.fun();
        o2.fun();
    }
}

public class staticclass {

    public static void main(String[] args) {
        // c o=new c();
        c.fun();
        c out=new c();
        c.ic1 o1=new c.ic1();
        c.ic2 o2=out.new ic2();
        o2.fun();
    }
}
