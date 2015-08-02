package com.kate.app.model;

import java.sql.Timestamp;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;

import com.kate.app.service.SuggestionService;

public class MyTimerTask extends TimerTask{
	@Autowired
	private SuggestionService suggestionService;
	
	@Override
	    public void run() {
			suggestionService.writeFileByName();
	  }
}
