package com.example.techuni.navigation

//import ImageCarousel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.techuni.ui.theme.screens.HOME.HomeScreen
import com.apk.george.ui.theme.screens.login.LoginScreen
import com.apk.george.ui.theme.screens.registration.RegistrationScreen
import com.example.myapplication.ui.theme.HJ.MainScreen
//import com.example.techuni.ui.theme.screens.studentsSupport.MainScreen1
//import com.example.techuni.SplashScreen
//import com.example.techuni.SplashScreen
import com.example.techuni.navigation.navigation.NavDrawerItem
import com.example.techuni.navigation.navigation.NavigationItem
//import com.example.techuni.ui.theme.screens.ADD.AddScreen
//import com.example.techuni.ui.theme.screens.ADD.MyApp1
//import com.example.techuni.ui.theme.screens.About.AboutTUKScreen
import com.example.techuni.ui.theme.screens.HOME.AddScreen
import com.example.techuni.ui.theme.screens.notices.NoticesScreen
//import com.example.techuni.ui.theme.screens.News.NoticesScreen
import com.example.techuni.ui.theme.screens.News.PhotosTaken
import com.example.techuni.ui.theme.screens.News.UniversityPlayScreen
import com.example.techuni.ui.theme.screens.AboutTuk.AboutTUK
import com.example.techuni.ui.theme.screens.AboutTuk.NewsAboutTUK
import com.example.techuni.ui.theme.screens.AboutTuk.sampleNews
import com.example.techuni.ui.theme.screens.AboutTuk.sampleTopics
import com.example.techuni.ui.theme.screens.HOME.UniversityCouncil
import com.example.techuni.ui.theme.screens.News.ForeignScholars
import com.example.techuni.ui.theme.screens.News.ForestScreen
import com.example.techuni.ui.theme.screens.News.GermanyScreen
import com.example.techuni.ui.theme.screens.News.KenyaRomScreen
import com.example.techuni.ui.theme.screens.News.KenyaRomanPhotos
import com.example.techuni.ui.theme.screens.News.PhotosonAwardCollaboration
import com.example.techuni.ui.theme.screens.News.news.AwardCollaboration
import com.example.techuni.ui.theme.screens.News.news.TransNewsScreen
import com.example.techuni.ui.theme.screens.News.news.TransviewPhotos
import com.example.techuni.ui.theme.screens.NewsScreen
import com.example.techuni.ui.theme.screens.UONnews.UONLIST
import com.example.techuni.ui.theme.screens.UONnews.UonNewsTopics
//import com.example.techuni.ui.theme.screens.News.Accordion.NewsContent
//import com.example.techuni.ui.theme.screens.News.news.NewsAccordionItem
//import com.example.techuni.ui.theme.screens.News.news.sampleNews
import com.example.techuni.ui.theme.screens.events.EventListScreen
import com.example.techuni.ui.theme.screens.events.EventScreen
//import com.example.techuni.ui.theme.screens.events.MyApp
//import com.example.techuni.ui.theme.screens.News.NewsScreen
import com.example.techuni.ui.theme.screens.hostels.HostelsScreen
import com.example.techuni.ui.theme.screens.notices.RetrieveNoticesScreen
import com.example.techuni.ui.theme.screens.notices.SaveNoticeScreen
//import com.example.techuni.ui.theme.screens.notices.RetrieveAnnouncementScreen
//import com.example.techuni.ui.theme.screens.notices.SaveAnnouncementScreen
import com.example.techuni.ui.theme.screens.people.MutuasProfileScreen
//import com.example.techuni.ui.theme.screens.perfomance.AddStudentScreen
import com.example.techuni.ui.theme.screens.perfomance.AppliedScienceAndTechnology
import com.example.techuni.ui.theme.screens.perfomance.crudonperfomance.AddStudentScreen
//import com.example.techuni.ui.theme.screens.perfomance.PerfomanceScreen
import com.example.techuni.ui.theme.screens.perfomance.crudonperfomance.ViewStudentsScreen
import com.example.techuni.ui.theme.screens.schools.SchoolsScreen
import com.example.techuni.ui.theme.screens.studentsSupport.supportaccordionm.StudentSupport
import com.example.techuni.ui.theme.screens.studentsSupport.supportaccordionm.sampleSubjects
//import com.example.techuni.ui.theme.screens.splash.SplashScreen
//import com.example.techuni.ui.theme.screens.studentCouncil.StudentCoucilScreen
import com.example.techuni.ui.theme.screens.video.VideoScreen
import com.example.we_can.SplashScreen

//import com.example.we_can.navigation.ROUTE_SPLASH


