import 'package:flutter/material.dart';

class MyAccount extends StatelessWidget {

  String _title;

  MyAccount(this._title);

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text(_title),
      ),
    );
  }
}
