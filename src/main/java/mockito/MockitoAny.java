package mockito;

import java.util.List;

public class MockitoAny {
    boolean isSomething(String string, int i, Object object) {
        return false;
    }

    int returnSomeInt(boolean isTrue, List<String> strings) {
        return 0;
    }

    int returnSomeIntByte(byte[] bytes, String[] strings, int num) {
        return 0;
    }

    public void returnsNothing() {
        System.out.println("void method");
    }
}
