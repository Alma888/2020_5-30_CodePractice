//考察对String类的理解

//String x="fmn";  “fmn”是在常量池里的不可变对象。
//    x.toUpperCase();   在堆中new一个"FMN"对象，但无任何引用指向它。
//    String y=x.replace('f','F'); 在堆中 new一个"Fmn"对象，y指向它。
//    y=y+"wxy"; 在堆中 重新new一个"Fmnwxy"对象， 修改y指向，现在y指向它。
public class Main {
    public static void main(String[] args) {
        String s="fmn";
        s.toUpperCase(); //在堆中创建了一个"FMN"对象，但是没有引用指向它
        String y=s.replace('f','F');//在堆中又创建了一个fmn"对象，用y引用指向它
        y=y+"wxy";//在堆中 重新new一个"Fmnwxy"对象， 修改y指向，现在y指向它。
        System.out.println(y);

        int i=0;
        Integer j=new Integer(0);
        System.out.println(i==j);  //基本数据类型比较  两个值相等返回true
        System.out.println(j.equals(i));
    }
}
