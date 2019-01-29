package com.ailot;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;

import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.regex.Pattern.compile;

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

       List<Flight> flights = Lists.newArrayList();
       flights.add(new Flight(100,"9C201","Y"));
       flights.add(new Flight(101,"9C201","C"));
       flights.add(new Flight(102,"9C201","F"));
       flights.add(new Flight(103,"9C201","S"));
       flights.add(new Flight(100,"9C201","Y"));
       flights.add(new Flight(100,"9C201","Y"));
       flights.add(new Flight(100,"9C201","Y"));
       flights.add(new Flight(100,"9C201","Y"));
       flights.forEach(item-> System.out.println(item.toString()));

       Map<String,Flight> flights1 = flights.stream().filter(item -> item.getNo()=="9C201").collect(Collectors.toMap(Flight::getCabinCode,Function.identity(), (item1,item2) -> item2));
        System.out.println("----------------------------------");
       flights1.forEach((key,value)-> System.out.println(key+":"+value.toString()));

       Map<Integer,Flight> flightMap = flights.stream().collect(Collectors.toMap(Flight::getPrice, a -> a,(k1,k2)->k1));
       flightMap.forEach((key,value) -> System.out.println(key+":"+value.toString()));
       System.out.println("----------------------------------------------");
       List<Flight> flightList = Lists.newArrayList();
       flights.stream().forEach(item -> {
           if (!flightList.contains(item)){
               flightList.add(item);
           }
       });
       flightList.forEach(System.out::println);

       }

    static class Flight{

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
