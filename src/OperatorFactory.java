
import java.util.HashMap;
import java.util.Optional;

public class OperatorFactory {
    static HashMap<Object, GetCaseNumber> getCaseNameMap = new HashMap<Object, GetCaseNumber>();
    static {

        getCaseNameMap.put(0, new Case0());
        getCaseNameMap.put(1, new Case1());
        getCaseNameMap.put(2, new Case2());
        getCaseNameMap.put(3, new Case3());
        getCaseNameMap.put(4, new Case4());
        getCaseNameMap.put(5, new Case5());
        getCaseNameMap.put(6, new Case6());
        getCaseNameMap.put(7, new Case7());
//        getCaseNameMap.put(8, new Case8());
    }
    public static Optional<GetCaseNumber> getCaseNameOptional (int getCaseNumber){
        return Optional.ofNullable(getCaseNameMap.get(getCaseNumber));
    }
}

