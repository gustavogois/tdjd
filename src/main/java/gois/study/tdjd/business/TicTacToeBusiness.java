package gois.study.tdjd.business;

import gois.study.tdjd.model.TicTacToe;
import gois.study.tdjd.repository.TicTacToeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicTacToeBusiness {

    @Autowired
    private TicTacToeRepository repository;

    public TicTacToeBusiness() {
    }

    public TicTacToeBusiness(TicTacToeRepository repository) {
        this.repository = repository;
    }

    public boolean saveMove(TicTacToe bean) {
        try {
            repository.save(bean);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean drop() {
        try {
            repository.deleteAll();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
