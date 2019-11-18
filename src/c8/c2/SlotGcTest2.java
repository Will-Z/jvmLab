package c8.c2;

/**
 *
 * -verbose:gc
 *
 * [0.015s][info][gc] Using G1
 * [0.256s][info][gc] GC(0) Pause Full (System.gc()) 67M->65M(227M) 2.759ms
 *
 * 显然64MB内存并没有被回收
 *
 * @author will
 * @date 2019/11/18
 */
public class SlotGcTest2 {

    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        System.gc();
    }
}
