[![](https://jitpack.io/v/zxy-hunan/xUtils.svg)](https://jitpack.io/#zxy-hunan/xUtils)

# xUtils
最新版本 v1.0.4

简介
-------  
轻便型网络请求框架，使用Retrfoit+Rxjava做请求，比较适用于有少量http请求的应用。

使用方式
# How to
## Step 1. 项目根目录build.gradle下添加:
``` 
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ``` 
## Step 2. App目录build.gradle下添加
```  
	dependencies {
	        implementation 'com.github.zxy-hunan:xUtils:v1.0.4'
	}
```  

## Step 3. 创建Api接口继承于ApiPath，例:详情看demo
```  
public interface TestService extends ApiPath {
        @GET("/banner/json")
        Observable<BannerModel> bannerList();
}
```  

## Step 4. Application中NetUtil初始化
```  
NetUtil.options().setApiPath(TestService.class)
                .setDefault_time(10)
                .setUrl("https://www.wanandroid.com");
```  

## Step 5. 创建Http请求帮助类
```  
public class TestUtil {

        public static void bannerList(RxAppCompatActivity context, MyObserver<BannerModel> observer){
        TestService testService= (TestService) NetUtil.getApiPath();
            testService.bannerList()
                .compose(RxHelper.observableIO2Main(context))
                .subscribe(observer);
    }

}
```  

## Step 6. Activity中使用示例
```  
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
```  
