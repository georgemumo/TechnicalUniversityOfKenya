package com.example.techuni.ui.theme.screens.News

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.techuni.R

@Composable
fun GermanyScreen(navController: NavController){
    Column (
        modifier = Modifier
            .background(color = Color.White)
            .verticalScroll(rememberScrollState())
    ){
    Image(painter = painterResource(id = R.drawable.germany), contentDescription = "")
        Text(text = "The dream of young Kenyans getting employment opportunities in Germany may soon become a reality.  Mr. Volker Falch, Managing Director Head of International Division, Bildungswerk der Bayerischen Wirtschaft (BBW) International, explained that there is a high demand for young, well trained and talented Kenyans to work in Germany.Mr. Falch disc losed this when he recently paid a courtesy call to the Technical University of Kenya (TU-K), accompanied by Ms Aurelia Starringer, the Team Lead Migration.\n" +
                "\n" +
                " The delegation explained that Germany universities teach professional skills as well as collaborate with local industries to ensure that education is aligned with the market needs. The duo told the University Management that their company had been engaged with all aspects of vocational training for almost 50 years, in international projects and therefore together with experts and other partners, can tackle different key topics.\n" +
                "\n" +
                "The MD explained that his company acts as a link between the industry and potential employees (graduates) from other countries. That, they were interested in working with TU-K in identifying and recruiting student graduates who would love to work in Germany.\n" +
                "\n" +
                " “We seek to identify and partner with Kenyan academic and industry, inform them about the Germany companies having employment opportunities for young people. These students must have graduated, are competent and possess requisite skills and knowledge required by Germany companies and industries,” he said.\n" +
                "\n" +
                "The Vice-Chancellor Prof. Benedict Mutua welcomed the delegation and observed that the Germany model of training engineers is a motivation that forms the basis of TU-K’s drive, to be the hub of technologists’ training within the Eastern African region.\n" +
                "\n" +
                "He added that Germany has high level of labour ethics and a workforce that is well structured. Therefore he was confident that TU-K students would love to work there.\n" +
                "\n" +
                " He emphasised that the University takes serious hands-on training and that it is committed to partnering with the industry in nurturing talents and training highly skilled graduates who will change the region.\n" +
                "\n" +
                "Deputy Vice-Chancellor in-charge of Institutional Advancement and Enterprises (IAE) Prof. Paul Wambua, explained that Industry –Based Learning (IBL) programme is a revolutionary plan by the University’s Faculties to have learners, and in some cases, members of staff, go to industry to sharpen their skills in the real world.\n" +
                "\n" +
                "Present during the meeting were; Ag. Executive Dean Faculty of Engineering and the Built Environment (FEBE) Prof. Cleophas Maende, Ag. Director Entrepreneurial University and Resource Mobilization (IAE) Prof. Mugera Gitari, Dean of students Prof. Omondi Oketch, Ag. Director, School of Mechanical and Manufacturing Engineering, Dr. Fredrick Mutua.")
        Image(painter = painterResource(id = R.drawable.germany1), contentDescription = "")
        Text(text = "Dave Yator, BBW Kenya Representative, urged students to acquaint themselves with the Germany language saying it is a requisite requirement for potential employees.\n" +
                "\n" +
                "Prof. Oketch observed that TU-K students are well trained and would love to work in a developed country like Germany. He added that the students will be informed, adequately prepared and that their profiles sent to BBW. ")
    }

}
