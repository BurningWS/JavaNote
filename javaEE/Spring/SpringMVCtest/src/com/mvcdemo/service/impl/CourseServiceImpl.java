package com.mvcdemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import org.apache.catalina.servlets.DefaultServlet;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoaderListener;

import com.mvcdemo.model.Chapter;
import com.mvcdemo.model.Course;
import com.mvcdemo.service.CourseService;


@Service("courseService")
public class CourseServiceImpl implements CourseService {

	public Course getCoursebyId(Integer courseId) {
		
		Course course = new Course();
		
		course.setCourseId(courseId);
		course.setTitle("娣卞叆娴呭嚭Java澶氱嚎绋?);
		course.setImgPath("resources/imgs/course-img.jpg");
		course.setLearningNum(12345);
		course.setLevel(2);
		course.setLevelDesc("涓骇");
		course.setDuration(7200l);
		course.setDescr("澶氱嚎绋嬫槸镞ュ父寮€鍙戜腑镄勫父鐢ㄧ煡璇嗭紝涔熸槸闅剧敤鐭ヨ瘑銆侠ala bala...");
		
		List<Chapter> chapterList = new ArrayList<Chapter>();
		
		warpChapterList(courseId,chapterList);
		
		course.setChapterList(chapterList);
		
		return course;
	}

	private void warpChapterList(Integer courseId,List<Chapter> chapterList) {
		Chapter chapter = new Chapter();
		chapter.setId(1);
		chapter.setCourseId(courseId);
		chapter.setOrder(1);
		chapter.setTitle("绗?绔?澶氱嚎绋嬭儗鏅煡璇嗕粙缁?);
		chapter.setDescr("链珷灏嗕粙缁崭笌澶氱嚎绋嬬紪绋嬬浉鍏崇殑鑳屾櫙姒傚康");	
		chapterList.add(chapter);
		
		chapter = new Chapter();
		chapter.setId(2);
		chapter.setCourseId(courseId);
		chapter.setOrder(2);
		chapter.setTitle("绗?绔?Java 绾跨▼鍒濅綋楠?);
		chapter.setDescr("Java璇█灞傞溃瀵圭嚎绋嬬殑鏀寔锛屽浣曞垱寤猴紝鍚姩鍜屽仠姝㈢嚎绋嬨€傚浣曚娇鐢ㄥ父鐢ㄧ殑绾跨▼鏂规硶銆傜敤闅嫔攼婕斾箟鐞呜В绾跨▼镄勪唬镰?);
		chapterList.add(chapter);
		
		chapter = new Chapter();
		chapter.setId(3);
		chapter.setCourseId(courseId);
		chapter.setOrder(3);
		chapter.setTitle("绗?绔?Java 绾跨▼镄勬纭仠姝?);
		chapter.setDescr("链珷璁ㄨ濡备綍姝ｇ‘镄勫仠姝竴涓嚎绋嬶紝镞㈣绾跨▼锅滃缑浜嗭紝杩桦缑绾跨▼锅滃缑濂姐€?);		
		chapterList.add(chapter);
		
		chapter = new Chapter();
		chapter.setId(4);
		chapter.setCourseId(courseId);
		chapter.setOrder(4);
		chapter.setTitle("绗?绔?绾跨▼浜や簰");
		chapter.setDescr("浜夌敤鏉′欢锛岀嚎绋嬬殑浜や簰锛屽强姝婚挛镄勬垚锲犲强棰勯槻銆?);		
		chapterList.add(chapter);
		
		chapter = new Chapter();
		chapter.setId(5);
		chapter.setCourseId(courseId);
		chapter.setOrder(5);
		chapter.setTitle("绗?绔?杩涢桩灞曟湜");
		chapter.setDescr("绠€鍗曚粙缁?Java 骞跺彂鐩稿叧镄勭被锛屽强甯哥敤镄勫绾跨▼缂栫▼妯″瀷銆?);		
		chapterList.add(chapter);
		
	}




}
