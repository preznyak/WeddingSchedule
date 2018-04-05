import entity.WeddingTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import service.WeddingServiceTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        WeddingTest.class,
        WeddingServiceTest.class
})
public class WeddingTestSuite {
}
