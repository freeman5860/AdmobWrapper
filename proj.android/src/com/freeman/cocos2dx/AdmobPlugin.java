package com.freeman.cocos2dx;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdSize;

public class AdmobPlugin {
	private static Activity activity;
	
	private static InterstitialAd interstitial;
	private static AdView adView;
	
	private final static String MY_INTERSTITIAL_ID = "ca-app-pub-7350160644563922/2105560890";
	private final static String MY_BANNER_ID = "ca-app-pub-7350160644563922/9628827690";
	
	public static void setActivity(Activity act){
		activity = act;
	}
	
	public static void showBanner(){
		activity.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				if(adView == null){
					try{
			            LinearLayout.LayoutParams adParams = new LinearLayout.LayoutParams(
			            		activity.getWindowManager().getDefaultDisplay().getWidth(),
			            		activity.getWindowManager().getDefaultDisplay().getHeight()+
			            		activity.getWindowManager().getDefaultDisplay().getHeight()-50);
			            
			            adView = new AdView(activity);
			            adView.setAdSize(AdSize.BANNER);
			            adView.setAdUnitId(MY_BANNER_ID);
			            // Adding full screen container
			            activity.addContentView(adView, adParams);
			        }catch (Exception e) {
			            Log.e("AdmobPlugin", e.toString());
			        }
				}
				
				//AdRequest request = new AdRequest.Builder().addTestDevice("CE67E23C92D2161F4F0C7FA650639ABD").build();
				AdRequest request = new AdRequest.Builder().build();
				adView.loadAd(request);
				adView.setVisibility(View.VISIBLE);
			}
		});
	}
	
	public static void hideBanner(){
		activity.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				if(adView != null){
					adView.setVisibility(View.GONE);
				}
			}
		});
	}
	
	public static void showInterstitial(){
		activity.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				interstitial = new InterstitialAd(activity);
			    interstitial.setAdUnitId(MY_INTERSTITIAL_ID);
			    AdRequest adRequest = new AdRequest.Builder().build();
			    //AdRequest adRequest = new AdRequest.Builder().addTestDevice("CE67E23C92D2161F4F0C7FA650639ABD").build();
			    interstitial.loadAd(adRequest);
			    
			    interstitial.setAdListener(new AdListener() {
			    	@Override
			    	public void onAdLoaded() {
			    		activity.runOnUiThread(new Runnable() {
							
							@Override
							public void run() {
								interstitial.show();
							}
						});
			    	}
				});
			}
		});
	}
}
