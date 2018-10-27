/**
 * 
 */
package cn.wuzongbo.tes.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 *���1��־��28����4:42:50
 */
public class CompareToDateAndString {
		public static int compare_date(String date1,String date2){
			SimpleDateFormat sdf=new SimpleDateFormat("hh:mm");
			Date dt1=null;
			Date dt2=null;
			try {
				dt1 = sdf.parse(date1);
				dt2=sdf.parse(date2);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(dt1.getTime()<dt2.getTime()){
				System.out.println("dt1��dt2֮ǰ");
				return -1;
			}else if(dt1.getTime()>dt2.getTime()){
				System.out.println("dt1��dt2֮��");
			}
			return 0;
		}
		/**
		 * ����ת�����ַ���
		 * @param date
		 * @return
		 */
		public static String DateToStr(Date date){
			SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
			String str=sdf.format(date);
			return str;
		}
		/**
		 * �ַ���ת��������
		 * @param str
		 * @return
		 */
		public static Date StrToDate(String str){
			Date date = null;
			SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
			try {
				date=sdf.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date;
		}
		/**
		 * ��ȡ�������ͷ���
		 * @param o
		 * @return
		 */
		public static String getType(Object o){ //��ȡ�������ͷ���
			return o.getClass().toString(); //ʹ��int���͵�getClass()����
			}

}
