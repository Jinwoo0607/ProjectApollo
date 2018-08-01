package com.apollo.step.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.apollo.vo.AssigneeDTO;
import com.apollo.vo.MemberDTO;
import com.apollo.vo.StepDTO;
import com.apollo.vo.StepListMemberDTO;
import com.apollo.vo.StepListStepDTO;
import com.apollo.vo.StepListTaskDTO;
import com.apollo.vo.TaskDTO;
import com.apollo.vo.TaskInStepDTO;
import com.apollo.vo.TstatusDTO;

public interface StepDAO {
	
	/*
	 날      짜 : 2018. 6. 12.
	 기      능 : 프로젝트 생성
	 작성자명 : 김 정 권
	 */
	public ArrayList<StepDTO> getSteps(int pid);
	
	/**
	 * 
	 날      짜 : 2018. 6. 14.
	 기      능 :스텝아이디로 프로젝트 아이디 가져오기 >> session관리를 위해 
	 작성자명 : 박 민 식
	 */
	
	
	public int getProjectIdByStepId(int sid);
	/*
	 날      짜 : 2018. 6. 14.
	 기      능 : pid, fid 받아와서 Step 생성
	 작성자명 : 김 래 영
	 */
	public int insertStep(StepDTO stepdto);
	
	/**
	 * 
	 날      짜 : 2018. 6. 15.
	 기      능 : sid 받아서 해당 step에 들어있는 task 상태 목록을 board에 가져옴
	 작성자명 : 이 창 훈
	 */
	public ArrayList<TstatusDTO> selectTstatusBySid(int sid);

	
	

	/**
	 * 
	 날      짜 : 2018. 6. 19.
	 기      능 : 참여중인 모든 프로젝트에 속한 스텝 리스트 가져오기
	 작성자명 : 박 민 식
	 */
	public ArrayList<StepDTO> selectStepList(List<Integer> pids);

	/**
	 * 
	 날      짜 : 2018. 6. 19.
	 기      능 : tid 이용해서 sid 목록 가져오기
	 작성자명 : 김 정 권
	 */
	public ArrayList<StepDTO> getStepsid(String tid);
	
	/**
	 *
	 날      짜 : 2018. 6. 21.
	 기      능 : sid 로 step 정보 가져오기
	 작성자명 : 김 래 영
	 */
	public StepDTO selectStep(int sid);
	 
	/* 
	 날      짜 : 2018. 6. 21.
	 기      능 : 스텝 위치 이동
	 작성자명 : 박 민 식
	 */
	public int moveStep(StepDTO stepdto);
	
	public ArrayList<StepDTO> getStepsid(int tid);

	/**
	 * 
	 날      짜 : 2018. 6. 21.
	 기      능 : step 수정
	 작성자명 : 김 래 영
	 */
	public int updateStep(StepDTO stepdto);
	
	
	/**
	 * 
	 날      짜 : 2018. 6. 21.
	 기      능 : sid 로 step 삭제 (후행)
	 작성자명 : 김 래 영
	 */
	public int deleteStep(int sid);
	
	/**
	 * 
	 날      짜 : 2018. 6. 22.
	 기      능 : pid로 step 가져오기
	 작성자명 : 김 래 영
	 */
	public ArrayList<StepDTO> getStepInProject(int pid);

	/**
	 날      짜 : 2018. 6. 24.
	 기      능 : sid로 Tstatus list 가지고옴
	 작성자명 : 이 진 우
	 */
	public ArrayList<TstatusDTO> getListTstatus(int sid);
	
	/**
	 * 
	 날      짜 : 2018. 6. 24.
	 기      능 : List페이지에 Step의 이름을 가지고 오기 위한 함수
	 작성자명 : 이 진 우
	 */
	public StepDTO getListStepName(int sid);
	/**
	 * 
	 날      짜 : 2018. 6. 24.
	 기      능 : List페이지에 Task를 뿌려주기위한 Task리스트 
	 작성자명 : 이 진 우
	 */
	public ArrayList<StepListTaskDTO> getStepListTask(HashMap<String, String> map);
	/**
	 * 
	 날      짜 : 2018. 6. 24.
	 기      능 : List 페이지의 Task에 뿌려줄 Step을 위한 Step 리스트 
	 작성자명 : 이 진 우
	 */
	public ArrayList<StepListStepDTO> getStepListStep(HashMap<String, String> map);
	/**
	 * 
	 날      짜 : 2018. 6. 24.
	 기      능 : List페이지의 Task에 뿌려줄 Member을 위한 Member리스트
	 작성자명 : 이 진 우
	 */
	public ArrayList<StepListMemberDTO> getStepListMember(HashMap<String, String> map);

