package 多态.构造器和多态;

/**
 * @author clt
 * @create 2019/11/29 19:35
 * 构造器内部的多态方法的行为  示例
 */

class Glyph{
    Glyph(){
        System.out.println("before Glyph.draw()");
        draw();
        System.out.println("after Glyph.draw()");
    }
    void draw(){
        System.out.println("Glyph.draw()");
    }
}

class RectangularGlyph{
    RectangularGlyph(){
        System.out.println("before RectangularGlyph.draw()");
        draw();
        System.out.println("after RectangularGlyph.draw()");
    }
    void draw(){
        System.out.println("RectangularGlyph.draw()");
    }
}

class RoundGlyph extends Glyph{
    private int radius = 1;

    RoundGlyph(int r){
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph() radius = "+radius);
    }
    @Override
    void draw(){
        System.out.println("RoundGlyph.draw  radius = "+radius);
    }
}

public class PloyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);

        /**
         * before Glyph.draw()
         * RoundGlyph.draw  radius = 0
         * after Glyph.draw()
         * RoundGlyph.RoundGlyph() radius = 5
         * 在new RoundGlyph()实例时由于先会追溯基类构造方法
         * 所以会调用Glyph()构造方法中的draw 且draw被覆盖发生了多态
         * 所以实质是调用的RoundGlyph.draw()方法，而调用该方法时RoundGlyph还没有将
         * 成员变量进行赋值初始化  所以radius值为默认0  随后初始化完了后 变为5
         * 这种情况就是在基类构造过程中发送多态从而调用了导出类的方法，而此时导出类成员变量还没有进行初始化
         */

    }


}
