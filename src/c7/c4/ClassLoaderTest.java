package c7.c4;

import java.io.IOException;
import java.io.InputStream;

/**
 * 类加载器与 instanceof 关键字测试
 *
 * p.s. 对于任意一个类, 都需要由加载它的类加载器和这个类本身一同确立其在Java虚拟机中的唯一性
 *
 * @author will
 * @date 2019/11/18
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {

        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("c7.c4.ClassLoaderTest").getDeclaredConstructor().newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof c7.c4.ClassLoaderTest);

        System.out.println(obj.getClass().getClassLoader());
        System.out.println(ClassLoaderTest.class.getClassLoader());
    }
}
