import 'package:flutter/material.dart';

class Settings extends StatelessWidget {

  String _title;

  Settings(this._title);

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(title: new Text(_title),),
    );
  }
}
