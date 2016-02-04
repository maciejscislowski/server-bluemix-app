package it.scislowski.bluemix.server.dao;

import it.scislowski.bluemix.server.domain.User;
import org.ektorp.CouchDbConnector;
import org.ektorp.dataload.DataLoader;
import org.ektorp.dataload.DefaultDataLoader;
import org.ektorp.support.CouchDbRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.io.Reader;

/**
 * @author Maciej.Scislowski@gmail.com
 */
@Repository
public class UserDao extends CouchDbRepositorySupport<User> implements DataLoader {

    private final static String[] INITIAL_DATA_PATH = {"classpath:users.json"};

    @Inject
    protected UserDao(CouchDbConnector db) {
        super(User.class, db);
        initStandardDesignDocument();
    }

    @Override
    public void loadInitialData(Reader reader) {;
        new DefaultDataLoader(db).load(reader);
    }

    @Override
    public void allDataLoaded() {
        System.out.println("****************************** User data are loaded ******************************");
    }

    @Override
    public String[] getDataLocations() {
        return INITIAL_DATA_PATH;
    }

}
