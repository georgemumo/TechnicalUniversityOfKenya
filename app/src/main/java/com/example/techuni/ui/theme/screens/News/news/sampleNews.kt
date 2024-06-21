package com.example.techuni.ui.theme.screens.AboutTuk

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.techuni.R
import com.example.techuni.navigation.ROUTE_AWARDCOLLABORATION
import com.example.techuni.navigation.ROUTE_KENYAROM
import com.example.techuni.navigation.ROUTE_UNIVERSITY_PLAY_POLICY
import com.example.we_can.screens.actions.News


val sampleNews = listOf(
    News(
        title = "Universities Play Critical Role in Big Data and Digitization Rollout",
        imageRes = R.drawable.news,
        description = "Partnership between universities and industry is critical in ensuring uptake of digital-based solutions in the processing of lands records in Kenya.\n" +
                "\n" +
                "The Technical University of Kenya (TU-K) VC Prof. Benedict Mutua, who was speaking during the 3rd Regional Research Conference themed; Data, Innovation and Technology for Land Governance said that the conference is taking place when the university has set up a base for big data research and quality information in land administration that is helpful in both private and public sectors.",

        icons = listOf(
            Icons.Filled.Add,
            Icons.Filled.CheckCircle,
            Icons.Filled.Favorite),
        navigateToRoute = ROUTE_UNIVERSITY_PLAY_POLICY
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
        title ="Friendship through Culture; Kenyan-Roman Collaboration" ,
        imageRes = R.drawable.kenyaroman,
        description = "  Students from the Technical University of Kenya (TU-K) and Universities from Romania participated in a conference and workshop discussions to commemorate the “World Day for Cultural Diversity for Dialogue and Development”./n+\n" +
                "        The cultural exchange is mainly to strengthen multiculturalism and promote the rich traditions of masks across different cultures, with an aim to promote peace and tolerance./n+/n+\n" +
                "        The event was jointly organised by TU-K and Romania Embassy in Kenya. The activities for the day included music, theatre, and traditional dances with masks. These series of activities would mark friendship and partnership between Romania and Kenya./n+/n+\n" +
                "        Distinguished guests who graced the occasion, included Romania Ambassador to Kenya H.E. Mrs. Gentiana Serbu, Serbia Ambassador to Kenya H.E. Ms. Danijela Cubrilo Martic, the VC, Prof, Benedict Mutua, DVC in charge of Institutional Advancement and Enterprises Prof. Paul Wambua, DVC in charge of Research and Technology Advancement Prof. Alfred Orina, Ag. DVC in charge of Students Academics and Affairs Prof. Francis Gatheri./n+/n+\n" +
                "        Presentations with cultural significance and historical contexts made included, “Ritual masks from Serbia former and living tradition” by Mr. Natasa Mladenovic Ribic, the Curator, Centre for the Intangible Cultural Heritage at Ethnographic Museum, Serbia. “Romanian Masks- ancient traditions” by Mr. Virgil Nitulescu, Manager of National Museum of the Romanian Peasant. “Community engagement in developing Kenyan Culture” by Dr. Lydia Muthuma, Senior Lecture, Visual Arts and Photography, TU-K and Mr. Ovidiu Baron, the Deputy Manager of Astra Museum./n+/n+\n" +
                "        In his remarks, the VC, Prof Benedict Mutua welcomed the guests and commended the team that organised the event. Prof. Mutua acknowledged the importance of the event usually commemorated annually on 21st May./n+/n+\n" +
                "        “It is indeed a very important day because it reminds us of the importance of our different cultures, every year the world heritage looks at themes that brings us close to various cultures to discover and experience diversity,” he continued./n+/n+\n" +
                "        H.E. Mrs. Gentiana Serbu, acknowledged the historical significance of the day and gave a brief history of Romania during communist time, how tens of thousands of students from Africa would go there for studies.",
        navigateToRoute = ROUTE_KENYAROM ,
        icons =listOf(
            Icons.Filled.CheckCircle,
            Icons.Filled.Add,
            Icons.Filled.Favorite

        ) ,
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
