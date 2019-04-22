package com.ailot;

import com.google.common.collect.Lists;

import java.text.ParseException;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws ParseException {

       /*List<String> list1 = new ArrayList<>();
       list1.add("1");
       list1.add("2");
        System.out.println(list1.getClass().getSuperclass());


        List<String> list2 = new ArrayList<String>(){
            {
                add("1");
                add("2");
            }
        };
        System.out.println(list2.getClass().getSuperclass());*/

        /*Date today = new LocalDate().toDate();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = dateFormat.parse("2018-12-27 15:10:00");
        Date date2 = dateFormat.parse("2018-12-27 18:00:00");
        if (today.compareTo(date1) < 0 || today.compareTo(date2) > 0){
            System.out.println(today.compareTo(date1));
            System.out.println(today.compareTo(date2));
        }
        System.out.println((date2.getTime() - date1.getTime())/1000/60);*/

      /* String str = "UO314:PB20;JQ442:BG20;IT450:BG20;TZ357:BG20;XW407:BX20;AK480:PBAB,PBPB";
       String currencyAccounts = "CNY:APICNTCHCN;MYR:APICNTCHMY;THB:APICNTCHTH;HKD:APICNTCHMY;PHP:APICNTCHPH;";
       String flight = "MU5683/MU2585|MU123/MU234";*/
        /*Map<String, String> baggageClassCodeMap = Splitter.on(";").trimResults().withKeyValueSeparator(":").split(str);
        Map<String, String> currencyAccountsList = Splitter.on(";").omitEmptyStrings().trimResults().withKeyValueSeparator(":").split(currencyAccounts);

        System.out.println(baggageClassCodeMap);
        System.out.println(currencyAccountsList);

        Date date = new LocalDate().plusDays(2).toDate();
        System.out.println(new Date().before(date));*/
        /* System.out.println(Arrays.toString(flight.split("\\|")));*/
        /*String code = "EU2206";
        System.out.println(StringUtils.substring(code,0,2));*/
       /* Map<String, String> customTimeMap = Splitter.on(";").omitEmptyStrings().trimResults().withKeyValueSeparator(":").split(null);
        System.out.println(customTimeMap);*/
       /*String phone = "12356478";
       System.out.println(matchPhone(phone));*/

        //        Map<String,Integer> map=new HashMap<>();
//        map.put("A", 1000);
//        map.put("B", 2000);
//        map.put("C", 3000);
//
//        // add new key value ("A",99), if key "A" exist in map then do function  "(X,Y) -> (Y+X)" ,the function return value will replace the oldvalue.
//        Integer newValue1 = map.merge("A", 99, (X,Y) -> (Y+X));
//        Integer newValue2 = map.merge("A", 888, (X,Y) -> Y);
//        // add new key value ("D",666), if key "D" not exist in map then insert the key value to map
//        Integer newValue3 = map.merge("D", 666, (X,Y) -> Y);
//        Integer newValue4 = map.merge(null, 777, (X,Y) -> Y);
//        Integer newValue5 = map.merge(null, 5555, (X,Y) -> Y);
//        System.out.println(newValue1);
//        System.out.println(newValue2);
//
//        Float a = 0.47F;
//        Float b = 0F;
//
//        System.out.println(a.compareTo(b));


        List<Flight> flights = Lists.newArrayList();
        flights.add(new Flight(100, "9C201", "Y"));
        flights.add(new Flight(101, "9C201", "C"));
        flights.add(new Flight(102, "9C201", "F"));
        flights.add(new Flight(103, "9C201", "S"));
        flights.add(new Flight(104, "9C201", "Y"));
        flights.add(new Flight(105, "9C201", "Y"));
        flights.add(new Flight(106, "9C201", "Y"));
        flights.add(new Flight(107, "9C201", "Y"));
        //flights.forEach(item -> System.out.println(item.toString()));

//        List list = flights.stream().filter(item -> item.getPrice()==100).collect(Collectors.toList());
//        list.forEach(System.out::println);
//        String air = "DD,dd,SL";
//        System.out.println(air.indexOf("dd".toUpperCase()));
//        Map<String, Flight> flights1 = flights.stream().filter(item -> item.getNo() == "9C201").collect(Collectors.toMap(Flight::getCabinCode, Function.identity(), (item1, item2) -> item2));
//        System.out.println("----------------------------------");
//        flights1.forEach((key, value) -> System.out.println(key + ":" + value.toString()));
//
//        Map<Integer, Flight> flightMap = flights.stream().collect(Collectors.toMap(Flight::getPrice, a -> a, (k1, k2) -> k1));
//        flightMap.forEach((key, value) -> System.out.println(key + ":" + value.toString()));
//        System.out.println("----------------------------------------------");
//        List<Flight> flightList = Lists.newArrayList();
//        flights.stream().forEach(item -> {
//            if (!flightList.contains(item)) {
//                flightList.add(item);
//            }
//        });
//        flightList.forEach(System.out::println);

//        String codes = "9C14460025:AIRSALESWS-EXCEP-110;AQ49103552:FS_ERR_006|FS_ERR_005;G576345251:OPEN;CA76344875:XXX;EU76345273:XXX;";
//        String strs = "TB05:100,110;TB10:200,360;TB15:375,610;TB20:550,885;TB25:725,;";
//        String error = String.join("|", Arrays.stream(codes.split(";")).collect(Collectors.groupingBy(codesStr ->
//                codesStr.split(":")[0])).get("AQ49103552").stream().map(str -> str.split(":")[1]).collect(Collectors.toList()));
//        Map<String,String> errors = Splitter.on(";").omitEmptyStrings().trimResults().withKeyValueSeparator(":").split(strs);
//        System.out.println(new Gson().toJson(errors));

//        List<String> stopList = Lists.newArrayList();
//        String preStop = "HKG,CTU";
//        if (StringUtils.isNotBlank(preStop)){
//            stopList.addAll(Arrays.asList(preStop.split(",")));
//        }
//        String postStop = "CAN,";
//        if (StringUtils.isNotBlank(postStop)){
//            stopList.addAll(Arrays.asList(postStop.split(",")));
//        }
//        System.out.println(String.join(",",stopList));
//        stopList.forEach(System.out::println);
//        String s = "1234567";
//        StringBuffer sb = new StringBuffer();
//        char[] c = s.toCharArray();
//        for (char c1 : c) {
//            sb.append(String.valueOf(c1)).append(",");
//        }
//        System.out.println(sb.substring(0,sb.length()-1));
        System.out.println(9 / 7);
    }

    static class Flight {

        int price;

        String no;

        String cabinCode;

        String depDate;

        String arrDate;

        public Flight(int price, String no, String cabinCode) {
            this.price = price;
            this.no = no;
            this.cabinCode = cabinCode;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getCabinCode() {
            return cabinCode;
        }

        public void setCabinCode(String cabinCode) {
            this.cabinCode = cabinCode;
        }

        public String getDepDate() {
            return depDate;
        }

        public void setDepDate(String depDate) {
            this.depDate = depDate;
        }

        public String getArrDate() {
            return arrDate;
        }

        public void setArrDate(String arrDate) {
            this.arrDate = arrDate;
        }

        @Override
        public String toString() {
            return "Flight{" +
                    "price=" + price +
                    ", no='" + no + '\'' +
                    ", cabinCode='" + cabinCode + '\'' +
                    ", depDate='" + depDate + '\'' +
                    ", arrDate='" + arrDate + '\'' +
                    '}';
        }
    }
}
