import 'package:flutter/material.dart';

class DailyEssential extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      height: 420,
      child: new GridView.count(
          crossAxisCount: 2,
        shrinkWrap: false,
        primary: false,
        padding: EdgeInsets.all(10),
        mainAxisSpacing: 10,
        children: <Widget>[
          new EssentialView('https://images-eu.ssl-images-amazon.com/images/G/31/img20/Grocery/GW/grocery._CB420354730_SR260,332_.jpg', 'Grocessery essentials'),
          new EssentialView('https://images-eu.ssl-images-amazon.com/images/G/31/img17/Auto/2020/235x300_1._CB436105264_SR260,332_.jpg', 'Masks & Personal hygiene'),
          new EssentialView('https://images-eu.ssl-images-amazon.com/images/G/31/img18/HPC/GW/QC/235x300_household_kioskcard._CB434940507_SR260,332_.jpg', 'Personal Supplies'),
          new EssentialView('https://images-eu.ssl-images-amazon.com/images/G/31/img19/Baby/GW/QC/Essentials/Baby_Pets_Kiosk._CB434940478_SR260,332_.jpg', 'Baby essentials'),
          new EssentialView('https://images-eu.ssl-images-amazon.com/images/G/31/OHL_Covid_GW/6._CB434555400_SR260,332_.jpg', 'Lights & Bulbs'),
          new EssentialView('https://images-eu.ssl-images-amazon.com/images/G/31/img20/Grocery/GW/kiosk._CB433642095_SR260,332_.jpg', 'Health & Fitness'),
        ],

      ),
    );
  }
}

class EssentialView extends StatelessWidget {

  String productUrl;
  String productName;


  EssentialView(this.productUrl, this.productName);

  @override
  Widget build(BuildContext context) {
    return new Container(
      color: Colors.grey[100],
      height: 150,
      width: 160,
      padding: EdgeInsets.all(5),
      child: new Column(
        children: <Widget>[
          new Image.network(productUrl,height: 150,width: 160),
          SizedBox(height: 5.0,),
          new Text(productName,style: new TextStyle(fontWeight: FontWeight.bold,color: Colors.brown),maxLines: 3,),
        ],
      ) ,
    );
  }
}
