package 异常;

/**
 * @author clt
 * @create 2019/12/3 19:42
 */
class MyException extends  Exception{

    private  String message;

    public MyException() {
        super();
    }

    public MyException(String s) {
        super(s);
        this.message = s;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

public class Practice4 {
    public static void main(String[] args) {
        System.out.println("program has started");
        try {
            System.out.println("program enter try {} ");
            throw new MyException("i am an exception");
        } catch (MyException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("program continue to execute");
    }
}
