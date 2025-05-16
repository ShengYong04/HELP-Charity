/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.control;
import assignment.adt.LinkedListInterface;
import assignment.dao.DoneeDAO;
import assignment.entity.Donee;
import assignment.entity.family;
import assignment.entity.individual;
import assignment.entity.organization;
import assignment.utility.successfulMsg;
import assignment.utility.doneeComparator;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author User
 */
public class DummyDonee {
    private static DoneeDAO dataFile = new DoneeDAO();
    
    public static void addDummydonee(LinkedListInterface<Donee> doneeList){
        doneeList = dataFile.openFile();
        // individual (14)
        individual ind = new individual(20, 'F');
        Donee donee = new Donee("Yee Jia Qi","0192881603","yee@gmail.com", "93, Jalan Tun H S Lee 9B, Medan Kuchai, 93962 Lawas, Sarawak", "DNE916703", "i",LocalDate.of(2024, Month.JANUARY, 12), ind);
        doneeList.add(donee);
        
        ind = new individual(20, 'M');
        donee = new Donee("Lim Wee Yang","0124778899","lim@gmail.com", "1, Jalan 5B, Pandan Kiara, 16946 Wakaf Che Yeh, Kelantan", "DNE280912", "i",LocalDate.of(2024, Month.FEBRUARY, 12), ind);
        doneeList.add(donee);
        
        ind = new individual(20, 'M');
        donee = new Donee("Tan Junn Yi","0124501122","tan@gmail.com", "No. 174, Jalan 41H, Desa Meru, 33589 Parit Buntar, Perak", "DNE594705", "i",LocalDate.of(2024, Month.MARCH, 11), ind);
        doneeList.add(donee);
        
        ind = new individual(20, 'M');
        donee = new Donee("Kho Sheng Yong","0124471677","kho@gmail.com", "4C-06, Jln Utama 3/9C, Bandar Pinang, 58138 Sri Petaling, KL", "DNE702647", "i",LocalDate.of(2024, Month.APRIL, 11), ind);
        doneeList.add(donee);
        
        ind = new individual(20, 'F');
        donee = new Donee("Ko Jie Qi","01828816889","ko@gmail.com", "No. 62, Lorong Bangsar 8/2, Desa Setia Jaya, 62714 Precinct 8, Putrajaya", "DNE904793", "i",LocalDate.of(2024, Month.MAY, 11), ind);
        doneeList.add(donee);
        
        ind = new individual(20, 'F');
        donee = new Donee("Clarist Liew Wing Ling","01116881711","liew@gmail.com", "No. 62, Lorong Bangsar 8/2, Desa Setia Jaya, 62714 Precinct 8, Putrajaya", "DNE374861", "i",LocalDate.of(2024, Month.JUNE, 11), ind);
        doneeList.add(donee);
        
        ind = new individual(20, 'F');
        donee = new Donee("Heng Pei Lin","0145678899","heng@gmail.com", "5, Jalan 5P, SS12G, 62126 Precinct 12, Putrajaya" , "DNE742023", "i",LocalDate.of(2024, Month.JULY, 11), ind);
        doneeList.add(donee);
        
        ind = new individual(20, 'F');
        donee = new Donee("Tan Qian Yiin","0124445555","heng@gmail.com", "3-8, Lorong 9/6F, Desa Kinrara, 90047 Likas, Sabah" , "DNE461724", "i",LocalDate.of(2024, Month.AUGUST, 11), ind);
        doneeList.add(donee);
        
        ind = new individual(21, 'M');
        donee = new Donee("Saw Khoo Zi Chong","01144553322","saw@gmail.com", "9, Jln Sultan Ismail 8, Sri Belakong, 22645 Bandar Permaisuri, Terengganu" , "DNE122781", "i",LocalDate.of(2024, Month.SEPTEMBER, 11), ind);
        doneeList.add(donee);
        
        ind = new individual(21, 'M');
        donee = new Donee("Siah E-Ian","0142337766","siah@gmail.com", "No. 847, Jln 63J, USJ 7, 24016 Bukit Payong, Terengganu" , "DNE664413", "i", LocalDate.of(2024, Month.JULY, 11), ind);
        doneeList.add(donee);
        
        ind = new individual(21, 'M');
        donee = new Donee("Christopher Yap Jian Xing","0124576677","chris@gmail.com", "No. 50, Jalan Air Itam 97J, PJU4, 87030 Kiamsam, Labuan" , "DNE589716", "i", LocalDate.of(2024, Month.MAY, 11), ind);
        doneeList.add(donee);
        
        ind = new individual(21, 'M');
        donee = new Donee("Lee Zhe Heng","01844123345","lee@gmail.com", "2, Jln 15W, Bukit Semarak, 18038 Machang, Kelantan Darul Naim" , "DNE832201", "i", LocalDate.of(2024, Month.MARCH, 11), ind);
        doneeList.add(donee);
        
        ind = new individual(30, 'M');
        donee = new Donee("Ganesh a/l Padathan","01844123345","ganesh@gmail.com" , "2, Jln 15W, Bukit Semarak, 18038 Machang, Kelantan Darul Naim" , "DNE632456", "i", LocalDate.of(2024, Month.MARCH, 11), ind);
        doneeList.add(donee);
        
        ind = new individual(41, 'M');
        donee = new Donee("V. T. Rajiv","0125201314","V@gmail.com", "76, Lorong 3/8, Laman Casa, 95159 Kuching, Sarawak" , "DNE991281", "i", LocalDate.of(2024, Month.APRIL, 11), ind);
        doneeList.add(donee);
        
        // family(5)
        family fam = new family(5,38, 'M');
        donee = new Donee("Seng Yuen Loong","0169999111","Seng@gmail.com", "93, Jalan 17W, SS1, 90429 Kundasang, Sabah" , "DNE706211", "f", LocalDate.of(2024, Month.SEPTEMBER, 11), fam);
        doneeList.add(donee);
        
        fam = new family(3,37, 'F');
        donee = new Donee("Kasthuriraani a/l Sivakumar","0137788877","katsu@gmail.com", "8, Jalan Hang Jebat 6/2, PJU40, 11377 Gelugor, Pulau Pinang" , "DNE882249", "f", LocalDate.of(2024, Month.FEBRUARY, 11), fam);
        doneeList.add(donee);
        
        fam = new family(8,28, 'M');
        donee = new Donee("Nur Wahida Zuhaili","0198868886","nur@gmail.com", "Lot 190, Jalan 2/93D, Kampung Manggis, 02773 Sanglang, Perlis" , "DNE743342", "f", LocalDate.of(2024, Month.FEBRUARY, 11), fam);
        doneeList.add(donee);
        
        fam = new family(9,31, 'F');
        donee = new Donee("Gong Meh Yeh","0168778877","gong@gmail.com", "1, Jln 98A, USJ 1, 02777 Arau, Perlis" , "DNE130053", "f", LocalDate.of(2024, Month.MARCH, 11), fam);
        doneeList.add(donee);
        
        fam = new family(6,55, 'M');
        donee = new Donee("Yosri Rao a/l Namasivayam","0168778877","yosri@gmail.com", "9S-55, Jln 3, Sri Pertama, 16617 Lojing, Kelantan" , "DNE842038", "f", LocalDate.of(2024, Month.JULY, 11), fam);
        doneeList.add(donee);
        
        //organization(5)
        organization org = new organization("Hope Foundation");
        donee = new Donee("Aw Gek Tatt","01844666644","hope@foundation.org", "433, Jln Davis, Pandan Brickfields, 62259 Precinct 19, Putrajaya" , "DNE675529", "o", LocalDate.of(2024, Month.JULY, 11), org);
        doneeList.add(donee);
        
        org = new organization("Wellness Warriors");
        donee = new Donee("Jane Aun","0168771234","wellness@warriors.org", "5, Jalan 5P, SS12G, 62126 Precinct 12, Putrajaya" , "DNE244427", "o", LocalDate.of(2024, Month.AUGUST, 11), org);
        doneeList.add(donee);
        
        org = new organization("Shelter of Hope");
        donee = new Donee("John Teoh","0122889288","hope@shelter.org", "No. 847, Jln 63J, USJ 7, 24016 Bukit Payong, Terengganu" , "DNE792753", "o", LocalDate.of(2024, Month.JANUARY, 11), org);
        doneeList.add(donee);
        
        org = new organization("Lifeline Support");
        donee = new Donee("Jane Solekhan","0174271677","lifeline@support.org", "No. 847, Jln 63J, USJ 7, 24016 Bukit Payong, Terengganu" , "DNE243999", "o", LocalDate.of(2024, Month.SEPTEMBER, 11), org);
        doneeList.add(donee);
        
        org = new organization("Unity Outreach");
        donee = new Donee("Yee Jia Hui","01116881941","unity@outreach.org", "1, Lorong 1/81I, Bandar Amanjaya, 11266 Batu Ferringhi, Pulau Pinang" , "DNE117751", "o", LocalDate.of(2024, Month.MAY, 11), org);
        doneeList.add(donee);
        

        doneeList.sort(new doneeComparator());
        dataFile.writeFile(doneeList);
        successfulMsg.addSuccessful();
    }
}
