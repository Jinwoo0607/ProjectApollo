<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="js/task.js"></script>
<script type="text/javascript" src="js/projectInfo.js"></script>
<link href="css/projectinfo.css" type="text/css" rel="stylesheet">
<div class="main-body-container">
  <div class="main-body-onepannel">
    <div class="main-body-onepannel-container">
      <div class="main-body-onepannel-header">
      	<jsp:include page="/WEB-INF/views/inc/projectInsideHeader.jsp"></jsp:include>
        <div class="main-body-onepannel-header-bottom">
        </div>
      </div>
      <div class="main-body-onepannel-body">

		<div id=projectinfo_outerbox>
		  <div id="projectinfo_first_row"> <!-- row_1 -->
		
			<div id="projectinfo_Task_Status_Donut">
				<b class="information-item-title">마감기한 기준 Task 현황</b>
				<div id="prison_Donut">
				<canvas id="projectinfo_DonutChart"></canvas>
				</div>
			</div>
		
		    <div id="projectinfo_Task_Situation_Table" >
		
					<div class="projectinfo_Task_Situation_Table_header" >
						<b class="information-item-title">Step별 Task 완료/미완료 현황</b>
						<select id="projectinfo_task_situation_table_selectbar">
							 <c:forEach var="step" items="${steplist}">
		                        <option value="${step.sid}">${step.sname}</option>
		                     </c:forEach>
						</select>
					</div>
					<div class="task_progress_table_wrapper">
						<table id="task_progress_table" class="table">
							<tr><th>완료 task</th><th>미완료 task</th></tr>
						</table>
					</div>
			 </div>
		
		  </div> <!-- end_row_1 -->
		
		  <div > <!-- row_2 -->
		    <div id="projectinfo_Step_Progress_Graph" ><b class="information-item-title">Step별 진행률</b>
		  	<br>
		  	<br>
		    	<div id="prison_progressbar">
					<canvas id="projectinfo_progressbar"></canvas>
		  		</div>
		    </div>
		  </div> <!-- end_row_2 -->
		
		  <div> <!-- row_3 -->
		    <div id="projectinfo_Project_Member_Table" ><b class="information-item-title">프로젝트에 참여중인 사원 목록</b>&nbsp&nbsp
		    <a id ="project_member_add_btn" data-toggle="modal" data-target="#project_member_add_modal"><i class="fa fa-plus-square"></i></a>
		  	<br>
		  	<br>
				<table id="project_member_table" class="table">
					<tr><th>이름</th><th>직위</th><th>부서명</th><th>이메일</th><th>핸드폰 번호</th></tr>
						 <c:forEach var="member" items="${memberlist}">
						 <tr class="project_member_table_tr">
						 	<td class="information-pmember">
						 		<div class="information-pmember-name">
							 		${member.mname}
						 		</div>
						 	</td>
						 	<td>${member.position}</td>
						 	<td>${member.deptname}</td>
						 	<td class="information-pmember-mid">${member.mid}</td>
						 	<td>${member.pnum}</td>
						 </tr>
				         </c:forEach>
				</table>
			</div>
		  </div> <!-- end_row_3 -->
		
		<input type="hidden" id="project_infopage_pid" value="${projectinfo.pid}">
		<input type="hidden" id="project_infopage_manager" value="${projectinfo.mid}">
		</div> <!-- end_outerbox -->
      </div>
    </div>
  </div>
</div>
<!-- 프로젝트 멤버 추가 Modal -->
<div class="modal fade" id="project_member_add_modal">
	<div class="modal-dialog modal-add-project-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" id="add_project_member">&times;</button>
				<h4 class="modal-title">New Project Member</h4>
			</div>
			<div class="modal-body ">
			
	<table id="project_pmember_table" class="table">
		<tr><th>이름</th><th>직위</th><th>부서명</th><th>이메일</th><th>핸드폰 번호</th><th>초대</th></tr>
			 <c:forEach var="pmember" items="${invitememberlist}">
			 <tr><td>${pmember.mname}</td><td>${pmember.position}</td><td>${pmember.deptname}</td><td>${pmember.mid}</td><td>${pmember.pnum}</td><td><a id ='pmember_add_btn'><i id ="${pmember.mid}" class="fas fa-user-plus"></i></a></td></tr>
	         </c:forEach>
	</table>
	
	<!-- 
	<a id ='pmember_add_btn'><i id ="${member.mid}" class="fas fa-user-plus"></i></a>
	 -->
			</div>
			<div align="center">
				<input type="button" class="btn" id="cancel-btn"
					data-dismiss="modal" value="돌아가기">
			</div>
			<br>
		</div>
	</div>
</div>