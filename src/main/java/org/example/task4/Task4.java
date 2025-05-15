package org.example.task4;

import java.util.List;

public class Task4 {
    public static void Main() {
        var reader = new SmartTextReader();
        reader.open("userdata/shared_data.txt");
        var data = reader.read();
        reader.close();
        printdata(data);

        var logger_reader = new SmartTextChecker(new SmartTextReader());
        logger_reader.open("userdata/shared_data.txt");
        var logger_data = logger_reader.read();
        logger_reader.close();
        printdata(logger_data);

        var security_reader = new SmartTextChecker(new SmartTextSecurity(new SmartTextReader()));
        security_reader.open("system/passwords.txt");
        var security_data = security_reader.read();
        security_reader.close();
        printdata(security_data);
    }
    static void printdata(List<List<Character>> data) {
        data.forEach(data2-> {
            data2.forEach(System.out::print);
            System.out.println();
        });
    }
}
