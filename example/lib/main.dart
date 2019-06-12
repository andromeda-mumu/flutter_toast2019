import 'package:flutter/material.dart';
import 'package:flutter_toast2019/flutter_toast2019.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      home: new Scaffold(
        appBar: new AppBar(
          title: const Text('Plugin example app'),
        ),
        body: new Center(
          child: RaisedButton(
              child: Text('toast'),
              onPressed: ()=>FlutterToast2019.toast('toast from flutter', ToastDuration.short),
          ),
        ),
      ),
    );
  }
}

