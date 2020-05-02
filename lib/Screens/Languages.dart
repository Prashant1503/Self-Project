import 'package:flutter/material.dart';

class AppLanguages extends StatelessWidget {

  String _title;

  AppLanguages(this._title);

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text(_title),
      ),
    );
  }
}
