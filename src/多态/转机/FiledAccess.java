package 多态.转机;


/**
 * @author clt
 * @create 2019/11/29 18:27
 * 缺陷：域与静态方法 示例
 */
class Sup{
    public int field = 0;

    public int getField() {
        return field;
    }

}

class Sub extends Sup{
    public int field = 1;

    public int getField(){
        return field;
    }

    public int getSupField(){
        return super.field;
    }
}


public class FiledAccess {

    public static void main(String[] args) {
        Sup sup = new Sub();
        System.out.println("Sup.field="+sup.field+",sup.getField()="+sup.getField());
        Sub sub = new Sub();
        System.out.println("Sub.field="+sup.field+",Sub.getField()="+sup.getField()+
                            ",Sub.getSupField()="+sub.getSupField());
        /**
         * 子类和父类 存在相同名称的域且子类的域为public时，
         * 两个域是分配了不同的存储空间。
         */


    }


}
