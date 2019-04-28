package cn.practice.BZhan._08_Enum;

/**
 * 枚举类型：
 * 其实是枚举类型的对象，
 * 都是Color类型的对象
 *
 * 枚举类还可以实现接口；
 *
 * 枚举类还可以定义抽象方法，
 * 但是每一个对象都要实现该抽象方法
 */
public enum  Color implements GetColor{
    RED,GREEN,BLUE;

    private int color;

    // 定义构造方法
    private Color(){
        System.out.println("无参构造器");
    }

    private Color(int color){
        System.out.println("有参构造器");
        this.color = color;
    }

    @Override
    public int getColor() {
        return 0;
    }
}
