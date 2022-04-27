package nio.byteBuffer;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static util.ByteBufferUtil.debugAll;
/**
 * 字符串与ByteBuffer的相互转换
 */
public class TestStringToByteBuffer {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        // 1. 字符串转为byteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put("hello".getBytes(StandardCharsets.UTF_8));
        debugAll(buffer);

        // 2. Charset直接转换 encode转换后会自动转换到读模式
        ByteBuffer hello = StandardCharsets.UTF_8.encode("hello");
        debugAll(hello);

        // 3. wrap 也会自动转换到读模式
        ByteBuffer wrap = ByteBuffer.wrap("hello".getBytes(StandardCharsets.UTF_8));
        debugAll(wrap);

        // byte数组转为字符串 [buffer必须在读模式]
        String s = StandardCharsets.UTF_8.decode(hello).toString();
        System.out.println(s);
    }
}
