package javassist_ecj_bug;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class PowerMockJavassistTest {

    @Test
    public void test1() throws Exception {
        try (TestClosable tc = newClosable()) {
        }
//        try (TestClosable tc = new TestClosable()) {
//        }
    }

    public static TestClosable newClosable() {
        return new TestClosable();
    }

    public static class TestClosable implements AutoCloseable {
        @Override
        public void close() throws Exception {
        }
    }
}
