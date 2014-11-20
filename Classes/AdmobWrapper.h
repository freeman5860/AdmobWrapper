//
//  VungleWrapper.h
//  PowersOfTwo
//
//  Created by Freeman on 14-4-19.
//
//

#ifndef ADMOB_WRAPPER_H_
#define ADMOB_WRAPPER_H_

class AdmobWrapper{
    
public:
    static AdmobWrapper * getInstance();
    
    // show banner ad
    void showBanner();
    // hide banner ad
    void hideBanner();
    // show interstitial
    void showInterstitial();
    
};

#endif /* defined(ADMOB_WRAPPER_H_) */
