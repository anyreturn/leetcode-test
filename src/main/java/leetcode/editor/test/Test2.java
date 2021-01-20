package leetcode.editor.test;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSONObject;

/**
 * @author ：xinze
 * @date ：Created by 2020/4/23 09:23
 * @description：
 * @modified By：
 * @version:
 */

public class Test2 {

    public static void main(String[] args) {

        Test2 test2 = new Test2();

        //LinkedHashMap linkedHashMap = new LinkedHashMap(16);
        ////linkedHashMap
        //
        //LinkedHashSet linkedHashSet = new LinkedHashSet(16);
        //
        ////Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate();
        //
        //ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap();

        //int n = -2;
        //
        //char n1 = 2 + '0';
        //int n2 = 60 - '0';
        //int n3 = 1 + '0';
        //int n4 = 1 - '0';
        //System.out.println();

        //int a= n-1;
        //String binary = Integer.toBinaryString(a);
        //System.out.println(binary);
        //
        //Long ll = 2L;


        //int count = new Test2().numberOf1(n);
        //System.out.println(count);

        //List<String> list = new ArrayList<String>();
        //list.add("1");
        //list.add("2");
        //Test2 test2 = new Test2();
        //test2.test(list);

        //test2.testClassForName();

    }

    void testGuava(){
        //FutureFallback
        FutureTask futureTask = new FutureTask(null);
    }

    void testFuture(){
        Future future = new FutureTask(null);
        //future.add
    }

    void testClassForName(){
        String packPath = "leetcode.editor.test.TestClassForname";
        String packPathImpl = "leetcode.editor.test.impl.TestClassFornameImpl";

        try {
            Class<?> aClass = Class.forName(packPathImpl);

            Method method = aClass.getMethod("getClazz1");

            Object object = method.invoke(aClass.newInstance());

            System.out.println(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void test(List<String> list){
        List<String> stringList = list.stream().map(this::maps).filter(o->o!=null).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(stringList));
    }

    public String maps(String s){
        if(s.equals("1")){
            return s;
        }
        return null;
    }

    int numberOf1(int n){
        //n=Math.abs(n);
        int count =0;
        while(n!=0){
            count++;
            String binary = Integer.toBinaryString(n);
            String binary1 = Integer.toBinaryString(n-1);
            System.out.println(binary);
            System.out.println(binary1);
            n=(n-1)&n;
            String binary2 = Integer.toBinaryString(n);
            System.out.println(binary2);

        }
        return count;
    }
}
