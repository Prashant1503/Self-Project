import 'package:flutter/material.dart';

class Orders extends StatelessWidget {

  String _title;

  Orders(this._title);

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(title: new Text(_title),),
    );
  }
}
