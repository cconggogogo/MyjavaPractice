package cn.practice.basis.grammar._07_File.FileTest;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;


public class Test1 {
    public static void main(String[] args) throws IOException {
//        test2();
//        test3();
//        test4();
        test5();
    }

    private static void test5() {
        System.out.println("递归删除带内容的文件");
        File file = new File("F:\\FileDemo\\test1");
        deleteFileFolders(file);
    }

    private static void deleteFileFolders(File file) {
        File[] files = file.listFiles();
        for (File fff: files) {
            if (fff.isDirectory()) {
                deleteFileFolders(fff);
            } else {
                System.out.println(fff.getName() + "===" +fff.delete());
            }
        }

        System.out.println(file.getName() + "===" + file.delete());
    }

    private static void test4() {
        System.out.println("输出以java结尾的文件");
        File file = new File("F:\\FileDemo\\test1");
        getAllEndByJava(file);
    }

    private static void getAllEndByJava(File file) {
        File[] files = file.listFiles();
        for (File f: files) {
            if (f.isDirectory()) {
                getAllEndByJava(f);
            } else {
                if (f.getName().endsWith(".java")) {
                    System.out.println(f.getName());
                }
            }
        }
    }

    public static void test3() {
        File file = new File("F:\\FileDemo\\test1");
        System.out.println("判断功能");
        System.out.println("isDirectory" + file.isDirectory());
        System.out.println("isFile" + file.isFile());
        System.out.println("exist: " + file.exists());
        System.out.println("canWrite: " + file.canWrite());
        System.out.println("canRead: " + file.canRead());
        System.out.println();

        System.out.println("获取功能");
        System.out.println("getAbosoult： " + file.getAbsolutePath());
        System.out.println("getPath: " + file.getPath());
        File[] files = file.listFiles();
        System.out.println("所有文件为");
        for (File f: files){
            System.out.println(f);
        }
        System.out.println("over");
        System.out.println();

        System.out.println("测试筛选功能");
        String[] str = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir,name).isFile() && name.endsWith(".jpg");
            }
        });
        for (String string: str){
            System.out.println(string);
        }
        System.out.println();

        System.out.println("筛选功能2");
        File[] files1 =  file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir,name).isFile() && name.endsWith(".jpg");
            }
        });
        for (File f: files1) {
            System.out.println(f.getName());
        }
    }
    public static void test1() {
        File file = new File("F:\\FileDemo");

        File file1 = new File("F:\\", "FileDemo");

        File file2 = new File("F:\\");
        File file3 = new File(file2, "FileDemo");
    }

    public static void test2() throws IOException {
        System.out.println("创建文件的相关方法的学习");
        File file = new File("F:\\FileDemo\\test1","a.txt");
        file.createNewFile();
//        file.mkdirs();

        System.out.println("删除文件");
        System.out.println(file.delete());
        System.out.println("改名");
        File file1 = new File("F:\\FileDemo\\test1\\大话西游.jpg");
        File file2 = new File("aaa.jpg");
        System.out.println(file1.renameTo(file2));


    }
}
