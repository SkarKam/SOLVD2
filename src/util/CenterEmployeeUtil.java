package util;

import models.CenterEmployee;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CenterEmployeeUtil {
    private CenterEmployeeUtil() {}

    public static String getFullName(CenterEmployee centerEmployee){
        if(centerEmployee.getClass() == CenterEmployee.class) {
            return centerEmployee.getName() + ' ' + centerEmployee.getSurname();
        } else {
            throw  new RuntimeException("This is not a Center Employee");
        }
    }
    public static String parseDateOfEmployement(CenterEmployee centerEmployee){
        if(centerEmployee.getClass() == CenterEmployee.class) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dateFormat.format(centerEmployee.getDateOfEmployment());
        } else {
            throw new RuntimeException("This is not a Center Employee");
        }
    }
}
