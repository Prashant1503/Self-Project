import 'dart:convert';

import 'package:carousel_pro/carousel_pro.dart';
import 'package:ecommerceappstore/Screens/category/ProductCategory.dart';
import 'package:ecommerceappstore/Screens/dashboard/AdOneScreen.dart';
import 'package:ecommerceappstore/Screens/dashboard/DailyDealsHorizontalListView.dart';
import 'package:ecommerceappstore/Screens/dashboard/DailyEssential.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:ecommerceappstore/Screens/dashboard/Category_horizontal_listView.dart';
import 'AdOneScreen.dart';

class Dashboard  extends StatefulWidget {
  String _title;

  Dashboard(this._title);

  @override
  _State createState() => _State();
}

class _State extends State<Dashboard> {

  @override
  Widget build(BuildContext context) {

    //for slider image view in dashboard..
    Widget _imageCoursel = new Container(
      padding: EdgeInsets.only(top: 0),
      height: 200.0,
      child: new Carousel(
        dotSize: 5.0,
       indicatorBgPadding: 5.0,
       boxFit: BoxFit.cover,
        images: [
          new NetworkImage('https://i.ebayimg.com/images/g/aDkAAOSwjkZcGt0C/s-l400.webp'),
          new NetworkImage('https://i.ebayimg.com/images/g/iLoAAOSwO-pcGt5A/s-l400.webp'),
          new NetworkImage('https://i.ebayimg.com/images/g/vVEAAOSwiE1cGt5A/s-l400.webp'),
          new NetworkImage('https://images-eu.ssl-images-amazon.com/images/G/31/img17/Pantry/MARCH_2020/summerstore/V179543792_summer_store_1242x450_essential._CB420050553_SY300_.jpg'),
          new NetworkImage('https://images-eu.ssl-images-amazon.com/images/G/31/img17/Pantry/April20/Storefront/BAU_STOREFRONT_HEADER_750x300._CB1198675309_.jpg'),
        ],
        autoplay: true,
        animationCurve: Curves.fastOutSlowIn,
        animationDuration: Duration(milliseconds: 1000),
      ),
    );

    return Scaffold(
      appBar: new AppBar(
        title: new Text('Dashboard'),
      ),
      body: new ListView(
        children: <Widget>[
          _imageCoursel,
          Expanded(
            child: new Padding(padding: const EdgeInsets.all(4.0),
              child: Expanded(
                child: Container(
                  child: new Row(
                    children: <Widget>[
                      new Text('Category',style: new TextStyle(fontSize: 21.0,fontWeight: FontWeight.bold),),
                      SizedBox(width: 210,height: 5,),
                      new MaterialButton(
                        onPressed: (){
                          Navigator.push(context, MaterialPageRoute(builder: (context) => GridProductCategory()));
                        },
                        minWidth: 10,
                        height: 24,
                        color: Colors.redAccent,
                        textColor: Colors.white,
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(15.0),
                        ),
                        child: new Text('See All',),
                      )
                    ],
                  ),
                ),
              ),
            ),
          ),
          CategoryItem(),
          InkWell(child: new Image.network('https://images-eu.ssl-images-amazon.com/images/G/31/Gateway/Zeitgeist/Mar20/Covid19/IN_GWD_Covid19_MOHFW_1x._CB420361282_.jpg'),onTap: (){
            Navigator.push(context, MaterialPageRoute(builder: (context) => AdScreen()));
          },),
          new Padding(padding: const EdgeInsets.all(8.0),
            child: new Text('Daily Deals',style: new TextStyle(fontSize: 21.0,fontWeight: FontWeight.bold)),
          ),
          new Container(
            height: 210.0,
            child: DailyDeals(),
          ),
          new Padding(padding: const EdgeInsets.all(8.0)),
          new Container(
            height: 200,
            color: Colors.lightGreen[100],
            child: Padding(
              padding: const EdgeInsets.only(right: 145),
              child: new Column(
                children: <Widget>[
                  SizedBox(height: 10.0,),
                  new Text('Your Favourites for Less',
                    style: new TextStyle(fontSize: 20.0,fontWeight: FontWeight.bold,color: Colors.brown),textAlign: TextAlign.left,
                  ),
                  SizedBox(height: 5),
                  Padding(
                    padding: const EdgeInsets.symmetric(horizontal: 14.0),
                    child: new Text('Discover our deal of the day and featured deals',
                      style: new TextStyle(fontSize: 17.0,color: Colors.brown),
                    ),
                  ),
                  SizedBox(height: 5),
                  Flexible(
                    child: new Container(
                      margin: EdgeInsets.only(left: 10),
                      height: double.infinity,
                      child: new Column(
                        children: <Widget>[
                          //network image for covid-19 ad
                          InkWell(child: new Image.network("https://i.ebayimg.com/images/g/klsAAOSwqKNcGtu7/s-l1600.webp"),onTap: (){Navigator.push(context, MaterialPageRoute(builder: (context) =>AdScreen()));},),
                          InkWell(
                            child: new Row(
                              children: <Widget>[
                                SizedBox(height: 5,),
                                new MaterialButton(onPressed: (){},child: new Text('Click to see',style: new TextStyle(
                                  fontWeight: FontWeight.bold,
                                  fontSize: 19.0,
                                ),),textColor: Colors.brown,),
                                new Icon(Icons.arrow_forward,color: Colors.brown,),
                              ],
                            ),
                          )
                        ],
                      ),
                    ),
                  )
                ],
              ),
            ),
          ),
          new Container(
            child: Padding(
              padding: const EdgeInsets.all(10),
              child: new Row(
                children: <Widget>[
                  new Text('Home and daily essentials',style: new TextStyle(fontSize: 19.0,fontWeight: FontWeight.bold,color: Colors.brown),),
                ],
              ),
            ),
          ),
          new Container(
            child: new DailyEssential(),),
          new SizedBox(height: 10,),

          
       ],
      )

    );
  }
}
