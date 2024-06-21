package com.example.techuni

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.techuni.navigation.AppNavHost
import com.example.techuni.navigation.navigation.DrawerItem
import com.example.techuni.navigation.navigation.NavDrawerItem
import com.example.techuni.navigation.navigation.TopBar
//import com.apk.george.navigation.AppNavHost
//import com.apk.george.ui.theme.GeorgeTheme
import com.example.techuni.ui.theme.TechUniTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TechUniTheme{
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}
@Composable
fun MainScreen(){
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(androidx.compose.material.DrawerValue.Closed))
    val navController = rememberNavController()
    AppNavHost(navController = navController)
     CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

}
}
@Preview
@Composable
fun GreetingPreview() {
    TechUniTheme {
        MainScreen()

    }
    }
@Composable
fun Drawer(scope: CoroutineScope,scaffoldState: ScaffoldState,navController: NavController){
    val items = listOf(
        NavDrawerItem.Home,
        NavDrawerItem.Music,
        NavDrawerItem.News,
        NavDrawerItem.Schools,
        NavDrawerItem.StudentCouncil,
        NavDrawerItem.hostels,
        NavDrawerItem.notices,
        NavDrawerItem.Perfomance,
    )
    Column (
        modifier = Modifier.background(colorResource(id = R.color.purple_200))
    ){
        Image(
            painter = painterResource(id = R.drawable.logo1)
            , contentDescription = R.drawable.logo1.toString(),
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .padding(10.dp)
            )
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(5.dp))
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
/*Add codes for items*/
        items.forEach { item ->
            DrawerItem(item = item, selected = currentRoute == item.route, onItemClick = {
                navController.navigate(item.route) {
                    // Pop up to the start destination of the graph to
                    // avoid building up a large stack of destinations
                    // on the back stack as users select items
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    // Avoid multiple copies of the same destination when
                    // reselecting the same item
                    launchSingleTop = true
                    // Restore state when reselecting a previously selected item
                    restoreState = true
                }
                // Close drawer
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            })
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Technical University Of Kenya",
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.CenterHorizontally)
            )

    }
}


@Preview(showBackground = true)
@Composable
fun DrawerPreview() {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(androidx.compose.material.DrawerValue.Closed))
    val navController = rememberNavController()
    Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
}
