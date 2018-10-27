package cn.wuzongbo.tes.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**  

* <p>Title: CommonUtil</p>  

* <p>Description:ͨ�÷��� </p>  

* @author ���ڲ�  

* @date 2018��4��9��  

*/  
/**  

* <p>Title: CommonUtil</p>  

* <p>Description: ͨ�ù�����</p>  

* @author ���ڲ�  

* @date 2018��4��9��  

*/  

public class CommonUtil {
	//
	/**  
	
	 * <p>Title: existsList</p>  
	
	 * <p>Description:ava��ȡ���ͼ����в���ͬ��Ԫ�� </p>  
	
	 * @param objectListA
	 * @param objectListB
	 * @return  
	
	 */  
	public List<Object> existsList(List<Object> objectListA,List<Object> objectListB){
		List<Object> exists=new ArrayList<Object>(objectListB);
		
		exists.removeAll(objectListA);
		
		return objectListB;
		
	}
/**  
	
	 * <p>Title: existsList</p>  
	
	 * <p>Description:ava��ȡ���ͼ����в���ͬ��Ԫ�� </p>  
	
	 * @param objectListA
	 * @param objectListB
	 * @return  
	
	 */  
	public List<Object> noexistsList(List<Object> objectListA,List<Object> objectListB){
		
		List<Object>  exists=new ArrayList<Object>(objectListB);

		List<Object> noexists=new ArrayList<Object>(objectListB);
		noexists.removeAll(exists);
		
		return noexists;
		
		
		
	}
	
	  /** 
     * �ж��ַ����Ƿ�Ϊ�� 
     * @param str 
     * @return 
     */  
    public static boolean isEmpty(String str){  
        return (str == null || "".equals(str.trim()));  
    }  
      
    /** 
     * ��ȡ���ƺ�׺ 
     * @param name 
     * @return 
     */  
    public static String getExt(String name){  
        if(name == null || "".equals(name) || !name.contains("."))  
            return "";  
        return name.substring(name.lastIndexOf(".")+1);  
    }  
    /** 
     * ��ȡָ��λ��������� 
     * @param num 
     * @return 
     */  
    public static String getRandom(int num){  
        Random random = new Random();  
        StringBuilder sb = new StringBuilder();  
        for(int i = 0;i < num; i++){  
            sb.append(String.valueOf(random.nextInt(10)));  
        }  
        return sb.toString();  
    } 

    /**
 * ��ȡ���渽��·��,��/��/��
 */
private String getPath(){
	//��ȡ������
	Calendar a=Calendar.getInstance();
	String year = String.valueOf(a.get(Calendar.YEAR));
	String month = String.valueOf(a.get(Calendar.MONTH)+1);
	String day = String.valueOf(a.get(Calendar.DAY_OF_MONTH));
	StringBuilder backPath = new StringBuilder(128);
	backPath.append(year).append("/").append(month).append("/").append(day);
	return backPath.toString();
}

/**
 * getExtName:��ȡ�ļ���׺��. <br/>
 * @author lcma
 * @param s �ļ���������׺
 * @param split �ļ����ͺ�׺֮��ġ�.��
 * @return
 * @since JDK 1.7
 */
private String getExtName(String s, char split) {
    int i = s.lastIndexOf(split);
    int leg = s.length();
    return i > 0 ? (i + 1) == leg ? " " : s.substring(i+1, s.length()) : " ";
}

/**
 * getUUIDFileName:���ļ���ת����uuid��ʾ����ֹ�ļ����ϴ��ظ�. <br/>
 * @author lcma
 * @param fileName �ļ���
 * @return
 * @since JDK 1.6
 */
private String getUUIDFileName(String fileName){
	UUID uuid = UUID.randomUUID();
	StringBuilder sb = new StringBuilder(100);
	sb.append(uuid.toString()).append(".").append(this.getExtName(fileName, '.'));
	return sb.toString();
}




}
