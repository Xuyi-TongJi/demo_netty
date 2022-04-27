package nio.byteBuffer;

import java.nio.ByteBuffer;

import static util.ByteBufferUtil.debugAll;

public class TestByteBufferRead {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a', 'b', 'c', 'd'});
        buffer.flip();

        // 从头开始读
        buffer.get(new byte[4]);
        debugAll(buffer);

        // 将读指针position重置为0
        buffer.rewind();
        System.out.println((char)buffer.get());

        // mark & reset[对rewind的增强]
        // mark 做一个标记，记录一个position位置
        // reset 将position重置到mark的位置
        System.out.println((char)buffer.get());

        // mark at index 2 [c]
        buffer.mark();
        buffer.get(); // c
        buffer.get(); // d
        // reset position to mark [2]
        buffer.reset();
        System.out.println((char)buffer.get()); // c

        // get i(index) 仅仅会读index处的数据，而不会改变position指针
        System.out.println((char)buffer.get(3));
    }
}
