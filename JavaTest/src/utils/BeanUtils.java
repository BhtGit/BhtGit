package utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * http://www.ofmonkey.com/entity/xml
 * xml生成实体类
 *
 * @author ：BHT
 * @date ：2019-09-09 16:07
 */
public class BeanUtils {

    /**
     * 实体类的无参数的get方法转换为xml
     * 除去getClass
     *
     * @param beans  beans
     * @param header 包裹数据的外层参数
     * @param flag   如果值为空，是否传该参数 true传
     * @return xml
     */
    public static String castGetMethodToXml(List beans, String header, boolean flag) throws InvocationTargetException, IllegalAccessException {
        if (CollectionUtils.isEmpty(beans)) {
            return "";
        }
        StringBuilder xml = new StringBuilder();
        xml.append("<");
        xml.append(header);
        xml.append(">");
        for (Object bean : beans) {
            xml.append(castGetMethodToXml(bean, flag));
        }
        xml.append("</");
        xml.append(header);
        xml.append(">");
        return xml.toString();
    }

    /**
     * 实体类的无参数的get方法转换为xml
     * 除去getClass
     *
     * @param bean bean
     * @param flag 如果值为空，是否传该参数 true传
     * @return xml
     */
    public static String castGetMethodToXml(Object bean, boolean flag) throws InvocationTargetException, IllegalAccessException {
        if (bean == null) {
            return "";
        }
        String className = bean.getClass().getSimpleName();
        // 首字母切换为小写
        className = className.substring(0, 1).toLowerCase() + className.substring(1);
        Method[] methods = bean.getClass().getMethods();
        Map<String, Method> getMethods = new HashMap<>();
        for (Method method : methods) {
            String name = method.getName();
            if (StringUtils.equals(name, "getClass")) {
                continue;
            }
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (name.indexOf("get") == 0 && parameterTypes.length == 0 && name.length() > 3) {
                getMethods.put(name, method);
            }
        }
        StringBuilder xml = new StringBuilder();
        xml.append("<");
        xml.append(className);
        xml.append(">");
        Set<Map.Entry<String, Method>> entries = getMethods.entrySet();
        for (Map.Entry<String, Method> entity : entries) {
            // 除去开头的get
            String key = entity.getKey().substring(3);
            // 首字母切换为小写
            String substring = key.substring(0, 1);
            String s = substring.toLowerCase();
            key = s + key.substring(1);
            Object value = entity.getValue().invoke(bean);
            // 如果没有值则不传该参数
            if (value == null) {
                value = "";
            }
            if (!flag && StringUtils.isBlank(value.toString())) {
                continue;
            }
            xml.append("<");
            xml.append(key);
            xml.append(">");
            xml.append(value.toString());
            xml.append("</");
            xml.append(key);
            xml.append(">");
        }
        xml.append("</");
        xml.append(className);
        xml.append(">");
        return xml.toString();
    }

