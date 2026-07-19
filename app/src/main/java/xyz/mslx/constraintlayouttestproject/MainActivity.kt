package xyz.mslx.constraintlayouttestproject

import android.R.id.bold
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices.NEXUS_5
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import xyz.mslx.constraintlayouttestproject.ui.theme.ConstraintLayoutTestProjectTheme
import kotlin.math.ceil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConstraintLayoutTestProjectTheme {
                Column(Modifier.padding(top = 10.dp)) {
                    Profile()
                }
            }
        }
    }
    @Preview(device = NEXUS_5, showBackground = true, showSystemUi = true, widthDp = 360, heightDp = 983)
    @Composable
    fun Profile(){
        val topBar = ConstraintSet{
            val flash = createRefFor("flash")
            val name = createRefFor("name")
            val contact = createRefFor("contact")
            val edit = createRefFor("edit")

            constrain(flash){
                start.linkTo(parent.start, margin = 5.dp)
                bottom.linkTo(parent.bottom, margin = 15.dp)
            }
            constrain(name){
                start.linkTo(flash.end)
                bottom.linkTo(parent.bottom, margin = 15.dp)
            }
            constrain(contact){
                centerHorizontallyTo(parent)
                bottom.linkTo(parent.bottom, margin = 15.dp)
            }
            constrain(edit){
                end.linkTo(parent.end, margin = 15.dp)
                bottom.linkTo(parent.bottom, margin = 15.dp)
            }
        }
        val pic = ConstraintSet{
            val pic = createRefFor("pic")
            constrain(pic){
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        }
        val info = ConstraintSet{
            val name = createRefFor("userName")
            val number = createRefFor("number")
            val action = createRefFor("action")
            val line = createRefFor("line")
            val bio = createRefFor("bio")
            val dateCreateAccount = createRefFor("dateCreateAccount")
            constrain(name){
                top.linkTo(parent.top, margin = 15.dp)
                start.linkTo(parent.start, margin = 15.dp)
            }
            constrain(number){
                top.linkTo(name.bottom)
                start.linkTo(parent.start, margin = 15.dp)
            }
            constrain(action){
                end.linkTo(parent.end, margin = 15.dp)
                top.linkTo(parent.top, margin = 15.dp)
            }
            constrain(bio){
                top.linkTo(parent.top, margin = 10.dp)
                start.linkTo(parent.start, margin = 15.dp)
            }
            constrain(dateCreateAccount){
                top.linkTo(bio.bottom, margin = 3.dp)
                start.linkTo(parent.start, margin = 15.dp)
            }
        }
        val setting = ConstraintSet{
            val mediaIcon = createRefFor("mediaIcon")
            val mediaContent = createRefFor("mediaContent")
            val mediaCount = createRefFor("mediaCount")
            val mediaFlash = createRefFor("mediaFlash")
            constrain(mediaIcon) {
                top.linkTo(parent.top, margin = 15.dp)
                start.linkTo(parent.start, margin = 15.dp)
            }

            constrain(mediaContent) {
                top.linkTo(mediaIcon.top)
                bottom.linkTo(mediaIcon.bottom)
                start.linkTo(mediaIcon.end, margin = 10.dp)
            }

        }
        Column() {
            ConstraintLayout(
                topBar,
                Modifier
                    .height(60.dp)
                    .fillMaxWidth()
            )
            {
                Image(
                    painter = painterResource(R.drawable.flash),
                    null,
                    Modifier
                        .layoutId("flash")
                        .size(20.dp)
                )
                Text(
                    "Amin Ahmadi",
                    Modifier.layoutId("name"),
                    color = Color(0xff007AFF),
                    fontSize = 15.sp
                )
                Text("Contact Info", Modifier.layoutId("contact"), fontSize = 15.sp, fontWeight = FontWeight.Bold)

                Text("edit", Modifier.layoutId("edit"), fontSize = 15.sp, color = Color(0xff007AFF))
            }

            ConstraintLayout(
                pic,
                Modifier
                    .fillMaxWidth()
                    .height(375.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.profile),
                    null,
                    Modifier
                        .layoutId("pic")
                        .fillMaxSize()
                )
            }
            ConstraintLayout(
                info,
                Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ){
                Text("Amin Ahmadi", Modifier.layoutId("userName"), fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text("+989121234567", Modifier.layoutId("number"), fontSize = 12.sp, color = Color(0xff8E8E93))
                Image(
                    painter = painterResource(R.drawable.action),
                    null,
                    Modifier.layoutId("action").size(width = 132.dp, height = 36.dp)
                )

            }

            Box(Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp).background(color = Color.Gray).height(1.dp))

            ConstraintLayout(
                info,
                Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Text(
                    "Im the strongest person in the world",
                    Modifier
                        .layoutId("bio"),
                    fontSize = 15.sp
                )
                Text("July 19, 2026", Modifier.layoutId("dateCreateAccount"), fontSize = 12.sp, color = Color(0xff8E8E93))
            }
            ConstraintLayout(
                setting,
                Modifier
                    .fillMaxWidth()
                    .height(141.dp),
            ) {
                Image(
                    painter = painterResource(R.drawable.media),
                    null,
                    Modifier.layoutId("mediaIcon").size(29.dp)
                )
                Text("Media, Links, & Docs", Modifier.layoutId("mediaContent"), fontSize = 15.sp)
            }
        }
    }
}
