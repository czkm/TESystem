package cn.wuzongbo.tes.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**  

* <p>Title: CommonUtil</p>  

* <p>Description:通用方法 </p>  

* @author 吴宗波  

* @date 2018年4月9日  

*/  
/**  

* <p>Title: CommonUtil</p>  

* <p>Description: 通用工具类</p>  

* @author 吴宗波  

* @date 2018年4月9日  

*/  

public class CommonUtil {
	//
	/**  
	
	 * <p>Title: existsList</p>  
	
	 * <p>Description:ava获取泛型集合中不相同的元素 </p>  
	
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
	
	 * <p>Description:ava获取泛型集合中不相同的元素 </p>  
	
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
     * 判断字符串是否为空 
     * @param str 
     * @return 
     */  
    public static boolean isEmpty(String str){  
        return (str == null || "".equals(str.trim()));  
    }  
      
    /** 
     * 获取名称后缀 
     * @param name 
     * @return 
     */  
    public static String getExt(String name){  
        if(name == null || "".equals(name) || !name.contains("."))  
            return "";  
        return name.substring(name.lastIndexOf(".")+1);  
    }  
    /** 
     * 获取指定位数的随机数 
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
 * 获取保存附件路径,年/月/日
 */
private String getPath(){
	//获取年月日
	Calendar a=Calendar.getInstance();
	String year = String.valueOf(a.get(Calendar.YEAR));
	String month = String.valueOf(a.get(Calendar.MONTH)+1);
	String day = String.valueOf(a.get(Calendar.DAY_OF_MONTH));
	StringBuilder backPath = new StringBuilder(128);
	backPath.append(year).append("/").append(month).append("/").append(day);
	return backPath.toString();
}

/**
 * getExtName:获取文件后缀名. <br/>
 * @author lcma
 * @param s 文件名包括后缀
 * @param split 文件名和后缀之间的‘.’
 * @return
 * @since JDK 1.7
 */
private String getExtName(String s, char split) {
    int i = s.lastIndexOf(split);
    int leg = s.length();
    return i > 0 ? (i + 1) == leg ? " " : s.substring(i+1, s.length()) : " ";
}

/**
 * getUUIDFileName:把文件名转换成uuid表示，防止文件名上传重复. <br/>
 * @author lcma
 * @param fileName 文件名
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
