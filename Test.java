//考察 【子类构造隐式调用父类无参构造】

class Person {
    String name = "No name";
   public Person(){}
    public Person(String nm) {
        name = nm;
    }
}
class Employee extends Person {
    String empID = "0000";
    //这里子类的构造方法会隐式的调用父类的无参构造，若父类中已经有 有参构造 了
    //所以就没有无参构造了，这时调用，编译会出错
    public Employee(String id) {
        empID = id;
    }
}
public class Test {
    public static void main(String args[]) {
        Employee e = new Employee("123");
        System.out.println(e.empID);
    }
}