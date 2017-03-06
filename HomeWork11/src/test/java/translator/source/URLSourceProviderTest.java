package translator.source;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import translator.SourceLoadingException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

public class URLSourceProviderTest {
    private URLSourceProvider URLProvider;

    @Before
    public void init() {
        URLProvider = new URLSourceProvider();
    }

    @After
    public void destroy() {
        URLProvider = null;
    }

    @Test
    public void isAllowed() throws Exception {
        URLSourceProvider provider = mock(URLSourceProvider.class);

        List<String> list = new ArrayList<>();
        list.add("notUrl");
        list.add(null);

        assertFalse("check urls", provider.isAllowed(list.get(0)));
        assertFalse("check urls", provider.isAllowed(list.get(1)));
    }

    @Test(expected = SourceLoadingException.class)
    public void load() throws Exception {
        URLProvider.load("");
    }
}