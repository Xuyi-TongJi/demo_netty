package nio.byteBuffer;

import java.nio.ByteBuffer;

/**
 * ByteBuffer分配容量
 */
public class TestBufferAllocate {
    public static void main(String[] args) {
        // HeapByteBuffer 堆内存，读写效率较低，且会收到GC影响
        System.out.println(ByteBuffer.allocate(16).getClass());
        // DirectByteBuffer 直接内存，读写效率较高[少一次拷贝]，不会受到GC影响，但分配速度较慢[调用OS API]，容易造成内存泄漏
        System.out.println(ByteBuffer.allocateDirect(16).getClass());
    }
}
