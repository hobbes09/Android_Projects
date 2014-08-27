package com.example.trainingapp;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class LocationDemo extends Activity implements LocationListener{
	
	private TextView tv;
	LocationManager lManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.locationdemo);
		tv = (TextView)findViewById(R.id.tvLocation);
		
		lManager = (LocationManager)getSystemService(LOCATION_SERVICE);
		
		String provider = LocationManager.GPS_PROVIDER;
		Location loc = lManager.getLastKnownLocation(provider);
		if(loc!=null){
			updateLocation(loc);
		}
		
		lManager.requestLocationUpdates(provider, 10000, 1, this);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		lManager.removeUpdates(this);
	}

	private void updateLocation(Location loc) {
		// TODO Auto-generated method stub
		double longi = loc.getLongitude();
		double latt = loc.getLatitude();
		
		tv.setText("Current location: Lattitude = "+latt+" and Longitude = "+longi);
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		updateLocation(location);
		
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}
	
	
}
