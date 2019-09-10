package gois.study.tdjd.repository;

import gois.study.tdjd.model.TicTacToe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicTacToeRepository extends CrudRepository<TicTacToe, Integer> {
}
