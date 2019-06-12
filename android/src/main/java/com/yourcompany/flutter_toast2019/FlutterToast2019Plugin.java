package com.yourcompany.flutter_toast2019;

import android.content.Context;
import android.widget.Toast;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** FlutterToast2019Plugin */
public class FlutterToast2019Plugin implements MethodCallHandler {
  private  final Context mContext;
  public FlutterToast2019Plugin(Context context){
    mContext = context;
  }
  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    //flutter_toast2019是我们method channel的名字，dart中会用到他。
    //为了防止命名冲突，可再它前面加上域名
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "example.com/flutter_toast2019");
    channel.setMethodCallHandler(new FlutterToast2019Plugin(registrar.context()));
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    //call.method是方法名
    if (call.method.equals("toast")) {
      //调用本地代码的时候，只能传递一个参数，为了传递多个，可以把参数放在一个map里面，call.argument()方法支持map和JSONObject
      String conntent = call.argument("content");
      String duration = call.argument("dutation");
      Toast.makeText(mContext,conntent,"short".equals(duration)?Toast.LENGTH_SHORT:Toast.LENGTH_LONG).show();
      //执行成功
      result.success(true);
    } else {
      result.notImplemented();
    }
  }
}
