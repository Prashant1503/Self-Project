import 'package:flutter/material.dart';

class Category extends StatelessWidget {

  String _title;

  Category(this._title);

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text(_title),
      ),
    );
  }
}