@Composable
fun AppNavHost(modifier: Modifier = Modifier,
               navController: NavHostController = rememberNavController(),
               startDestination: String=  ROUTE_HOME){
    NavHost(navController = navController,
        modifier = modifier,
        startDestination = startDestination )
    {

        composable(ROUTE_LOGIN){ LoginScreen(navController) }
//        composable(ROUTE_ADDEVENTSCREEN){ EventScreen(navController )}
        composable(ROUTE_EVENTLISTSCREEN){ EventListScreen(navController )}
        composable(ROUTE_ADDEVENTSCREEN){EventScreen(navController)}
        composable(ROUTE_FOREST){ ForestScreen(navController)}
        composable(ROUTE_UNIVERSITY_PLAY_POLICY){ UniversityPlayScreen(navController)}
        composable(ROUTE_UONLIST){ UONLIST(uonNews = UonNewsTopics, navController  )}
//        composable(ROUTE_CONFRENCESCREEN){ ConfrenceScreen(navController)}
        composable(ROUTE_TRANSVIEWSCREEN){ TransNewsScreen(navController)}
        composable(ROUTE_NEWS){ NewsScreen(navController )}
        composable(ROUTE_FOREIGNSCHOLARS){ ForeignScholars(navController )}
        composable(ROUTE_TRANSVIEWPHOTOS){ TransviewPhotos(navController)}
//        composable( ROUTE_SAVE_ANNOUNCEMENT){ SaveAnnouncementScreen(navController )}
//        composable(ROUTE_RETRIEVE_ANNOUNCEMENT){ RetrieveAnnouncementScreen(navController)}
//        composable(ROUTE_NEWSCONTENT){ NewsContent(navController )}
//        composable(ROUTE_ABOUTSCREEN){ AboutTUKScreen(navController )}
        composable(ROUTE_ACCORDION_ITEM){ AboutTUK(topic = sampleTopics, navController) }
//        composable(ROUTE_NEWSACCORDIONITEM){ NewsAccordionItem( )}
        composable(ROUTE_KENYAROM){ KenyaRomScreen(navController)}
        composable(ROUTE_ADDSTUDENTSCREEN){ AddStudentScreen(viewModel(),navController) }
        composable(ROUTE_VIEWSTUDENTSCREEN){ ViewStudentsScreen(viewModel(),navController) }
        composable(ROUTE_KENYAROMPHOTOS){ KenyaRomanPhotos(navController )}
        composable(ROUTE_NEWSABOUTTUK){ NewsAboutTUK(news = sampleNews, navController  )}
        composable(ROUTE_UNIVERSITYCOUNCIL){ UniversityCouncil(navController)}
        composable(ROUTE_SAVENOTICE){ SaveNoticeScreen(navController )}
        composable(ROUTE_RETRIEVENOTICE){ RetrieveNoticesScreen(navController )}
        composable(ROUTE_PHOTOSTAKENONAWARDCOLLABORATION){ PhotosonAwardCollaboration(navController)}
        composable(ROUTE_AWARDCOLLABORATION){ AwardCollaboration(navController )}
        composable(ROUTE_PHOTOSTAKEN){ PhotosTaken(navController )}
        composable(ROUTE_VIDEOSCREEN){ VideoScreen(navController )}
//        composable(ROUTE_NEWS){ NewsScreen(navController )}
        composable(ROUTE_SCHOOLS){ SchoolsScreen(navController )}
        composable(ROUTE_GERMANY){ GermanyScreen(navController)}

        composable("mainScreen") {
            MainScreen(navController)
        }
      composable(ROUTE_STUDENTSUPPORT){ StudentSupport(support = sampleSubjects, navController )}

//        composable("screen1") {
//            Screen1()
//        }
//        composable("screen2") {
//            Screen2()
//        }
//        composable("screen3") {
//            Screen3()
//        }
//        composable("screen4") {
//            Screen4()
//        }
        composable(ROUTE_APPLIED_SCIENCE_AND_TECHNOLOGY) {
            AppliedScienceAndTechnology(navController)
        }
//        composable("screen2") {
//            Screen2()
//        }
//        composable("screen3") {
//            Screen3()
//        }
//        composable("screen4") {
//            Screen4()
//        }


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
        composable(NavDrawerItem.Support.route){
            StudentSupport(support = sampleSubjects, navController )
        }
        composable(NavDrawerItem.Perfomance.route){
            MainScreen(navController)
        }
        composable(ROUTE_NOTICES){ NoticesScreen(navController) }

        composable(NavDrawerItem.Schools.route){
            SchoolsScreen(navController)
        }
    composable(ROUTE_SPLASH){ SplashScreen(navController ) }
    composable(NavDrawerItem.News.route){
        NewsScreen(navController )
    }
        composable(NavDrawerItem.hostels.route){
            HostelsScreen(navController)
        }
        composable(NavDrawerItem.Music.route){
            AboutTUK(topic = sampleTopics , navController  )
        }
        composable(NavDrawerItem.StudentCouncil.route){
            UniversityCouncil(navController)
        }
        composable(NavigationItem.ADD.route){
            AddScreen(navController )
        }


    }

}