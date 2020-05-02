import 'package:ecommerceappstore/Screens/accounts/Account.dart';
import 'package:ecommerceappstore/Screens/category/Category.dart';
import 'package:ecommerceappstore/Screens/dashboard/Dashboard.dart';
import 'package:ecommerceappstore/Screens/Languages.dart';
import 'package:ecommerceappstore/Screens/Orders.dart';
import 'package:ecommerceappstore/Screens/Settings.dart';
import 'package:ecommerceappstore/Screens/Wishlist.dart';
import 'package:flutter/material.dart';

class MainDrawer extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: Column(
        children: <Widget>[
          new Container(
            width: double.infinity,
            padding: EdgeInsets.all(20),
            color: Theme.of(context).primaryColor,
            child: new Center(
              child: new Column(
                children: <Widget>[
                  //this container is used for circle shape..
                  Container(
                    margin: EdgeInsets.only(top: 20),
                    width: 100,
                    height: 100,
                    decoration: BoxDecoration(
                      shape: BoxShape.circle,
                      image: DecorationImage(image: AssetImage('Images/login_image.jpg'),fit: BoxFit.fill),
                    ),
                  ),
                  new Text('Prashant Vani',style: new TextStyle(
                    fontSize: 21.0,
                    color: Colors.white,
                  ),),
                  SizedBox(height: 5.0,),
                  new Text('email@123.com',style: new TextStyle(
                    color: Colors.white,
                  ),),
                ],
              ),
            ),
          ),
          ListTile(
            leading: Icon(Icons.home),
            title: new Text('Dashboard'),
            onTap: () {
              Navigator.push(context, MaterialPageRoute(builder: (context) => Dashboard('Dashboard')));
            },
          ),
          ListTile(
            leading: Icon(Icons.category),
            title: new Text('Shop by Category'),
            onTap: () {
              Navigator.push(context, MaterialPageRoute(builder: (context) => Category('Category')));
            },
          ),
          new Divider(color: Colors.grey,),
          ListTile(
            leading: Icon(Icons.shopping_cart),
            title: new Text('Your Orders'),
            onTap: () {
              Navigator.push(context, MaterialPageRoute(builder: (context) => Orders('Orders')));
            },
          ),
          ListTile(
            leading: Icon(Icons.assignment),
            title: new Text('Wishlist'),
            onTap: () {
              Navigator.push(context, MaterialPageRoute(builder: (context) => OrderWishlist('My Wishlist')));

            },
          ),
          ListTile(
            leading: Icon(Icons.account_circle),
            title: new Text('Your Account'),
            onTap: () {
              Navigator.push(context, MaterialPageRoute(builder: (context) => MyAccount('My Account')));

            },
          ),
          ListTile(
            leading: Icon(Icons.language),
            title: new Text('Languages'),
            onTap: () {
              Navigator.push(context, MaterialPageRoute(builder: (context) => AppLanguages('Languages')));
            },
          ),
          new Divider(color: Colors.grey,),

          InkWell(
            child: ListTile(
              leading: Icon(Icons.notifications),
              title: new Text('Your Notifications'),
              onTap: () {
                Navigator.push(context, MaterialPageRoute(builder: (context) => AppLanguages('Languages')));
              },
            ),
          ),
          ListTile(
            leading: Icon(Icons.settings),
            title: new Text('Settings'),
            onTap: () {
              Navigator.push(context, MaterialPageRoute(builder: (context) => Settings('Settings')));
              },
          ),
          ListTile(
            leading: Icon(Icons.exit_to_app),
            title: new Text('Log Out'),
            onTap: () {
              print('this feature is not yet available');
            },
          ),
        ],

      )
    );
  }
}
