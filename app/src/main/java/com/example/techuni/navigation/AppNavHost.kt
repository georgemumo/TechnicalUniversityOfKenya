package com.example.techuni.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.apk.george.ui.theme.screens.HOME.HomeScreen
import com.apk.george.ui.theme.screens.login.LoginScreen
import com.apk.george.ui.theme.screens.registration.RegistrationScreen
import com.example.techuni.navigation.navigation.NavDrawerItem
import com.example.techuni.navigation.navigation.NavigationItem
import com.example.techuni.ui.theme.screens.About.AboutTUKScreen
import com.example.techuni.ui.theme.screens.News.NewsScreen
import com.example.techuni.ui.theme.screens.hostels.HostelsScreen
import com.example.techuni.ui.theme.screens.schools.SchoolsScreen
import com.example.techuni.ui.theme.screens.studentCouncil.StudentCoucilScreen


@Composable
fun AppNavHost(modifier: Modifier = Modifier,
               navController: NavHostController = rememberNavController(),
               startDestination: String= ROUTE_HOME){
    NavHost(navController = navController,
        modifier = modifier,
        startDestination = startDestination ){
//        composable(ROUTE_ONBOARDING){ OnboardingScreen(navController)}
//        composable(ROUTE_GALLERY){ GalleryScreen(navController)}
//        composable(ROUTE_ABOUTUS){ AboutUsScreen(navController) }
        composable(ROUTE_REGISTER){ RegistrationScreen(navController) }
        composable(NavigationItem.Home.route){ HomeScreen(navController) }
//        composable(NavigationItem.Action.route){ TopicList(topic = sampleTopics, navController) }
        composable(NavDrawerItem.Home.route){
            HomeScreen(navController)
        }
        composable(NavDrawerItem.News.route){
            NewsScreen(navController)
        }
        composable(NavDrawerItem.Schools.route){
            SchoolsScreen(navController)
        }
        composable(NavDrawerItem.hostels.route){
            HostelsScreen(navController)
        }
        composable(NavDrawerItem.Music.route){
            AboutTUKScreen(navController)
        }
        composable(NavDrawerItem.StudentCouncil.route){
            StudentCoucilScreen(navController)
        }
        composable(ROUTE_LOGIN){ LoginScreen(navController) }
//        composable(ROUTE_REASONS){ ReasonsScreen(navController) }
        composable(ROUTE_HOME){ HomeScreen(navController)}
//        composable(ROUTE_ADD_TASK){ AddProductsScreen(navController)}
//        composable(ROUTE_VIEW_TASK){ ViewTasksScreen(navController)}
//        composable(ROUTE_UPDATE_TASK+"/{id}"){
//                passedData-> UpdateProductsScreen(
//            navController,passedData.arguments?.getString("id")!!
//        )
//        }
//        composable(ROUTE_VIEW_UPLOAD){
//            ViewUploadsScreen(navController)
//        }

    }

}