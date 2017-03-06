package translator.source;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class SourceLoaderTest {
    private SourceLoader loader;

    @Before
    public void setUp() throws Exception {
        loader = new SourceLoader();
    }

    @After
    public void tearDown() throws Exception {
        loader = null;
    }

    @Test
    public void loadSource() throws Exception {
        SourceProvider mock = mock(SourceProvider.class);

        when(mock.isAllowed(anyString())).thenReturn(true);
        when(mock.load(anyString())).thenReturn(anyString());

        loader.loadSource(anyString());
    }
}