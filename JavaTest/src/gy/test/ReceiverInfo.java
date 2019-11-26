package gy.test;

import java.io.Serializable;

/**
 * @author ：BHT
 * @date ：2019-07-04 15:43
 * <p>
 * 收货信息
 */
public class ReceiverInfo implements Serializable {
    /**
     * 收货人
     */
    private String receiverName;
    /**
     * 手机
     */
    private String receiverMobile;
    /**
     * 固话
     */
    private String receiverPhone;
    /**
     * 邮编
     */
    private String receiverZip;
    /**
     * 收货地址
     */
    private String receiverAddress;
    /**
     * 省市区地址
     */
    private AddressInfo addressInfo;

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverZip() {
        return receiverZip;
    }

    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public AddressInfo getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(AddressInfo addressInfo) {
        this.addressInfo = addressInfo;
    }

    @Override
    public String toString() {
        return "ReceiverMessage{" +
                "receiverName='" + receiverName + '\'' +
                ", receiverMobile='" + receiverMobile + '\'' +
                ", receiverPhone='" + receiverPhone + '\'' +
                ", receiverZip='" + receiverZip + '\'' +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", addressInfo=" + addressInfo +
                '}';
    }
}
