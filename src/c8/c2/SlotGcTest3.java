package c8.c2;

/**
 * -verbose:gc
 *
 * [0.020s][info][gc] Using G1
 * [0.284s][info][gc] GC(0) Pause Full (System.gc()) 67M->0M(10M) 4.650ms
 *
 * 64MB内存被成功回收
 *
 * p.s. SlotGcTest1-3中 placeholder能否被回收的根本原因是: 局部变量表中的Slot是否还存有关于placeholder数组对象的引用.
 *
 * @author will
 * @date 2019/11/18
 */
public class SlotGcTest3 {

    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
    }
}
