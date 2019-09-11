package gois.study.tdjd.business;

import gois.study.tdjd.model.TicTacToe;
import gois.study.tdjd.repository.TicTacToeRepository;

public class TicTacToeBusiness {

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
