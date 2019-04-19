package ru.ftc.focusstart.unittests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

public class GetStatusUseCaseTest {

    private StatusRepository statusRepository;
    private GetStatusUseCase getStatusUseCase;

    @Before
    public void setUp() {
        statusRepository = Mockito.mock(StatusRepository.class);
        getStatusUseCase = new GetStatusUseCase(statusRepository);
    }

    @Test
    public void testInvokeWithStatusInRepository() {
        String status = "some status";
        Mockito.when(statusRepository.getStatus()).thenReturn(status);

        String actualResult = getStatusUseCase.invoke();

        assertEquals(status, actualResult);
        Mockito.verify(statusRepository).getStatus();
        Mockito.verify(statusRepository, Mockito.never()).setStatus(anyString());
        Mockito.verifyNoMoreInteractions(statusRepository);
    }

    @Test
    public void testInvokeWithNullStatusInRepository() {
        Mockito.when(statusRepository.getStatus()).thenReturn(null);

        String actualResult = getStatusUseCase.invoke();

        assertEquals("STATUS_DEFAULT", actualResult);
        Mockito.verify(statusRepository).getStatus();
        Mockito.verify(statusRepository).setStatus("STATUS_DEFAULT");
        Mockito.verifyNoMoreInteractions(statusRepository);
    }

    @Test(expected = RuntimeException.class)
    public void testInvokeWithExceptionThrownFromRepository() {
        Mockito.when(statusRepository.getStatus()).thenThrow(new RuntimeException());

        getStatusUseCase.invoke();
    }
}