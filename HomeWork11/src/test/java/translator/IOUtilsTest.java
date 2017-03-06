package translator;

import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IOUtilsTest {
    @Test
    public void testToStringWishByteArray() throws Exception {
        byte[] data = "111, 243, 145, 123".getBytes();
        InputStream in = new ByteArrayInputStream(data);
        Assert.assertEquals("111, 243, 145, 123\n", IOUtils.toString(in));
    }

    @Test(expected = IOException.class)
    public void testToStringToThrowIOException() throws Exception {
        InputStream mock = mock(InputStream.class);
        assertEquals("test IOException", IOUtils.toString(mock));
    }
}