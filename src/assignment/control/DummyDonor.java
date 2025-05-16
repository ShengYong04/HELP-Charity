/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.control;

import assignment.adt.LinkedListInterface;
import assignment.dao.DonorDAO;
import assignment.entity.Donor;
import assignment.utility.Success;
import assignment.utility.donorComparator;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author weeya
 */
public class DummyDonor {
    public static void addDummyDonor(LinkedListInterface<Donor> donorList){
        // Private (30)
        Donor donor = new Donor ("DNR969816", "Jane Iqmal", "0156515441", "tiong.alafnan@yahoo.com", "Private", "Lot 94, Jalan Alor 9W, Bandar Mulia, 96388 Daro, Sarawak", LocalDate.of(2024, Month.JANUARY, 12));
        donorList.add(donor);
        donor = new Donor("DNR213456", "Sybil a/l Sumisha", "0179576358", "zulum@bahrin.com", "Private", "93, Jalan Tun H S Lee 9B, Medan Kuchai, 93962 Lawas, Sarawak", LocalDate.of(2024, Month.FEBRUARY, 21));
        donorList.add(donor);
        donor = new Donor("DNR192357", "John Lum", "0184045428", "cruslan@nagarajan.org", "Private", "91, Jln Selamat 4, Bandar Amanjaya, 81754 Gemas Baharu, Johor Darul Ta'zim", LocalDate.of(2024, Month.MARCH, 1));
        donorList.add(donor);
        donor = new Donor("DNR853029", "Ja'afer bin Rosli", "0151350056", "rehman28@yahoo.com", "Private", "1, Jalan 6/8, Seksyen 2, 55401 Bukit Jalil, Kuala Lumpur", LocalDate.of(2024, Month.APRIL, 11));
        donorList.add(donor);
        donor = new Donor("DNR576575", "Jane Norazman", "0124282975", "wayxiao79@yahoo.com", "Private", "4, Jalan Cantonment 9/8E, Bandar Seri Tunku, 25942 Karak, Pahang Darul Makmur", LocalDate.of(2024, Month.MAY, 12));
        donorList.add(donor);
        donor = new Donor("DNR041169", "John Devaraj", "0156180405", "nazhan23@gmail.com", "Private", "I-97-70, Jln Kedah 4/2, Taman Sungai Buaya, 02792 Wang Kelian, Perlis", LocalDate.of(2024, Month.JUNE, 21));
        donorList.add(donor);
        donor = new Donor("DNR135803", "Tai Shui Moo", "0146834845", "gwaiy@yahoo.com", "Private", "No. 9, Jalan Hang Jebat 3, SS66L, 66984 Damansara, Selangor", LocalDate.of(2024, Month.JULY, 22));
        donorList.add(donor);
        donor = new Donor("DNR411798", "Tan Ah Dim", "0132066436", "pramanathan@gmail.com", "Private", "97, Jalan 2/2, Alam Laksamana, 78218 Pekan Asahan, Melaka", LocalDate.of(2024, Month.AUGUST, 2));
        donorList.add(donor);
        donor = new Donor("DNR244368", "Jane Haiqal", "0134857790", "zarai.teoyen@xia.org", "Private", "61, Lorong 2Y, Pangsapuri Ria, 81692 Johor Lama, Johor", LocalDate.of(2024, Month.SEPTEMBER, 1));
        donorList.add(donor);
        donor = new Donor("DNR624881", "John Wee", "0189334812", "ramlan.ramya@hotmail.com", "Private", "7Y-94, Jln 5/3, Bandar Bestari, 75904 Bukit Katil, Malacca", LocalDate.of(2024, Month.JUNE, 7));
        donorList.add(donor);
        donor = new Donor("DNR015358", "Chu Zhang Sum", "0190909676", "martin67@yahoo.com", "Private", "99, Jln 1, Bandar Bukit Timur, 66534 Batu Caves, Selangor", LocalDate.of(2024, Month.FEBRUARY, 11));
        donorList.add(donor);
        donor = new Donor("DNR545536", "Lau Liang Lein", "0130175458", "mazahari@gmail.com", "Private", "74, Jln Istana 8/55, Sri Saujana, 25126 Nenasi, Pahang", LocalDate.of(2024, Month.JANUARY, 13));
        donorList.add(donor);
        donor = new Donor("DNR844669", "Jane Dairiam", "0191283285", "tang.lichu@yahoo.com", "Private", "71, Jln Raja Laut, Medan Raya, 82208 Renggam, Johor", LocalDate.of(2024, Month.MAY, 5));
        donorList.add(donor);
        donor = new Donor("DNR410655", "John Tukimin", "0178836864", "bgoh@yahoo.com", "Private", "1, Jalan 5B, Pandan Kiara, 16946 Wakaf Che Yeh, Kelantan", LocalDate.of(2024, Month.MARCH, 3));
        donorList.add(donor);
        donor = new Donor("DNR487570", "Aw Gek Tatt", "01394659443", "karathu.gobind@gmail.com", "Private", "433, Jln Davis, Pandan Brickfields, 62259 Precinct 19, Putrajaya", LocalDate.of(2024, Month.JULY, 7));
        donorList.add(donor);
        donor = new Donor ("DNR220029", "John Jayawardene", "0197220231", "caemen.teh@bukhari.net", "Private", "2F-45, Jalan Robson 1/4U, Taman Kiara, 89686 Inanam, Sabah", LocalDate.of(2024, Month.JANUARY, 21));
        donorList.add(donor);
        donor = new Donor("DNR589627", "Jane Arifuddin", "0104745734", "ramanathan@hii.com", "Private", "No. 5, Jalan Madras 7/41N, PJU2, 30682 Tanjung Malim, Perak Darul Ridzuan", LocalDate.of(2024, Month.FEBRUARY, 3));
        donorList.add(donor);
        donor = new Donor("DNR465252", "R. S. Haanii", "0152753095", "pau@lew.com", "Private", "9F-00, Jln 9/9K, Kampung Genting, 86148 Kulai, Johor", LocalDate.of(2024, Month.MARCH, 4));
        donorList.add(donor);
        donor = new Donor("DNR053180", "Shoba a/l Solamalay", "0153234142", "tewchu74@ngeh.org", "Private", "No. 3, Jln 7/3, Ara Timur, 01570 Kangar, Perlis Indera Kayangan", LocalDate.of(2024, Month.APRIL, 5));
        donorList.add(donor);
        donor = new Donor("DNR573087", "Athi Cumaraswamy", "0187727040", "vivien@hotmail.com", "Private", "7, Jln Mohana Chandran 8/50, SS64, 70596 Linggi, Negeri Sembilan", LocalDate.of(2024, Month.MAY, 7));
        donorList.add(donor);
        donor = new Donor("DNR113555", "Chew She Joy", "0152994996", "rashmi@yahoo.com", "Private", "7-1, Jalan Alor 6Y, Pandan Duta, 89142 Pitas, Sabah", LocalDate.of(2024, Month.JUNE, 11));
        donorList.add(donor);
        donor = new Donor("DNR450383", "John Arias", "0155689342", "linda39@dee.info", "Private", "98, Jln Ampang 4, Petaling Semarak, 62121 Precinct 6, Putrajaya", LocalDate.of(2024, Month.JULY, 26));
        donorList.add(donor);
        donor = new Donor("DNR652714", "Kum Goo Chang", "0165307920", "badrina@yahoo.com", "Private", "No. 25, Jln Wisma Putra 3/29, SS9, 76959 Bandaraya Melaka, Malacca", LocalDate.of(2024, Month.AUGUST, 21));
        donorList.add(donor);
        donor = new Donor("DNR613205", "Yiaw Lit Shia", "0196856634", "zaiyon66@gmail.com", "Private", "Lot 5O-61, Jalan 2/7E, Kampung Semarak, 63825 Ulu Yam, Selangor", LocalDate.of(2024, Month.SEPTEMBER, 2));
        donorList.add(donor);
        donor = new Donor("DNR732044", "Lam Lao Khia", "0156358704", "norazmi@gmail.com", "Private", "1, Lorong Sultan Ismail 7B, Bandar Rahmat, 81811 Tebrau, Johor Darul Ta'zim", LocalDate.of(2024, Month.APRIL, 17));
        donorList.add(donor);
        donor = new Donor("DNR486142", "E. Murugeson", "0152790107", "yen.tony@gmail.com", "Private", "5, Jln 2/28Y, Alam Pahlawan, 33614 Lumut, Perak Darul Ridzuan", LocalDate.of(2024, Month.FEBRUARY, 9));
        donorList.add(donor);
        donor = new Donor("DNR577440", "Sangeeta a/l Munshi", "0156202852", "yaacob@gmail.com", "Private", "66, Jalan 5/58, Puncak Sinar, 12725 Simpang Ampat, Pulau Pinang", LocalDate.of(2024, Month.JANUARY, 19));
        donorList.add(donor);
        donor = new Donor("DNR171776", "John Azli", "0151151939", "kahar@hotmail.com", "Private", "R-31-34, Jalan 1/27U, Taman Desa Suria, 62378 Precinct 5, Putrajaya", LocalDate.of(2024, Month.AUGUST, 20));
        donorList.add(donor);
        donor = new Donor("DNR564246", "Soh Hu Tung", "0111433248", "michael@gmail.com", "Private", "20, Jln 2/76Q, PJU86, 17543 Dabong, Kelantan", LocalDate.of(2024, Month.MARCH, 8));
        donorList.add(donor);
        donor = new Donor("DNR610046", "N. Iyer", "0152228237", "aslina@yahoo.com", "Private", "41, Jalan Robson 9/46, Bukit Petaling, 17805 Wakaf Che Yeh, Kelantan", LocalDate.of(2024, Month.JULY, 12));
        donorList.add(donor);
        
        // Public(15)
        donor = new Donor ("DNR461405", "Mercy Malaysia", "01322762116", "info@mercy.org.my", "Public", "1st Floor, MCOBA Building, 42 Jalan Syed Putra,50460 Kuala Lumpur", LocalDate.of(2024, Month.JANUARY, 1));
        donorList.add(donor);
        donor = new Donor("DNR001017", "Tech Innovators Inc.", "0171234567", "info@techinnovators.com", "Public", "5, Lorong 4, Puncak Pelangi, 78213 Masjid Tanah, Melaka", LocalDate.of(2024, Month.FEBRUARY, 21));
        donorList.add(donor);
        donor = new Donor("DNR824004", "Green Earth Solutions", "0188573746", "contact@greenearth.com", "Public", "5, Jalan 5P, SS12G, 62126 Precinct 12, Putrajaya", LocalDate.of(2024, Month.MARCH, 2));
        donorList.add(donor);
        donor = new Donor("DNR466084", "Future Vision Consulting", "0127492756", "support@futurevision.com", "Public", "25, Jln 7P, Bandar Sri Kiara, 70358 Senawang, Negeri Sembilan", LocalDate.of(2024, Month.APRIL, 16));
        donorList.add(donor);
        donor = new Donor("DNR085794", "HealthFirst Medical Group", "0154567123", "info@healthfirst.com", "Public", "3-8, Lorong 9/6F, Desa Kinrara, 90047 Likas, Sabah", LocalDate.of(2024, Month.MAY, 9));
        donorList.add(donor);
        donor = new Donor("DNR721458", "EcoWise Industries", "0178765783", "hello@ecowise.com", "Public", "2O-54, Jalan Vivekananda 9, Bandar Petaling, 22892 Wakaf Tapai, Terengganu", LocalDate.of(2024, Month.JUNE, 3));
        donorList.add(donor);
        donor = new Donor("DNR158960", "SmartBuild Constructors", "0187386475", "contact@smartbuild.com", "Public", "No. 847, Jln 63J, USJ 7, 24016 Bukit Payong, Terengganu", LocalDate.of(2024, Month.JULY, 7));
        donorList.add(donor);
        donor = new Donor("DNR115508", "BrightPath Education", "0116472639", "info@brightpath.com", "Public", "No. 50, Jalan Air Itam 97J, PJU4, 87030 Kiamsam, Labuan", LocalDate.of(2024, Month.AUGUST, 22));
        donorList.add(donor);
        donor = new Donor ("DNR260354", "AquaPure Water Systems", "0138347465", "support@aquapure.com", "Public", "2, Jln 15W, Bukit Semarak, 18038 Machang, Kelantan Darul Naim", LocalDate.of(2024, Month.SEPTEMBER, 1));
        donorList.add(donor);
        donor = new Donor("DNR857961", "TechWave Solutions", "0179012345", "hello@techwave.com", "Public", "Lot 11, Jln S.P. Seenivasagam 4/1S, Sri Delima, 39141 Kemayan, Pahang", LocalDate.of(2024, Month.AUGUST, 31));
        donorList.add(donor);
        donor = new Donor("DNR889894", "NovaTech Enterprises", "0180123336", "contact@novatech.com", "Public", "76, Lorong 3/8, Laman Casa, 95159 Kuching, Sarawak", LocalDate.of(2024, Month.MARCH, 12));
        donorList.add(donor);
        donor = new Donor("DNR997011", "BrightSide Charities", "0107234623", "info@brightside.com", "Public", "93, Jalan 17W, SS1, 90429 Kundasang, Sabah", LocalDate.of(2024, Month.JANUARY, 21));
        donorList.add(donor);
        donor = new Donor ("DNR644903", "SecureNet Cybersecurity", "0136789321", "support@securenet.com", "Public", "8, Jalan Hang Jebat 6/2, PJU40, 11377 Gelugor, Pulau Pinang", LocalDate.of(2024, Month.APRIL, 21));
        donorList.add(donor);
        donor = new Donor("DNR034050", "GreenTech Energy", "0179522118", "hello@greentech.com", "Public", "1, Jln 98A, USJ 1, 02777 Arau, Perlis", LocalDate.of(2024, Month.FEBRUARY, 13));
        donorList.add(donor);
        donor = new Donor("DNR660935", "ProServe Logistics", "0127643455", "contact@proserve.com", "Public", "9S-55, Jln 3, Sri Pertama, 16617 Lojing, Kelantan", LocalDate.of(2024, Month.MAY, 5));
        donorList.add(donor);
        //Government(5)
        donor = new Donor("DNR495505", "Ministry of Finance", "0188220151", "contact@finance.com", "Government", "No. 1, Jln Dato'Keramat, Seksyen 93, 02453 Beseri, Perlis", LocalDate.of(2024, Month.MARCH, 15));
        donorList.add(donor);
        donor = new Donor("DNR543814", "Ministry of Health", "0132114427", "contact@health.com", "Government", "No. 4, Jln 15S, Desa Damai, 01777 Wang Kelian, Perlis Indera Kayangan", LocalDate.of(2024, Month.JANUARY, 10));
        donorList.add(donor);
        donor = new Donor ("DNR728082", "Ministry of Education", "0132114427", "contact@education.com", "Government", "No. 4, Jln 15S, Desa Damai, 01777 Wang Kelian, Perlis Indera Kayangan", LocalDate.of(2024, Month.APRIL, 1));
        donorList.add(donor);
        donor = new Donor("DNR176618", "Ministry of Environment and Water", "0188895046", "contact@environment.com", "Government", "10, Jalan 8/73, Kampung Sungai Besi, 46903 Kuang, Selangor", LocalDate.of(2024, Month.FEBRUARY, 22));
        donorList.add(donor);
        donor = new Donor("DNR610441", "Ministry of Human Resources", "0142362321", "contact@hr.com", "Government", "No. 2, Jln Tugu, Ara Bahagia, 68887 Jerantut, Pahang", LocalDate.of(2024, Month.MAY, 8));
        donorList.add(donor);
        
        donorList.sort(new donorComparator());
        DonorDAO.saveFile(donorList);
        Success.registerSuccess();
    }
}
