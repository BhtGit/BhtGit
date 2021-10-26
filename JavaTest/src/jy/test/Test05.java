package jy.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test05 {
    public static void main(String[] args) {

            String soapAction = "GetPendingFlows";
        Map paramMap = new HashMap();
        paramMap.put("instanceId","175001");
        paramMap.put("eName","wanglc");
        paramMap.put("flowId","2442");
        paramMap.put("taksId","565001");
            String soapRequestData = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                    + "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">"
                    + "<soap12:Body>"
                    + " <"
                    + soapAction
                    + " xmlns=\"http://www.kayang.com/\">";

            for (Iterator i = paramMap.keySet().iterator(); i.hasNext();) {
                Object obj = i.next();
                soapRequestData = soapRequestData + "<" + obj.toString() + ">"+ paramMap.get(obj).toString() + "</" + obj.toString() + ">";

            }
            soapRequestData=soapRequestData+"<account>jyzq</account>"+"<password>jyzq</password>"+ " </" + soapAction	+ "> </soap12:Body>" + "</soap12:Envelope>";
            System.out.println(soapRequestData);

    }

}
