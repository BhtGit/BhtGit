package test.myassert;

/**
 * @author BHT 2022/4/20 10:25
 */
public class CrmRequestAsset implements MyAssert {

    @Override
    public RuntimeException newException(String message) {
        return new RuntimeException();
    }
}
