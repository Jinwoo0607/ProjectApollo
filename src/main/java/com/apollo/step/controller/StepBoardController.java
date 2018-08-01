package com.apollo.step.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import com.apollo.step.service.StepBoardService;
import com.apollo.step.service.StepListService;
import com.apollo.task.service.TaskService;
import com.apollo.vo.CommentDTO;
import com.apollo.vo.StepDTO;
import com.apollo.vo.TaskDTO;
import com.apollo.vo.TstatusDTO;

@Controller
public class StepBoardController {
	
	@Autowired
	private StepListService listservice;
	@Autowired
	private StepBoardService boardservice;
	@Autowired
	private TaskService taskservice;
	
	
	
	@Autowired
	private View jsonview;
	
	/**
	 * 
	 날      짜 : 2018. 6. 20.
	 기      능 : board에서 task 생성 
	 작성자명 : 이 창 훈
	 */
	@RequestMapping("/boardInsertTask.htm")
	public String createTask(TaskDTO taskdto, HttpServletRequest request) {
		taskdto.setPid((Integer)request.getSession().getAttribute("pid"));
		int sid = (Integer) request.getSession().getAttribute("sid");
		try {
			//task insert service
			boardservice.insertBoardTask(taskdto);
			//task 생성 후 시퀀스로 생성된 tid를 해당 step에 insert 하는 하는
			boardservice.insertBoardTaskInStep(taskdto.getTid(), sid);
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "redirect:/board.htm";
	}
	
	
	public String showBoardStepList(String s1, Model model) {
		return null;
	}
	
	
	/**
	 * 
	 날      짜 : 2018. 6. 18.
	 기      능 : board에서 task를 드래그를 통해 이동하여 update함. 
	 작성자명 : 이 창 훈
	 */
	@RequestMapping("/boardTaskStatusUpdate.htm")
	public View changeBoardStepStatus(TaskDTO taskdto, HttpSession session) {
		
		int result = 0;
		
		try {
			result = boardservice.updateBoardTaskByTid(taskdto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String realtname = taskservice.getTname(taskdto.getTid());
		
		// 상태 변경 성공시 코멘트 입력
		if(result == 1) {
			String comment = "";
			String mid = (String) session.getAttribute("mid");
			ArrayList<TstatusDTO> tstatuslist = new ArrayList();
			tstatuslist = taskservice.gettstatuslist(taskdto.getTid());

			for(TstatusDTO tstatusdto : tstatuslist) {
				int tstatusid = tstatusdto.getTstatusid();
					if(tstatusid == taskdto.getTstatusid()) {
						
						String modifier = taskservice.getTaskModifierName(mid);
						comment = modifier + "님이 " + realtname +"의 상태를 " + tstatusdto.getTstatus() + "로 변경하였습니다";
					}
			}
			
			CommentDTO commentdto = new CommentDTO();
			commentdto.setComments(comment);
			commentdto.setTid(taskdto.getTid());
			commentdto.setMid(mid);
			commentdto.setCmtkind(1);
			int insert_comment_result = taskservice.insertComment(commentdto);
			
		} // end - 상태 변경 성공시 발동 조건문 
		
		return jsonview;
	}
	
	/**
	 * 
	 날      짜 : 2018. 6. 15.
	 기      능 : 해당 step의 task들을 board page에 각각의 상태와 task를 가져온다. 
	 작성자명 : 이 창 훈
	 */
	@RequestMapping("/board.htm")
    public String selectBoard(Model model,HttpServletRequest request, HttpSession session) {
		session.setAttribute("location", "/board.htm");

        int sid = (Integer) request.getSession().getAttribute("sid");
        
        try {
        	  
        	  StepDTO stepinfo = listservice.getListStepName(sid);
        	  model.addAttribute("stepinfo", stepinfo);
        	  ArrayList<TstatusDTO> tstatusdto = boardservice.selectTstatusBySid(sid);
              model.addAttribute("b", tstatusdto);
              
              ArrayList<TaskDTO> taskdto = boardservice.getTasksByStepId(sid);
              model.addAttribute("t", taskdto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
               
        
        return "step/board";
    }



	
}
