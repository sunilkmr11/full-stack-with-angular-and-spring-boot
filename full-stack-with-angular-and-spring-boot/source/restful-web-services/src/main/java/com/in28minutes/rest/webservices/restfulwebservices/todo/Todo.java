package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.Date;

public class Todo {

	private long id;
	private String description;
	private Date targetDate;
	private boolean done;
//	private Date startDate;
//	private Date endDate;
	
	protected Todo() {
		
	}
	public Todo(long id, String description, Date targetDate, boolean done
			  //, Date startDate,	Date endDate
			) {
		super();
		this.id = id;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
		/*
		 * this.startDate = startDate; this.endDate = endDate;
		 */
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	
public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	//	public Date getStartDate() {
//		return startDate;
//	}
//	public void setStartDate(Date startDate) {
//		this.startDate = startDate;
//	}
//	public Date getEndDate() {
//		return endDate;
//	}
//	public void setEndDate(Date endDate) {
//		this.endDate = endDate;
//	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ",  description=" + description + ", targetDate="
				+ targetDate + ", done=" + done +  "]";
	}
	
	
}
