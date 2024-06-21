package com.example.techuni.ui.theme.screens.AboutTuk

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import com.example.techuni.R
import com.example.techuni.navigation.ROUTE_AWARDCOLLABORATION
import com.example.techuni.navigation.ROUTE_NEWS
import com.example.techuni.navigation.ROUTE_UNIVERSITY_PLAY_POLICY
import com.example.we_can.screens.actions.News
import com.example.we_can.screens.actions.Topic

val sampleNews = listOf(
    News(
        title = "Universities Play Critical Role in Big Data and Digitization Rollout",
        imageRes = R.drawable.news,
        description = "Partnership between universities and industry is critical in ensuring uptake of digital-based solutions in the processing of lands records in Kenya.\n" +
                "\n" +
                "The Technical University of Kenya (TU-K) VC Prof. Benedict Mutua, who was speaking during the 3rd Regional Research Conference themed; Data, Innovation and Technology for Land Governance said that the conference is taking place when the university has set up a base for big data research and quality information in land administration that is helpful in both private and public sectors.",
        navigateToRoute = ROUTE_UNIVERSITY_PLAY_POLICY,
        icons = listOf(
            Icons.Filled.Add,
            Icons.Filled.CheckCircle,
            Icons.Filled.Favorite)
    ),
    News(
        title = "68 Students Awarded Global Collaboration Certification",
        imageRes = R.drawable.st,
        description = "Sixty eight students from the Technical University of Kenya have been awarded the prestigious Global Collaboration certificate by X-Culture, a renowned business coaching organisation. The certificates were presented by Elizabeth Rose, a Research Chair Professor at X-Culture. The students had been trained for seven weeks. The training places students in top cadre in their careers; either in employment, business or in entrepreneurship.\n" +
                "\n" +
                "Prof. Rose who gave a lecture during the award ceremony at TU-K, said students or career persons acquire critical skills and unique experience that employers value in today’s business world. The Acting DVC – Academic, Research and Students, Prof. Francis Gatheri Ag. Dean, Faculty of Social Sciences and Technology, Prof. Tom Kwanya, DBAE Academic Team Leader, Prof. Vidijah Sagwa, together with ATL, Modern and Classical Languages Dr. Teresa Atieno Otieno attended the award ceremony.\n" +
                "\n" +
                "Dr. Lilian Ogendo, Senior Lecturer, in the Department of Business Administration and Entrepreneurship (DBAE) is the lead coordinator for X-culture in Kenya."
                ,
        navigateToRoute = ROUTE_AWARDCOLLABORATION,



        icons = listOf(
            Icons.Filled.CheckCircle,
            Icons.Filled.Add,
            Icons.Filled.Favorite
        )
    ),
    News(
        title = "TU-K signs MoU with Transilvania University of Brașov",
        imageRes = R.drawable.trans1,
        description ="The Technical University of Kenya recently has signed an MoU with Transilvania University of Brașov, Romania. The signing ceremony took place at the Romanian Embassy in Nairobi.  TU-K Vice-Chancellor Prof. Benedict Mutua and Transilvania University of Brașov Dean, Faculty of Furniture Design and Wood Engineering Prof. Alin OLĂRESCU signed the MoU on behalf of their respective institutions.\n" +
                "\n" +
                "Present during the event were the Romanian Ambassador to Kenya, H.E Gentiana Serbu, and TU-K Deputy Vice-Chancellor in-charge of Institutional Advancement and Enterprises (IAE) Prof. Paul Wambua, among other dignitaries.\n" +
                "\n" +
                "TU-K enjoys mutual relationship with the Embassy of Romania. The two have jointly taken part in various activities among them; ‘The Romanian International Day for Cultural Diversity and Development, held in Nairobi from 21st May.’ The event exhibited cultural heritage and traditions from Kenya and Romania. Music, dance and art defined the occasion.",
        icons = listOf(
            Icons.Filled.CheckCircle,
            Icons.Filled.Add,
            Icons.Filled.Favorite

        ),
        navigateToRoute = ROUTE_AWARDCOLLABORATION
    ),





)
