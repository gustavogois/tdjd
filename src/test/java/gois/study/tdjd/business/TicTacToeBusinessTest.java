package gois.study.tdjd.business;

import gois.study.tdjd.model.TicTacToe;
import gois.study.tdjd.repository.TicTacToeRepository;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TicTacToeBusinessTest {

    @Test
    public void whenSaveMoveThenInvokeRepositorySave() {

        TicTacToeRepository repository = mock(TicTacToeRepository.class);
        TicTacToeBusiness business = new TicTacToeBusiness(repository);

        TicTacToe bean = new TicTacToe(3, 2, 1, 'Y');
        business.saveMove(bean);

        verify(repository, times(1)).save(bean);
    }
}
