package com.example.techuni.navigation

//import ImageCarousel
import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.techuni.ui.theme.screens.HOME.HomeScreen
import com.apk.george.ui.theme.screens.login.LoginScreen
import com.apk.george.ui.theme.screens.registration.RegistrationScreen
import com.example.techuni.R
import com.example.techuni.SplashScreen
//import com.example.techuni.SplashScreen
import com.example.techuni.navigation.navigation.NavDrawerItem
import com.example.techuni.navigation.navigation.NavigationItem
//import com.example.techuni.ui.theme.screens.ADD.AddScreen
//import com.example.techuni.ui.theme.screens.ADD.MyApp1
import com.example.techuni.ui.theme.screens.About.AboutTUKScreen
import com.example.techuni.ui.theme.screens.HOME.AddScreen
import com.example.techuni.ui.theme.screens.News.ConfrenceScreen
import com.example.techuni.ui.theme.screens.News.NewsScreen
import com.example.techuni.ui.theme.screens.News.NoticesScreen
import com.example.techuni.ui.theme.screens.News.PhotosTaken
import com.example.techuni.ui.theme.screens.News.UniversityPlayScreen
import com.example.techuni.ui.theme.screens.events.EventListScreen
import com.example.techuni.ui.theme.screens.events.EventScreen
//import com.example.techuni.ui.theme.screens.events.MyApp
//import com.example.techuni.ui.theme.screens.News.NewsScreen
import com.example.techuni.ui.theme.screens.hostels.HostelsScreen
import com.example.techuni.ui.theme.screens.people.MutuasProfileScreen
import com.example.techuni.ui.theme.screens.schools.SchoolsScreen
//import com.example.techuni.ui.theme.screens.splash.SplashScreen
import com.example.techuni.ui.theme.screens.studentCouncil.StudentCoucilScreen
import com.example.techuni.ui.theme.screens.video.VideoScreen

//import com.example.we_can.navigation.ROUTE_SPLASH


@Composable
fun AppNavHost(modifier: Modifier = Modifier,
               navController: NavHostController = rememberNavController(),
               startDestination: String= ROUTE_ADDEVENT){
    NavHost(navController = navController,
        modifier = modifier,
        startDestination = startDestination ){

        composable(ROUTE_LOGIN){ LoginScreen(navController) }
        composable(ROUTE_EVENTS) { EventListScreen(navController) }
        composable(ROUTE_ADDEVENT) { EventScreen(navController) }
//        composable(ROUTE_NOTICES){ NoticesScreen(navController )}
        composable(ROUTE_UNIVERSITY_PLAY_POLICY){ UniversityPlayScreen(navController)}
        composable(ROUTE_CONFRENCESCREEN){ ConfrenceScreen(navController)}
//        composable(ROUTE_EVENTS){ MyApp(navController)}
        composable(ROUTE_ABOUTSCREEN){ AboutTUKScreen(navController )}
//        composable(ROUTE_MYAPP){ MyApp1(navController ) }
        composable(ROUTE_PHOTOSTAKEN){ PhotosTaken(navController )}
        composable(ROUTE_VIDEOSCREEN){ VideoScreen(navController )}
        composable(ROUTE_NEWS){ NewsScreen(navController )}
        composable(ROUTE_SCHOOLS){ SchoolsScreen(navController )}
        composable(ROUTE_STUDENTCOUNCIL){ StudentCoucilScreen(navController )}
        composable(ROUTE_ADD){ AddScreen(navController)
//
        }

        composable(ROUTE_HOME){ HomeScreen(navController) }
        composable(ROUTE_REGISTER){ RegistrationScreen(navController) }
        composable(NavigationItem.Home.route){ HomeScreen(navController) }
        composable(ROUTE_MUTUAS){ MutuasProfileScreen(navController)}
        composable(NavDrawerItem.Home.route){
            HomeScreen(navController)
        }
        composable(NavDrawerItem.notices.route){
            NoticesScreen(navController )
        }
//        composable(NavDrawerItem.News.route){
//            NewsScreen(navController)
//        }
        composable(NavDrawerItem.Schools.route){
            SchoolsScreen(navController)
        }
    composable(ROUTE_SPLASH){ SplashScreen(navController )}
//        composable(ROUTE_SPLASH){ SplashScreen(navController )}
        composable(NavDrawerItem.hostels.route){
            HostelsScreen(navController)
        }
        composable(NavDrawerItem.Music.route){
            AboutTUKScreen(navController)
        }
        composable(NavDrawerItem.StudentCouncil.route){
            StudentCoucilScreen(navController)
        }
        composable(NavigationItem.ADD.route){
            AddScreen(navController )
        }


    }

}