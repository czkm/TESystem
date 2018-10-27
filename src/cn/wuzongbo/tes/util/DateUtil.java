package cn.wuzongbo.tes.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * 
* <p>Title: DateUtil</p>  

* <p>Description:ʱ�䴦���� </p>  

* @author ���ڲ�  

* @date 2018��4��5��
 */
public class DateUtil {
	 // �����ڸ�ʽ
	 public static String DATE_FORMAT = "yyyy-MM-dd";
	 
	 // �����ڸ�ʽ
	 public static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	
	 /**
     * �жϵ�ǰʱ���Ƿ���[startTime, endTime]���䣬ע��ʱ���ʽҪһ��
     * 
     * @param nowTime ��ǰʱ��
     * @param startTime ��ʼʱ��
     * @param endTime ����ʱ��
     * @return
     * 
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }
    /* 
     * ��ʱ��ת��Ϊʱ���
     */    
    public static String dateToStamp(String s) throws ParseException{
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }
    /* 
     * ��ʱ���ת��Ϊʱ��
     */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
    public static String stampToDateMintues(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
    public static Date stringToDate(String s) throws ParseException{
    	
    	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	   Date date= sdf.parse(s);			
    	   return date;
    }
    
    public static String dateToString(Date time){
    	
    	//����Ҫ��ȡ��ʲô����ʱ��
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //��ȡString���͵�ʱ��
        String createdate = sdf.format(time);
        
        return createdate;
    	
    }
    
    /**
     * �����ڸ�ʽ���ַ���ת��Ϊ������
     * 
     * @param date
     * @param format
     * @return
     */
    public static long convert2long(String date, String format) {
     try {
      if (StringUtils.isNotBlank(date)) {
       if (StringUtils.isBlank(format))
        format = DateUtil.TIME_FORMAT;
       SimpleDateFormat sf = new SimpleDateFormat(format);
       return sf.parse(date).getTime();
      }
     } catch (ParseException e) {
      e.printStackTrace();
     }
     return 0l;
    }
    
    /**
     * ������������ת��Ϊ���ڸ�ʽ���ַ���
     * 
     * @param time
     * @param format
     * @return
     */
    public static String convert2String(long time, String format) {
     if (time > 0l) {
      if (StringUtils.isBlank(format))
       format = DateUtil.DATE_FORMAT;
      SimpleDateFormat sf = new SimpleDateFormat(format);
      Date date = new Date(time);
      return sf.format(date);
     }
     return "";
    }
    
    /**
     * ��ȡ��ǰϵͳ������
     * 
     * @return
     */
    public static long curTimeMillis() {
     return System.currentTimeMillis();
    }

}
