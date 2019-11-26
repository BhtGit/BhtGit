package gy.test;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Pattern;

/**
 * @author ：BHT
 * @date ：2019-07-04 20:14
 */
public class Test01 {

    public ReceiverInfo getReceiverInfo(String receiverMessage) {

        ReceiverInfo receiverInfo = new ReceiverInfo();
        receiverMessage = receiverMessage.replaceAll(",", " ");
        receiverMessage = receiverMessage.replaceAll("，", " ");
        // 匹配手机号码
        String receiverMobile = RegexUtils.getMatcher(RegexUtils.MOBILE_REGEX, receiverMessage);
        receiverInfo.setReceiverMobile(receiverMobile);
        if (StringUtils.isNotBlank(receiverMobile)) {
            receiverMessage = receiverMessage.replaceAll(Pattern.quote(receiverMobile), "");
        }
        // 匹配固定电话
        String receiverPhone = RegexUtils.getMatcher(RegexUtils.PHONE_REGEX, receiverMessage);
        receiverInfo.setReceiverPhone(receiverPhone);
        if (StringUtils.isNotBlank(receiverPhone)) {
            receiverMessage = receiverMessage.replaceAll(Pattern.quote(receiverPhone), "");
        }
        // 匹配邮政编码
        String receiverZip = RegexUtils.getMatcher(RegexUtils.ZIP_REGEX, receiverMessage);
        receiverInfo.setReceiverZip(receiverZip);
        if (StringUtils.isNotBlank(receiverZip)) {
            receiverMessage = receiverMessage.replaceAll(Pattern.quote(receiverZip), "");
        }
        receiverMessage = receiverMessage.trim().replaceAll(" +", " ");

        // 剩下姓名地址
        String[] msgs = receiverMessage.split(" ");

        AddressInfo addressInfo = getAddressInfo(receiverMessage);
        receiverInfo.setAddressInfo(addressInfo);
        String receiverName;
        String receiverAddress;
        if (msgs[0].contains(addressInfo.getProvinceName())) {
            // 如果省名字在第一位，则认为最后一位是姓名
            receiverName = msgs[msgs.length - 1];
            receiverAddress = receiverMessage.substring(0, receiverMessage.length() - receiverName.length());
        } else {
            // 如果省名字不在第一位，则认为第一位是姓名
            receiverName = msgs[0];
            receiverAddress = receiverMessage.substring(receiverName.length());
        }
        receiverInfo.setReceiverName(receiverName);
        receiverInfo.setReceiverAddress(receiverAddress.trim());

        return receiverInfo;
    }

    public AddressInfo getAddressInfo(String address){
        AddressInfo info = new AddressInfo();
        info.setProvinceName(null);
        return info;
    }

    public static void main(String[] args) {
        String aaa = "上海市 浦东新区 晨晖路88车金蝶软件园 18522314231，4422338 花小花，216000，";
        System.out.println(new Test01().getReceiverInfo(aaa));
    }


}
