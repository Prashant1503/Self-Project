import 'package:flutter/material.dart';

class CategoryItem extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      height: 140,
        child: Expanded(
          child: InkWell(
            child: ListView(
              scrollDirection: Axis.horizontal,
              children: <Widget>[
                Category(image_location: 'https://i.ebayimg.com/images/g/FVIAAOSwFURcG8vK/s-l300.webp',image_caption: 'Beauty'),
                Category(image_location: 'https://i.ebayimg.com/images/g/kEwAAOSwnZJcG8vM/s-l300.webp',image_caption: 'Watches',),
                Category(image_location: 'https://i.ebayimg.com/images/g/gE4AAOSwgnJcG8vI/s-l300.webp',image_caption: 'Laptops',),
                Category(image_location: 'https://i.ebayimg.com/images/g/MyIAAOSwsrlcG8vM/s-l300.webp',image_caption: 'Toys',),
                Category(image_location: 'https://i.ebayimg.com/images/g/WREAAOSwh7tcG8vJ/s-l300.webp',image_caption: 'Phones',),
                Category(image_location: 'https://i.ebayimg.com/images/g/hIgAAOSwyTtcJkbp/s-l300.webp',image_caption: 'Shoes',),
              ],
            ),
          ),
        ),
    );
  }
}

class Category extends StatelessWidget {

  final String image_location;
  final String image_caption;

  Category({
    this.image_location,
    this.image_caption,
  });

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(1.0),
      child: InkWell(
        child: Container(
          width: 90,
          child: new ListTile(
            title: Image.network(image_location,width: 80,height: 80.0,),
            subtitle: Container(
              alignment: Alignment.topCenter,
              child: new Text(image_caption,style: new TextStyle(fontWeight: FontWeight.bold),maxLines: 10,),
            ),
          ),
        ),
      ),
    );
  }
}
