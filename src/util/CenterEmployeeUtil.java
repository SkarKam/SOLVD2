package util;

import models.CenterEmployee;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CenterEmployeeUtil {
    private CenterEmployeeUtil() {}

    public static String getFullName(CenterEmployee centerEmployee){
        {
            return centerEmployee.getName() + ' ' + centerEmployee.getSurname();
        }
    }
    public static String parseDateOfEmployement(CenterEmployee centerEmployee){

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dateFormat.format(centerEmployee.getDateOfEmployment());
    }
}
