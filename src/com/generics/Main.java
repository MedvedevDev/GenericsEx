package com.generics;

public class Main {

    public static void main(String[] args) {
	    Gen<Integer> iOb;
	    iOb = new Gen<Integer>(999);
	    iOb.showType();

	    Gen gO = new Gen();
        System.out.println(gO.f);
	    int g = iOb.getOb();
        System.out.println(g);

        Gen<String> strOb  = new Gen<>("hello");
        strOb.showType();
        String getStr = strOb.getOb();
        System.out.println(getStr);

        TwoGen<Integer,String> o = new TwoGen<>(123, "Sto20tri");
        o.showType();

        int v  = o.getOb1();
        System.out.println(v);
        System.out.println(o.getOb2());

        System.out.println(" ---------------------------- ");
        Integer[] nums = {1,2,3,4,5,6,7};
        Stats<Integer>  iob = new Stats<>(nums);
        double d = iob.average();
        System.out.println(d);

        System.out.println(" ---------------------------- ");
        Integer[] nums1 = {1,3,4,5};
        if (GenMethDemo.isIn(1, nums1)) {
            System.out.println("2 is in  nums1");
        } else {
            System.out.println("False");
        }

        if(!GenMethDemo.isIn(7, nums1)){
            System.out.println("7  not is in");
        } else {
            System.out.println("False");
        }

        System.out.println(" ---------------------------- ");
        GenCons t1 = new GenCons(23);
        t1.show();
        GenCons t2 = new GenCons(123.4f);
        t2.show();

        System.out.println(" ---------------------------- ");
        Integer[] nums3 = {7,45,7,3,6,0};
        MinMaxClass<Integer>  r = new MinMaxClass<>(nums3);
        System.out.println("max " + r.max());
        System.out.println("min " + r.min());

        Character[] ch = {'f', 'x', 'b', 'a', 'r', 'q', 'v', 'a', 'm', 'u'};
        MinMaxClass<Character> r1 = new MinMaxClass<>(ch);
        System.out.println("max " + r1.max());
        System.out.println("min " + r1.min());

        System.out.println(" ---------------------------- ");
        Gen2<String, Integer> x = new Gen2<>("Sabs", 34);
        System.out.println(x.getOb());
        System.out.println(x.getOb2());
    }
}

class Stats<T extends Number> {
    T[] nums;

    Stats(T[] mas) {
        nums = mas;
    }

    double average(){
        double sum=0.0;
        for (int i=0; i<nums.length; i++){
            sum += nums[i].doubleValue();
        }

        return sum / nums.length;
    }
}

class Gen<B> {
    B ob;
    int f;

    Gen(){
        f=4;
    }

    Gen(B o){
        ob = o;
    }

    B getOb(){
        return ob;
    }

    void showType(){
        System.out.println(ob.getClass().getName());
    }
}

class TwoGen<T, V>{
    T ob1;
    V ob2;

    TwoGen(T  o1, V o2){
        ob1 = o1;
        ob2 =  o2;
    }

    public void showType(){
        System.out.println("ob1 " + ob1.getClass().getName() + " ob2 " + ob2.getClass().getName());
    }

    T getOb1(){
        return ob1;
    }

    V getOb2(){
        return ob2;
    }
}

class TwoD {
    int x,y;

    TwoD(int a , int b){
        x = a;
        y = b;
    }
}

class ThreeD extends TwoD{
    int z;

    ThreeD(int a , int b, int c){
        super(a, b);
        z = c;
    }
}

class FourD extends ThreeD{
    int t;

    FourD(int a , int b, int c, int d){
        super(a, b, c);
        t = d;
    }
}

class Coords<T extends TwoD>{
    T[] coords;

    Coords(T[] mas){
        coords = mas;
    }

    void showXY(Coords<?> c){
        System.out.println("Coords x y");
        for (int i = 0; i<c.coords.length; i++)
            System.out.println(c.coords[i].x + " " + c.coords[i].y);
    }
}

class GenMethDemo{
    static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y){
        for (int i=0; i<y.length; i++)
            if (x.equals(y[i])) return true;

            return false;
    }
}

class GenCons{
    private double val;

    <T extends Number>GenCons(T a){
        val = a.doubleValue();
    }

    void show(){
        System.out.println(val);
    }
}

interface MinMax<T extends Comparable<T>>{
    T min();
    T max();
}

class MinMaxClass<T extends Comparable<T>> implements MinMax<T>{
    T[] vals;
    MinMaxClass(T[] o){vals = o;}

    @Override
    public T min() {
        T v = vals[0];
        for (int i=0; i<vals.length; i++)
            if (vals[i].compareTo(v) < 0) v = vals[i];
        return v;
    }

    @Override
    public T max() {
        T v = vals[0];
        for (int i=0; i<vals.length; i++)
            if (vals[i].compareTo(v) > 0) v = vals[i];
        return v;
    }
}

class Gen2<T, V> extends Gen<T>{
    V ob2;

    Gen2(T o, V o1){
        super(o);
        ob2 = o1;
    }

    V getOb2(){
        return ob2;
    }
}