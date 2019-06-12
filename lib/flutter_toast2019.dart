import 'dart:async';

import 'package:flutter/services.dart';
enum ToastDuration{
  short,long
}
class FlutterToast2019 {
  //这里的名字要和java一样
  static const MethodChannel _channel = const MethodChannel('example.com/flutter_toast2019');
  static Future<bool> toast(String msg,ToastDuration duration) async{
    var argument ={
      'content':msg,
      'duration':duration.toString()
    };
    // 本地方法是一个异步调用。'toast' 对应我们在前面 Java 代码的 onMethodCall
    // 方法里面处理的方法名
    var success = await _channel.invokeMethod('toast',argument);
    return success;
  }
}
