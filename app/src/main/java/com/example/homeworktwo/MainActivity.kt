package com.example.homeworktwo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


val digs = arrayOf(
    "None",
    "ერთი",
    "ორი",
    "სამი",
    "ოთხი",
    "ხუთი",
    "ექვსი",
    "შვიდი",
    "რვა",
    "ცხრა",
)
val digs2 = arrayOf(
    "ათი",
    "თერთმეტი",
    "თორმეტი",
    "ცამეტი",
    "თოთხმეტი",
    "თხუთმეტი",
    "თექვსმეტი",
    "ჩვიდმეტი",
    "თვრამეტი",
    "ცხრამეტი"
)

val tens = arrayOf(
    "",
    "",
    "ოცი",
    "ოცდაათი",
    "ორმოცი",
    "ორმოცდაათი",
    "სამოცი",
    "სამოცდაათი",
    "ოთხმოცი",
    "ოთხმოცდაათი",

    )
val tens2 = arrayOf(

    "",
    "",
    "ოცდა",
    "ოცდა",
    "ორმოცდა",
    "ორმოცდა",
    "სამოცდა",
    "სამოცდა",
    "ოთხმოცდა",
    "ოთხმოცდა"
)



val huns = arrayOf(
    "",
    "ასი",
    "ორასი",
    "სამასი",
    "ოთხასი",
    "ხუთასი",
    "ექვსასი",
    "შვიდასი",
    "რვაასი",
    "ცხრაასი",
)

val huns2 = arrayOf(

    ""
    , "ას"
    , "ორას"
    , "სამას"
    , "ოთხას"
    ,"ხუთას"
    , "ექვსას"
    , "შვიდას"
    , "რვაას"
    ,"ცხრაას"
)
//onedigit start
fun oneDigits(digit:String): String{
    if (digit.length == 1) {
        return digs[digit.toInt()]
    }else return "NONE"
}

//onedigit end
//twodigit start
fun twoDigits(digit:String): String {
    if (digit.length == 2) {

        if (digit[0] == '1') {
            return digs2[digit[1].toString().toInt()]
        } else if (digit[1].toString().toInt() == 0) {
            return tens[digit[0].toString().toInt()]
        } else if (digit[0].toString().toInt() % 2 != 0) {
            return tens2[digit[0].toString().toInt()] + " " + digs2[digit[1].toString().toInt()]
        } else if (digit[0].toString().toInt() % 2 == 0) {
            return tens2[digit[0].toString().toInt()] + " " + digs[digit[1].toString().toInt()]
        }
    }

    return "error"
}
//twodigit end
//threedigit start
fun threeDigits(digit:String): String{
    if (digit.substring(1,3)  == "00"){
        return huns[digit[0].toString().toInt()]
    }else {
        return  huns2[digit[0].toString().toInt()] +" " + twoDigits(digit.substring(1,3).toString())

    }

}
//threedigit end

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView:TextView = findViewById(R.id.textView)
        val editTextNumber: EditText = findViewById(R.id.editTextNumber)
        val button: Button = findViewById(R.id.button)


        button.setOnClickListener{
            val input = editTextNumber.text.toString()
//            Toast.makeText(this, input, Toast.LENGTH_SHORT).show()
            if (input.length == 1){
                textView.setText(oneDigits(input))
            }else if(input.length == 2 ){
                textView.setText(twoDigits(input))
            }else if (input.length == 3){
                textView.setText(threeDigits(input))
            }else if(input == "1000"){
                textView.setText("ათასი")
            }
            else{

                textView.setText("გთხოვთ შეიყვანოდ მხოლოდ რიცხვები 1 დან 1000-ის ჩათვლით")
            }
        }





    }
}