package test.myassert;

/**
 * @author BHT 2022/4/20 10:45
 */
public enum AssertEnum implements MyAssert {

    CRM_REQUEST(new CrmRequestAsset());

    private MyAssert myAssert;

    AssertEnum(MyAssert myAssert){
        this.myAssert = myAssert;
    }

    @Override
    public RuntimeException newException(String message) {
        return this.myAssert.newException(message);
    }
}
