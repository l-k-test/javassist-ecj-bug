package javassist_ecj_bug;

import org.junit.Test;

public class JUnitJavassistTest {

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