    public static void main(String[] args) {
        List<A> list = new ArrayList<>();
        A a = new BeanUtils().new A();
        a.setActual_amount(123);
        a.setShip_from_address("321");
        list.add(a);
        list.add(a);

        String hhhh = null;
        try {
            hhhh = castGetMethodToXml(list, "hhhh", false);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(hhhh);
    }

    class A {
        private String payment_of_charge = "";
        private String payment_district = "";
        private String monthly_account = "";
        private String freight = "0";
        /**
         * 校验字段
         */
        private String checkword = "";
        /**
         * 货主
         */
        private String company = "";
        /**
         * 仓库
         */
        private String warehouse = "";
        /**
         * 订单号码
         */
        private String erp_order = "";
        /**
         * 订单类型  销售订单  换货订单
         */
        private String order_type = "销售订单";
        /**
         * 下单日期
         */
        private String order_date = "";
        /**
         * 收件公司
         */
        private String ship_to_name = "";
        /**
         * 收件人
         */
        private String ship_to_attention_to = "";
        /**
         * 收件人所在
         * 国家
         */
        private String ship_to_country = "";
        /**
         * 收件人所在
         * 省
         */
        private String ship_to_province = "";
        /**
         * 收件人所在
         * 市
         */
        private String ship_to_city = "";
        /**
         * 收件人所在
         * 区/县
         */
        private String ship_to_area = "";
        /**
         * 收件人详细
         * 地址
         */
        private String ship_to_address = "";
        /**
         * 收件人详细
         * 地址邮编
         */
        private String ship_to_postal_code = "";
        /**
         * 手机号
         */
        private String ship_to_phone_num = "";
        /**
         * 电话号码 家固
         */
        private String ship_to_tel_num = "";
        /**
         *
         */
        private List SaleOrderDetail;
        /**
         * 商铺名称
         */
        private String shopName = "";
        /**
         * 货到付款
         */
        private String cod = "";
        /**
         * 如果是货到付款，代付金额
         */
        private String amount = "";
        private String carrier = "";
        private String carrier_service = "";
        /**
         * 寄件公司
         */
        private String ship_from_name = "";
        /**
         * 寄件人
         */
        private String ship_from_attention_to = "";
        /**
         * 寄件国家或地区
         */
        private String ship_from_country = "";
        /**
         * 寄件省
         */
        private String ship_from_province = "";
        /**
         * 寄件市
         */
        private String ship_from_city = "";
        /**
         * 寄件区/县
         */
        private String ship_from_area = "";
        /**
         * 寄件地址
         */
        private String ship_from_address = "";
        /**
         * 寄件邮编
         */
        private String ship_from_postal_code = "";
        /**
         * 寄件手机
         */
        private String ship_from_phone_num = "";
        /**
         * 寄件固定电话
         */
        private String ship_from_tel_num = "";
        /**
         * 商家备注
         */
        private String company_note = "";
        /**
         * 预留字段6（传平台单号给到顺丰外仓 通过附加字段6来传输）
         */
        private String user_def6 = "";

        /**
         * 发票抬头
         */
        private String invoice_title = "";
        /**
         * 订单金额
         */
        private double order_total_amount;
        /**
         * 让利金额
         */
        private double order_discount;
        /**
         * 实际单价
         */
        private double item_price;

        /**
         * 是否需要开发票
         */
        private String invoice;

        /**
         * 发票类型
         */
        private String invoice_type = "";

        /**
         * 发票内容
         */
        private String invoice_content = "";

        /**
         * 路线编号
         */
        private String routeNumbers;

        /**
         * 是否保价
         */
        private String value_insured;
        /**
         * 保价金额
         */
        private double declared_value;

        /**
         * 附件信息
         * 1.card_title 标题
         * 2.card_content 内容
         * 3.card_tail 结尾
         */
        private String card_title = "";

        private String card_content = "";

        private String card_tail = "";

        /**
         * 贺卡定制判断
         */
        private String need_card;

        /**
         * 寄件方标识 Y or N
         * N.客户在顺丰外仓默认设置的寄件仓库地址，一般只有一个；
         * Y.上游ERP传过来的寄件人地址；
         */
        private String from_flag;

        public String getFrom_flag() {
            return from_flag;
        }

        public void setFrom_flag(String from_flag) {
            this.from_flag = from_flag;
        }

        public String getNeed_card() {
            return need_card;
        }

        public void setNeed_card(String need_card) {
            this.need_card = need_card;
        }

        public String getCard_title() {
            return card_title;
        }

        public void setCard_title(String card_title) {
            this.card_title = card_title;
        }

        public String getCard_content() {
            return card_content;
        }

        public void setCard_content(String card_content) {
            this.card_content = card_content;
        }

        public String getCard_tail() {
            return card_tail;
        }

        public void setCard_tail(String card_tail) {
            this.card_tail = card_tail;
        }

        public String getValue_insured() {
            return value_insured;
        }

        public void setValue_insured(String value_insured) {
            this.value_insured = value_insured;
        }

        public double getDeclared_value() {
            return declared_value;
        }

        public void setDeclared_value(double declared_value) {
            this.declared_value = declared_value;
        }

        public String getRouteNumbers() {
            return routeNumbers;
        }

        public void setRouteNumbers(String routeNumbers) {
            this.routeNumbers = routeNumbers;
        }

        public String getPayment_of_charge() {
            return payment_of_charge;
        }

        public void setPayment_of_charge(String payment_of_charge) {
            this.payment_of_charge = payment_of_charge;
        }

        public String getMonthly_account() {
            return monthly_account;
        }

        public void setMonthly_account(String monthly_account) {
            this.monthly_account = monthly_account;
        }

        public String getFreight() {
            return freight;
        }

        public void setFreight(String freight) {
            this.freight = freight;
        }

        public String getPayment_district() {
            return payment_district;
        }

        public void setPayment_district(String payment_district) {
            this.payment_district = payment_district;
        }

        /**
         * 实际支付金额
         */
        private double actual_amount;


        public String getCarrier() {
            return carrier;
        }

        public void setCarrier(String carrier) {
            this.carrier = carrier;
        }

        public String getCarrier_service() {
            return carrier_service;
        }

        public void setCarrier_service(String carrier_service) {
            this.carrier_service = carrier_service;
        }

        public String getCod() {
            return cod;
        }

        public void setCod(String cod) {
            this.cod = cod;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getShip_to_tel_num() {
            return ship_to_tel_num;
        }

        public void setShip_to_tel_num(String ship_to_tel_num) {
            this.ship_to_tel_num = ship_to_tel_num;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getCheckword() {
            return checkword;
        }

        public void setCheckword(String checkword) {
            this.checkword = checkword;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getWarehouse() {
            return warehouse;
        }

        public void setWarehouse(String warehouse) {
            this.warehouse = warehouse;
        }

        public String getErp_order() {
            return erp_order;
        }

        public void setErp_order(String erp_order) {
            this.erp_order = erp_order;
        }

        public String getOrder_type() {
            return order_type;
        }

        public void setOrder_type(String order_type) {
            this.order_type = order_type;
        }

        public String getOrder_date() {
            return order_date;
        }

        public void setOrder_date(String order_date) {
            this.order_date = order_date;
        }

        public String getShip_to_name() {
            return ship_to_name;
        }

        public void setShip_to_name(String ship_to_name) {
            this.ship_to_name = ship_to_name;
        }

        public String getShip_to_attention_to() {
            return ship_to_attention_to;
        }

        public void setShip_to_attention_to(String ship_to_attention_to) {
            this.ship_to_attention_to = ship_to_attention_to;
        }

        public String getShip_to_country() {
            return ship_to_country;
        }

        public void setShip_to_country(String ship_to_country) {
            this.ship_to_country = ship_to_country;
        }

        public String getShip_to_province() {
            return ship_to_province;
        }

        public void setShip_to_province(String ship_to_province) {
            this.ship_to_province = ship_to_province;
        }

        public String getShip_to_city() {
            return ship_to_city;
        }

        public void setShip_to_city(String ship_to_city) {
            this.ship_to_city = ship_to_city;
        }

        public String getShip_to_area() {
            return ship_to_area;
        }

        public void setShip_to_area(String ship_to_area) {
            this.ship_to_area = ship_to_area;
        }

        public String getShip_to_address() {
            return ship_to_address;
        }

        public void setShip_to_address(String ship_to_address) {
            this.ship_to_address = ship_to_address;
        }

        public String getShip_to_postal_code() {
            return ship_to_postal_code;
        }

        public void setShip_to_postal_code(String ship_to_postal_code) {
            this.ship_to_postal_code = ship_to_postal_code;
        }

        public String getShip_to_phone_num() {
            return ship_to_phone_num;
        }

        public void setShip_to_phone_num(String ship_to_phone_num) {
            this.ship_to_phone_num = ship_to_phone_num;
        }

        public List getSaleOrderDetail() {
            return SaleOrderDetail;
        }

        public void setSaleOrderDetail(List saleOrderDetail) {
            SaleOrderDetail = saleOrderDetail;
        }

        public String getShip_from_name() {
            return ship_from_name;
        }

        public void setShip_from_name(String ship_from_name) {
            this.ship_from_name = ship_from_name;
        }

        public String getShip_from_attention_to() {
            return ship_from_attention_to;
        }

        public void setShip_from_attention_to(String ship_from_attention_to) {
            this.ship_from_attention_to = ship_from_attention_to;
        }

        public String getShip_from_country() {
            return ship_from_country;
        }

        public void setShip_from_country(String ship_from_country) {
            this.ship_from_country = ship_from_country;
        }

        public String getShip_from_province() {
            return ship_from_province;
        }

        public void setShip_from_province(String ship_from_province) {
            this.ship_from_province = ship_from_province;
        }

        public String getShip_from_city() {
            return ship_from_city;
        }

        public void setShip_from_city(String ship_from_city) {
            this.ship_from_city = ship_from_city;
        }

        public String getShip_from_area() {
            return ship_from_area;
        }

        public void setShip_from_area(String ship_from_area) {
            this.ship_from_area = ship_from_area;
        }

        public String getShip_from_address() {
            return ship_from_address;
        }

        public void setShip_from_address(String ship_from_address) {
            this.ship_from_address = ship_from_address;
        }

        public String getShip_from_postal_code() {
            return ship_from_postal_code;
        }

        public void setShip_from_postal_code(String ship_from_postal_code) {
            this.ship_from_postal_code = ship_from_postal_code;
        }

        public String getShip_from_phone_num() {
            return ship_from_phone_num;
        }

        public void setShip_from_phone_num(String ship_from_phone_num) {
            this.ship_from_phone_num = ship_from_phone_num;
        }

        public String getShip_from_tel_num() {
            return ship_from_tel_num;
        }

        public void setShip_from_tel_num(String ship_from_tel_num) {
            this.ship_from_tel_num = ship_from_tel_num;
        }

        public String getCompany_note() {
            return company_note;
        }

        public void setCompany_note(String company_note) {
            this.company_note = company_note;
        }

        public String getInvoice_title() {
            return invoice_title;
        }

        public void setInvoice_title(String invoice_title) {
            this.invoice_title = invoice_title;
        }

        public double getOrder_total_amount() {
            return order_total_amount;
        }

        public void setOrder_total_amount(double order_total_amount) {
            this.order_total_amount = order_total_amount;
        }

        public double getOrder_discount() {
            return order_discount;
        }

        public void setOrder_discount(double order_discount) {
            this.order_discount = order_discount;
        }

        public double getItem_price() {
            return item_price;
        }

        public void setItem_price(double item_price) {
            this.item_price = item_price;
        }

        public String getInvoice() {
            return invoice;
        }

        public void setInvoice(String invoice) {
            this.invoice = invoice;
        }

        public String getInvoice_type() {
            return invoice_type;
        }

        public void setInvoice_type(String invoice_type) {
            this.invoice_type = invoice_type;
        }

        public String getInvoice_content() {
            return invoice_content;
        }

        public void setInvoice_content(String invoice_content) {
            this.invoice_content = invoice_content;
        }

        public double getActual_amount() {
            return actual_amount;
        }

        public void setActual_amount(double actual_amount) {
            this.actual_amount = actual_amount;
        }

        public String getUser_def6() {
            return user_def6;
        }

        public void setUser_def6(String user_def6) {
            this.user_def6 = user_def6;
        }
    }
}
