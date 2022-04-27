package nio;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO三大组件之一：ByteBuffer
 */
@Slf4j
public class TestByteBuffer {
    public static void main(String[] args) {
        testByteBuffer();
    }

    /**
     * 使用ByteBuffer和Channel实现文件读取
     */
    private static void testByteBuffer() {
        // FileChannel
        // 获取Channel：1. 输入输出流 2. RandomAccessFile
        try (FileChannel channel = new FileInputStream("data.txt").getChannel()) {
            // 获取缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(10);
            // 从channel中读取数据[向缓冲区写入] 返回读到的实际字节数 -1代表读取到EOF
            while (true) {
                int len = channel.read(buffer);
                log.debug("读取到的字节:{}", len);
                if (len == -1) {
                    break;
                }
                /* 打印buffer内容 */

                // 切换至读模式[读buffer向屏幕输出]
                buffer.flip();
                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
                    log.debug("实际字节:{}", (char) b);
                }
                // 切换至写模式[读channel向buffer输出]
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
