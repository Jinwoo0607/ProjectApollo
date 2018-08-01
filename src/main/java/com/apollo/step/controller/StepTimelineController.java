package com.apollo.step.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import com.apollo.step.service.StepListService;
import com.apollo.step.service.StepTimelineService;
import com.apollo.vo.MemberDTO;
import com.apollo.vo.StepDTO;
import com.apollo.vo.TaskDTO;
import com.apollo.vo.TstatusDTO;

/**
 * 
  클래스명 : StepTimelineController
  날      짜 : 2018. 6. 15.
  작성자명 : 박 민 식
 */
@Controller
@RequestMapping("/step")
public class StepTimelineController {
	
	@Autowired
	private View jsonview;
	
	@Autowired
	private StepTimelineService steptimelineservice; 
	@Autowired
	private StepListService listservice;
	
	@RequestMapping("/timeline.htm")
	public String getTimelineView(Model model,HttpServletRequest request) {
		ArrayList<TstatusDTO> tstatuses = null;
		ArrayList<MemberDTO> assignees = null;
		StepDTO stepinfo = null;
		request.getSession().setAttribute("location", "step/timeline.htm");
		int sid = (Integer) request.getSession().getAttribute("sid");
		try {
			tstatuses = steptimelineservice.selectTstatusBySid(sid);
			assignees = steptimelineservice.selectAssigneesBySid(sid);
      	  	stepinfo = listservice.getListStepName(sid);
      	  	model.addAttribute("stepinfo", stepinfo);
			model.addAttribute("assignees", assignees);
			model.addAttribute("tstatuses", tstatuses);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "step/timeline";
	}
	
	@RequestMapping("/getTimelineTasks.htm")
	public View getTimelineTasks(Model model,HttpServletRequest request) {

		int sid= (Integer) request.getSession().getAttribute("sid");
		ArrayList<TaskDTO> tasks = null;
		try {
			tasks = steptimelineservice.getTasksByStepId(sid);
			model.addAttribute("tasks", tasks);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonview;
	}

	
	@RequestMapping(value="selectTasksByMidAndSid.htm", method=RequestMethod.POST)
	public View selectTasksByMidAndSid(String mid, HttpServletRequest request,Model model) {
		int sid= (Integer) request.getSession().getAttribute("sid");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("sid", sid);
		map.put("mid", mid);
		ArrayList<TaskDTO> tasksbymid =null;
		try {
			tasksbymid = steptimelineservice.selectTasksByMidAndSid(map);
			model.addAttribute("tasksbymid", tasksbymid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return jsonview;
	}

	@RequestMapping(value="selectNotAssignedTasksBySid.htm", method=RequestMethod.POST)
	public View selectNotAssignedTasksBySid(Model model, HttpServletRequest request) {
		int sid= (Integer) request.getSession().getAttribute("sid");
		ArrayList<TaskDTO> tasks = null;
		try {
			tasks = steptimelineservice.selectNotAssignedTasksBySid(sid);
			model.addAttribute("tasks", tasks);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonview;
	}
}





