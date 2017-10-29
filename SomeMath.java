class SomeMath {

public static void main (String[] arguments){
double calculate =1.0 +2.0 * 3.0;
//different from =(1.0 + 2.0)*3.0
System.out.println(calculate);
calculate = calculate * 2.0;
// calculate *=2.0; would work too
System.out.println(calculate);
}
}
