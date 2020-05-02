import 'package:flutter/material.dart';

class GridProductCategory extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: new AppBar(
        title: new Text('Category'),
      ),
      body:Container(
        height: 600,
        child: new GridView.count(
          primary: false,
           padding: EdgeInsets.all(10),
          mainAxisSpacing: 10,
          shrinkWrap: true,
          crossAxisCount: 2,
          children: <Widget>[
            GridItemView('https://images-eu.ssl-images-amazon.com/images/G/31/img15/rcx-events/AurDikhaoStore/400x400_Vodoo_1.jpg','Electronics'),
            GridItemView('https://images-eu.ssl-images-amazon.com/images/G/31/img15/rcx-events/AurDikhaoStore/400x400_Vodoo_11.jpg','Fashion'),
            GridItemView('https://images-eu.ssl-images-amazon.com/images/G/31/img15/rcx-events/AurDikhaoStore/400x400_Vodoo_5.1.jpg','Books'),
            GridItemView('https://images-eu.ssl-images-amazon.com/images/G/31/img15/rcx-events/AurDikhaoStore/400x400_Vodoo_6.jpg','Home & Kitchen'),
            GridItemView('https://images-eu.ssl-images-amazon.com/images/G/31/img15/rcx-events/AurDikhaoStore/400x400_Vodoo_7.1.jpg','Toys & Baby Products'),
            GridItemView('https://images-eu.ssl-images-amazon.com/images/G/31/img15/rcx-events/AurDikhaoStore/400x400_Vodoo_8.jpg','Tv & Entertainment'),
            GridItemView('https://n4.sdlcdn.com/imgs/i/1/o/MF-05994.jpg','Mens Fashion'),

          ],
        ),

      ),
    );
  }
}

class GridItemView extends StatelessWidget {

   String productUrl;
   String productName;


  GridItemView(this.productUrl, this.productName);

  @override
  Widget build(BuildContext context) {

    double width = MediaQuery.of(context).size.width;

    return new Container(
      color: Colors.grey[100],
      height: 150,
      width: 100,
      child: new Column(
        children: <Widget>[
          new Image.network(productUrl,height: 150,width: 150),
          SizedBox(height: 5.0,),
          new Text(productName,style: new TextStyle(fontWeight: FontWeight.bold,color: Colors.brown),),
        ],
      ) ,
    );
  }
}
