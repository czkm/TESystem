package cn.wuzongbo.tes.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		// TODO Auto-generated method stub
		
		//将日期字符串转换成日期类型
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		if(source!=null&&source!=null){
			
			try {
				
				Date date=sdf.parse(source);
				return date;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return null;
	}

	
}
