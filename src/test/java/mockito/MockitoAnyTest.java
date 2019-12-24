package mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;

public class MockitoAnyTest {

    @Mock
    MockitoAny mockitoAny;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void anyTest() {
        Mockito.when(mockitoAny.isSomething(anyString(), anyInt(), any(Object.class))).thenReturn(true);
        assertTrue(mockitoAny.isSomething("A", 1, "A"));
        assertTrue(mockitoAny.isSomething("B", 10, new Object()));

        Mockito.when(mockitoAny.returnSomeInt(anyBoolean(), anyList())).thenReturn(2);
        assertEquals(2, mockitoAny.returnSomeInt(true, new ArrayList<>()));

        Mockito.when(mockitoAny.returnSomeIntByte(any(byte[].class), any(String[].class), anyInt())).thenReturn(3);
        assertEquals(3, mockitoAny.returnSomeIntByte(new byte[] {2}, new String[] {"derp"}, 3));
    }
}
