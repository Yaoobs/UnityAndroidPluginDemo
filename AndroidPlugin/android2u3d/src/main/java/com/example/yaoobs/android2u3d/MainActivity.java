package com.example.yaoobs.android2u3d;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.Toast;

/* 引入Unity的包,在之前Unity的classes.jar里  */
import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

/* 如果需要Activity与Unity对接，可以通过继承UnityPlayerActivity来实现  */
public class MainActivity extends UnityPlayerActivity {

    private Context mContext = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }

    /* 定义一个调用Unity方法的方法 ，基于UnitySendMessage实现 。
    * 由于没有布局文件，我们在这里通过Unity调用这个方法*/
    public void InvokeUnity(String mStr) {
        UnityPlayer.UnitySendMessage("Unity2Android", "SetCameraColor", "");
    }

    /* 定义一个打开Activity的方法，我们将在Unity中调用此方法 */
//    public void StartWebView(String mUrl)
//    {
//        //创建一个Intent以打开一个新的Activity
//        Intent intent=new Intent(mContext,WebActivity.class);
//        //传入一个URL
//        intent.putExtra("URL", mUrl);
//        //打开Activity
//        this.startActivity(intent);
//    }

    // 定义一个显示对话框的方法，在Unity中调用此方法
    public void ShowDialog(final String mTitle, final String mContent) {
        // 在UI线程下执行
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                mBuilder.setTitle(mTitle).setMessage(mContent).setPositiveButton("OK", null);
                mBuilder.show();
            }
        });
    }

    // 定义一个显示Toast的方法，在Unity中调用此方法
    public void ShowToast(final String mStr2Show) {
        // 同样需要在UI线程下执行
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), mStr2Show, Toast.LENGTH_LONG).show();
            }
        });
    }

    //  定义一个手机振动的方法，在Unity中调用此方法
    public void SetVibrator(final long[] mTime) {
        Vibrator mVibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        mVibrator.vibrate(mTime, -1); //-1：表示不重复 0：循环的震动
    }
}
