package 异常.使用finally进行清理;

/**
 * @author clt
 * @create 2019/12/4 20:02
 * 在return中使用finally 示例1
 */
//: exceptions/MultipleReturns.java

public class MultipleReturns1 {
    public static int f(int i) {
        try {
            System.out.println("Point 1");
            if(i == 1) return i;
            System.out.println("Point 2");
            System.out.println("End");
            return i;
        } finally {
            i = 10;
            return 20;
        }
    }
    public static void main(String[] args) {
        for(int i = 1; i <= 2; i++)
            System.out.println(f(i));
        /**
         * 无论从何处return finally都将会执行
         * 当finally语句块中对try语句块中的return变量进行修改时
         * return的值仍然是之前try中的值
         * 但finally语句块中重新return新的值则将覆盖try语句块中的return值
         * 大概过程是当try语句块中有return 值时将会保存起来
         * 如果在finally重新改变了之前的值变量，返回的将仍然是之前保留的那份
         * 但如果在finally中重新return新的值，则之前保留的那份值将失效，return的值
         * 将是finally中的
         */

    }
} /* Output:
Initialization that requires cleanup
Point 1
Performing cleanup
Initialization that requires cleanup
Point 1
Point 2
Performing cleanup
Initialization that requires cleanup
Point 1
Point 2
Point 3
Performing cleanup
Initialization that requires cleanup
Point 1
Point 2
Point 3
End
Performing cleanup
*///:~

