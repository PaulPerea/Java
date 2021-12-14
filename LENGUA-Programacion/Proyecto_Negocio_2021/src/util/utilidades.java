package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.toedter.calendar.JDateChooser;

public class utilidades {

public static String FechaActual(){
	Date fecha= new Date();
	SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	return sdf.format(fecha);
}
public static String FechaActualCalendar(){
	Calendar calen= Calendar.getInstance();
	int d= calen.get(Calendar.DAY_OF_MONTH);
	int m=calen.get(Calendar.MONTH+1);
	int a=calen.get(Calendar.YEAR);
	
	String f=d+"/"+m+"/"+a;
	return f;
	
}
public String leerFecha(JDateChooser fec){
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	return sdf.format(fec.getDate());
}


}
