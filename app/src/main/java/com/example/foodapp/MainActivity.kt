package com.example.foodapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listOfFoods = ArrayList<Food>()
    var adapter: FoodAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        load food
        listOfFoods.add(Food("Coffee pot", "A carafe /kəˈræf/ is a glass container without handles used for serving wine and other drinks. Unlike the related decanter, carafes do not include stoppers. Coffee pots included in coffee makers are also referred to as carafes in American English. In France, carafes are commonly used to serve water", R.drawable.coffee_pot))
        listOfFoods.add(Food("Coffee", "It is made by forcing pressurized hot water through very finely ground coffee beans using an espresso machine", R.drawable.espresso))
        listOfFoods.add(Food("French fries", "French-fried potatoes, are batonnet or allumette-cut deep-fried potatoes", R.drawable.chip))
        listOfFoods.add(Food("Honey", "Honey is a sweet, viscous food substance made by honey bees and some related insects", R.drawable.honey))
        listOfFoods.add(Food("Strawberry ice-cream", "Strawberry ice cream is a flavor of ice cream made with strawberry or strawberry flavoring.", R.drawable.strawberry))
        listOfFoods.add(Food("Sugar cubes", "A small cube of compacted sugar used especially for sweetening hot drinks; a sugar lump.", R.drawable.cubes))

        adapter = FoodAdapter(this, listOfFoods)
        gvListFood.adapter = adapter
    }

    class FoodAdapter: BaseAdapter {

        var listOfFood = ArrayList<Food>()
        var context: Context ?= null
        constructor(context: Context, listOfFood: ArrayList<Food>):super(){
            this.context = context
            this.listOfFood = listOfFood
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var food = this.listOfFood[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflator.inflate(R.layout.food_ticket, null)
            foodView.ivFoodImage.setImageResource(food.image!!)
            foodView.tvName.text = food.name
            return foodView
        }

        override fun getItem(position: Int): Any {
            return listOfFood[position]
        }

        override fun getItemId(position: Int): Long {
           return position.toLong()
        }

        override fun getCount(): Int {
            return listOfFood.size
        }

    }
}