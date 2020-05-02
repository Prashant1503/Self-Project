import 'package:ecommerceappstore/Screens/dashboard/Dashboard.dart';
import 'package:ecommerceappstore/Screens/MainDrawer.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(new MaterialApp(
    theme: new ThemeData(
      primarySwatch: Colors.red,
    ),
    debugShowCheckedModeBanner: false,
    title: 'Ecommerce App',
    home: new MyDrawer(),
  ));
}

class MyDrawer extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      drawer: MainDrawer(),
      appBar: AppBar(
        elevation: 0.1,
        title: new Text('Shopify'),
        actions: <Widget>[
          Padding(
              padding: EdgeInsets.only(right: 20),
              child: new Icon(Icons.search)
          ),
          Padding(
              padding: EdgeInsets.only(right: 20),
              child: new Icon(Icons.shopping_cart),
          ),

        ],
      ),
      body: new Container(
        child: Center(child: new Text('Navigate to navigation tab item,and see the magic',style: new TextStyle(fontWeight: FontWeight.bold,fontSize: 18.0),)),
      ),
    );
  }
}
