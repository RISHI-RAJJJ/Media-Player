package com.example.c;
import com.example.c.MainActivity;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class A extends Service {
	

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		//Toast.makeText(this, "helllooooo",Toast.LENGTH_LONG).show();
		
		return super.onStartCommand(intent, flags, startId);
	}
	@Override
	public void onDestroy() {
		//TODO Auto-generated method stub
		super.onDestroy();
		
	}
	
	

}
