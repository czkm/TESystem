package cn.wuzongbo.tes.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.junit.Before;
import org.junit.Test;

import cn.wuzongbo.tes.po.Classes;

public class TestList {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMinus() {
		Classes classes1=new Classes();
		classes1.setClassesName("admin1");
		classes1.setDepartId(2);
		classes1.setStatus((byte)1);
		
		Classes classes2=new Classes();
		classes2.setClassesName("admin2");
		classes2.setDepartId(1);
		classes2.setStatus((byte)1);
		Classes classes3=new Classes();
		classes3.setClassesName("admin3");
		classes3.setDepartId(3);
		classes3.setStatus((byte)1);
		
		
		Classes classes11=new Classes();
		classes11.setClassesName("admin1");
		classes11.setDepartId(2);
		classes11.setStatus((byte)1);
		
		Classes classes22=new Classes();
		classes22.setClassesName("admin2");
		classes22.setDepartId(1);
		classes22.setStatus((byte)1);
		Classes classes33=new Classes();
		classes33.setClassesName("admin3");
		classes33.setDepartId(3);
		classes33.setStatus((byte)1);
		Classes classes44=new Classes();
		classes44.setClassesName("admin4");
		classes44.setDepartId(4);
		classes44.setStatus((byte)1);
		System.out.println(classes1==classes2);
		System.out.println(classes1.equals(classes2));
	    List<Classes> listA=new ArrayList<Classes>();
	    listA.add(classes1);
	    listA.add(classes2);
	    listA.add(classes3);
	    List<Classes> listB=new ArrayList<Classes>();
	    listB.add(classes11);
	    listB.add(classes22);
	    listB.add(classes33);
	    listB.add(classes44);
	    List<Classes> ListC=new ArrayList<Classes>();
	    for(int i=0;i<listA.size();i++){
	    	Classes classesA=listA.get(i);
	    	for(int j=0;j<listB.size();j++){
	    		Classes classesB=listB.get(j);
	    		
	    		if(classesA.equals(classesB)){
	    			
	    			listB.remove(j);
	    	
	    			break;
	    		}
	    		
	    	}
	    }
	   
	   List<Classes>  subtract=  ListUtils.subtract(listB, listA);
	System.out.println(subtract.get(0).getClassesName());   
 	}
	@Test
	public void test(){
		
		List<Integer> listA=new ArrayList<Integer>();
		
		listA.add(1);
		listA.add(2);
		listA.add(3);
		listA.add(4);
		
		List<Integer> listB=new ArrayList<Integer>();
		
		listB.add(5);
		listB.add(6);
		listB.add(3);
		listB.add(4);
		
		List<Integer> listC=new ArrayList<Integer>();
		List<Integer> listD=new ArrayList<Integer>();
		List<Integer> liste=new ArrayList<Integer>();
		listC=ListUtils.intersection(listB, listA);
		
		listD=ListUtils.subtract(listA, listB);
		
		liste=ListUtils.subtract(listB, listA);
		
	}

}
