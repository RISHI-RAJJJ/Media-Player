package com.example.c;




 
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener{
	ListView l;
	Button a;
	Button b;
	Button c;
	Button d;
	SeekBar sb;
	SeekBar sa;
	MediaPlayer mp;
	CheckBox cb;
	SensorManager sm;
	Sensor sensor;
	float ff=-1;
	
	int o=0;
	AudioManager am;
	NotificationManager nm;
	Notification.Builder nb;
	
	int s=0;
	
	int id=0;
	
	int k=0;
	TextView z;
	TextView x;
	TextView V;
	TextView tv;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		l=(ListView)findViewById(R.id.listView1);
		a=(Button)findViewById(R.id.button1);
		b=(Button)findViewById(R.id.button2);
		c=(Button)findViewById(R.id.button3);
		d=(Button)findViewById(R.id.button4);
		sm=(SensorManager) getSystemService(SENSOR_SERVICE);
		sensor=sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		sb=(SeekBar)findViewById(R.id.seekBar1);
		sa=(SeekBar)findViewById(R.id.seekBar2);
		tv=(TextView)findViewById(R.id.textView1);
		nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		z=(TextView)findViewById(R.id.textView2);
		
		x=(TextView)findViewById(R.id.textView3);
		
		V=(TextView)findViewById(R.id.textView4);
		cb=(CheckBox)findViewById(R.id.checkBox1);
		cb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			//@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
					if(mp!=null) {
					if(ff==1){
						mp.start();
					}
					if(ff==0) {
						mp.pause();
					}
					
				}
				else {
					
				}
				}
				
			}
		});
		am=(AudioManager)getSystemService(AUDIO_SERVICE);
		int max=am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		sa.setMax(max);
		int current=am.getStreamVolume(AudioManager.STREAM_MUSIC);
		sa.setProgress(current);
		sa.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				if(fromUser){
				am.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
				}
				
			}
		});
		Thread t=new Thread() {
			public void run() {
				super.run();
				while(true){
					if(mp==null){
						sb.setProgress(0);
					}
					else {
						sb.setProgress(mp.getCurrentPosition());
					}
				}
				
			}
		};
		t.start();
		sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				if(fromUser) {
					mp.seekTo(progress);
				}
				
			}
		});
		
		
		String songs[]={"Love me like u do","Bezubaan","Ha hansi Ban gaye"};
		o=songs.length;
		o=o-1;
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,songs);
		l.setAdapter(adapter);
		
		l.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View arg1, int arg2,
					long arg3) {
				
					
				
				id=arg2;
			
				tv.setText(Integer.toString(id));
			}
		});

		

		
	}
	public void play(View v){
		
       if(k==0){
       if(mp==null) {
		
		
		if(id==0){
			
		 mp=MediaPlayer.create(this,R.raw.a);
		 sb.setMax(mp.getDuration());
			mp.start();
		  b.setText("pause");
		  z.setText("Selected");
		  x.setText("");
		  V.setText("");
			k=1;
			nb=new Notification.Builder(this);
			nb.setAutoCancel(true);
			Intent i=new Intent(this,A.class);
			
		
			
			PendingIntent pi=PendingIntent.getService(this, 1,i,0);
			
			nb.setSmallIcon(R.drawable.ic_launcher);
			nb.setTicker("Song playing");
			nb.setContentText("Song");
			nb.setContentIntent(null);
			nb.addAction(android.R.drawable.alert_light_frame,"previous",null);
			nb.addAction(android.R.drawable.alert_light_frame,"stop",null);
			
			nb.addAction(android.R.drawable.alert_light_frame,"next",null);
			Notification n=nb.build();
			nm.notify(1,n);
			
			//ma.notification();
		}
		if(id==1){
		
			 mp=MediaPlayer.create(this,R.raw.b);
			 sb.setMax(mp.getDuration());
			mp.start();
			//ma.notification();
			nb=new Notification.Builder(this);
			nb.setAutoCancel(true);
			Intent i=new Intent(this,A.class);
		
			
			PendingIntent pi=PendingIntent.getService(this, 1,i, 0);
			
			nb.setSmallIcon(R.drawable.ic_launcher);
			nb.setTicker("Song playing");
			nb.setContentText("Song");
			nb.setContentIntent(null);
			nb.addAction(android.R.drawable.alert_light_frame,"previous",null);
			nb.addAction(android.R.drawable.alert_light_frame,"stop",null);
			nb.addAction(android.R.drawable.alert_light_frame,"next",null);
			Notification n=nb.build();
			nm.notify(1,n);
			  b.setText("pause");
			  k=1;
			  x.setText("Selected");
			  z.setText("");
			  V.setText("");
			  
			 
		}
		if(id==2){
			
			mp=MediaPlayer.create(this,R.raw.m);
			sb.setMax(mp.getDuration());
			mp.start();
			//ma.notification();
			nb=new Notification.Builder(this);
			nb.setAutoCancel(true);
			Intent i=new Intent(this,A.class);
		String s=Integer.toString(id);
			i.putExtra("iv",s);
			PendingIntent pi=PendingIntent.getService(this, 1,i, 0);
			
			nb.setSmallIcon(R.drawable.ic_launcher);
			nb.setTicker("Song playing");
			nb.setContentText("Song");
			nb.setContentIntent(null);
			nb.addAction(android.R.drawable.alert_light_frame,"previous",null);
			nb.addAction(android.R.drawable.alert_light_frame,"stop",null);
			nb.addAction(android.R.drawable.alert_light_frame,"next",null);
			Notification n=nb.build();
			nm.notify(1,n);
			  b.setText("pause");
			k=1;
			 V.setText("Selected");
			  x.setText("");
			  z.setText("");
		}
       } 
       else{
    	   mp.start();
    	   b.setText("pause");
    	   k=1;
    	   
       }
       
       }
       else {
    	   if(mp!=null) {
	    	   mp.pause();   
	    	   b.setText("play");
	    	 k=0;
		
	}
    	   
       }
    	 
		}
	public void stop(View V){
		mp.stop();
		mp=null;
		k=0;
		b.setText("play");
		
	}
	public void previous(View v){
		if(mp!=null){
		mp.stop();
		mp=null;
		id=id-1;
		tv.setText(Integer.toString(id));
		if(id==-1){
	id=o;
	tv.setText(Integer.toString(id));
		}
		
		
		if(id==0){
			
		 mp=MediaPlayer.create(this,R.raw.a);
		 sb.setMax(mp.getDuration());
			mp.start();
			//ma.notification();
		  b.setText("pause");
			k=1;
			 z.setText("Selected");
			  x.setText("");
			  V.setText("");
			
		}
		
		if(id==1){
			
			 mp=MediaPlayer.create(this,R.raw.b);
			 sb.setMax(mp.getDuration());
			mp.start();
			//ma.notification();
			  b.setText("pause");
			
			k=1;
			 x.setText("Selected"); 
			  V.setText("");
			  z.setText("");
			 
		}
		if(id==2){
			
			mp=MediaPlayer.create(this,R.raw.m);
			sb.setMax(mp.getDuration());
			mp.start();
			//ma.notification();
			  b.setText("pause");
			k=1;
			 V.setText("Selected");
			 z.setText("");
			 x.setText("");
		}
		}
	}
	public void next(View v){
		mp.stop();
		mp=null;
		id=id+1;
		tv.setText(Integer.toString(id));
		if(id==3){
	id=0;
	tv.setText(Integer.toString(id));
		}
		
		
		if(id==0){
			
		 mp=MediaPlayer.create(this,R.raw.a);
		 sb.setMax(mp.getDuration());
			mp.start();
			//ma.notification();
		  b.setText("pause");
			k=1;
			 z.setText("Selected");
			 x.setText("");
			 V.setText("");
		}
		
		if(id==1){
			
			 mp=MediaPlayer.create(this,R.raw.b);
			 sb.setMax(mp.getDuration());
			mp.start();
			//ma.notification();
			  b.setText("pause");
			
			k=1;
			 x.setText("Selected");
			 V.setText("");
			 z.setText("");
		}
		if(id==2){
			
			mp=MediaPlayer.create(this,R.raw.m);
			sb.setMax(mp.getDuration());
			mp.start();
			//ma.notification();
			  b.setText("pause");
			k=1;
			 V.setText("Selected");
			 x.setText("");
			 z.setText("");

		}
		
	}
	public void notification() {
		nb=new Notification.Builder(this);
		//nb.setAutoCancel(true);
		Intent i=new Intent(this,A.class);
	String s=Integer.toString(id);
		i.putExtra("iv",s);
		PendingIntent pi=PendingIntent.getService(this, 1,i, 0);
		
		
		nb.setSmallIcon(R.drawable.ic_launcher);
		nb.setTicker("Song playing");
		nb.setContentText("Song");
		nb.setContentIntent(pi);
		Notification n=nb.build();
		nm.notify(1,n);
		
	}
	//@Override
/*	protected void onResume() {
		
		super.onResume();
		sm.registerListener((SensorEventListener) this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		sm.unregisterListener((SensorEventListener) this, sensor);
	}*/
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onSensorChanged(SensorEvent event) {
		float f[]=event.values;
		 ff=f[0];
		
	}

}
