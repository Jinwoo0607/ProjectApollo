package com.apollo.inbox.service;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apollo.inbox.dao.InboxDAO;
import com.apollo.vo.CommentDTO;


@Service
public class InboxService {
	@Autowired
	private SqlSession sqlsession;
	/**
	 * 
	 날      짜 : 2018. 6. 18.
	 기      능 : imcomming 데이터 가져오는 서비스
	 작성자명 : 신 호 용
	 */
	
	public ArrayList<CommentDTO> getCommentlist(String mid){
		System.out.println("service commemtlist");
		InboxDAO dao = sqlsession.getMapper(InboxDAO.class);
		ArrayList<CommentDTO> commemtlist = dao.getCommentlist(mid);
		return commemtlist;
	}
	/**
	 * 
	 날      짜 : 2018. 7. 3.
	 기      능 : sent 의경우 new 표시 안하게 하기위한 업데이트 서비스
	 작성자명 : 신 호 용
	 */
	public int updateNewCheckSent(String mid){
		InboxDAO dao = sqlsession.getMapper(InboxDAO.class);
		int result = dao.updateNewCheckSent(mid);
		return result;
	}
	
	/**
	 * 
	 날      짜 : 2018. 7. 3.
	 기      능 : newcheck하는 서비스
	 작성자명 : 신 호 용
	 */
	public int newCheck(Map map){
		InboxDAO dao = sqlsession.getMapper(InboxDAO.class);
		int result = dao.newCheck(map);
		return result;
	}
	/**
	 * 
	 날      짜 : 2018. 7. 4.
	 기      능 : newCount 읽음 으로 업데이트하는 서비스
	 작성자명 : 신 호 용
	 */
	public int updateNewCount(String mid){
		InboxDAO dao = sqlsession.getMapper(InboxDAO.class);
		int result = dao.updateNewCount(mid);
		return result;
	}
	/**
	 * 
	 날      짜 : 2018. 7. 4.
	 기      능 : 인박스 new카운트
	 작성자명 : 신 호 용
	 */
	public int newCount(String mid){
		System.out.println("newcount 서비스 mid" + mid);
		InboxDAO dao = sqlsession.getMapper(InboxDAO.class);
		int result = dao.newCount(mid);
		return result;
	}
	
	/**
	 * 
	 날      짜 : 2018. 6. 18.
	 기      능 : sent 데이터 가져오는 서비스
	 작성자명 : 신 호 용
	 */
	public ArrayList<CommentDTO> getSentlist(String mid){
		System.out.println("service sentlist");
		InboxDAO dao = sqlsession.getMapper(InboxDAO.class);
		ArrayList<CommentDTO> sentlist = dao.getSentlist(mid);
		return sentlist;
	}
	/**
	 * 
	 날      짜 : 2018. 6. 18.
	 기      능 : 아카이브 데이터 가져오는 서비스
	 작성자명 : 신 호 용
	 */
	public ArrayList<CommentDTO> getArchivelist(String mid){
		System.out.println("service archivelist");
		InboxDAO dao = sqlsession.getMapper(InboxDAO.class);
		ArrayList<CommentDTO> archivelist = dao.getArchivelist(mid);
		return archivelist;
	}
	/**
	 * 
	 날      짜 : 2018. 6. 18.
	 기      능 : 아카이브 업데이트 하는 서비스(해제)
	 작성자명 : 신 호 용
	 */
	public int updateArchive(CommentDTO comment) {
		System.out.println("service archiveupdate ");
		System.out.println(comment.getCmtid());
		System.out.println(comment.getMid());
		InboxDAO dao = sqlsession.getMapper(InboxDAO.class);
		int result = dao.updateArchive(comment);
		
		return result; 
	}
	/**
	 * 
	 날      짜 : 2018. 6. 18.
	 기      능 : 아카이브 업데이트 하는 서비스(저장)
	 작성자명 : 신 호 용
	 */
	public int updateArchive2(CommentDTO comment) {
		System.out.println("service archiveupdate ");
		System.out.println(comment.getCmtid());
		System.out.println(comment.getMid());
		InboxDAO dao = sqlsession.getMapper(InboxDAO.class);
		int result = dao.updateArchive2(comment);
		
		return result; 
	}
	/**
	 * 
	 날      짜 : 2018. 6. 19.
	 기      능 : stream 데이터 가져오는 서비스
	 작성자명 : 신 호 용
	 */
	
	
}
