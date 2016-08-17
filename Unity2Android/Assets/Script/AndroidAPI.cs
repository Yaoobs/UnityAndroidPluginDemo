using UnityEngine;
using System.Collections;

public class AndroidAPI : MonoBehaviour {

	// Use this for initialization
	void Start () {
		this.name="Unity2Android"; 
	}

	void SetCameraColor()  
	{  
		//Set Camera Background Color  
		Camera.main.backgroundColor=new Color(1.0F,0.5F,0.5F);  
	} 

	// Update is called once per frame
	void Update () {
		// 返回Button退出
		if(Input.GetKey(KeyCode.Escape))
			Application.Quit();
	}

	void OnGUI ()   
	{  
		// 通过API调用对话框  
		if(GUILayout.Button("调用安卓Jar中的方法ShowDialog",GUILayout.Height(50)))  
		{  
			//获取Android的Java接口  
			AndroidJavaClass jc=new AndroidJavaClass("com.unity3d.player.UnityPlayer");  
			AndroidJavaObject jo=jc.GetStatic<AndroidJavaObject>("currentActivity");  
			//构造参数  
			string[] mString=new string[2];  
			mString[0]="Unity2Android";  
			mString[1]="Talk is cheap，Show me the code！";  
			//调用方法  
			jo.Call("ShowDialog",mString);  
		}  
		// 通过API调用Toast
		if(GUILayout.Button("调用安卓Jar中的方法ShowToast",GUILayout.Height(50)))  
		{ 
			AndroidJavaClass jc=new AndroidJavaClass("com.unity3d.player.UnityPlayer");  
			AndroidJavaObject jo=jc.GetStatic<AndroidJavaObject>("currentActivity"); 
			jo.Call("ShowToast","HELLO WORLD！"); 
		}
		// 通过API调用手机震动的方法
		if(GUILayout.Button("调用安卓Jar中的方法SetVibrator",GUILayout.Height(50)))  
		{ 
			long[] mTime = new long[]{ 200, 2000, 2000, 200, 200, 200 };
			AndroidJavaClass jc=new AndroidJavaClass("com.unity3d.player.UnityPlayer");  
			AndroidJavaObject jo=jc.GetStatic<AndroidJavaObject>("currentActivity"); 
			jo.Call("SetVibrator",mTime); 
		}
		//通过API调用Toast  
		if(GUILayout.Button("通过SendMessage调用Unity中的方法",GUILayout.Height(50)))  
		{  
			//获取Android的Java接口  
			AndroidJavaClass jc=new AndroidJavaClass("com.unity3d.player.UnityPlayer");  
			AndroidJavaObject jo=jc.GetStatic<AndroidJavaObject>("currentActivity");  

			jo.Call("InvokeUnity","");  
		} 
		//通过传值打开Activity  
		//		if(GUILayout.Button("调用Android API中打开Activity",GUILayout.Height(50)))  
		//		{  
		//			//获取Android的Java接口  
		//			AndroidJavaClass jc=new AndroidJavaClass("com.unity3d.player.UnityPlayer");  
		//			AndroidJavaObject jo=jc.GetStatic<AndroidJavaObject>("currentActivity");  
		//			//打开博主的博客  
		//			jo.Call("StartWebView","http://blog.csdn.net/Yaoobs");  
		//		} 

	} 
}
