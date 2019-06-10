package cn.practice.Others._01_BasicJavaMethod.BZhan._02_JDK8.lambda.practice._01;

/**
 * 总结：
 * 在需要重写方法的地方：
 * 直接写函数体即可
 */
public class WorkerInterfaceTest {
    public static void execute(WorkerInterface work){
        work.doSomeWork();
    }

    public static void main(String[] args) {
        execute(new WorkerInterface() {
            @Override
            public void doSomeWork() {
                System.out.println("doSomething");
            }
        });

        // 等价于下面：通过lambda的方式传递方法
        execute(
                () -> System.out.println("doSomething")
        );
    }
}
