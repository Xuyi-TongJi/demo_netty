package nio.byteBuffer;

import util.ByteBufferUtil;

import java.nio.ByteBuffer;

/**
 * ByteBuffer读写数据以及读写模式切换
 */
public class TestByteBufferReadWrite {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte) 0x61);
        buffer.put(new byte[]{0x62, 0x63, 0x64});
        ByteBufferUtil.debugAll(buffer);

        // 切换到读模式
        buffer.flip();
        System.out.println((char)buffer.get());
        ByteBufferUtil.debugAll(buffer);
        // 切换到写模式[压缩]
        buffer.compact();
        ByteBufferUtil.debugAll(buffer);
    }
}
