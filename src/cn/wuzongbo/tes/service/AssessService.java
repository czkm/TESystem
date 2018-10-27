package cn.wuzongbo.tes.service;


import java.util.List;

import cn.wuzongbo.tes.po.Assess;
import cn.wuzongbo.tes.po.AssessExample;
import cn.wuzongbo.tes.po.QueryTeacherGetScoreVO;

public interface AssessService {
	
	public Assess findAssess(AssessExample assessExample) throws Exception;
	
	public int Insert(Assess assess) throws Exception;
	 //��ȡ����ѧ���ύ�Ľ�ʦ��������
    public  List<QueryTeacherGetScoreVO> getTeatcherScoreByDepart(int departId) throws Exception;
    //ͨ���û���Ų�ѯ�����ύ�ɼ�����ʦ���
    public List<Integer> getTeacherIdByUserId(Integer userId) throws Exception;
    //ͨ���û���Ż�ȡ��ʦ������Ϣ
    public List<Assess> selectAssessesByUserId(AssessExample assessExample) throws Exception;
    

}
