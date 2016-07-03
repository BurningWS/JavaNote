package com.mvcdemo.model;

import java.util.List;

public class Course {

	// 璇剧▼Id
	private Integer courseId;
	// 璇剧▼鍚岖О
	private String title;
	// 锲剧墖璺缎
	private String imgPath;
	// 瀛︿范浜烘暟
	private Integer learningNum;
	// 璇剧▼镞堕昵
	private Long duration;
	// 璇剧▼闅惧害
	private Integer level;
	// 璇剧▼闅惧害鎻忚堪
	private String levelDesc;
	// 璇剧▼浠嬬粛
	private String descr;
	// 璇剧▼鎻愮翰
	private List<Chapter> chapterList;

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getLearningNum() {
		return learningNum;
	}

	public void setLearningNum(Integer learningNum) {
		this.learningNum = learningNum;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public List<Chapter> getChapterList() {
		return chapterList;
	}

	public void setChapterList(List<Chapter> chapterList) {
		this.chapterList = chapterList;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getLevelDesc() {
		return levelDesc;
	}

	public void setLevelDesc(String levelDesc) {
		this.levelDesc = levelDesc;
	}

}
