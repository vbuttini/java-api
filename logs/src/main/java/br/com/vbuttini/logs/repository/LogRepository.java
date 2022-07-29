package br.com.vbuttini.logs.repository;

import br.com.vbuttini.logs.entity.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * This class contain the order repository
 *
 * @author vinic
 */
@Repository
public interface LogRepository extends MongoRepository<Log, String>  {
}
