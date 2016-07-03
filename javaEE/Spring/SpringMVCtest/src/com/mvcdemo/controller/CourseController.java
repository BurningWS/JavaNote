package com.mvcdemo.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mvcdemo.model.Course;
import com.mvcdemo.service.CourseService;

@Controller
@RequestMapping("/courses")   // class grade
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	// dispose /courses/view?courseId=123    method grade
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String viewCourse(@RequestParam("courseId") Integer courseId,  //matching parameter
			Model model) {
		
		System.out.println(courseId);
		Course course = courseService.getCoursebyId(courseId);
		model.addAttribute(course);
		return "course_overview";
	}
	
	//dispose /courses/view2/123 
		@RequestMapping("/view2/{courseId}")     // Restful style
		public String viewCourse2(@PathVariable("courseId") Integer courseId,
				Map<String, Object> model) {
			
			System.out.println(courseId);
			Course course = courseService.getCoursebyId(courseId);
			model.put("course",course);
			return "course_overview";
		}
		
		//链柟娉曞皢澶勭悊 /courses/view3?courseId=123 褰㈠纺镄刄RL
		@RequestMapping("/view3")
		public String viewCourse3(HttpServletRequest request) {  //traditional servlet disposal
			
			Integer courseId = Integer.valueOf(request.getParameter("courseId"));		
			Course course = courseService.getCoursebyId(courseId);
			request.setAttribute("course",course);
			
			return "course_overview";
		}
		
		
		// dispose   /courses/admin?add
		@RequestMapping(value="/admin", method = RequestMethod.GET, params = "add")
		public String createCourse(){
			return "course_admin/edit";
		}
		
		// dispose   /courses/save
		@RequestMapping(value="/save", method = RequestMethod.POST)
		public String  doSave(@ModelAttribute Course course){		
			
			System.out.println("Info of Course:");
			System.out.println(ReflectionToStringBuilder.toString(course));
			
			// do service operation
			course.setCourseId(123);
			return "redirect:view2/"+course.getCourseId();
		}
		
		@RequestMapping(value="/upload", method=RequestMethod.GET)
		public String showUploadPage(@RequestParam(value= "multi", required = false) Boolean multi){	
			if(multi != null && multi){
				return "course_admin/multifile";	
			}
			return "course_admin/file";		
		}
		
		@RequestMapping(value="/doUpload", method=RequestMethod.POST)
		public String doUploadFile(@RequestParam("file") MultipartFile file) throws IOException{
			
			if(!file.isEmpty()){
				System.out.println(file.getOriginalFilename());
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File("d:\\temp\\imooc\\", System.currentTimeMillis()+ file.getOriginalFilename()));
			}
			
			return "success";
		}
		
		@RequestMapping(value="/doUpload2", method=RequestMethod.POST)
		public String doUploadFile2(MultipartHttpServletRequest multiRequest) throws IOException{
			
			Iterator<String> filesNames = multiRequest.getFileNames();
			while(filesNames.hasNext()){
				String fileName =filesNames.next();
				MultipartFile file =  multiRequest.getFile(fileName);
				if(!file.isEmpty()){
					System.out.println(file.getOriginalFilename());
					FileUtils.copyInputStreamToFile(file.getInputStream(), new File("c:\\temp\\imooc\\", System.currentTimeMillis()+ file.getOriginalFilename()));
				}
				
			}
			return "success";
		}
}
