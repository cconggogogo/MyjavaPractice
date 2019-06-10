package cn.practice.DesignPatterns.CreateModel.Singleton.Hungry;

/**
 * 枚举类型的单例模式
 */
public enum Singleton3 {

    INSTANCE;

    private String objName;


    public String getObjName() {
        return objName;
    }


    public void setObjName(String objName) {
        this.objName = objName;
    }


    public static void main(String[] args) {

        // 单例测试
        Singleton3 firstSingleton = Singleton3.INSTANCE;
        firstSingleton.setObjName("firstName");
        System.out.println(firstSingleton.getObjName());
        Singleton3 secondSingleton = Singleton3.INSTANCE;
        secondSingleton.setObjName("secondName");
        System.out.println(firstSingleton.getObjName());
        System.out.println(secondSingleton.getObjName());
        System.out.println("-----------------------------");

        // 反射获取实例测试
        try {
            Singleton3[] enumConstants = Singleton3.class.getEnumConstants();
            for (Singleton3 enumConstant : enumConstants) {
                System.out.println(enumConstant.getObjName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

