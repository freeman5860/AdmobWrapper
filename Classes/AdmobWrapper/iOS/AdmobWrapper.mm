//
//  VungleWrapper.mm
//  PowersOfTwo
//
//  Created by Freeman on 14-4-19.
//
//

#include "AdmobWrapper.h"
#include "AppController.h"
#include "RootViewController.h"
#include "GADBannerView.h"
#include "GADInterstitial.h"

static AdmobWrapper * s_pWrapper = NULL;

AdmobWrapper * AdmobWrapper::getInstance(){
    if (s_pWrapper == NULL) {
        s_pWrapper = new AdmobWrapper();
    }
    return s_pWrapper;
}

void AdmobWrapper::showBanner(){
    AppController* appController = (AppController*) [UIApplication sharedApplication].delegate;
    
    GADRequest * request = [GADRequest request];
    //request.testDevices = [NSArray arrayWithObjects:GAD_SIMULATOR_ID, nil];
    [appController->bannerView_ loadRequest:request];
    [appController->bannerView_ setHidden:FALSE];
}

void AdmobWrapper::hideBanner(){
    AppController* appController = (AppController*) [UIApplication sharedApplication].delegate;
    [appController->bannerView_ setHidden:TRUE];
}

void AdmobWrapper::showInterstitial(){
    AppController* appController = (AppController*) [UIApplication sharedApplication].delegate;
    GADRequest * request = [GADRequest request];
   // request.testDevices = [NSArray arrayWithObjects:GAD_SIMULATOR_ID, nil];
    [appController->interstitial loadRequest:request];
}