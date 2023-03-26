package com.chen.ribbon;

/**
 * @ClassName:TestClassLoader
 * @Auther: 26050
 * @Description:
 * @Date: 2023/3/19 18:47
 * @Version: v1.0
 */
public class TestClassLoader extends ClassLoader{

    public static void main(String[] args) {
        TestClassLoader loader = new TestClassLoader();

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
