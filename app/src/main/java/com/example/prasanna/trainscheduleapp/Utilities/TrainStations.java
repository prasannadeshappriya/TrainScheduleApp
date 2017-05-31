package com.example.prasanna.trainscheduleapp.Utilities;

import com.example.prasanna.trainscheduleapp.Models.TrainStation;
import java.util.ArrayList;

/**
 * Created by prasanna on 5/30/17.
 */

public abstract class TrainStations {
    private static ArrayList<TrainStation> arrTrainStation;

    public static ArrayList<TrainStation> getStationArray() {
        arrTrainStation = new ArrayList<>();
        arrTrainStation.add(new TrainStation("3", "ABANPOLA", "ABN"));
        arrTrainStation.add(new TrainStation("410", "ADAGALA", "Adagala"));
        arrTrainStation.add(new TrainStation("11", "AHANGAMA", "ANM"));
        arrTrainStation.add(new TrainStation("18", "AHUNGALLE", "AUH"));
        arrTrainStation.add(new TrainStation("13", "AKBOPURA", "APR"));
        arrTrainStation.add(new TrainStation("7", "AKURALA", "AKU"));
        arrTrainStation.add(new TrainStation("22", "ALAWATUPITIYA", "AWP"));
        arrTrainStation.add(new TrainStation("9", "ALAWWA", "ALW"));
        arrTrainStation.add(new TrainStation("329", "ALUTH AMBALAMA", ""));
        arrTrainStation.add(new TrainStation("8", "ALUTHGAMA", "ALT"));
        arrTrainStation.add(new TrainStation("1", "AMBALANGODA", "ABA"));
        arrTrainStation.add(new TrainStation("2", "AMBEWELA", "ABL"));
        arrTrainStation.add(new TrainStation("14", "AMBEYPUSSA", "APS"));
        arrTrainStation.add(new TrainStation("19", "ANAWILUNDAWA", "AVD"));
        arrTrainStation.add(new TrainStation("10", "ANDADOLA", "AND"));
        arrTrainStation.add(new TrainStation("5", "ANGAMPITIYA", ""));
        arrTrainStation.add(new TrainStation("4", "ANGULANA", "AGL"));
        arrTrainStation.add(new TrainStation("12", "ANURADHAPURA", "ANP"));
        arrTrainStation.add(new TrainStation("15", "ANURADHAPURA TOWN", "APT"));
        arrTrainStation.add(new TrainStation("6", "ARACHCHIKATTUWA", "AKT"));
        arrTrainStation.add(new TrainStation("343", "ARAPATHGAMA", ""));
        arrTrainStation.add(new TrainStation("16", "ARUKKUWATTE", ""));
        arrTrainStation.add(new TrainStation("17", "ASELAPURA", "ASL"));
        arrTrainStation.add(new TrainStation("467", "ASGIRIYA", "ASG"));
        arrTrainStation.add(new TrainStation("21", "AUKANA", "AWK"));
        arrTrainStation.add(new TrainStation("20", "AVISSAWELLA", ""));
        arrTrainStation.add(new TrainStation("23", "BADULLA", "BAD"));
        arrTrainStation.add(new TrainStation("31", "BALANA", "BNA"));
        arrTrainStation.add(new TrainStation("34", "BALAPITIYA", "BPA"));
        arrTrainStation.add(new TrainStation("35", "BAMBALAPITIYA", "BPT"));
        arrTrainStation.add(new TrainStation("25", "BANDARAWELA", "BDA"));
        arrTrainStation.add(new TrainStation("475", "Bandirippuwa", ""));
        arrTrainStation.add(new TrainStation("28", "BANGADENIYA", "BGY"));
        arrTrainStation.add(new TrainStation("39", "BASELINE ROAD", "BSL"));
        arrTrainStation.add(new TrainStation("33", "BATTALUOYA", "BOA"));
        arrTrainStation.add(new TrainStation("24", "BATTICALOA", "BCO"));
        arrTrainStation.add(new TrainStation("41", "BATUWATTE", "BTU"));
        arrTrainStation.add(new TrainStation("26", "BEMMULLA", "BEM"));
        arrTrainStation.add(new TrainStation("32", "BENTOTA", "BNT"));
        arrTrainStation.add(new TrainStation("36", "BERUWALA", "BRL"));
        arrTrainStation.add(new TrainStation("30", "BOLAWATTE", "BLT"));
        arrTrainStation.add(new TrainStation("38", "BOOSSA", "BSH"));
        arrTrainStation.add(new TrainStation("37", "BORELESSA", "BSA"));
        arrTrainStation.add(new TrainStation("40", "BOTALE", "BTL"));
        arrTrainStation.add(new TrainStation("27", "BULUGAHAGODA", "BGH"));
        arrTrainStation.add(new TrainStation("29", "BUTHGAMUWA", "BJM"));
        arrTrainStation.add(new TrainStation("398", "CHAVAKACHCHERI", ""));
        arrTrainStation.add(new TrainStation("371", "CHEDDIIKULAM", ""));
        arrTrainStation.add(new TrainStation("44", "CHILAW", "CHL"));
        arrTrainStation.add(new TrainStation("43", "CHINA BEY", "CBY"));
        arrTrainStation.add(new TrainStation("423", "CHUNNAKAM", ""));
        arrTrainStation.add(new TrainStation("61", "COLOMBO FORT", "FOT"));
        arrTrainStation.add(new TrainStation("46", "COTTA ROAD", "CRD"));
        arrTrainStation.add(new TrainStation("53", "DARALUWA", "DRL"));
        arrTrainStation.add(new TrainStation("457", "DEC", ""));
        arrTrainStation.add(new TrainStation("54", "DEHIWALA", "DWL"));
        arrTrainStation.add(new TrainStation("337", "Dekinda", ""));
        arrTrainStation.add(new TrainStation("47", "DEMATAGODA", "DAG"));
        arrTrainStation.add(new TrainStation("48", "DEMODARA", "DDR"));
        arrTrainStation.add(new TrainStation("52", "DEWAPURAM", "DPM"));
        arrTrainStation.add(new TrainStation("417", "DEWEDDA", "Dewedda"));
        arrTrainStation.add(new TrainStation("50", "DIYATALAWA", "DLA"));
        arrTrainStation.add(new TrainStation("51", "DODANDUWA", "DNA"));
        arrTrainStation.add(new TrainStation("60", "EGODA UYANA", "EYA"));
        arrTrainStation.add(new TrainStation("395", "ELIPHANT PASS", "EPS"));
        arrTrainStation.add(new TrainStation("57", "ELLE", "ELL"));
        arrTrainStation.add(new TrainStation("401", "ELUTHUMATTUVAL", ""));
        arrTrainStation.add(new TrainStation("341", "ELWALA", ""));
        arrTrainStation.add(new TrainStation("55", "ENDERAMULLA", "EDM"));
        arrTrainStation.add(new TrainStation("56", "ERATTAPERIYAKULAM", "EKM"));
        arrTrainStation.add(new TrainStation("59", "ERAVUR", "EVR"));
        arrTrainStation.add(new TrainStation("58", "ERUKKALAM PENDU", "EPN"));
        arrTrainStation.add(new TrainStation("104", "FREE TRADE ZONE", "IPZ"));
        arrTrainStation.add(new TrainStation("64", "GALABODA", "GBD"));
        arrTrainStation.add(new TrainStation("69", "GALGAMUWA", "GLM"));
        arrTrainStation.add(new TrainStation("68", "GALLE", "GLE"));
        arrTrainStation.add(new TrainStation("62", "GALLELLA", "GAL"));
        arrTrainStation.add(new TrainStation("74", "GALOYA JUNCTION", "GOA"));
        arrTrainStation.add(new TrainStation("70", "GAMMANA", "GMA"));
        arrTrainStation.add(new TrainStation("75", "GAMPAHA", "GPH"));
        arrTrainStation.add(new TrainStation("76", "GAMPOLA", "GPL"));
        arrTrainStation.add(new TrainStation("71", "GANEGODA", "GND"));
        arrTrainStation.add(new TrainStation("63", "GANEMULLA", "GAN"));
        arrTrainStation.add(new TrainStation("73", "GANEWATTE", "GNW"));
        arrTrainStation.add(new TrainStation("479", "Gangathilaka", ""));
        arrTrainStation.add(new TrainStation("65", "GANGODA", "GDA"));
        arrTrainStation.add(new TrainStation("440", "GANTALAWA", ""));
        arrTrainStation.add(new TrainStation("66", "GELIOYA", "GEY"));
        arrTrainStation.add(new TrainStation("72", "GINTHOTA", "GNT"));
        arrTrainStation.add(new TrainStation("476", "GIRAMBE", "GRB"));
        arrTrainStation.add(new TrainStation("77", "GIRAMBE", "GRB"));
        arrTrainStation.add(new TrainStation("67", "GODAGAMA", "GGA"));
        arrTrainStation.add(new TrainStation("79", "GREAT WESTERN", "GWN"));
        arrTrainStation.add(new TrainStation("81", "HABARADUWA", "HBD"));
        arrTrainStation.add(new TrainStation("82", "HABARANA", "HBN"));
        arrTrainStation.add(new TrainStation("456", "Hadiriwalana", ""));
        arrTrainStation.add(new TrainStation("84", "HALIELA", "HEA"));
        arrTrainStation.add(new TrainStation("92", "HAPUTALE", "HPT"));
        arrTrainStation.add(new TrainStation("80", "HATAMUNA", "HAU"));
        arrTrainStation.add(new TrainStation("87", "HATARAS KOTUWA", "HKT"));
        arrTrainStation.add(new TrainStation("96", "HATTON", "HTN"));
        arrTrainStation.add(new TrainStation("89", "HEEL OYA", "HLO"));
        arrTrainStation.add(new TrainStation("83", "HEENDENIYA", "HDP"));
        arrTrainStation.add(new TrainStation("91", "HETTIMULLA", "HML"));
        arrTrainStation.add(new TrainStation("86", "HIKKADUWA", "HKD"));
        arrTrainStation.add(new TrainStation("93", "HINGURAKGODA", "HRG"));
        arrTrainStation.add(new TrainStation("444", "HINGURALA", ""));
        arrTrainStation.add(new TrainStation("94", "HIRIYALA", "HRL"));
        arrTrainStation.add(new TrainStation("90", "HOMAGAMA", "HMA"));
        arrTrainStation.add(new TrainStation("85", "HOMAGAMA HOSPITAL", "HHR"));
        arrTrainStation.add(new TrainStation("95", "HORAPE", "HRP"));
        arrTrainStation.add(new TrainStation("88", "HORIWIALA", "HLA"));
        arrTrainStation.add(new TrainStation("97", "HUNUPITIYA", "HUN"));
        arrTrainStation.add(new TrainStation("98", "HYINPORT", ""));
        arrTrainStation.add(new TrainStation("100", "IDALGASINNA", "IGH"));
        arrTrainStation.add(new TrainStation("101", "IHALAGAMA", "IHA"));
        arrTrainStation.add(new TrainStation("102", "IHALAKOTTE", "IKT"));
        arrTrainStation.add(new TrainStation("105", "IHALAWATAWALA", "IWL"));
        arrTrainStation.add(new TrainStation("99", "INDURUWA", "IDA"));
        arrTrainStation.add(new TrainStation("103", "INGURUOYA", "INO"));
        arrTrainStation.add(new TrainStation("428", "INUVIL", ""));
        arrTrainStation.add(new TrainStation("107", "JA-ELA", "JLA"));
        arrTrainStation.add(new TrainStation("400", "JAFFNA", ""));
        arrTrainStation.add(new TrainStation("106", "JAYANTHIPURA", "JAP"));
        arrTrainStation.add(new TrainStation("338", "KACHCHERI HALL", ""));
        arrTrainStation.add(new TrainStation("114", "KADADASI NAGAR", "KDN"));
        arrTrainStation.add(new TrainStation("128", "KADIGAMUWA", "KMA"));
        arrTrainStation.add(new TrainStation("120", "KADUGANNAWA", "KGW"));
        arrTrainStation.add(new TrainStation("113", "KADUGODA", "KDG"));
        arrTrainStation.add(new TrainStation("480", "Kahatapitiya", ""));
        arrTrainStation.add(new TrainStation("152", "KAHAWA", "KWE"));
        arrTrainStation.add(new TrainStation("154", "KAKKAPALLIYA", "KYA"));
        arrTrainStation.add(new TrainStation("127", "KALAWEWA", "KLW"));
        arrTrainStation.add(new TrainStation("123", "KALKUDAH", "KKH"));
        arrTrainStation.add(new TrainStation("147", "KALUTARA NORTH", "KTN"));
        arrTrainStation.add(new TrainStation("148", "KALUTARA SOUTH", "KTS"));
        arrTrainStation.add(new TrainStation("130", "KAMBURUGAMUWA", "KMG"));
        arrTrainStation.add(new TrainStation("108", "KANDANA", "KAN"));
        arrTrainStation.add(new TrainStation("119", "KANDEGODA", "KGD"));
        arrTrainStation.add(new TrainStation("115", "KANDY", "KDT"));
        arrTrainStation.add(new TrainStation("424", "KANKESANTHURAI", ""));
        arrTrainStation.add(new TrainStation("132", "KANTALE", "KNI"));
        arrTrainStation.add(new TrainStation("110", "KAPUWATTE", "KAW"));
        arrTrainStation.add(new TrainStation("139", "KARADIPUWAL", "KPL"));
        arrTrainStation.add(new TrainStation("146", "KATHALUWA", "KTL"));
        arrTrainStation.add(new TrainStation("109", "KATTUWA", "KAT"));
        arrTrainStation.add(new TrainStation("144", "KATUGASTOTA", "KTG"));
        arrTrainStation.add(new TrainStation("468", "KATUGASTOTA     ROAD", ""));
        arrTrainStation.add(new TrainStation("150", "KATUGODA", "KUG"));
        arrTrainStation.add(new TrainStation("122", "KATUKURUNDA", "KKD"));
        arrTrainStation.add(new TrainStation("42", "KATUNAYAKA AIRPORT", "CAK"));
        arrTrainStation.add(new TrainStation("145", "KATUNAYAKE", "KTK"));
        arrTrainStation.add(new TrainStation("117", "KEENAWALA", "KEN"));
        arrTrainStation.add(new TrainStation("141", "KEKIRAWA", "KRA"));
        arrTrainStation.add(new TrainStation("124", "KELANIYA", "KLA"));
        arrTrainStation.add(new TrainStation("333", "KILINOCHCHI", "KOC"));
        arrTrainStation.add(new TrainStation("133", "KINIGAMA", "KNM"));
        arrTrainStation.add(new TrainStation("447", "KIRINDIWELA", ""));
        arrTrainStation.add(new TrainStation("138", "KIRULAPANA", "KPE"));
        arrTrainStation.add(new TrainStation("116", "KITAL ELLE", "KEL"));
        arrTrainStation.add(new TrainStation("111", "KOCHCHIKADE", "KCH"));
        arrTrainStation.add(new TrainStation("397", "KODIKAMAM", ""));
        arrTrainStation.add(new TrainStation("134", "KOGGALA", "KOG"));
        arrTrainStation.add(new TrainStation("474", "KOHOMBILIWALA", ""));
        arrTrainStation.add(new TrainStation("429", "KOKUVIL", ""));
        arrTrainStation.add(new TrainStation("126", "KOLLUPITIYA", "KLP"));
        arrTrainStation.add(new TrainStation("453", "KOLONNAWA", "KLN"));
        arrTrainStation.add(new TrainStation("125", "KOLONNAWA", "KLN"));
        arrTrainStation.add(new TrainStation("140", "KOMPANNAVEDIYA", "KPN"));
        arrTrainStation.add(new TrainStation("422", "KONDAVIL", ""));
        arrTrainStation.add(new TrainStation("135", "KONWEWA", "KON"));
        arrTrainStation.add(new TrainStation("136", "KORALAWELLA", "KOR"));
        arrTrainStation.add(new TrainStation("143", "KOSGAMA", "KSG"));
        arrTrainStation.add(new TrainStation("112", "KOSGODA", "KDA"));
        arrTrainStation.add(new TrainStation("121", "KOSHINNA", "KHA"));
        arrTrainStation.add(new TrainStation("118", "KOTAGALA", "KGA"));
        arrTrainStation.add(new TrainStation("137", "KOTTAWA", "KOT"));
        arrTrainStation.add(new TrainStation("153", "KUDA WAWA", "KWW"));
        arrTrainStation.add(new TrainStation("149", "KUDAHAKAPOLA", "KUD"));
        arrTrainStation.add(new TrainStation("131", "KUMARAKANDA", "KMK"));
        arrTrainStation.add(new TrainStation("129", "KUMBALGAMA", "KMB"));
        arrTrainStation.add(new TrainStation("408", "KURAHANHENAGAMA", "Kurahanhenagama"));
        arrTrainStation.add(new TrainStation("151", "KURANA", "KUR"));
        arrTrainStation.add(new TrainStation("142", "KURUNEGALA", "KRN"));
        arrTrainStation.add(new TrainStation("158", "LAKSAUYANA", "LYA"));
        arrTrainStation.add(new TrainStation("155", "LIYANAGEMULLA", "LGM"));
        arrTrainStation.add(new TrainStation("334", "LIYANWALA", "LIYANWALA"));
        arrTrainStation.add(new TrainStation("156", "LUNAWA", "LNA"));
        arrTrainStation.add(new TrainStation("157", "LUNUWILA", ""));
        arrTrainStation.add(new TrainStation("181", "MADAMPAGAMA", "MPA"));
        arrTrainStation.add(new TrainStation("161", "MADAMPE", "MDP"));
        arrTrainStation.add(new TrainStation("372", "MADHU ROAD", "MRD"));
        arrTrainStation.add(new TrainStation("174", "MADURANKULIYA", "MKI"));
        arrTrainStation.add(new TrainStation("472", "Magalegoda", ""));
        arrTrainStation.add(new TrainStation("393", "MAGALEGODA", ""));
        arrTrainStation.add(new TrainStation("167", "MAGGONA", "MGN"));
        arrTrainStation.add(new TrainStation("452", "MAGULEGODA", ""));
        arrTrainStation.add(new TrainStation("190", "MAHAIYAWA", "MYA"));
        arrTrainStation.add(new TrainStation("159", "MAHARAGAMA", "MAG"));
        arrTrainStation.add(new TrainStation("170", "MAHO", "MHO"));
        arrTrainStation.add(new TrainStation("182", "MALAPALLE", "MPL"));
        arrTrainStation.add(new TrainStation("427", "MALLAKAM", ""));
        arrTrainStation.add(new TrainStation("183", "MANAMPITIYA", "MPT"));
        arrTrainStation.add(new TrainStation("165", "MANGALAELIYA", "MGE"));
        arrTrainStation.add(new TrainStation("331", "MANKULAM", "MKM"));
        arrTrainStation.add(new TrainStation("434", "MANNAR", "MNR"));
        arrTrainStation.add(new TrainStation("179", "MANUWANGAMA", "MNG"));
        arrTrainStation.add(new TrainStation("160", "MARADANA", "MDA"));
        arrTrainStation.add(new TrainStation("462", "MARAKONA", ""));
        arrTrainStation.add(new TrainStation("454", "MARALUWEWA", "Maraluwewa"));
        arrTrainStation.add(new TrainStation("186", "MATALE", "MTL"));
        arrTrainStation.add(new TrainStation("187", "MATARA", "MTR"));
        arrTrainStation.add(new TrainStation("432", "MATHOTTAM", ""));
        arrTrainStation.add(new TrainStation("466", "MAVILMADA", ""));
        arrTrainStation.add(new TrainStation("425", "MAVITTAPURAM", ""));
        arrTrainStation.add(new TrainStation("163", "MEDAGAMA", "MEM"));
        arrTrainStation.add(new TrainStation("189", "MEDAWACHCHIYA", "MWH"));
        arrTrainStation.add(new TrainStation("421", "MEDDEGAMA", ""));
        arrTrainStation.add(new TrainStation("464", "MEEGAMMANA", ""));
        arrTrainStation.add(new TrainStation("164", "MEEGODA", "MGD"));
        arrTrainStation.add(new TrainStation("403", "MEESALAI", ""));
        arrTrainStation.add(new TrainStation("188", "MHA INDURUWA", "MWA"));
        arrTrainStation.add(new TrainStation("162", "MIDIGAMA", "MED"));
        arrTrainStation.add(new TrainStation("169", "MIHINTALE", "MHN"));
        arrTrainStation.add(new TrainStation("168", "MIHINTALE JUNCTION", "MHJ"));
        arrTrainStation.add(new TrainStation("173", "MINNERIYA", "MIY"));
        arrTrainStation.add(new TrainStation("171", "MIRIGAMA", "MIR"));
        arrTrainStation.add(new TrainStation("409", "MIRIHANPITIGAMA", "Mihihanpitigama"));
        arrTrainStation.add(new TrainStation("172", "MIRISSA", "MIS"));
        arrTrainStation.add(new TrainStation("443", "MIRISWATTA", ""));
        arrTrainStation.add(new TrainStation("402", "MIRUSUVIL", ""));
        arrTrainStation.add(new TrainStation("177", "MOLLIPATANA", "MLP"));
        arrTrainStation.add(new TrainStation("176", "MORAGOLLAGAMA", "MLG"));
        arrTrainStation.add(new TrainStation("175", "MORAKELE", "MKP"));
        arrTrainStation.add(new TrainStation("184", "MORATUWA", "MRT"));
        arrTrainStation.add(new TrainStation("439", "MOUNT LAVINIA", ""));
        arrTrainStation.add(new TrainStation("180", "MUNDAL", "MNL"));
        arrTrainStation.add(new TrainStation("332", "MURIKANDY", "MRK"));
        arrTrainStation.add(new TrainStation("431", "MURUNKAN", ""));
        arrTrainStation.add(new TrainStation("185", "MUTHTHETTUGALA", "MTG"));
        arrTrainStation.add(new TrainStation("191", "NAGOLLAGAMA", "NAG"));
        arrTrainStation.add(new TrainStation("196", "NAILIYA", "NLY"));
        arrTrainStation.add(new TrainStation("197", "NANUOYA", "NOA"));
        arrTrainStation.add(new TrainStation("195", "NARAHENPITA", "NHP"));
        arrTrainStation.add(new TrainStation("192", "NATTANDIYA", "NAT"));
        arrTrainStation.add(new TrainStation("399", "NAVATKULI", ""));
        arrTrainStation.add(new TrainStation("201", "NAWALAPITIYA", "NVP"));
        arrTrainStation.add(new TrainStation("202", "NAWINNA", "NWN"));
        arrTrainStation.add(new TrainStation("194", "NEGAMA", "NGM"));
        arrTrainStation.add(new TrainStation("193", "NEGOMBO", "NGB"));
        arrTrainStation.add(new TrainStation("415", "NELUMPATHGAMA", "Nelumpathgama"));
        arrTrainStation.add(new TrainStation("199", "NELUMPOKUNA", "NPK"));
        arrTrainStation.add(new TrainStation("370", "NERIYAKULAM", "NYK"));
        arrTrainStation.add(new TrainStation("198", "NOORANAGAR", "NOR"));
        arrTrainStation.add(new TrainStation("200", "NUGEGODA", "NUG"));
        arrTrainStation.add(new TrainStation("203", "OHIYA", "OHA"));
        arrTrainStation.add(new TrainStation("204", "OMANTHAI", "OMT"));
        arrTrainStation.add(new TrainStation("208", "PADUKKA", "PDK"));
        arrTrainStation.add(new TrainStation("420", "PAHALAWARDHANA", "Pahalawardhana"));
        arrTrainStation.add(new TrainStation("238", "PALAVI", "PVI"));
        arrTrainStation.add(new TrainStation("396", "PALLAI", "PAL"));
        arrTrainStation.add(new TrainStation("465", "PALLE TALAVINNA", ""));
        arrTrainStation.add(new TrainStation("219", "PALLEWALA", "PLL"));
        arrTrainStation.add(new TrainStation("237", "PALUGASWEWA", "PUW"));
        arrTrainStation.add(new TrainStation("223", "PANADURA", "PND"));
        arrTrainStation.add(new TrainStation("224", "PANAGODA", "PNG"));
        arrTrainStation.add(new TrainStation("226", "PANALEEYA", "PNL"));
        arrTrainStation.add(new TrainStation("233", "PANGIRIWATTA", "PRW"));
        arrTrainStation.add(new TrainStation("205", "PANNIPITIYA", "PAN"));
        arrTrainStation.add(new TrainStation("216", "PARAKUMPURA", "PKU"));
        arrTrainStation.add(new TrainStation("394", "PARANTHAN", "PRN"));
        arrTrainStation.add(new TrainStation("213", "PARASANGAHAWEWA", "PHW"));
        arrTrainStation.add(new TrainStation("209", "PATAGAMGODA", "PGD"));
        arrTrainStation.add(new TrainStation("236", "PATHANPHA", "PTP"));
        arrTrainStation.add(new TrainStation("230", "PATTIPOLA", "PPL"));
        arrTrainStation.add(new TrainStation("211", "PAYAGALA NORTH", "PGN"));
        arrTrainStation.add(new TrainStation("212", "PAYAGALA SOUTH", "PGS"));
        arrTrainStation.add(new TrainStation("232", "PEMROSE", ""));
        arrTrainStation.add(new TrainStation("207", "PERADENIYA", "PDA"));
        arrTrainStation.add(new TrainStation("459", "PERAKUMPURA", "PKP"));
        arrTrainStation.add(new TrainStation("231", "PERALANDA", "PRL"));
        arrTrainStation.add(new TrainStation("227", "PERIYANAGAVILLU", "PNV"));
        arrTrainStation.add(new TrainStation("436", "PESALAI", ""));
        arrTrainStation.add(new TrainStation("217", "PILIDUWA", "PLD"));
        arrTrainStation.add(new TrainStation("222", "PILIMATALAWA", "PLT"));
        arrTrainStation.add(new TrainStation("416", "PINNAGOLLA", "Pinnagolla"));
        arrTrainStation.add(new TrainStation("228", "PINNAWALA", "PNW"));
        arrTrainStation.add(new TrainStation("214", "PINWATTE", "PIN"));
        arrTrainStation.add(new TrainStation("210", "PIYADIGAMA", "PGM"));
        arrTrainStation.add(new TrainStation("240", "PIYAGAMA", "PYA"));
        arrTrainStation.add(new TrainStation("477", "Polgaha Anga", ""));
        arrTrainStation.add(new TrainStation("218", "POLGAHAWELA", "PLG"));
        arrTrainStation.add(new TrainStation("220", "POLONNARUWA", "PLN"));
        arrTrainStation.add(new TrainStation("221", "POLWATHUMODARA", "PLR"));
        arrTrainStation.add(new TrainStation("229", "POONEWA", "PON"));
        arrTrainStation.add(new TrainStation("419", "PORAPOLA", "Porapola"));
        arrTrainStation.add(new TrainStation("418", "PORAPOLA JUNC.", "Porapola Juc."));
        arrTrainStation.add(new TrainStation("234", "POTUHERA", "PTA"));
        arrTrainStation.add(new TrainStation("206", "PULACHCHIKULAM", "PCK"));
        arrTrainStation.add(new TrainStation("330", "PULIYANKULAM", "PKM"));
        arrTrainStation.add(new TrainStation("225", "PUNANI", "PNI"));
        arrTrainStation.add(new TrainStation("406", "PUNKANKULAM", ""));
        arrTrainStation.add(new TrainStation("235", "PUTTALAM", "PTM"));
        arrTrainStation.add(new TrainStation("445", "PUWAKPITIYA", "PWP"));
        arrTrainStation.add(new TrainStation("446", "PUWAKPITIYA TOWN", ""));
        arrTrainStation.add(new TrainStation("243", "RADELLA", "RDL"));
        arrTrainStation.add(new TrainStation("246", "RAGAMA", "RGM"));
        arrTrainStation.add(new TrainStation("241", "RAMBUKKANA", "RBK"));
        arrTrainStation.add(new TrainStation("247", "RANAMUGGAMUWA", "RMA"));
        arrTrainStation.add(new TrainStation("245", "RANDENIGAMA", "RGA"));
        arrTrainStation.add(new TrainStation("249", "RATHGAMA", "RTG"));
        arrTrainStation.add(new TrainStation("248", "RATMALANA", "RML"));
        arrTrainStation.add(new TrainStation("244", "REDEETHENNA", "RDT"));
        arrTrainStation.add(new TrainStation("242", "RICHMOND HILL", "RCH"));
        arrTrainStation.add(new TrainStation("250", "ROSELLA", "RZL"));
        arrTrainStation.add(new TrainStation("251", "SALIYAPURA", "SAL"));
        arrTrainStation.add(new TrainStation("404", "SANKATHANAI", ""));
        arrTrainStation.add(new TrainStation("257", "SARASAVIUYANA", "SUA"));
        arrTrainStation.add(new TrainStation("259", "SAWARANA", "SWR"));
        arrTrainStation.add(new TrainStation("252", "SECRETARTAT HALT", "SCR"));
        arrTrainStation.add(new TrainStation("253", "SEEDUWA", "SED"));
        arrTrainStation.add(new TrainStation("255", "SEENIGAMA", "SMA"));
        arrTrainStation.add(new TrainStation("254", "SENARATHGAMA", "SGM"));
        arrTrainStation.add(new TrainStation("258", "SEVANAPITIYA", "SVP"));
        arrTrainStation.add(new TrainStation("339", "SIYABALANGAMUWA", ""));
        arrTrainStation.add(new TrainStation("260", "SIYALANGAMUWA", "SYA"));
        arrTrainStation.add(new TrainStation("256", "SRAWASTHIPURA", "SRP"));
        arrTrainStation.add(new TrainStation("437", "TALAIMANNAR", ""));
        arrTrainStation.add(new TrainStation("438", "TALAIMANNAR PIER", ""));
        arrTrainStation.add(new TrainStation("270", "TALAWA", "TLA"));
        arrTrainStation.add(new TrainStation("269", "TALAWAKELE", "TKL"));
        arrTrainStation.add(new TrainStation("276", "TALAWATTEGEDARA", "TWG"));
        arrTrainStation.add(new TrainStation("461", "TAWALANOYA", ""));
        arrTrainStation.add(new TrainStation("426", "TELLIPALLAI", ""));
        arrTrainStation.add(new TrainStation("277", "TELWATTE", "TWT"));
        arrTrainStation.add(new TrainStation("262", "TEMBLIGALA", "TBL"));
        arrTrainStation.add(new TrainStation("405", "THACHANTHOPPU", ""));
        arrTrainStation.add(new TrainStation("271", "THALPE", "TLP"));
        arrTrainStation.add(new TrainStation("414", "THAMBAGALLA", "Thambagalla"));
        arrTrainStation.add(new TrainStation("263", "THAMBUTTEGAMA", "TBM"));
        arrTrainStation.add(new TrainStation("450", "THAMPALAKAMAM", ""));
        arrTrainStation.add(new TrainStation("265", "THANDIKULAM", "TDK"));
        arrTrainStation.add(new TrainStation("433", "THIIRUKETHEESWARAM", ""));
        arrTrainStation.add(new TrainStation("267", "THILLADIYA", "TDY"));
        arrTrainStation.add(new TrainStation("272", "THIRANAGAMA", "TNA"));
        arrTrainStation.add(new TrainStation("435", "THODDAVELI", ""));
        arrTrainStation.add(new TrainStation("455", "Thuruliyagama", ""));
        arrTrainStation.add(new TrainStation("268", "TIMBIRIYAGEDARA", "TIM"));
        arrTrainStation.add(new TrainStation("274", "TISMALPOLA", "TSM"));
        arrTrainStation.add(new TrainStation("273", "TRAIN HALT 01", "TRH"));
        arrTrainStation.add(new TrainStation("264", "TRINCOMALEE", ""));
        arrTrainStation.add(new TrainStation("275", "TUDELLA", "TUD"));
        arrTrainStation.add(new TrainStation("266", "TUMMODARA", "TDR"));
        arrTrainStation.add(new TrainStation("278", "UDATALAWINNA", "UDL"));
        arrTrainStation.add(new TrainStation("285", "UDATHTHAWALA", "UWL"));
        arrTrainStation.add(new TrainStation("281", "UDHAMULLA", "UHM"));
        arrTrainStation.add(new TrainStation("413", "UDUGODAGAMA", "Udugodagama"));
        arrTrainStation.add(new TrainStation("279", "UDUWARA", "UDW"));
        arrTrainStation.add(new TrainStation("280", "UGGALLA", "UGL"));
        arrTrainStation.add(new TrainStation("282", "UKUWELA", "UKL"));
        arrTrainStation.add(new TrainStation("283", "ULAPANE", ""));
        arrTrainStation.add(new TrainStation("284", "UNAWATUNA", "UNW"));
        arrTrainStation.add(new TrainStation("451", "Urugodawattha", ""));
        arrTrainStation.add(new TrainStation("412", "UYANGALLA", "Uyangalla"));
        arrTrainStation.add(new TrainStation("286", "VALACHCHENEI", "VCH"));
        arrTrainStation.add(new TrainStation("288", "VANDARAMULLAI", "VML"));
        arrTrainStation.add(new TrainStation("289", "VAVUNIYA", "VNA"));
        arrTrainStation.add(new TrainStation("287", "VEYANGODA", "VGD"));
        arrTrainStation.add(new TrainStation("340", "VIRALMURIPPUWA", "Viralmurippuwa"));
        arrTrainStation.add(new TrainStation("292", "WADDUWA", "WDA"));
        arrTrainStation.add(new TrainStation("295", "WAGA", "WGG"));
        arrTrainStation.add(new TrainStation("299", "WAIKKALA", "WKL"));
        arrTrainStation.add(new TrainStation("296", "WALAHAPITIYA", "WHP"));
        arrTrainStation.add(new TrainStation("407", "WALASWEWA", "Walaswewa"));
        arrTrainStation.add(new TrainStation("301", "WALGAMA", "WLG"));
        arrTrainStation.add(new TrainStation("303", "WALPOLA", "WPA"));
        arrTrainStation.add(new TrainStation("306", "WANAWASALA", "WSL"));
        arrTrainStation.add(new TrainStation("305", "WANDURAWA", "WRW"));
        arrTrainStation.add(new TrainStation("308", "WATAGODA", "WTG"));
        arrTrainStation.add(new TrainStation("336", "WATARAKA", ""));
        arrTrainStation.add(new TrainStation("300", "WATAWALA", "WLA"));
        arrTrainStation.add(new TrainStation("294", "WATTEGAMA", "WGA"));
        arrTrainStation.add(new TrainStation("478", "Weligalla", ""));
        arrTrainStation.add(new TrainStation("302", "WELIGAMA", "WLM"));
        arrTrainStation.add(new TrainStation("298", "WELIKANDA", "WKD"));
        arrTrainStation.add(new TrainStation("293", "WELLAWA", "WEL"));
        arrTrainStation.add(new TrainStation("307", "WELLAWATTA", "WTE"));
        arrTrainStation.add(new TrainStation("411", "WERAGALA", "Weragala"));
        arrTrainStation.add(new TrainStation("304", "WIJAYARAJADAHANA", "WRD"));
        arrTrainStation.add(new TrainStation("309", "WILWATTE", "WWT"));
        arrTrainStation.add(new TrainStation("297", "WLAKUBURA", "WKA"));
        arrTrainStation.add(new TrainStation("473", "YAGODA", "YGD"));
        arrTrainStation.add(new TrainStation("387", "YAGODA", "YGD"));
        arrTrainStation.add(new TrainStation("315", "YAPAHUWA", "YPW"));
        arrTrainStation.add(new TrainStation("313", "YATAGAMA", "YGM"));
        arrTrainStation.add(new TrainStation("463", "YATAWARA", "YATAWARA"));
        arrTrainStation.add(new TrainStation("311", "YATIRAWANA", "YATIRAWANA"));
        arrTrainStation.add(new TrainStation("316", "YATTALGODA", "YTG"));
        return arrTrainStation;
    }
}
