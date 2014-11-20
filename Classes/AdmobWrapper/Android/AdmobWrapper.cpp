#include "AdmobWrapper.h"
#include <jni.h>
#include "platform/android/jni/JniHelper.h"

using namespace cocos2d;

static AdmobWrapper * s_Instance = NULL;

AdmobWrapper * AdmobWrapper::getInstance(){
	if(s_Instance == NULL){
		s_Instance = new AdmobWrapper();
	}

	return s_Instance;
}

void AdmobWrapper::showBanner(){
	JniMethodInfo minfo;
	bool isHave = JniHelper::getStaticMethodInfo(minfo,
			"com/freeman/cocos2dx/AdmobPlugin","showBanner","()V");
	if(!isHave){
			//CCLog("jni:openURL 函数不存在");
	}else{
		minfo.env->CallStaticVoidMethod(minfo.classID,minfo.methodID);
	}
}

void AdmobWrapper::hideBanner(){
	JniMethodInfo minfo;
	bool isHave = JniHelper::getStaticMethodInfo(minfo,
				"com/freeman/cocos2dx/AdmobPlugin","hideBanner","()V");
	if(!isHave){
				//CCLog("jni:openURL 函数不存在");
	}else{
		minfo.env->CallStaticVoidMethod(minfo.classID,minfo.methodID);
	}
}

void AdmobWrapper::showInterstitial(){
	JniMethodInfo minfo;
	bool isHave = JniHelper::getStaticMethodInfo(minfo,
				"com/freeman/cocos2dx/AdmobPlugin","showInterstitial","()V");
	if(!isHave){
				//CCLog("jni:openURL 函数不存在");
	}else{
		minfo.env->CallStaticVoidMethod(minfo.classID,minfo.methodID);
	}
}