	/**
	 * 
	 날      짜 : 2018. 6. 24.
	 기      능 : 해당 테스크가 속한 스텝들을 가져온다 
	 작성자명 : 김 정 권
	 */
	public ArrayList<StepDTO> getStepNamesbytid(int tid);
	
	/**
	 * 
	 날      짜 : 2018. 6. 24.
	 기      능 : 해당 테스크와 같은 프로젝트에 있지만 아직 속하지 않은 스텝들을 가져온다
	 작성자명 : 김 정 권
	 */
	public ArrayList<StepDTO> getStepListByTid(int tid);
	
	/**
	 * 
	 날      짜 : 2018. 6. 25.
	 기      능 : 스텝 검색결과를 가져온다 
	 작성자명 : 박 민 식
	 */
	public ArrayList<StepDTO> getSearchSteps(HashMap<String, String> map);
	/**
	 * 
	 날      짜 : 2018. 6. 28.
	 기      능 :  LIST PAGE 우측 상단의 TASK 완료/미완료 
	 작성자명 : 이 진 우
	 */
	public int listCountCompletedTask(int sid);
	public int listCountUnfinishedTask(int sid);
	/**
	 * 
	 날      짜 : 2018. 6. 28.
	 기      능 : LIST PAGE 우측 중간의 STEP 기한 
	 작성자명 : 이 진 우
	 */
	public Integer listCountThePast(int sid);
	public Integer listCountTheRest(int sid);
	/**
	 * 
	 날      짜 : 2018. 6. 28.
	 기      능 : LIST PAGE 우측 하단의 TASK 상태
	 작성자명 : 이 진 우
	 */
	public int listCountNoDay(int sid);
	public int listCountAfterNextWeek(int sid);
	public int listCountUntilThisWeek(int sid);
	public int listCountOverdueTask(int sid);
	/**
	 * 
	 날      짜 : 2018. 6. 28.
	 기      능 : LIST PAGE 맴퍼 필터용 맴버 리스트
	 작성자명 : 이 진 우
	 */
	public ArrayList<MemberDTO> listProjectMemberList(int sid);
	/**
	 * 
	 날      짜 : 2018. 7. 6.
	 기      능 : LIST PAGE 에서 TASK를 단체로 상태 변경
	 작성자명 : 이 진 우
	 */
	public int listStatusTasks(TaskDTO task);
	/**
	 * 
	 날      짜 : 2018. 7. 3.
	 기      능 : LIST PAGE 에서 TASK를 단체로 특정인에게 할당전에 중복 값을 제거하기 위해서 가지고 오는 쿼리
	 작성자명 : 이 진 우
	 */
	public ArrayList<AssigneeDTO> listBeforeAssignTasks(String mid);
	/**
	 * 
	 날      짜 : 2018. 7. 3.
	 기      능 : LIST PAGE 에서 TASK를 단체로 특정인에게 할당
	 작성자명 : 이 진 우
	 */
	public int listAssignTasks(List<AssigneeDTO> list);
	/**
	 * 
	 날      짜 : 2018. 7. 6.
	 기      능 : LIST PAGE 에서 TASK 단체로 특정 Step에 추가 하기전에 STEP LIST를 들고오는 함수
	 작성자명 : 이 진 우
	 */
	public ArrayList<StepDTO> getStepListBeforeAddStepTasks(int sid);
	/**
	 * 
	 날      짜 : 2018. 7. 3.
	 기      능 : LIST PAGE 에서 TASK를 단체로 특정 스텝에 추가하기전 중복 값을 제거하기위해서 가지고 오는 쿼리
	 작성자명 : 이 진 우
	 */
	public ArrayList<TaskInStepDTO> listBeforeAddStepTasks(int sid);
	/**
	 * 
	 날      짜 : 2018. 7. 3.
	 기      능 : LIST PAGE 에서 TASK를 단체로 특정 스텝에 추가
	 작성자명 : 이 진 우
	 */
	public int listAddStepTasks(List<TaskInStepDTO> list);
	/**
	 * 
	 날      짜 : 2018. 7. 3.
	 기      능 : LIST PAGE 에서 TASK 단체로 삭제
	 작성자명 : 이 진 우
	 */
	public int listDeleteTasks(List<Integer> list);
}
