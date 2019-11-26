package gy.test;

import org.apache.commons.lang.StringUtils;

import java.security.MessageDigest;

/**
 * @author ：BHT
 * @date ：2019-09-10 09:51
 */
public class Test02 {

    private static final char[] base64EncodeChars = new char[]{'A', 'B', 'C',
            'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c',
            'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2',
            '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    public static String getSourceContent(String content, String checkword) throws Exception {
        if (StringUtils.isEmpty(content)) {
            return "error";
        }
        String[] value = java.net.URLDecoder.decode(content, "utf-8").split("&");
        if (value.length <= 0) {
            return "error";
        }
        String sourceSplitUrl = "";
        String sourceSplitDES = "";
        for (String tempStr : value) {
            if (!StringUtils.isEmpty(tempStr) && tempStr.contains("logistics_interface=")) {
                // 数据明文
                sourceSplitUrl = tempStr.replaceAll("logistics_interface=", "");
            } else if (!StringUtils.isEmpty(tempStr) && tempStr.contains("data_digest=")) {
                // 加密数据
                sourceSplitDES = tempStr.replaceAll("data_digest=", "");
            }

            // 兼容顺丰回传不传参数名称问题
            if (!StringUtils.isEmpty(tempStr)
                    && !tempStr.contains("data_digest=")
                    && !tempStr.contains("wareshouse=")
                    && !tempStr.contains("warehouseCode=")) {
                // 数据明文
                sourceSplitUrl = tempStr.replaceAll("logistics_interface=", "");
            }
        }
        String reEncode = MD5AndBase64Encypt(sourceSplitUrl + checkword);
        if (reEncode.equals(sourceSplitDES)) {
            return sourceSplitUrl;
        }
        return "error";
    }

    private static String MD5AndBase64Encypt(String pwd) {
        try {
            MessageDigest md1 = MessageDigest.getInstance("MD5");

            byte[] bb = pwd.getBytes("UTF8");
            byte[] hash = md1.digest(bb);
            return encode(hash);
        } catch (Exception e) {
            return "";
        }
    }

    public static String encode(byte[] data) {
        StringBuilder sb = new StringBuilder();
        int len = data.length;
        int i = 0;
        int b1, b2, b3;

        while (i < len) {
            b1 = data[i++] & 0xff;
            if (i == len) {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[(b1 & 0x3) << 4]);
                sb.append("==");
                break;
            }
            b2 = data[i++] & 0xff;
            if (i == len) {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[((b1 & 0x03) << 4)
                        | ((b2 & 0xf0) >>> 4)]);
                sb.append(base64EncodeChars[(b2 & 0x0f) << 2]);
                sb.append("=");
                break;
            }
            b3 = data[i++] & 0xff;
            sb.append(base64EncodeChars[b1 >>> 2]);
            sb.append(base64EncodeChars[((b1 & 0x03) << 4)
                    | ((b2 & 0xf0) >>> 4)]);
            sb.append(base64EncodeChars[((b2 & 0x0f) << 2)
                    | ((b3 & 0xc0) >>> 6)]);
            sb.append(base64EncodeChars[b3 & 0x3f]);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {

//        String s = "logistics_interface=%3CwmsPurchaseOrderPushInfo%3E%0A++%3Cheader%3E%0A++++%3Cerp_order_num%3Exy_gys-PO4243706318%3C%2Ferp_order_num%3E%0A++++%3Creceipt_id%3Exy_gys-PO4243706318%3C%2Freceipt_id%3E%0A++++%3Cclose_date%3E2019-09-09+16%3A11%3A42+%3C%2Fclose_date%3E%0A++++%3CeoorWarehouserCode%3E010VB%3C%2FeoorWarehouserCode%3E%0A++++%3Cwarehouse%3E010VB%3C%2Fwarehouse%3E%0A++%3C%2Fheader%3E%0A++%3CdetailList%3E%0A++++%3Citem%3E%0A++++++%3Cid%3ESFTEST0012019-09-09T16%3A12%3A01.538%2B08%3A00%3C%2Fid%3E%0A++++++%3Cerp_order_line_num%3E0%3C%2Ferp_order_line_num%3E%0A++++++%3Csku_no%3ESFTEST001%3C%2Fsku_no%3E%0A++++++%3Cqty%3E1000%3C%2Fqty%3E%0A++++++%3Clot%3E%3C%2Flot%3E%0A++++++%3Cproductiondate%3E2019-09-01%3C%2Fproductiondate%3E%0A++++++%3Cexpirationdate%3E2019-11-30%3C%2Fexpirationdate%3E%0A++++++%3Cexpiration_date%3E2019-11-30+00%3A00%3A00%3C%2Fexpiration_date%3E%0A++++++%3Cinventory_sts%3E10%3C%2Finventory_sts%3E%0A++++%3C%2Fitem%3E%0A++%3C%2FdetailList%3E%0A%3C%2FwmsPurchaseOrderPushInfo%3E&data_digest=YjY5Mzg0ZDg2Nzg4MTliOWVlMGE0YmNhMWE0Mzk3Nzc%3D&warehouseCode=010VB";
//        String pwd = "OMS2TEST";
//
//        String sourceContent = getSourceContent(s, pwd);
//        System.out.println(sourceContent);

        System.out.println(null+"|"+null);

    }

}
