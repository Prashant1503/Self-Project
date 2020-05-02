import 'package:flutter/material.dart';

class OrderWishlist extends StatelessWidget {

  String _title;

  OrderWishlist(this._title);

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(title: new Text(_title),),
    );
  }
}
