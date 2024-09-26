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
import com.example.techuni.navigation.ROUTE_FOREIGNSCHOLARS
import com.example.techuni.navigation.ROUTE_FOREST
import com.example.techuni.navigation.ROUTE_GERMANY
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
        title ="TU-K Students to Access Jobs in Germany" ,
        imageRes =R.drawable.germany ,
        description = "The dream of young Kenyans getting employment opportunities in Germany may soon become a reality.  Mr. Volker Falch, Managing Director Head of International Division, Bildungswerk der Bayerischen Wirtschaft (BBW) International, explained that there is a high demand for young, well trained and talented Kenyans to work in Germany.Mr. Falch disc losed this when he recently paid a courtesy call to the Technical University of Kenya (TU-K), accompanied by Ms Aurelia Starringer, the Team Lead Migration.\n" +
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
                "Present during the meeting were; Ag. Executive Dean Faculty of Engineering and the Built Environment (FEBE) Prof. Cleophas Maende, Ag. Director Entrepreneurial University and Resource Mobilization (IAE) Prof. Mugera Gitari, Dean of students Prof. Omondi Oketch, Ag. Director, School of Mechanical and Manufacturing Engineering, Dr. Fredrick Mutua.",

        navigateToRoute = ROUTE_GERMANY,
        icons = listOf(
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
    News(
        title = "Foreign Scholars Speak at Students’ Event",
        imageRes = R.drawable.forei1,
        description = "The Institute of Electrical and Electronic Engineers (IEEE) of the Technical University of Kenya student branch, on Friday 17 th May 2024 held a workshop that was addressed by distinguished academics from recognized universities globally. TU-K joined the world’s largest Technical Professional Organization IEEE, in the year 2020 and became the 7th University in Kenya to be a member of the Association. The international academics included; Prof. Atif Samim from Saudi Arabia, Prof. Cristiano Tomassoni from Italy, Prof. Carlos Lopez Martinez from Spain and Prof. Shiban Koul from India.",
        icons =listOf(
            Icons.Filled.CheckCircle,
            Icons.Filled.Add,
            Icons.Filled.Favorite

        ) ,
        navigateToRoute = ROUTE_FOREIGNSCHOLARS,
    ),
    News(
        title = "TU-K Partners with KFS to Increase Tree Cover",
        imageRes =R.drawable.cover ,
        description = "The Technical University of Kenya has partnered with the Kenya Forestry Service (KFS) in a joint effort to grow tree seedlings. The initiative will greatly contribute towards the Government’s target of planting 15 billion trees in 10 years.\n" +
                "\n" +
                "On 10th May 2024, The University, together with KFS, for the second time, jointly planted 1200 tree seedlings at Konza Technopolis City consisting an assortment of indigenous trees. The day had been declared a public holiday by the Government for Kenyans to plant trees and also to honour people who lost lives during the recent flashfloods.",
        icons =listOf(
            Icons.Filled.CheckCircle,
            Icons.Filled.Add,
            Icons.Filled.Favorite

        )  ,
        navigateToRoute = ROUTE_FOREST,
    ),
    News(
        title = "TUKAA Holds Inaugural Board Meeting",
        imageRes = R.drawable.meet,
        description = "The Technical University of Kenya Alumni Association (TUKAA) held its inaugural board meeting on 2nd May 2024 in the conference room.The main agenda of the meeting was to welcome the newly-appointed members and deliberate on the best way forward for the Association. The meeting culminated in the election of the Board Chairman, Eng. Robert Juma Wamalwa.\n" +
                "\n" +
                "The Board is expected to provide oversight in the operations, and functions of TUKAA, including among many other functions, coordinating an AGM that will elect the association’s substantive officials and promote the reputation/well-being of the University including fundraising, among other responsibilities.\n" +
                "\n" +
                "The Board members include Prof. Paul Wambua, Prof. Cleophas Maende, Prof. Sylvester Masu, Prof. Dorcas Yole, Dr. Mary Ahuna, Eng. Robert Juma Wamalwa, Ms. Fausta Mburu Njiru, Mr. Nzau Musau and Ms. Jane Bukachi.\n" +
                "\n" +
                "In his acceptance speech, Eng. Wamalwa expressed his appreciation stating that it was an honour to be entrusted with such a responsibility. He assured the members that he would harness the strength to drive meaningful impact in the Association.\n" +
                "\n" +
                "“I would like to extend my heartfelt gratitude to the Management and Staff of TU-K for their contribution towards this day. Of course, none of this would be possible without our alumni community, TUKAA,” he said.\n" +
                "\n" +
                "Speaking during the meeting, the Secretary to the Board, Prof. Wambua appreciated the Alumni for their support and commitment. He particularly recognised the effort and sacrifices of the Association's officials to ensure the Board was in place.\n" +
                "\n" +
                "He commended the Board members for attending the inaugural meeting noting that, it indeed showed their commitment to the Association. He further reaffirmed the institution's commitment to the TUKAA’s goals and objectives.\n" +
                "\n" +
                "“The University management is in full support of this board. I assure you that we will walk with the board every step of the way to ensure all the functions are operational and running,” he said.\n" +
                "\n" +
                "In attendance were members of the Alumni Secretariat, Mr. Maurice Fox Okungu, Ms. Larissa Odini, Ms. Mildred Nafula, Mrs. Patricia Oduor and Vivian Oketch. \n" +
                "\n" +
                "The Director for Alumni Affairs, Mr. Maurice Fox Okungu, expressed his gratitude towards the DVC for his support in expediting the registration process and the subsequent launch of the Alumni board. “The launch of the alumni board marks a significant milestone for TUKAA, signalling the beginning of activities focusing on outreach and networking events,” he said. Mr. Maurice Okungu further congratulated the entire University Management on the timely appointment of the board members. Additionally, he asked the newly appointed Board to assist in the formulation of the policy guidelines for TUKAA.\n" +
                "\n" +
                "Ms. Larissa Odini took the board members through a brief background of the alumni association and the necessary adjustments required to ensure its full functionality. She highlighted the pivotal role of the secretariat emphasizing its key role as the liaison between the alumni association and the university. The Technical University of Kenya (TU-K) takes pride in its exceptional alumni community which consists of graduates and former students of the Kenya Polytechnic, Kenya Polytechnic University College (KPUC), and the Technical University of Kenya. To fully operationalize the association, there was a need for the pioneer Board members to be appointed. The TU-K Alumni Association exists to connect, inform, serve, and engage the University's diverse alumni and friends. ‘This meeting indeed marked a historical milestone for the alumni association’ she added.",
        icons = listOf(
            Icons.Filled.CheckCircle,
            Icons.Filled.Add,
            Icons.Filled.Favorite

        ) ,


        navigateToRoute = null.toString(),
    ),
    News(
        title = "TU-K Signs MoU with France Education Institutions",
        imageRes = R.drawable.france,
        description = "The Technical University of Kenya (TU-K) recently signed an MoU with Lycée Professionnel Christian Antou (LPH) and Lycée D’enseignement Général et Technologique Évariste De Parny (LEP). Both institutions will work together on academic and vocational-related matters with the aim of strengthening ties in the areas of tourism and hospitality, as well as in languages such as French, German and English.\n" +
                "\n" +
                "The MoU is motivated by the desire to develop and maintain linguistic, cultural, academic and expertise exchanges between the learning institutions.\n" +
                "\n" +
                "The delegation from France included Marjorie Coste, advisor to the Director, Local Education Authority of Reunion Island; Lionel Mezoul, professional development counsellor, Academic Region of Reunion Island; Nathalie Arnaud, instructor at Lycée Professionnel Christian Antou; and Mustapha El Idrissi an instructor at Lycée D’enseignement Général et Technologique Évariste De Parny.\n" +
                "\n" +
                "Mr. Bernard Clouteau, an attaché in charge of Education and French, from the Embassy of France in Kenya and Somalia was in attendance and signed the MoU on behalf of the embassy.\n" +
                "\n" +
                "The Vice-Chancellor, Prof. Benedict Mutua, together with the Deputy Vice-Chancellor in charge of Institutional Advancement and Enterprises (IAE), Prof. Paul Wambua, signed the MoU on behalf of the university.\n" +
                "\n" +
                "Other members present were; Director School of Hospitality and Human Ecology Prof. Richard Makopondo; Academic Team Leader, Hospitality and Leisure Studies Prof. Boniface Kihima; Dr. Japheth Kwenga, a lecturer in the Department of Hospitality and Leisure Studies; and Academic Team Leader, Modern and Classical Languages Dr. Teresa Otieno who is the coordinator of this collaboration in TU-K.\n" +
                "\n" +
                "Lycée Professionnel Hotelier La Renaissance is a vocational educational institution determined to offer state of the art technical and vocational education in hospitality and catering to prepare future qualified professionals from certificate of vocational aptitude (CAP) to Higher Technical Certificates (BTS).\n" +
                "\n" +
                "TU-K’s working relationship with France dates back to 2016, when the university was represented in the first edition of Kenya Day, held in Paris, France. The event brought together Directors of International Relations and Linkages from various French Universities, Research Centers and TVET institutions.\n" +
                "\n" +
                "The university took part in the second edition of Kenya Day event that was held in Paris, France, where they held discussions with French education leaders and representatives of nine universities.\n" +
                "\n" +
                "Presentations were made on topical issues around the long-standing diplomatic relationship between Kenya and France and mainly focused on Technical and Higher Educational Partnerships. \n" +
                "\n" +
                "TU-K is working closely with the Embassy of France in Nairobi and has on several occasions hosted the leaders of the mission, including Dr. Mathieu GUERIN, Attaché for Scientific and University Cooperation, the former Head of Cooperation and Cultural Affairs Department, Mr. Cyril GERARDON and the current Head of Cooperation and Cultural Affairs Department, Mr. Denis SAINT-MARIE.\n" +
                "\n" +
                "The meeting ended with a tour of the facilities at the School of Hospitality and Human Ecology.\n" +
                "\n" +
                "\n",
        icons =  listOf(
            Icons.Filled.CheckCircle,
            Icons.Filled.Add,
            Icons.Filled.Favorite

        )  ,
        navigateToRoute = null.toString(),
    )







)
