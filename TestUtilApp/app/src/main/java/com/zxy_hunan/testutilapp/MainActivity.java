package com.zxy_hunan.testutilapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.zyx_hunan.baseutil.net.util.MyObserver;

public class MainActivity extends RxAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestUtil.bannerList(MainActivity.this, new MyObserver<BannerModel>(MainActivity.this) {
                    @Override
                    public void onSuccess(BannerModel result) {
                        Log.i("test","result:"+result.toString());
                        Log.i("test","result:"+result.getErrorMsg()+" "+result.getErrorCode()+" "+result.getData().size());
                        Toast.makeText(MainActivity.this, ""+result.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Throwable e, String errorMsg) {

                    }

                    @Override
                    public void onComplete(Boolean isError) {

                    }
                });
            }
        });
    }
}