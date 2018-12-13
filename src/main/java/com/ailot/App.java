package com.ailot;

import org.joda.time.LocalDate;

import java.text.ParseException;
import java.util.Date;

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

       /* Date today = new LocalDate().toDate();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dateFormat.parse("2018-10-27");
        Date date2 = dateFormat.parse("2018-10-29");
        if (today.compareTo(date1) < 0 || today.compareTo(date2) > 0){
            System.out.println(today.compareTo(date1));
            System.out.println(today.compareTo(date2));
        }*/

       /*String str = "UO314:PB20;JQ442:BG20;IT450:BG20;TZ357:BG20;XW407:BX20;AK480:PBAB,PBPB";
        Map<String, String> baggageClassCodeMap = Splitter.on(";").trimResults().withKeyValueSeparator(":").split(str);
        System.out.println(baggageClassCodeMap);*/

        Date date = new LocalDate().plusDays(2).toDate();
        System.out.println(new Date().before(date));
        System.out.println();

    }
}
