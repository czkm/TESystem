package cn.wuzongbo.tes.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {
	private static ObjectMapper mapper = new ObjectMapper();  
	  
    public static String bean2Json(Object obj) throws JsonProcessingException {  
        String json= mapper.writeValueAsString(obj);
        return json;  
    }  
  
    public static <T> T json2Bean(String jsonStr, Class<T> objClass)  
            throws JsonParseException, JsonMappingException, IOException {  
        return mapper.readValue(jsonStr, objClass);  
    }  

}
