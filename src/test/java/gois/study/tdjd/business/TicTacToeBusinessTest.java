package gois.study.tdjd.business;

import gois.study.tdjd.model.TicTacToe;
import gois.study.tdjd.repository.TicTacToeRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class TicTacToeBusinessTest {

    private TicTacToeRepository repository;
    private TicTacToeBusiness business;
    private TicTacToe bean;

    @Before
    public void before() {
        repository = mock(TicTacToeRepository.class);
        business = new TicTacToeBusiness(repository);
        bean = new TicTacToe(3, 2, 1, 'Y');
    }

    @Test
    public void whenSaveMoveThenInvokeRepositorySave() {

        business.saveMove(bean);

        verify(repository, times(1)).save(bean);
    }

    @Test
    public void whenSaveMoveThenReturnTrue() {

        assertTrue(business.saveMove(bean));
    }

    @Test
    public void givenExceptionWhenSaveMoveThenReturnFalse() {
        doThrow(new RuntimeException("Bla")).when(repository).save(any(TicTacToe.class));
        assertFalse(business.saveMove(bean));
    }

    @Test
    public void whenDropThenInvokeRepositoryDeleteAll() {
        business.drop();
        verify(repository).deleteAll();
    }

    @Test
    public void whenDropThenReturnTrue() {
        assertTrue(business.drop());
    }

    @Test
    public void givenExceptionWhenDropThenReturnFalse() {
        doThrow(new RuntimeException("Bla")).when(business).drop();
        assertFalse(business.drop());
    }
}
