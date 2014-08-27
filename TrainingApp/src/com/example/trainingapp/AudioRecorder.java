package com.example.trainingapp;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

public class AudioRecorder extends Activity{

	private MediaRecorder recorder;
	private MediaPlayer player;
	private boolean isRecording = false;
	private boolean isPlaying = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.audiorecorder);
	}

	public void recordAudio(View v){
		if(isRecording){
			Toast.makeText(this, "Already recording", Toast.LENGTH_LONG).show();
			return;
		}
		recorder = new MediaRecorder();
		recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		recorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
		recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
		recorder.setOutputFile(Environment.getExternalStorageDirectory().getPath()+"/oracle.mp3");
		try {
			recorder.prepare();
			recorder.start();
			Toast.makeText(this, "Started recording", Toast.LENGTH_LONG).show();
			isRecording = true;
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(this, "Error recording", Toast.LENGTH_LONG).show();
		}
	}
	
	
	public void stopAudio(View v){
		if(isRecording){
			recorder.stop();
			recorder.release();
			isRecording = false;
			Toast.makeText(this, "Stopped recording", Toast.LENGTH_LONG).show();
		}
		
		if(isPlaying){
			player.stop();
			player.release();
			isPlaying = false;
			Toast.makeText(this, "Playback Stopped", Toast.LENGTH_LONG).show();
		}
	}
	
	public void playAudio(View v){
		if(isPlaying){
			Toast.makeText(this, "Already playing", Toast.LENGTH_LONG).show();
			return;
		}
		String path = "file:///"+Environment.getExternalStorageDirectory().getPath()+"/oracle.mp3";
		player = MediaPlayer.create(this, Uri.parse(path));
		if(player!=null){
			player.start();
			Toast.makeText(this, "Playback Started", Toast.LENGTH_LONG).show();
			isPlaying = true;
		}
	}
	
}
