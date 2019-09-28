package mockito;

import random.fibonacci.StreamIterate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;


class MockitoPracticeTests {
    @InjectMocks
    StreamIterate streamIterate;

    @Mock
    StreamIterate streamIterateMock;

    @Mock
    List<String> mockStringList;

    @Spy
    List<String> spyStringList = new ArrayList<>();

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void mockThenReturn() {
        Mockito.when(mockStringList.get(0)).thenReturn("returnedMock");
        String result = mockStringList.get(0);
        Mockito.verify(mockStringList).get(0);
        Assertions.assertEquals("returnedMock", result);
    }

    @Test
    void spyThenReturn() {
        spyStringList.add("one");
        spyStringList.add("two");
        Mockito.verify(spyStringList).add("one");
        Mockito.verify(spyStringList).add("two");
        Assertions.assertEquals(2, spyStringList.size());

        mockStringList.add("one");
        Mockito.verify(mockStringList).add("one");
        Assertions.assertEquals(0, mockStringList.size());
    }


    @Test
    void streamIterateInjectMock() {
       int num = streamIterate.fibonacci(1);
       Assertions.assertEquals(0, num);

       int num2 = streamIterateMock.fibonacci(1);
       Assertions.assertEquals(0, num2);
    }
}
