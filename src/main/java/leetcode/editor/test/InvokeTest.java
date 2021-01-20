package leetcode.editor.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author ：xinze
 * @date ：Created by 2021/1/20 11:35
 * @description：
 * @modified By：
 * @version:
 */

class People {
    //静态属性
    public static String Version="1.1.1";
    private String Name;
    private Integer Age;
    private String Habit;
    //公共构造函数
    public People(String name, Integer age, String habit) {
        Name = name;
        Age = age;
        Habit = habit;
    }
    //私有构造函数
    private People(String name){
        Name=name;
    }

    public People(){

    }
    //私有方法
    private void isPrivate(String data){
        System.out.println("这是个私有方法,传入的参数为："+data);
    }
    //公有方法
    public String getName() {
        return Name;
    }
    //静态方法
    public static void StaticVoid(){
        System.out.println("这是一个静态方法");
    }
}


public class InvokeTest {
    public static void main(String[] args) {
        try {
            System.out.println("----------------------获取Class对象-----------------------");
            //因为我这里People和reflectionTest在同一包下，如果不在同一包下需要传入完整的类路径
            Class clazz = Class.forName("leetcode.editor.test.People");
            System.out.println(clazz);
            /**
             * 还有两种获取Class对象的方法,这几种方法获取的Class对象都是同一个对象：
             * 一般都会用foeName的方式，因为下面第一种方法需要导包
             * 第二种方法，对象都创建出来了，除非是要调用私有的东西，那我还反射个毛。
             * 1.Class clazz=People.class;
             * 2.People p=new People();
             *   Class clazz=p.getClass();
             * */
            System.out.println("----------------------获取构造函数对象-----------------------");
            //获取所有构造函数，不包括私有的，如果想包括私有就用getDeclaredConstructors
            Constructor[] constructors = clazz.getConstructors();
            for (Constructor c : constructors) {
                System.out.println(c);
            }
            //获取私有构造函数并调用(String.class为构造函数参数类型)
            Constructor constructor = clazz.getDeclaredConstructor(String.class);
            //忽略访问修饰符，如果是共有的就不需要这一步
            constructor.setAccessible(true);
            //根据这个构造函数创建一个People实例对象
            People people = (People) constructor.newInstance("张三");
            //最后通过对象输出刚刚设置的姓名
            System.out.println(people.getName());

            System.out.println("----------------------获取方法对象-----------------------");
            //获取所有公共方法,包括父类的方法，比如Object的equals，如果想包含私有方法就用getDeclaredMethods,但只有本类的方法
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
            //获取一个私有方法并调用
            Method method = clazz.getDeclaredMethod("isPrivate", String.class);
            //忽略访问修饰符
            method.setAccessible(true);
            //访问私有方法，如果这个私有方法有返回值用一个变量接收就行了。
            //通过invoke调用该私有方法，除了要传入这个方法本来的参数，比如这里的耶low，还需要一个该方法对应类的对象，我们就用上面反射获取的people对象
            method.invoke(people, "耶low");
            //获取静态方法并调用，发现调用静态方法不需要实例对象，这也符合原理中所说的。
            Method method2=clazz.getMethod("StaticVoid");
            method2.invoke(null);

            System.out.println("----------------------获取属性对象-----------------------");
            //获取本类的所有属性，包括私有的
            Field[] fields=clazz.getDeclaredFields();
            for(Field field:fields){
                System.out.println(field);
            }
            //获取私有属性并调用
            Field field=clazz.getDeclaredField("Name");
            field.setAccessible(true);
            //设置这个私有属性
            field.set(people,"李四");
            //然后获取一下Name，看看设置成功没
            System.out.println(people.getName());
            //获取静态属性
            Field field2=clazz.getField("Version");
            //输出静态属性的值
            System.out.println(field2.get(clazz));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
