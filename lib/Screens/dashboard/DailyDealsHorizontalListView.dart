import 'package:flutter/material.dart';


class DailyDeals extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      height: 140,
        width: 190,
        child: ListView(
          scrollDirection: Axis.horizontal,
          children: <Widget>[
            Product('https://i.ebayimg.com/images/g/lusAAOSwZ~peHldJ/s-l140.webp','INR 5,296.66','INR 9,837.26','46%','OFF'),
            Product('https://i.ebayimg.com/images/g/rS8AAOSwZKJekQvz/s-l140.webp','INR 56,694.44','INR 52,235.66','10%','OFF'),
            Product('https://i.ebayimg.com/images/g/2~gAAOSw5UZY-OPx/s-l140.webp','INR 35,238.70','INR 32,837.26','20%','OFF'),
            Product('https://i.ebayimg.com/images/g/DkgAAOSwqcJbpTrR/s-l140.webp','INR 25,138.38','INR 23,837.26','10%','OFF'),
            Product('https://i.ebayimg.com/images/g/sjkAAMXQWuRQ-tXg/s-l140.webp','INR 90,438.70','INR 85,787.26','40%','OFF'),
            Product('https://i.ebayimg.com/images/g/90UAAOxy3lFRCX7J/s-l140.webp','INR 98,304.83','INR 89,537.26','50%','OFF'),
          ],
        ),


    );
  }
}

class Product extends StatelessWidget {

   String productImage;
  final String productPrice;
  final String productSpecialPrice;
  final String productoffPercent;
  final String productOffTag;


  Product(this.productImage,this.productPrice,this.productSpecialPrice,this.productoffPercent,this.productOffTag);

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(1.0),
      child: InkWell(
        onTap: () {},
        child: Container(
          color: Colors.grey[100],
          width: 190,
          height: 140,
          child: new ListTile(
            title: Image.network(productImage,width: 140,height: 140.0,),
            subtitle: Container(
              alignment: Alignment.topCenter,
              child: new Column(
                children: <Widget>[
                  SizedBox(height: 8.0,),
                  new Text(productPrice,style: new TextStyle(fontWeight: FontWeight.bold,fontSize: 17,color: Colors.black),maxLines: 10,),
                  new Row(
                    children: <Widget>[
                      SizedBox(height: 8.0,),
                      new Text(productSpecialPrice,style: new TextStyle(fontSize: 16,color: Colors.grey)),
                      SizedBox(width: 10,),
                      new CircleAvatar(radius: 3,backgroundColor: Colors.grey,),
                      SizedBox(width: 10,),
                      new Text(productoffPercent,style: new TextStyle(fontSize: 16)),
                    ],
                  ),
                  new Text(productOffTag,style: new TextStyle(fontSize: 16)),
                ],
              )
            ),
          ),
        ),
      ),
    );
  }
}
