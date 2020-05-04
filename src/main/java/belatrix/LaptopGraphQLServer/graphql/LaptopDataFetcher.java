package belatrix.LaptopGraphQLServer.graphql;

import graphql.schema.DataFetcher;
import belatrix.LaptopGraphQLServer.db.DummyLaptopDB;
import belatrix.LaptopGraphQLServer.model.Laptop;
import org.springframework.stereotype.Component;

@Component
public class LaptopDataFetcher {
    DummyLaptopDB dummyLaptopDB = new DummyLaptopDB();

    public DataFetcher getAllLaptops() {
        return dataFetchingEnvironment -> dummyLaptopDB.getAllLaptops();
    }

    public DataFetcher getLaptopByID() {
        return dataFetchingEnvironment -> dummyLaptopDB
                .getLaptopByID(Integer.parseInt(dataFetchingEnvironment.getArgument("id")))
                .orElse(new Laptop(0, "None", 0, 0));
    }

    public DataFetcher getLaptopsLessThan() {
        return dataFetchingEnvironment -> dummyLaptopDB.getLaptopsLessThan(dataFetchingEnvironment.getArgument("price"));
    }

    public DataFetcher deleteLaptop() {
        return dataFetchingEnvironment -> dummyLaptopDB.deleteLaptop(Integer.parseInt(dataFetchingEnvironment.getArgument("id")));
    }
}
