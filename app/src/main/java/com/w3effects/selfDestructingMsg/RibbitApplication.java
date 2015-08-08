package com.teamtreehouse.selfDestructingMsg;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.PushService;
import com.teamtreehouse.selfDestructingMsg.ui.MainActivity;
import com.teamtreehouse.selfDestructingMsg.utils.ParseConstants;

public class RibbitApplication extends Application {
	
	@Override
	public void onCreate() { 
		super.onCreate();
	    Parse.initialize(this, 
	    	"atkTFyNX9YAZNRdFnxpMXTfkX9kCil2PhJcxfFsa",
	    	"Eq5ocY50dFwSYrgsWUMY54EceW7wyNZH07rT3uSa");
	    
	    //PushService.setDefaultPushCallback(this, MainActivity.class);
	    PushService.setDefaultPushCallback(this, MainActivity.class, 
	    		R.drawable.ic_stat_ic_launcher);
	    ParseInstallation.getCurrentInstallation().saveInBackground();
	}
	
	public static void updateParseInstallation(ParseUser user) {
		ParseInstallation installation = ParseInstallation.getCurrentInstallation();
		installation.put(ParseConstants.KEY_USER_ID, user.getObjectId());
		installation.saveInBackground();
	}
}
